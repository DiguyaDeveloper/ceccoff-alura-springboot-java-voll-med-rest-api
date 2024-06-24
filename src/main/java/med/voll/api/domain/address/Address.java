package med.voll.api.domain.address;

public record Address(
        String street,
        String neighborhood,
        String zipCode,
        String city,
        String state,
        String number,
        String additionalInfo
) {
}