package dev.megashopper.common.dtos;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Principal {

    private String authCustomerId;

    public Principal(UserResponsePayload user) {
        this.authCustomerId = user.getCustomerId();
    }

    public Principal(String authCustomerId) {
        this.authCustomerId = authCustomerId;
    }
}
