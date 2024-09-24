package data.pet.repository;

import data.pet.entity.FormForAdoption;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormForAdoptionRepo extends JpaRepository<FormForAdoption, Long> {
    @Override
    List<FormForAdoption> findAll();
    @Override
    void delete(@NonNull FormForAdoption entity);
    @Override
    @NonNull
    <S extends FormForAdoption> S save(@NonNull S entity);

}
