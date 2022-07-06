package dev.megashopper.common.service;

import dev.megashopper.common.dtos.AuthRequest;
import dev.megashopper.common.dtos.UserResponsePayload;
import dev.megashopper.common.repository.AuthRepository;
import dev.megashopper.common.utils.exceptions.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dev.megashopper.common.dtos.Principal;
import javax.validation.Valid;
//import java.security.Principal;

@Service
@Transactional
public class AuthService {

    private final UserService userService;
    private final AuthRepository authRepo;

    @Autowired
    public AuthService(UserService userService, AuthRepository authRepo) {
        this.authRepo = authRepo;
        this.userService = userService;
    }

    public Principal authenticate(@Valid AuthRequest authRequest) {
        return authRepo.findUserByEmailAndPassword(authRequest.getEmail(), authRequest.getPassword())
                .map(UserResponsePayload::new)
                .map(Principal::new)
                .orElseThrow(AuthenticationException::new);

    }
}
