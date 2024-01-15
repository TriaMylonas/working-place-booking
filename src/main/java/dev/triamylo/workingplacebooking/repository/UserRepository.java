package dev.triamylo.workingplacebooking.repository;

import dev.triamylo.workingplacebooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
