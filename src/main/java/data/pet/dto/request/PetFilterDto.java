package data.pet.dto.request;

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