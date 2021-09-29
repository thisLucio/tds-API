package io.tcc.userservice.repository;

import io.tcc.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
        User findByUsername(String username);

}
