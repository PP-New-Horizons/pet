package data.pet.services.interfaces;

import data.pet.dto.request.PetFilterDto;
import data.pet.dto.response.PetDto;
import data.pet.entity.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    List<PetDto> getAllPets();
    List<PetDto> getAllPetsForAdmin();
    List<PetDto> getPetsByTypeId(Long typeId);
    List<PetDto> getPetsByFilter(PetFilterDto petFilterDto);
    Optional<PetDto> getPetById(Long id);
}
