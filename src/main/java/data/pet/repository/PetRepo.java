package data.pet.repository;

import data.pet.entity.FormForAdoption;
import data.pet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepo extends JpaRepository<Pet, Long> {

    List<Pet> findByIsBookedTrue();

    @Query("SELECT p FROM Pet p WHERE p.form IN :forms AND p.isAdopted = false")
    List<Pet> findAllByForms(@Param("forms") List<FormForAdoption> forms);
}