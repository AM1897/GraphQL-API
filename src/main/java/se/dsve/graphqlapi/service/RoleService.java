
package se.dsve.graphqlapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dsve.graphqlapi.model.Role;
import se.dsve.graphqlapi.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role newRoleData) {
        return roleRepository.findById(id)
                .map(role -> {
                    role.setName(newRoleData.getName());
                    role.setDescription(newRoleData.getDescription());
                    return roleRepository.save(role);
                })
                .orElseGet(() -> {
                    newRoleData.setId(id);
                    return roleRepository.save(newRoleData);
                });
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}