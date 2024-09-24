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
    @Query("SELECT p FROM Pet p WHERE p.petTypeId.id = :typeId")
    List<Pet> findAllPetsByTypeId(@Param("typeId") Long typeId);

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
