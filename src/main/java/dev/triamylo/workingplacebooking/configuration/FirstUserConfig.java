package dev.triamylo.workingplacebooking.configuration;

import dev.triamylo.workingplacebooking.model.Role;
import dev.triamylo.workingplacebooking.model.User;
import dev.triamylo.workingplacebooking.repository.RoleRepository;
import dev.triamylo.workingplacebooking.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Optional;

@Component
public class FirstUserConfig {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TransactionTemplate transaction;
    private final PasswordEncoder passwordEncoder;

    public FirstUserConfig(UserRepository userRepository, RoleRepository roleRepository,
                           TransactionTemplate transaction, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.transaction = transaction;
        this.passwordEncoder = passwordEncoder;
    }

    //    the PostConstruct annotation is used on a method that needs to be executed after
    //    dependency injection is done to perform any initialization task!
    @PostConstruct
    public void initUser() {

//        all of that must in one transaction with the database happen.
//        first we look for the admin role, second check for the admin user.
//        if they are not exist we make them. If they exist we use them.
        transaction.execute(status -> {

            Optional<Role> optionalAdminRole = roleRepository.findByName("ADMIN");

            if(optionalAdminRole.isEmpty()){
                Role adminRole = new Role("ADMIN", "administration role");
                roleRepository.save(adminRole);
                optionalAdminRole = roleRepository.findByName("ADMIN");
            }

            Optional<User> optionalAdminlUser = userRepository.findByUserName("adminUser");

            if (optionalAdminlUser.isEmpty()) {
                User adminUser = new User("adminUser", passwordEncoder.encode("admin"), "admin", "adminLastname", "admin@gmail.com");
                userRepository.save(adminUser);
                optionalAdminlUser = userRepository.findByUserName("adminUser");
            }

            // now that I have both I assign the role to the user and save him to the database
            User adminUser = optionalAdminlUser.get();
            Role adminRole = optionalAdminRole.get();

            if(!adminUser.getRoles().contains(adminRole)){
                adminUser.addRole(adminRole);
                userRepository.save(adminUser);
            }

            return null;
        });
    }

}
