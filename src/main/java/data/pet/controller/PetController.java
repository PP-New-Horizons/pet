package data.pet.controller;

import data.pet.dto.request.PetFilterDto;
import data.pet.entity.Pet;
import data.pet.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
@Slf4j
public class PetController {
    private final PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getAllPets());
    }

    @GetMapping("/cats")
    public ResponseEntity<List<Pet>> getAllCats() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetsByTypeId(1L));
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Pet>> getAllDogs() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetsByTypeId(2L));
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getPetsByFilters(
            @RequestParam(required = false) Integer petTypeId,
            @RequestParam(required = false) Integer genderId,
            @RequestParam(required = false) Integer startIntervalAge,
            @RequestParam(required = false) Integer endIntervalAge,
            @RequestParam(required = false) Integer healthId,
            @RequestParam(required = false) Integer hairId,
            @RequestParam(required = false) Boolean greed,
            @RequestParam(required = false) Integer sizeId) {
        PetFilterDto petFilterDto = PetFilterDto.builder()
                .petTypeId(petTypeId)
                .genderId(genderId)
                .startIntervalAge(startIntervalAge)
                .endIntervalAge(endIntervalAge)
                .healthId(healthId)
                .hairId(hairId)
                .greed(greed)
                .sizeId(sizeId)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetsByFilter(petFilterDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(petService.getPetById(id).get());
    }
}
