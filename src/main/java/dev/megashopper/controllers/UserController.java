package dev.megashopper.controllers;
import dev.megashopper.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.megashopper.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Rest controller combines @Controller and @ResponseBody(changes return value to HTTP response)
@RestController
@RequestMapping("/User")

public class UserController<ResourceCreationResponse, NewUserRequest> {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService, UserService userService1) {
        this.userService = userService;
    }

/* TODO: This code will not work until it has been implemented into UserRepository
*   */
    @GetMapping(produces = "application/json")
    public <UserResponse> List<UserResponse> getAllUsers() {
        return (List<UserResponse>) userService.fetchAllUsers();
    }

    @GetMapping("/id/{customerId}")
    public <UserResponse> UserResponse getUserById(@PathVariable String customerId) {
        return (UserResponse) userService.fetchUserById(customerId);
    }

    /* TODO: Uncomment/Need Import from UserRepository after implementing 'createUser' method
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResourceCreationResponse postNewUser (@RequestBody NewUserRequest newUser) {
        return userService.createUser(newUser);
    }

}
