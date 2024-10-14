package data.pet.dto.response;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class PetDto {
    @NotNull(message = "Не задан id")
    @Digits(integer = 8, fraction = 0,message = "Должно быть недробное значение id" )
    @Min(value = 0,message = "Id должен быть положительным")
    private Long id;

    private String pathToAvatar;

    private List<String> pathsToGallery;

    private String name;

    @NotBlank(message = "")
    private String gender;

    private String description;

    @NotBlank(message = "")
    private String history;

    @NotBlank(message = "")
    private String health;

    @NotBlank(message = "")
    private Integer allMonths;

    @NotBlank(message = "")
    private String createdDate;

    @NotBlank(message = "")
    @AssertFalse(message = "")
    private boolean booked;

    @NotBlank(message = "")
    @AssertFalse(message = "")
    private boolean adopted;

    @NotBlank(message = "")
    private boolean breed;

    @NotBlank(message = "")
    private String petType;

    @NotBlank(message = "")
    private String color;

    @NotBlank(message = "")
    private String hair;

    @NotBlank(message = "Не выбран размер")
    private String size;

}
