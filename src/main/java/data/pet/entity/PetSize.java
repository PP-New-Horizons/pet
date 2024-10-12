package data.pet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "size")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PetSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Не указан размер")
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String name;

}