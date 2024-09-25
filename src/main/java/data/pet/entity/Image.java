package data.pet.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 256)
    @EqualsAndHashCode.Include
    private String name;

    @Column(unique = true, nullable = false, length = 1024)
    @EqualsAndHashCode.Include
    private String path;

    @EqualsAndHashCode.Include
    private boolean isAvatar;

}