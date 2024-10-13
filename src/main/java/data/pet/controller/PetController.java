package data.pet.controller;

import data.pet.dto.request.PetFilterDto;
import data.pet.dto.response.PetDto;
import data.pet.exception.NotFoundPetException;
import data.pet.services.interfaces.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Pet", description = "Pet Api")
@RequestMapping("/api/pets")
@RequiredArgsConstructor
@Slf4j
public class PetController {
    private final PetService petService;

    @GetMapping
    @Operation(summary = "Get a list of all pets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of pets received")})
    public ResponseEntity<List<PetDto>> getAllPets() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getAllPets());
    }

    @GetMapping("/cats")
    @Operation(summary = "Get a list of all cats")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of cats received")})
    public ResponseEntity<List<PetDto>> getAllCats() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetsByTypeId(1L));
    }

    @GetMapping("/dogs")
    @Operation(summary = "Get a list of all dogs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of dogs received")})
    public ResponseEntity<List<PetDto>> getAllDogs() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetsByTypeId(2L));
    }

    @Validated
    @GetMapping("/filter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of filtered pets received")})
    @Operation(summary = "Get a list of pets by filter")
    public ResponseEntity<List<PetDto>> getPetsByFilters(
            @Parameter(
                    description = "id=1 - Кошка, id=2 - Собака",
                    example = "1")
            @RequestParam(required = false)
            @Min(value = 1,message = "Минимальное petTypeId значение 1")
            @Max(value = 2,message = "Максимально petTypeId значение 2")
            Integer petTypeId,

            @Parameter(
                    description = "id=1 - Мужской, id=2 - Женский",
                    example = "1")
            @RequestParam(required = false)
            @Min(value = 1,message = "Минимальное genderId значение 1")
            @Max(value = 2,message = "Максимально genderId значение 2")
            Integer genderId,

            @Parameter(
                    description = "Начало интервала возраста в месяцах включительно",
                    example = "0")
            @RequestParam(required = false)
            @PositiveOrZero(message = "minAgeInMonths - должно быть ноль или положительное число")
            Integer minAgeInMonths,

            @Parameter(
                    description = "Конец интервала возраста в месяцах включительно",
                    example = "15")
            @RequestParam(required = false)
            @Positive(message = "maxAgeInMonths - должно быть положительное число")
            @Min(value = 0, message = "maxAgeInMonths - должно быть не отрицательное число")
            Integer maxAgeInMonths,

            @Parameter(
                    description = "id=1 - С ограниченными возможностями, id=2 - Требуется лечение, id=3 - Хорошее",
                    example = "3")
            @RequestParam(required = false)
            @Min(value = 1,message = "Минимальное healthId значение 1")
            @Max(value = 3,message = "Максимально healthId значение 3")
            Integer healthId,

            @Parameter(
                    description = "id=1 - Гладкошерстный, id=2 - Длинношерстный, id=3 - Лысый",
                    example = "1")
            @RequestParam(required = false)
            @Min(value = 1,message = "Минимальное hairId значение 1")
            @Max(value = 3,message = "Максимально hairId значение 3")
            Integer hairId,

            @Parameter(
                    description = "Порода, true - есть, false - нет",
                    example = "false")
            @RequestParam(required = false) Boolean breed,

            @Parameter(
                    description = "id=1 - Блондин, id=2 - Брюнет, id=3 - Рыжий, id=4 - Шатен, id=5 - Пестрый",
                    example = "1")
            @RequestParam(required = false)
            @Min(value = 1,message = "Минимальное colorId значение 1")
            @Max(value = 5,message = "Максимально colorId значение 5")
            Integer colorId,

            @Parameter(
                    description = "id=1 - Большой, id=2 - Средний, id=3 - Маленький",
                    example = "1")
            @RequestParam(required = false)
            @Min(value = 1,message = "Минимальное значение sizeId 1")
            @Max(value = 3,message = "Максимально значение sizeId 3")
            Integer sizeId) {
        PetFilterDto petFilterDto = PetFilterDto.builder()
                .petTypeId(petTypeId)
                .genderId(genderId)
                .minAgeInMonths(minAgeInMonths)
                .maxAgeInMonths(maxAgeInMonths)
                .healthId(healthId)
                .hairId(hairId)
                .breed(breed)
                .color(colorId)
                .sizeId(sizeId)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetsByFilter(petFilterDto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a pet by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pet received"),
            @ApiResponse(responseCode = "404", description = "Pet is not found")})
    public ResponseEntity<PetDto> getPetById(
            @PathVariable Long id
    ) {
        if (petService.getPetById(id).isEmpty()) {
            throw new NotFoundPetException(String.format("Pet with id %d is not found", id));
        }
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetById(id).get());
    }
}
