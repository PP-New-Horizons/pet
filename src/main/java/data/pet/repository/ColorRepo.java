package data.pet.repository;

import data.pet.entity.Color;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepo extends JpaRepository<Color, Long> {
    @Override
    @NonNull
    <S extends Color> S save(@NonNull S entity);

    @Override
    @NonNull
    List<Color> findAll();

    @NonNull
    Color findById(long id);

}
