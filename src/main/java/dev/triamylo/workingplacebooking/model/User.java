package dev.triamylo.workingplacebooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id()
    @UuidGenerator
    private String id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Role> roles;

    public User(String userName,String password,String firstName,String lastName,String email){

        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = new ArrayList<>();
    }

    public void addRole(Role role){
        roles.add(role);
    }
    public void removeRole(Role role){
        roles.remove(role);
    }
}
