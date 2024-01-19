package dev.triamylo.workingplacebooking.repository;

import dev.triamylo.workingplacebooking.model.Role;
import dev.triamylo.workingplacebooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserName(String name);

}
