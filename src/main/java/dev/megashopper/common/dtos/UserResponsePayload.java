package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.Password;
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
    private Password password;
    public UserResponsePayload(User user) {
        this.customerId = user.getCustomerId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
