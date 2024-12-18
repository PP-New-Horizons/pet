package data.pet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private List<Image> images;

    //    @Pattern(message = "Не верный формат имени: ${validatedValue}",
//            regexp = "^(?:[А-Яа-яЁё]{2,25}|[А-Яа-яЁё]{1,24}(-[А-Яа-яЁё]{1,24})+)$")
//    @Length(min = 2)
    @Column(columnDefinition = "VARCHAR", name = "name")
//    @ManyToOne
            String name;

    //    @Valid
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    /*@Column(name = "age")
    Integer age;*/

    //    @NotNull
    @Column(columnDefinition = "VARCHAR", name = "description")
    String description;

    @Column(columnDefinition = "VARCHAR", name = "history")
    String history;

    //    @Valid
    @ManyToOne
    @JoinColumn(name = "health_type")
    private HealthType healthType;

    @Column(name = "date_of_birth", nullable = false)
    @UpdateTimestamp
    private LocalDate dateOfBirth;

    @Column(name = "created_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime createdAt;

    @Column(name = "is_booked")
    private boolean isBooked;

    @Column(name = "is_adopted")
    private boolean isAdopted;

    @Column(name = "breed")
    private boolean breed;

    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petTypeId;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    //    @Valid
    @ManyToOne
    @JoinColumn(name = "hair_id")
    private Hair hair;

    //    @Valid
    @ManyToOne
    @JoinColumn(name = "size_id")
    private PetSize petSize;
}
