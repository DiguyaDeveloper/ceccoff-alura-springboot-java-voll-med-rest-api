package med.voll.api.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Address(
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zipCode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String number,
        String additionalInfo
) {
    public Address(AddressEntity address) {
        this(
                address.getStreet(),
                address.getNeighborhood(),
                address.getZipCode(),
                address.getCity(),
                address.getState(),
                address.getNumber(),
                address.getAdditionalInfo()
        );

    }
}