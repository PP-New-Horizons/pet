package data.pet.repository;

import data.pet.entity.Gender;
import data.pet.entity.Image;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenderRepo extends JpaRepository<Gender, Long> {

    @Override
    @NonNull
    <S extends Gender> S save(@NonNull S entity);

}
