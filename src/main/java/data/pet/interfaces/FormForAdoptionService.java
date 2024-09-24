package data.pet.interfaces;

import data.pet.entity.FormForAdoption;
import data.pet.repository.FormForAdoptionRepo;

import java.util.List;

public interface FormForAdoptionService {

    List<FormForAdoption> getAll();

    void delete (FormForAdoption f);
}
