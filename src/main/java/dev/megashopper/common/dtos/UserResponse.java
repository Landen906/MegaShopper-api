package dev.megashopper.common.dtos;

import dev.megashopper.common.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String username;


    public UserResponse(User user) {
        this.id = user.getCustomerId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
    }
}
