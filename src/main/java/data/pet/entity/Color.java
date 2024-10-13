package data.pet.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "color")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank(message = "Не выбран цвет")
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String name;

}