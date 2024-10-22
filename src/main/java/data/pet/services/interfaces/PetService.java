package data.pet.services.interfaces;

import data.pet.dto.request.PetFilterDto;
import data.pet.dto.response.PetDto;
import data.pet.entity.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    List<PetDto> getAllPetsForUser();
    List<PetDto> getAllPetsForAdmin();
    List<PetDto> getPetsByTypeIdForUser(Long typeId);
    List<PetDto> getPetsByFilterForUser(PetFilterDto petFilterDto);
    Optional<PetDto> getPetDtoByIdForUser(Long id);
    Optional<Pet> getPetById(Long petId);
    void updateBookStatusPet(Pet pet, boolean isBooked);
}
