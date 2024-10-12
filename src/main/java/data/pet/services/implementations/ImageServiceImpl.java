package data.pet.services.implementations;

import data.pet.entity.Image;
import data.pet.repository.ImageRepo;
import data.pet.services.interfaces.ImageService;
import jakarta.servlet.http.HttpServletRequest;
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
    private final HttpServletRequest request;

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
                .map(image -> generateFullImageUrl(image.getPath()))
                .collect(Collectors.toList());
    }

    private String generateFullImageUrl(String relativePath) {
        String baseUrl = String.format("%s://%s:%s",
                request.getScheme(),
                request.getServerName(),
                request.getServerPort());
        return String.format("%s%s", baseUrl, relativePath);
    }
}
