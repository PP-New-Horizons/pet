package data.pet.services.interfaces;

import data.pet.entity.Image;

import java.util.List;

public interface ImageService {
    void saveImage(Image image);

    List<Image> getAllByPetId(Long id);

    List<String> getImages(List<Image> images, boolean isAvatar);
}
