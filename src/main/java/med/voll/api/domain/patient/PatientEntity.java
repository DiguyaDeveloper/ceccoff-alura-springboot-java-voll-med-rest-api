package med.voll.api.domain.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.AddressEntity;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.UpdateDoctor;
import med.voll.api.domain.doctor.enums.Speciality;
import med.voll.api.domain.phone.PhoneEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "patient")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String name;
    private String email;
    private String document;
    private Boolean active;
    @Embedded
    private AddressEntity address;
    @Embedded
    private PhoneEntity phone;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public PatientEntity(Patient patient) {
        this.name = patient.name();
        this.email = patient.email();
        this.address = new AddressEntity(patient.address());
        this.phone = new PhoneEntity(patient.phone());
        this.active = true;
        this.document = patient.document();
    }

    public void update(UpdatePatient patient) {
        if (!patient.name().isEmpty()) {
            this.name = patient.name();
        }

        if (patient.address() != null) {
            this.address.update(patient.address());
        }

        if (patient.phone() != null) {
            this.phone.update(patient.phone());
        }
    }

    public void inactivate() {
        this.active = false;
    }
}
