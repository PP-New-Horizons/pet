package data.pet.services.implementations;

import data.pet.entity.Image;
import data.pet.repository.ImageRepo;
import data.pet.services.interfaces.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Value("${file.upload-dir}")
    private String uploadDir;
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
    public byte[] readImageAsBytes(String filePath) throws IOException {
        Path path = Paths.get(uploadDir, filePath);
        return Files.readAllBytes(path);
    }

    @Override
    public List<byte[]> getImages(List<Image> images, boolean isAvatar) {
        return images.stream()
                .filter(image -> image.isAvatar() == isAvatar)
                .map(image -> {
                    try {
                        return readImageAsBytes(image.getPath());
                    } catch (IOException e) {
                        log.error("Error reading image: {}", image.getPath(), e);
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
