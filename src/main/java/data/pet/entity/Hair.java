package data.pet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hair")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Hair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Не указан цвет")
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String name;

}