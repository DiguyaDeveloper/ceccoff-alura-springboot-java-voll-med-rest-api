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

    public void update(Address address) {
        if (address.street() != null) {
            this.street = address.street();
        }
        if (address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if (address.zipCode() != null) {
            this.zipCode = address.zipCode();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.state() != null) {
            this.state = address.state();
        }
        if (address.number() != null) {
            this.number = address.number();
        }
        if (address.additionalInfo() != null) {
            this.additionalInfo = address.additionalInfo();
        }
    }
}
