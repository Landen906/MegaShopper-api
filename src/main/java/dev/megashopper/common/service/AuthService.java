package dev.megashopper.common.service;

import dev.megashopper.common.dtos.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.security.Principal;

@Service
@Transactional
public class AuthService {

    private final UserService userService;

    @Autowired
    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public Principal authenticate(@Valid AuthRequest authRequest) {
        return null;
    }
}
