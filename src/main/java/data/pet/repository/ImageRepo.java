package data.pet.repository;

import data.pet.entity.Image;
import lombok.NonNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepo extends JpaRepository<Image,Long> {
    @Override
    @NonNull
    List<Image> findAll();

    @Override
    @NonNull
    <S extends Image > S save(@NonNull S entity);

    @Override
    void delete(@NonNull Image entity);

    @NonNull
    List<Image> findAllByPetId(Long id);
}
