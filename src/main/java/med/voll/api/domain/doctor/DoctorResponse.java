package med.voll.api.domain.doctor;

import med.voll.api.domain.doctor.enums.Speciality;

import java.util.UUID;

public record DoctorResponse(
        UUID id,
        String name,
        String email,
        String crm,
        Speciality specialty
) {
        public DoctorResponse(DoctorEntity doctor) {
                this(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getEmail(),
                        doctor.getCrm(),
                        doctor.getSpeciality()
                );
        }
}
