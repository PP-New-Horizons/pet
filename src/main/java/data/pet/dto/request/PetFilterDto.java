package data.pet.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Schema(description = "Tutorial Model Information")

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
