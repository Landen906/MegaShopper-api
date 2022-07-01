package dev.megashopper.common.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



//
public class Principal {

    private String authCustomerId;
    private String email;
    public Principal(UserResponsePayload user) {
        this.authCustomerId = user.getCustomerId();
    }

    public Principal(String authCustomerId) {
        this.authCustomerId = authCustomerId;
    }

    public Principal(String authCustomerId, String email) {
        this.authCustomerId = authCustomerId;
        this.email = email;
    }

    public String getAuthCustomerId() {
        return authCustomerId;
    }

    public void setAuthCustomerId(String authCustomerId) {
        this.authCustomerId = authCustomerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
