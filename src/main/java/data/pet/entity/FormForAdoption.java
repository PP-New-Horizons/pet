package data.pet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "form_for_adoption")
public class FormForAdoption {
    @Id
    private Long id;

    @Column(name = "adopters_name")
    private String adoptersName;

    @Column(name = "adopters_last_name")
    private String adoptersLastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet pet;

    private LocalDateTime dateOfCreated;

    @PrePersist
    protected void onCreate() {
        dateOfCreated = LocalDateTime.now();
    }
}
