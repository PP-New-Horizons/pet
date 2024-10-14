package data.pet.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class PetFilterDto {

    private Integer petTypeId;

    private Integer genderId;

    private Integer minAgeInMonths;

    private Integer maxAgeInMonths;

    private Integer healthId;

    private Integer hairId;

    private Boolean breed;

    private Integer color;

    private Integer sizeId;
}