package data.pet.services.interfaces;

import data.pet.dto.request.PetFilterDto;
import data.pet.dto.response.PetDto;
import data.pet.entity.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    List<Pet> getAllPets();
    List<Pet> getAllPetsForAdmin();
    List<Pet> getPetsByTypeId(Long typeId);
    List<Pet> getPetsByFilter(PetFilterDto petFilterDto);
    Optional<PetDto> getPetById(Long id);
}
