package dev.triamylo.workingplacebooking.service;

import dev.triamylo.workingplacebooking.model.User;
import dev.triamylo.workingplacebooking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User get(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean delete(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());

        if (existingUser.isPresent()) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());

        if(existingUser.isPresent()){
            User updatedUser = existingUser.get();
            updatedUser.setUserName(user.getUserName());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setEmail(user.getEmail());
            userRepository.save(updatedUser);
        }

        return false;
    }
}
