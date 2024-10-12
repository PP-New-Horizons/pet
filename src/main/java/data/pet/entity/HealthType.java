package data.pet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "health_type")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HealthType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Не состояние здоровья")
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String name;

}