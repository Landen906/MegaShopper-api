package dev.megashopper.common.repository;

import dev.megashopper.common.entities.Password;
import dev.megashopper.common.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthRepository  extends JpaRepository<User, String> {
    Optional<User> findUserByUsernameAndPassword(String username, Password password);
}
