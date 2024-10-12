package data.pet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gender")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Не выбран пол")
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String name;

}