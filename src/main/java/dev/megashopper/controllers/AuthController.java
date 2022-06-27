package dev.megashopper.controllers;

import dev.megashopper.common.dtos.AuthRequest;
import dev.megashopper.common.dtos.Principal;
import dev.megashopper.common.dtos.UserResponse;
import dev.megashopper.common.dtos.UserResponsePayload;
import dev.megashopper.common.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Principal authenticate(@RequestBody AuthRequest authRequest, HttpServletResponse resp) {
        UserResponsePayload authUser = userService.authenticateUserCredentials(authRequest);
        Principal payload = new Principal(authUser);
            resp.setHeader("Authorization");
            return payload;
        }
    }
