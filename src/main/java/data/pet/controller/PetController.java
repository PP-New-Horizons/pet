package data.pet.controller;

import data.pet.dto.request.PetFilterDto;
import data.pet.dto.response.PetDto;
import data.pet.services.interfaces.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PetDto>> getAllPets() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getAllPets());
    }

    @GetMapping("/cats")
    @Operation(summary = "Get a list of all cats")
    public ResponseEntity<List<PetDto>> getAllCats() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetsByTypeId(1L));
    }

    @GetMapping("/dogs")
    @Operation(summary = "Get a list of all dogs")
    public ResponseEntity<List<PetDto>> getAllDogs() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetsByTypeId(2L));
    }

    @GetMapping("/filter")
    @Operation(summary = "Get a list of pets by filter")
    public ResponseEntity<List<PetDto>> getPetsByFilters(
            @Parameter(
                    description = "id=1 - Кошка, id=2 - Собака",
                    example = "1")
            @RequestParam(required = false) Integer petTypeId,
            @Parameter(
                    description = "id=1 - Мужской, id=2 - Женский",
                    example = "1")
            @RequestParam(required = false) Integer genderId,
            @Parameter(
                    description = "Начало интервала возраста в месяцах включительно",
                    example = "0")
            @RequestParam(required = false) Integer minAgeInMonths,
            @Parameter(
                    description = "Конец интервала возраста в месяцах включительно",
                    example = "15")
            @RequestParam(required = false) Integer endIntervalAge,
            @Parameter(
                    description = "id=1 - С ограниченными возможностями, id=2 - Требуется лечение, id=3 - Хорошее",
                    example = "3")
            @RequestParam(required = false) Integer healthId,
            @Parameter(
                    description = "id=1 - Блондин, id=2 - Брюнет, id=3 - Рыжий, id=4 - Шатен, id=5 - Пестрый",
                    example = "1")
            @RequestParam(required = false) Integer hairId,
            @Parameter(
                    description = "Порода, true - есть, false - нет",
                    example = "false")
            @RequestParam(required = false) Boolean breed,
            @Parameter(
                    description = "id=1 - Брюнет, id=2 - Рыжий, id=3 - Шатен, id=4 - Пёстрый",
                    example = "1")
            @RequestParam(required = false) Integer colorId,
            @Parameter(
                    description = "id=1 - Большой, id=2 - Средний, id=3 - Маленький",
                    example = "1")
            @RequestParam(required = false) Integer sizeId) {
        PetFilterDto petFilterDto = PetFilterDto.builder()
                .petTypeId(petTypeId)
                .genderId(genderId)
                .minAgeInMonths(minAgeInMonths)
                .maxAgeInMonths(minAgeInMonths)
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
    public ResponseEntity<PetDto> getPetById(
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetById(id).get());
    }
}
