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

    private Integer startIntervalAge;

    private Integer endIntervalAge;

    private Integer healthId;

    private Integer hairId;

    private Boolean greed;

    private Integer sizeId;
}
