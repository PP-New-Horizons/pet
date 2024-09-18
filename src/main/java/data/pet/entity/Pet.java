package data.pet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

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

    @Column(columnDefinition = "VARCHAR", name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Column(columnDefinition = "VARCHAR", name = "description")
    String description;

    @Column(columnDefinition = "VARCHAR", name = "history")
    String history;

    @ManyToOne
    @JoinColumn(name = "health_type")
    private HealthType healthType;

    @Column(name = "date_of_birth", nullable = false)
    @UpdateTimestamp
    private LocalDateTime dateOfBirth;

    @Column(name = "created_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime createdAt;

    @Column(name = "is_booked")
    private boolean isBooked;

    @Column(name = "breed")
    private boolean breed;

    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petTypeId;

    @ManyToOne
    @JoinColumn(name = "colour_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "hair_id")
    private Hair hair;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;
}
