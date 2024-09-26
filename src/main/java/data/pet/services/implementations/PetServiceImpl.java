package data.pet.services.implementations;

import data.pet.dto.request.PetFilterDto;
import data.pet.dto.response.PetDto;
import data.pet.entity.Pet;
import data.pet.repository.PetRepo;
import data.pet.services.interfaces.PetService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Optional<PetDto> getPetById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Pet> getPetsByFilter(PetFilterDto petFilter) {
        LocalDate minBirthDate = calculateBirthDateFromAgeInMonths(petFilter.getMinAgeInMonths());
        LocalDate maxBirthDate = calculateBirthDateFromAgeInMonths(petFilter.getMaxAgeInMonths());

        return petRepo.findPetsByFilters(
                petFilter.getPetTypeId(),
                petFilter.getGenderId(),
                minBirthDate,
                maxBirthDate,
                petFilter.getHealthId(),
                petFilter.getBreed(),
                petFilter.getHairId(),
                petFilter.getColor(),
                petFilter.getSizeId()
        );
    }

    // Преобразует количество месяцев в дату рождения
    private LocalDate calculateBirthDateFromAgeInMonths(Integer ageInMonths) {
        if (ageInMonths == null) {
            return null;  // Если возраст не указан, возвращаем null
        }
        return LocalDate.now().minusMonths(ageInMonths);  // Возвращаем дату рождения, отнимая месяцы от текущей даты
    }

}

//    public List<Pet> getPetsByFilter(PetFilterDto petFilterDto) {
//        return petRepo.findPetsByFilters(petFilterDto.getPetTypeId(),
//                petFilterDto.getGenderId(), petFilterDto.getStartIntervalAge(),
//                petFilterDto.getEndIntervalAge(), petFilterDto.getHealthId(), petFilterDto.getBreed(),
//                petFilterDto.getHairId(), petFilterDto.getSizeId());
//    }

