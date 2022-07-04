package dev.megashopper.common.service;

import com.shippo.exception.InvalidRequestException;
import dev.megashopper.common.datasource.EntitySearcher;
import dev.megashopper.common.dtos.*;
import dev.megashopper.common.dtos.UserResponse;
import dev.megashopper.common.entities.User;
import dev.megashopper.common.repository.UserRepository;
import dev.megashopper.common.utils.exceptions.ResourceNotFoundException;
import dev.megashopper.common.utils.exceptions.ResourcePersistenceException;
import dev.megashopper.common.utils.web.validators.groups.OnCreate;
import dev.megashopper.common.utils.web.validators.groups.OnUpdate;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.naming.AuthenticationException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Validated
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final EntitySearcher entitySearcher;
    @Autowired
    public UserService(UserRepository userRepository, EntitySearcher entitySearcher) {
        this.userRepository = userRepository;
        this.entitySearcher = entitySearcher;
    }

    public List<UserResponse> fetchAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }
    public List<UserResponsePayload> search(Map<String, String> requestParamMap) {
        if (requestParamMap.isEmpty()) fetchAllUsers();
        Set<User> matchingUsers = entitySearcher.searchForEntity(requestParamMap, User.class);
        if (matchingUsers.isEmpty()) throw new ResourceNotFoundException();
        return matchingUsers.stream()
                .map(UserResponsePayload::new)
                .collect(Collectors.toList());
    }

    public boolean isUsernameAvailability(@Valid UsernameRequest request) {
        return !userRepository.existsByUsername(request.getUsername());
    }

    public boolean isEmailAvailability(@Valid EmailRequest request) {
        return !userRepository.existsByEmail(request.getEmail());
    }

    public UserResponsePayload fetchUserByEmail(@Valid EmailRequest request) {
        return userRepository.findUserByEmail(request.getEmail())
                .map(UserResponsePayload::new)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Validated(OnCreate.class)
    public ResourceCreationResponse createUser(@Valid UserRequestPayload newUserRequest) {

        User newUser = newUserRequest.extractResource();

        if (userRepository.existsByUsername(newUser.getUsername())) {
            throw new ResourcePersistenceException("There is already a user with that username!");
        }
      
     
    /* TODO: Uncomment/Need Import from UserRepository after implementing 'createUser' method
     */
    // Method
//    public UserResponse createUser(User newUser.){
//
//        if (newUser == null ||
//
//                newUser.getUsername() == null || newUser.getUsername().equals("") ||
//                newUser.getPassword() == null || newUser.getPassword().equals(""))
//        {
//            String msg = "Provided user data was invalid. Question and answer text must not be null or empty!";
//            throw new InvalidRequestException(msg);
//        }
//
//        return new UserResponse.(newUser).getCustomerId();
//    }

        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new ResourcePersistenceException("There is already a user with that email!");
        }

        newUser.setCustomerId();
        userRepository.save(newUser);

        return new ResourceCreationResponse(newUser.getCustomerId());

    }

    @Validated(OnUpdate.class)
    public void updateUser(@Valid UserRequestPayload updatedUserRequest) {

        User updatedUser = updatedUserRequest.extractResource();
        User userForUpdate = userRepository.findById(updatedUser.getCustomerId()).orElseThrow(ResourceNotFoundException::new);

        if (updatedUser.getFirstName() != null) {
            userForUpdate.setFirstName(updatedUser.getFirstName());
        }

        if (updatedUser.getLastName() != null) {
            userForUpdate.setLastName(updatedUser.getLastName());
        }

        if (updatedUser.getEmail() != null) {
            if (userRepository.existsByEmail(updatedUser.getEmail())) {
                throw new ResourcePersistenceException("There is already a user with that email!");
            }
            userForUpdate.setEmail(updatedUser.getEmail());
        }

        if (updatedUser.getUsername() != null) {
            if (userRepository.existsByUsername(updatedUser.getUsername())) {
                throw new ResourcePersistenceException("There is already a user with that username!");
            }
            userForUpdate.setUsername(updatedUser.getUsername());
        }

        if (updatedUser.getPassword() != null) {
            userForUpdate.setPassword(updatedUser.getPassword());
        }

    }

    @SneakyThrows
    public UserResponsePayload authenticateUserCredentials(@Valid AuthRequest authRequest) {
        return userRepository.findUserByUsernameAndPassword(authRequest.getUsername(), authRequest.getPassword())
                .map(UserResponsePayload::new)
                .orElseThrow(AuthenticationException::new);
    }
    public UserResponsePayload findUserById(String id) {
        return userRepository.findUserById(id)
                .map(UserResponsePayload::new)
                .orElseThrow(ResourceNotFoundException::new);
    }

}

//    public UserResponse fetchUserBycustomerId(String customerId) {
//        return userRepository.findById(customerId)
//                .map(UserResponse::new)
//                .orElseThrow(InvalidRequestException::new);
//    }
//
//    public UserResponse fetchUserByUsername(@Min(3) String username) {
//        return userRepository.findUserByUsername(username)
//                .map(UserResponse::new)
//                .orElseThrow(InvalidRequestException::new);
//    }
//
//
//    public UserResponse fetchUserByEmail(@Email String email) {
//        return UserRepository.findUserByEmail(email)
//                .map(UserResponse::new)
//                .orElseThrow(InvalidRequestException::new);
//    }
//
//    public UserResponse createUser(@Valid NewUserRequest newUserRequest) {
//
//        User newUser = newUserRequest.extractResource();
//
//        if (userRepository.existsByUsername(newUser.getUsername())) {
//            throw new InvalidRequestException("There is already a user with that username!");
//        }
//
//        if (userRepository.existsByEmail(newUser.getEmail())) {
//            throw new InvalidRequestException("There is already a user with that email!");
//        }
//
//        new.setcustomerId(UUID.randomUUID().toString());
//        userRepository.save(newUser);
//
//        return new InvalidRequestException(.getcustomerId());
//    }
//
//    public void updateUser(@Valid UpdateUserRequest updateUserRequest) {
//        // TODO: 6/26/22 implement update
//    }
//
//    public UserResponse authenticateUserCredentials(@Valid AuthRequest authRequest) {
//        return userRepository.findUserByUsernameAndPassword(authRequest.getUsername(), authRequest.getPassword()
//                .map(UserResponse::new)
//                .orElseThrow(AuthenticationException::new));
//    }
//
//
//}


