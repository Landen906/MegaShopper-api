package dev.megashopper.common.dtos;


import dev.megashopper.common.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class Principal {
    private String authUserId;
    private String authUsername;

    public Principal(UserResponse user) {
        this.authUserId = String.valueOf(user.getCustomerId());
        this.authUsername = String.valueOf(user.getUsername());
    }

    public Principal(String authUserId, String authUserRole) {
        this.authUserId = authUserId;
        this.authUsername = authUserRole;
    }
}
