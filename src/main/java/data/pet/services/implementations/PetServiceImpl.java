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

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepo petRepo;
    private final ImageService imageService;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<PetDto> getAllPetsForUser() {
        return petRepo.findAllIsBookedFalseAndIsAdoptedFalse().stream()
                .map(this::mapPetToDto)
                .toList();
    }

    @Override
    public List<PetDto> getAllPetsForAdmin() {
        return petRepo.findAll().stream()
                .map(this::mapPetToDto)
                .toList();
    }

    @Override
    public List<PetDto> getPetsByTypeIdForUser(Long typeId) {
        return petRepo.findAllByPetTypeIdAndIsBookedFalseAndIsAdoptedFalse(typeId).stream()
                .map(this::mapPetToDto)
                .toList();
    }

    @Override
    public Optional<PetDto> getPetDtoByIdForUser(Long petId) {
        return petRepo.findById(petId)
                .map(this::mapPetToDto);
    }

    @Override
    public Optional<Pet> getPetById(Long petId) {
        return petRepo.findById(petId);
    }

    @Override
    public void updateBookStatusPet(Pet pet, boolean isBooked) {
        pet.setBooked(isBooked);
        petRepo.save(pet);
    }

    private PetDto mapPetToDto(Pet pet) {
        PetDto petDto = new PetDto();
        petDto.setId(pet.getId());
        petDto.setName(pet.getName());
        petDto.setGender(pet.getGender().getName());
        petDto.setDescription(pet.getDescription());
        petDto.setHistory(pet.getHistory());
        petDto.setHealth(pet.getHealthType().getName());
        petDto.setBirthDate(pet.getDateOfBirth());
        petDto.setCreatedDate(pet.getCreatedAt().toLocalDate().toString());
        petDto.setBooked(pet.isBooked());
        petDto.setAdopted(pet.isAdopted());
        petDto.setBreed(pet.isBreed());
        petDto.setPetType(pet.getPetTypeId().getName());
        petDto.setColor(pet.getColor().getName());
        petDto.setHair(pet.getHair().getName());
        petDto.setSize(pet.getPetSize() != null ? pet.getPetSize().getName() : null);
        petDto.setPathToAvatar(imageService.getImages(pet.getImages(), true).stream().findFirst().orElse(null));
        petDto.setPathsToGallery(imageService.getImages(pet.getImages(), false));
        return petDto;
    }

    private Integer calculateAgeInMonths(LocalDate dateOfBirth) {
        return Period.between(dateOfBirth, LocalDate.now()).getMonths();
    }

    @Override
    public List<PetDto> getPetsByFilterForUser(PetFilterDto petFilter) {
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
                .toList();
    }

    private LocalDate calculateBirthDateFromAgeInMonths(Integer ageInMonths) {
        return Optional.ofNullable(ageInMonths)
                .map(LocalDate.now()::minusMonths)
                .orElse(null);
    }

}
