package data.pet.services.implementations;

import data.pet.entity.Image;
import data.pet.repository.ImageRepo;
import data.pet.services.interfaces.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
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

    @Override
    public List<String> getImages(List<Image> images, boolean isAvatar) {
        return images.stream()
                .filter(image -> image.isAvatar() == isAvatar)
                .map(Image::getPath)
                .collect(Collectors.toList());
    }
}
