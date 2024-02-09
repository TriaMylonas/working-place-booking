package dev.triamylo.workingplacebooking.service.user;

import dev.triamylo.workingplacebooking.model.User;

import java.util.List;

public interface UserService {
    List<User> list();

    User get(String id);

    void add(User user);

    void delete(User user);

    void update(User user);
}
