package dev.megashopper.common.repository;

import dev.megashopper.common.entities.Password;
import dev.megashopper.common.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

// TODO: Finish Implementing - UserRepository = UserDaoPostgres from foundation project

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    User findUserByUsername(String username);
    User findUserByEmail(String email);
    User findUserByUsernameAndPassword(String username, Password password);
    List<User> fetchAllUsers();

}

