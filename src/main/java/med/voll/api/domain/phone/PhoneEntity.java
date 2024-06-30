package med.voll.api.domain.phone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneEntity {

    private String phone;

    public PhoneEntity(Phone phone) {
        this.phone = "(%s) %s".formatted(phone.DDD(), phone.number());
    }
}
