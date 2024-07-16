package med.voll.api.domain.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.address.Address;
import med.voll.api.domain.doctor.enums.Speciality;
import med.voll.api.domain.phone.Phone;

public record Doctor(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Speciality speciality,
        @NotNull
        @Valid
        Address address,
        @NotNull
        @Valid
        Phone phone
) {
}
