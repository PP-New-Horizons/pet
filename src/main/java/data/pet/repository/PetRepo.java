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
    List<Pet> findByIsBookedFalseAndIsAdoptedFalse();

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
            "(:sizeId IS NULL OR p.size.id = :sizeId) AND " +
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


//    @Query("SELECT p FROM Pet p WHERE " +
//            "(:petTypeId IS NULL OR p.petTypeId.id = :petTypeId) AND " +
//            "(:genderId IS NULL OR p.gender.id = :genderId) AND " +
//            "(:startIntervalAge IS NULL OR p.age > :startIntervalAge) AND " +
//            "(:endIntervalAge IS NULL OR p.age < :endIntervalAge) AND " +
//            "(:healthType IS NULL OR p.healthType.id = :healthType) AND " +
//            "(:breed IS NULL OR p.breed = :breed) AND " +
//            "(:hairId IS NULL OR p.hair.id = :hairId) AND " +
//            "(:sizeId IS NULL OR p.size.id = :sizeId) AND " +
//            "p.isBooked = false AND " +
//            "p.isAdopted = false")
//    List<Pet> findPetsByFilters(@Param("petTypeId") Long petTypeId,
//                                @Param("genderId") Long genderId,
//                                @Param("startIntervalAge") Integer startIntervalAge,
//                                @Param("endIntervalAge") Integer endIntervalAge,
//                                @Param("healthType") Long healthType,
//                                @Param("breed") String breed,
//                                @Param("hairId") Long hairId,
//                                @Param("sizeId") Long sizeId);



    @Override
    @NonNull
    <S extends Pet> S save(@NonNull S entity);

    @Override
    void delete(@NonNull Pet entity);

    @Override
    @NonNull
    Optional<Pet> findById(@NonNull Long id);

//    @NonNull
//    List<Pet> findAllByPetType();
}
