package med.voll.api.domain.doctor;

import med.voll.api.domain.address.Address;
import med.voll.api.domain.doctor.enums.Speciality;
import med.voll.api.domain.phone.Phone;

public record Doctor(
        String name,
        String email,
        String crm,
        Speciality specialty,
        Address address,
        Phone phone
) {
}
