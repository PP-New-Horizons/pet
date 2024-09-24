package data.pet.services.implementations;

import data.pet.dto.request.PetFilterDto;
import data.pet.entity.Pet;
import data.pet.repository.PetRepo;
import data.pet.services.interfaces.PetService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepo petRepo;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Pet> getAllPets() {
        return petRepo.findByIsBookedFalseAndIsAdoptedFalse();
    }

    @Override
    public List<Pet> getAllPetsForAdmin() {
        return petRepo.findAll();
    }

    @Override
    public List<Pet> getPetsByTypeId(Long typeId) {
        return petRepo.findAllPetsByTypeId(typeId);
    }

    @Override
    public Optional<Pet> getPetById(Long id) {
        return Optional.empty();
    }

    public List<Pet> getPetsByFilter(PetFilterDto petFilterDto) {
        return petRepo.findPetsByFilters(petFilterDto.getPetTypeId(),
                petFilterDto.getGenderId(), petFilterDto.getStartIntervalAge(),
                petFilterDto.getEndIntervalAge(), petFilterDto.getHealthId(),
                petFilterDto.getBreed(), petFilterDto.getSizeId());
    }
}
