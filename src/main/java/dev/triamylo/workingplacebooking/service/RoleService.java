package dev.triamylo.workingplacebooking.service;

import dev.triamylo.workingplacebooking.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> list();

    Role get(String id);

    void add(Role role);

    boolean delete(Role role);

    boolean update(Role role);
}
