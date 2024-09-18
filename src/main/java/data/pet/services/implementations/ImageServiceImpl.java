package data.pet.services.implementations;

import data.pet.entity.Image;
import data.pet.repository.ImageRepo;
import data.pet.services.interfaces.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepo imageRepo;

    @Override
    public void saveImage(Image image) {
        imageRepo.save(image);
    }

    @Override
    public List<Image> getAllByPetId(Long id) {
        return imageRepo.findAllByPetId(id);
    }
}
