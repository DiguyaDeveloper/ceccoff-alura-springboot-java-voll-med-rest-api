package med.voll.api.domain.doctor;

import med.voll.api.domain.doctor.enums.Speciality;

public record DoctorResponse(
        String name,
        String email,
        String crm,
        Speciality specialty
) {
        public DoctorResponse(DoctorEntity doctor) {
                this(
                        doctor.getName(),
                        doctor.getEmail(),
                        doctor.getCrm(),
                        doctor.getSpeciality()
                );
        }
}
