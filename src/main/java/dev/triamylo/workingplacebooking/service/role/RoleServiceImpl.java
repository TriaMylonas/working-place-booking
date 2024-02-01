package dev.triamylo.workingplacebooking.service.role;

import dev.triamylo.workingplacebooking.model.Role;
import dev.triamylo.workingplacebooking.repository.RoleRepository;
import dev.triamylo.workingplacebooking.service.role.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Override
    public Role get(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public boolean delete(Role role) {

        Optional<Role> existingRole = roleRepository.findById(role.getId());

        if (existingRole.isPresent()) {
            roleRepository.delete(role);
            return true;
        }

        return false;
    }

    @Override
    public boolean update(Role role) {
        Optional<Role> existingRole = roleRepository.findById(role.getId());

        if (existingRole.isPresent()) {
            Role updatedRole = existingRole.get();

            updatedRole.setName(role.getName());
            updatedRole.setDescription(role.getDescription());

            roleRepository.save(updatedRole);
            return true;
        }
        return false;
    }
}
