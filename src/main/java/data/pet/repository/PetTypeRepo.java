package data.pet.repository;

import data.pet.entity.PetType;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetTypeRepo extends JpaRepository<PetType, Long> {
    @Override
    @NonNull
    List<PetType> findAll();

    @Override
    @NonNull
    <S extends PetType> S save(@NonNull S entity);

    @Override
    void delete(@NonNull PetType entity);
}
