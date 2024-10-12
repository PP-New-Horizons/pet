package data.pet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pet_type")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Не указан вид")
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String name;

}