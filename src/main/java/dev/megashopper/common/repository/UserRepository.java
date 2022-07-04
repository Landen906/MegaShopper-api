package dev.megashopper.common.repository;


import dev.megashopper.common.entities.Password;
import dev.megashopper.common.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {


    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    @Query("from User u where u.username = :username")
    List<User> findUsersByUsername(String username);

    Optional<User> createNewUser(String firstName, String lastName, String email, String address, String username, Password password);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsernameAndPassword(String username, Password password);
    Optional<User> findUserById(String id);
}

