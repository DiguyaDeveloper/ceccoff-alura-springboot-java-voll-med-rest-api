package med.voll.api.domain.patient;

import med.voll.api.domain.address.Address;
import med.voll.api.domain.phone.Phone;

public record Patient(String name, String email, Phone phone, String document, Address address) {
}
