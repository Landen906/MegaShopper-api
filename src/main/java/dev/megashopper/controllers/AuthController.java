package dev.megashopper.controllers;

import dev.megashopper.common.dtos.AuthRequest;
import dev.megashopper.common.dtos.Principal;
import dev.megashopper.common.dtos.TokenService;
import dev.megashopper.common.dtos.UserResponsePayload;
import dev.megashopper.common.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
@Data
@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final TokenService tokenService;
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Principal authenticate(@RequestBody AuthRequest authRequest, HttpServletResponse resp) {
        UserResponsePayload authUser = userService.authenticateUserCredentials(authRequest);
        Principal payload = new Principal(authUser);
        resp.setHeader("Authorization", tokenService.generateToken(payload));
        return payload;
    }
}
