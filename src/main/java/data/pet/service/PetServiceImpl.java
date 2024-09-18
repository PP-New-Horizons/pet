package data.pet.service;

import data.pet.dto.request.PetFilterDto;
import data.pet.entity.Pet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {
    @Override
    public List<Pet> getAllPets() {
        return List.of();
    }

    @Override
    public List<Pet> getPetsByTypeId(Long typeId) {
        return List.of();
    }

    @Override
    public List<Pet> getPetsByFilter(PetFilterDto petFilterDto) {
        return List.of();
    }

    @Override
    public Optional<Pet> getPetById(Long id) {
        return Optional.empty();
    }
}
