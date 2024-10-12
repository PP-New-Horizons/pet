package data.pet.dto.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class PetDto {
    private Long id;

    private String pathToAvatar;

    private List<String> pathsToGallery;

    private String name;

    private String gender;

    private String description;

    private String history;

    private String health;

    private Integer allMonths;

    private String createdDate;

    private boolean booked;

    private boolean adopted;

    private boolean breed;

    private String petType;

    private String color;

    private String hair;

    private String size;

}
