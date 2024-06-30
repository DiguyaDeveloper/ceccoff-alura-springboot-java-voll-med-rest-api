package med.voll.api.domain.doctor;

import med.voll.api.domain.address.Address;
import med.voll.api.domain.phone.Phone;

public record UpdateDoctor(
        String name,
        Address address,
        Phone phone
) {
}
