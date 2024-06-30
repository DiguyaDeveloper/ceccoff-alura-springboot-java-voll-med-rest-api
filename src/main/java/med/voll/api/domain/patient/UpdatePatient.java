package med.voll.api.domain.patient;

import med.voll.api.domain.address.Address;
import med.voll.api.domain.phone.Phone;

public record UpdatePatient(
        String name,
        Address address,
        Phone phone
) {
}
