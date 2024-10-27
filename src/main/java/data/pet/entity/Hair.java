package data.pet.entity;

import jakarta.persistence.*;
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

    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String name;

}