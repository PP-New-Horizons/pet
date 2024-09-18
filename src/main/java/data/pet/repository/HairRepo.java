package data.pet.repository;

import data.pet.entity.Hair;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HairRepo extends JpaRepository<Hair,Long> {
    @Override
    @NonNull
    <S extends Hair> S save(@NonNull S entity);
    @Override
    @NonNull
    List<Hair> findAll();

    @Override
    void delete(@NonNull Hair entity);



}
