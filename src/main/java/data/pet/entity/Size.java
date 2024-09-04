package data.pet.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "size")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String name;

}