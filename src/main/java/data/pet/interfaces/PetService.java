package data.pet.interfaces;

import data.pet.entity.FormForAdoption;
import data.pet.entity.Pet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetService {

    List<Pet> findAllByForms(List<FormForAdoption> forms);
}
