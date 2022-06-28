package dev.megashopper.common.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Principal {

    private String authCustomerId;
    private String email;
    public Principal(UserResponsePayload user) {
        this.authCustomerId = user.getCustomerId();
    }

    public Principal(String authCustomerId) {
        this.authCustomerId = authCustomerId;
    }
}
