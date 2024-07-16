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
        @NotBlank(message = "{name.required}")
        String name,
        @NotBlank(message = "{email.required}")
        @Email(message = "{email.invalid}")
        String email,
        @NotBlank(message = "{crm.required}")
        @Pattern(regexp = "\\d{4,6}", message = "{crm.invalid}")
        String crm,
        @NotNull(message = "{speciality.required}")
        Speciality speciality,
        @NotNull(message = "{address.required}")
        @Valid
        Address address,
        @NotNull(message = "{phone.required}")
        @Valid
        Phone phone
) {
}
