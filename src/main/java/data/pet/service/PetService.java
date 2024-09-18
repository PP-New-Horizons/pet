package data.pet.service;

import data.pet.dto.request.PetFilterDto;
import data.pet.entity.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    List<Pet> getAllPets();

    List<Pet> getPetsByTypeId(Long typeId);

    List<Pet> getPetsByFilter(PetFilterDto petFilterDto);

    Optional<Pet> getPetById(Long id);
}
