package data.pet.services;

import data.pet.entity.FormForAdoption;
import data.pet.entity.Pet;
import data.pet.interfaces.PetService;
import data.pet.repository.PetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final PetRepo petRepo;

    @Override
    public List<Pet> findAllByForms(List<FormForAdoption> forms) {
        return petRepo.findAllByForms(forms);
    }
}
