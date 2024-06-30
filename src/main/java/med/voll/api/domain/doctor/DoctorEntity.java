package med.voll.api.domain.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.AddressEntity;
import med.voll.api.domain.doctor.enums.Speciality;
import med.voll.api.domain.phone.PhoneEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "doctor")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;
    private String email;
    private String crm;
    private Boolean active;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @Embedded
    private AddressEntity address;
    @Embedded
    private PhoneEntity phone;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public DoctorEntity(Doctor doctor) {
        this.name = doctor.name();
        this.email = doctor.email();
        this.crm = doctor.crm();
        this.address = new AddressEntity(doctor.address());
        this.speciality = doctor.specialty();
        this.phone = new PhoneEntity(doctor.phone());
        this.active = true;
    }

    public void update(UpdateDoctor doctor) {
        if (!doctor.name().isEmpty()) {
            this.name = doctor.name();
        }

        if (doctor.address() != null) {
            this.address.update(doctor.address());
        }

        if (doctor.phone() != null) {
            this.phone.update(doctor.phone());
        }
    }

    public void inactivate() {
        this.active = false;
    }
}
