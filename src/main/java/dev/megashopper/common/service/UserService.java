package dev.megashopper.common.service;

import dev.megashopper.common.entities.User;
import dev.megashopper.common.repository.UserRepository;
import dev.megashopper.common.utils.exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

/* TODO: Uncomment/Need Import from UserRepository after implementing 'createUser' method
  */
    // Method
//    public UserResponse createNewUser(User newUser) {
//
//        if (newUser == null ||
//
//                newUser.getQuestionText() == null || newUser.getQuestionText().equals("") ||
//                newUser.getAnswerText() == null || newUser.getAnswerText().equals(""))
//        {
//            String msg = "Provided user data was invalid. Question and answer text must not be null or empty!";
//            throw new InvalidRequestException(msg);
//        }
//
//        return new UserResponse(userRepository.createUser(newUser).getcustomerId());
//    }

    }