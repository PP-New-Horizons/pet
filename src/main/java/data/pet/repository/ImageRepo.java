package data.pet.repository;

import data.pet.entity.Image;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImageRepo extends JpaRepository<Image, Long> {
    @Override
    @NonNull
    List<Image> findAll();

    @Override
    @NonNull
    <S extends Image> S save(@NonNull S entity);

    @Override
    void delete(@NonNull Image entity);

    //    @NonNull
//    List<Image> findAllByPetId(Long id);
    @Query("SELECT i FROM Image i JOIN Pet p ON p.id = :petId WHERE i.id IN (SELECT img.id FROM p.images img)")
    List<Image> findAllByPetId(@Param("petId") Long petId);
}
