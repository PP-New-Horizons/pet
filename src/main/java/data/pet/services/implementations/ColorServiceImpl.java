package data.pet.services.implementations;

import data.pet.entity.Color;
import data.pet.repository.ColorRepo;
import data.pet.services.interfaces.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
    private final ColorRepo colorRepo;

    public void saveColor(Color color) {
        colorRepo.save(color);
    }
}
