package data.pet.repository;

import data.pet.entity.Hair;
import data.pet.entity.Size;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepo extends JpaRepository<Size,Long> {
    @Override
    @NonNull
    <S extends Size> S save(@NonNull S entity);
}
