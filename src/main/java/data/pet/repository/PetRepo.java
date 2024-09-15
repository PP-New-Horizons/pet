package data.pet.repository;

import data.pet.entity.Pet;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PetRepo extends JpaRepository<Pet, Long> {
    @Override
    @NonNull
    List<Pet> findAll();

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
