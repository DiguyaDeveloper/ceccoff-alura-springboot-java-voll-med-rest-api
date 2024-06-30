package med.voll.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {
    private String street;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private String number;
    private String additionalInfo;

    public AddressEntity(Address address) {
        this.street = address.street();
        this.neighborhood = address.neighborhood();
        this.zipCode = address.zipCode();
        this.city = address.city();
        this.state = address.state();
        this.number = address.number();
        this.additionalInfo = address.additionalInfo();
    }
}
