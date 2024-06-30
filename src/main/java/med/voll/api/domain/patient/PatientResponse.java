package med.voll.api.domain.patient;

import med.voll.api.domain.doctor.DoctorEntity;
import med.voll.api.domain.doctor.enums.Speciality;
import med.voll.api.domain.phone.Phone;

import java.util.UUID;

public record PatientResponse(
        UUID id,
        String name,
        String email,
        String document,
        String phone
) {
        public PatientResponse(PatientEntity patient) {
                this(
                        patient.getId(),
                        patient.getName(),
                        patient.getEmail(),
                        patient.getDocument(),
                        patient.getPhone().getPhone()
                );
        }
}
