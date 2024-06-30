package med.voll.api.domain.phone;

import jakarta.validation.constraints.NotBlank;

public record Phone(
        @NotBlank
        String DDD,
        @NotBlank
        String number) {
}
