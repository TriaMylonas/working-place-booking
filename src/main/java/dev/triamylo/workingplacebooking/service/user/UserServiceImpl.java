package dev.triamylo.workingplacebooking.service.user;

import dev.triamylo.workingplacebooking.model.User;
import dev.triamylo.workingplacebooking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    TODO add the Encoder, and in the constructor
//    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
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
//        TODO here I must hash the password first and then save it to DB
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {

        User existingUser = userRepository.findById(user.getId()).orElse(null);

        if (existingUser == null) {
            return;
        }

        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
//        TODO here to add the password and encode
//        if (aUser.getPassword() != null && !aUser.getPassword().isEmpty()) {
//            existingUser.setPassword(passwordEncoder.encode(aUser.getPassword()));
//        }
//
        userRepository.save(existingUser);
    }


    public Optional<User> findByUserName(String name) {
        return userRepository.findByUserName(name);
    }


}
