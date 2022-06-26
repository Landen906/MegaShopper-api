package dev.megashopper.common.service;

<<<<<<< Updated upstream

=======
import dev.megashopper.common.dtos.UserResponse;
import dev.megashopper.common.entities.User;
>>>>>>> Stashed changes
import dev.megashopper.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepo;

    @Autowired
<<<<<<< Updated upstream
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
}
=======
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



    public List<UserResponse> fetchAllUsers() {
        return userRepository.fetchAllUsers().stream().map(UserResponse::new).collect(Collectors.toList());
    }

    }
>>>>>>> Stashed changes
