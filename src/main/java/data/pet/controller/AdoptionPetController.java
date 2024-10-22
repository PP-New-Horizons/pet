package data.pet.controller;

import data.pet.entity.Pet;
import data.pet.exception.NotFoundPetException;
import data.pet.exception.PetAdoptedException;
import data.pet.exception.PetBookedException;
import data.pet.services.interfaces.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Tag(name = "Pet adoption", description = " Pet Adoption Api")
@RequestMapping("/api/adoption")
@RequiredArgsConstructor
@Slf4j
@Validated
public class AdoptionPetController {
    private final PetService petService;


    @PostMapping
    @Operation(summary = "Send an application form to book a pet adoption service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application sent"),
            @ApiResponse(responseCode = "404", description = "Pet is not found"),
            @ApiResponse(responseCode = "409", description = "Pet is booked and/or adopted")
    })
    public ResponseEntity<String> sendAppointmentToBookPetAdoption(@Parameter(
            example = "1")
                                                                   @RequestParam(required = false)
                                                                   @Min(value = 1) Long petId) {
        Optional<Pet> optionalPet = petService.getPetById(petId);
        if (optionalPet.isEmpty()) {
            throw new NotFoundPetException(String.format("Pet with id %d is not found", petId));
        }
        if (optionalPet.get().isBooked()) {
            throw new PetBookedException(String.format("Pet with id %d is booked", petId));
        }
        if (optionalPet.get().isAdopted()) {
            throw new PetAdoptedException(String.format("Pet with id %d is adopted", petId));
        }
        petService.updateBookStatusPet(optionalPet.get(), true);
        return ResponseEntity.ok("Ok");
    }
}
