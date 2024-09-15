package data.pet.repository;

import data.pet.entity.HealthType;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthTypeRepo extends JpaRepository<HealthType,Long> {
    @Override
    @NonNull
    List<HealthType> findAll();

    @Override
    @NonNull
    <S extends HealthType> S save(@NonNull S entity);

    @Override
    void delete(@NonNull HealthType entity);

}
