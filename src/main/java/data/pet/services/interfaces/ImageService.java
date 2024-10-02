package data.pet.services.interfaces;

import data.pet.entity.Image;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    void saveImage(Image image);

    List<Image> getAllByPetId(Long id);

    byte[] readImageAsBytes(String filePath) throws IOException;

    List<byte[]> getImages(List<Image> images, boolean isAvatar);
}
