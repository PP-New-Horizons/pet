package data.pet.repository;

import data.pet.entity.Pet;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface PetRepo extends JpaRepository<Pet, Long> {
    @Override
    @NonNull
    List<Pet> findAll();

    @NonNull
    @Query("SELECT p FROM Pet p WHERE p.isBooked = false AND p.isAdopted = false")
    List<Pet> findAllIsBookedFalseAndIsAdoptedFalse();

    @NonNull
    @Query("SELECT p FROM Pet p WHERE p.petTypeId.id = :typeId AND p.isBooked = false AND p.isAdopted = false")
    List<Pet> findAllByPetTypeIdAndIsBookedFalseAndIsAdoptedFalse(@Param("typeId") Long typeId);

    @NonNull
    @Query("SELECT p FROM Pet p WHERE p.petTypeId.id = :typeId")
    List<Pet> findAllPetsByTypeId(@Param("typeId") Long typeId);

    @Query("SELECT p FROM Pet p WHERE " +
            "(:petTypeId IS NULL OR p.petTypeId.id = :petTypeId) AND " +
            "(:genderId IS NULL OR p.gender.id = :genderId) AND " +
            "(p.dateOfBirth >= :minBirthDate) AND " +
            "(p.dateOfBirth <= :maxBirthDate) AND " +
            "(:healthId IS NULL OR p.healthType.id = :healthId) AND " +
            "(:breed IS NULL OR p.breed = :breed) AND " +
            "(:hairId IS NULL OR p.hair.id = :hairId) AND " +
            "(:color IS NULL OR p.color.id = :color) AND " +
            "(:sizeId IS NULL OR p.petSize.id = :sizeId) AND " +
            "p.isBooked = false AND p.isAdopted = false")
    List<Pet> findPetsByFilters(@Param("petTypeId") Integer petTypeId,
                                @Param("genderId") Integer genderId,
                                @Param("minBirthDate") LocalDate minBirthDate,
                                @Param("maxBirthDate") LocalDate maxBirthDate,
                                @Param("healthId") Integer healthId,
                                @Param("breed") Boolean breed,
                                @Param("hairId") Integer hairId,
                                @Param("color") Integer color,
                                @Param("sizeId") Integer sizeId);

    @Override
    @NonNull
    <S extends Pet> S save(@NonNull S entity);

    @Override
    @NonNull
    <S extends Pet> S saveAndFlush(@NonNull S entity);

    @Override
    void delete(@NonNull Pet entity);

    @Override
    @NonNull
    Optional<Pet> findById(@NonNull Long id);

}
