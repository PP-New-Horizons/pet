package data.pet.services.implementations;

import data.pet.dto.request.PetFilterDto;
import data.pet.dto.response.PetDto;
import data.pet.entity.Pet;
import data.pet.repository.PetRepo;
import data.pet.services.interfaces.ImageService;
import data.pet.services.interfaces.PetService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepo petRepo;
    private final ImageService imageService;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<PetDto> getAllPets() {
        return petRepo.findByIsBookedFalseAndIsAdoptedFalse().stream()
                .map(this::mapPetToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PetDto> getAllPetsForAdmin() {
        return petRepo.findAll().stream()
                .map(this::mapPetToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PetDto> getPetsByTypeId(Long typeId) {
        return petRepo.findAllPetsByTypeId(typeId).stream()
                .map(this::mapPetToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PetDto> getPetById(Long petId) {
        return petRepo.findById(petId)
                .map(this::mapPetToDto);
    }

    private PetDto mapPetToDto(Pet pet) {
        PetDto petDto = new PetDto();
        petDto.setId(pet.getId());
        petDto.setName(pet.getName());
        petDto.setGender(pet.getGender().getName());
        petDto.setDescription(pet.getDescription());
        petDto.setHistory(pet.getHistory());
        petDto.setHealth(pet.getHealthType().getName());
        petDto.setAllMonths(calculateAgeInMonths(pet.getDateOfBirth()));
        petDto.setCreatedDate(pet.getCreatedAt().toLocalDate().toString());
        petDto.setBooked(pet.isBooked());
        petDto.setAdopted(pet.isAdopted());
        petDto.setBreed(pet.isBreed());
        petDto.setPetType(pet.getPetTypeId().getName());
        petDto.setColor(pet.getColor().getName());
        petDto.setHair(pet.getHair().getName());
        petDto.setSize(pet.getSize().getName());
        petDto.setPathToAvatar(imageService.getImages(pet.getImages(), true).stream().findFirst().orElse(null));
        petDto.setPathsToGallery(imageService.getImages(pet.getImages(), false));
        return petDto;
    }

    private Integer calculateAgeInMonths(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getMonths();
    }

    @Override
    public List<PetDto> getPetsByFilter(PetFilterDto petFilter) {
        LocalDate maxBirthDate = calculateBirthDateFromAgeInMonths(petFilter.getMinAgeInMonths());
        LocalDate minBirthDate = calculateBirthDateFromAgeInMonths(petFilter.getMaxAgeInMonths());
        if (maxBirthDate == null) {
            maxBirthDate = LocalDate.now();
        }
        if (minBirthDate == null) {
            minBirthDate = LocalDate.of(1900, 1, 1);
        }

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
                ).stream()
                .map(this::mapPetToDto)
                .collect(Collectors.toList());
    }

    private LocalDate calculateBirthDateFromAgeInMonths(Integer ageInMonths) {
        return Optional.ofNullable(ageInMonths)
                .map(LocalDate.now()::minusMonths)
                .orElse(null);
    }

}
