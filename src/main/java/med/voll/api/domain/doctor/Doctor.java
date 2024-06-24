package med.voll.api.domain.doctor;

import med.voll.api.domain.address.Address;
import med.voll.api.domain.doctor.enums.Speciality;

public record Doctor(
        String name,
        String email,
        String crm,
        Speciality specialty,
        Address address
) {
}
