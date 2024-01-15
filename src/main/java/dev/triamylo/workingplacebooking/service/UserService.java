package dev.triamylo.workingplacebooking.service;

import dev.triamylo.workingplacebooking.model.User;

import java.util.List;

public interface UserService {
    List<User> list();

    User get(String id);

    void add(User user);

    boolean delete(User user);

    boolean update(User user);
}
