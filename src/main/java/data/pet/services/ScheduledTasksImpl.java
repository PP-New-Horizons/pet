package data.pet.services;

import data.pet.entity.FormForAdoption;
import data.pet.entity.Pet;
import data.pet.interfaces.ScheduledTasks;
import data.pet.repository.FormForAdoptionRepo;
import data.pet.repository.PetRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ScheduledTasksImpl implements ScheduledTasks {
    private final FormForAdoptionRepo formForAdoptionRepo;
    private final PetRepo petRepo;

    @Override
    @Scheduled(cron = "?{task.cron.expression}")
    public void bookedTimer() {
        LocalDateTime threshold = LocalDateTime.now().minusHours(72);
        List<FormForAdoption> formForAdoptionsList = formForAdoptionRepo.findAll();
        List<FormForAdoption> oldForms = formForAdoptionsList.stream()
                                                .filter(f->f.getCreatedAt()
                                                .isBefore(threshold)).toList();
        if(oldForms!=null&!oldForms.isEmpty()){
            List<Pet> bookedPetsList = petRepo.findAllByForms(oldForms);
            bookedPetsList.forEach(pet -> pet.setBooked(false));
            petRepo.saveAll(bookedPetsList);
            formForAdoptionRepo.deleteAll(oldForms);
        }
    }
}
