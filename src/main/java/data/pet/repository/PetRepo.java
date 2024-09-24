package data.pet.repository;

import data.pet.entity.Pet;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface PetRepo extends JpaRepository<Pet, Long> {
    @Override
    @NonNull
    List<Pet> findAll();

    @NonNull
    List<Pet> findByIsBookedFalseAndIsAdoptedFalse();

    @Query("SELECT p FROM Pet p WHERE " +
            "(:petTypeId IS NULL OR p.pet_type_id = :petTypeId) AND " +
            "(:genderId IS NULL OR p.gender_id = :genderId) AND " +
            "(:startIntervalAge IS NULL OR p.age > :startIntervalAge) AND " +
            "(:endIntervalAge IS NULL OR p.age < :endIntervalAge) AND " +
            "(:healthType IS NULL OR p.health_type = :healthType) AND " +
            "(:breed IS NULL OR p.breed = :breed) AND " +
            "(:petTypeId IS NULL OR p.pet_type_id = :petTypeId) AND " +
            "(:sizeId IS NULL OR p.size_id = :sizeId)"+
            "p.isBooked = false AND " +
            "p.isAdopted = false")
    List<Pet> findPetsByFilters(@Param("petTypeId") Integer petTypeId,
                                @Param("genderId") Integer genderId,
                                @Param("startIntervalAge") Integer StartIntervalAge,
                                @Param("endIntervalAge") Integer EndIntervalAge,
                                @Param("healthType") Integer healthType,
                                @Param("breed") Boolean breed,
                                @Param("sizeId") Integer sizeId);

    @NonNull
    List<Pet> findAllPetsByTypeId(Long id);


    @Override
    @NonNull
    <S extends Pet> S save(@NonNull S entity);

    @Override
    void delete(@NonNull Pet entity);

    @Override
    @NonNull
    Optional<Pet> findById(@NonNull Long id);

    @NonNull
    List<Pet> findAllByPetType();
}
