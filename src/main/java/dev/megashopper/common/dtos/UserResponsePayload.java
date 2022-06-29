package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserResponsePayload {

    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String username;

    public UserResponsePayload(User user) {
        this.customerId = user.getCustomerId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.username = user.getUsername();
    }
}
