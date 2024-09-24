package data.pet.services;

import data.pet.entity.FormForAdoption;
import data.pet.interfaces.FormForAdoptionService;
import data.pet.repository.FormForAdoptionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@Service
public class FormForAdoptionServiceImpl implements FormForAdoptionService {

    private  final FormForAdoptionRepo formForAdoptionRepo;
    @Override
    public List<FormForAdoption> getAll() {
        return formForAdoptionRepo.findAll();
    }

    @Override
    public void delete(FormForAdoption f) {

    }
}
