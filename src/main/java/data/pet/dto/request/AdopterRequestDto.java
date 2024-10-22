package data.pet.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class AdopterRequestDto {
    private Long petId;
}
