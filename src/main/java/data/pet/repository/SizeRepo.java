package data.pet.repository;

import data.pet.entity.PetSize;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepo extends JpaRepository<PetSize,Long> {
    @Override
    @NonNull
    <S extends PetSize> S save(@NonNull S entity);
}
