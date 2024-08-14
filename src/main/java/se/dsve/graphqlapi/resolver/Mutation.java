package se.dsve.graphqlapi.resolver;

import se.dsve.graphqlapi.model.User;
import se.dsve.graphqlapi.model.Role;
import se.dsve.graphqlapi.model.Department;
import se.dsve.graphqlapi.model.DepartmentUser;
import se.dsve.graphqlapi.repository.UserRepository;
import se.dsve.graphqlapi.repository.RoleRepository;
import se.dsve.graphqlapi.repository.DepartmentRepository;
import se.dsve.graphqlapi.repository.DepartmentUserRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;


@Component
public class Mutation implements GraphQLMutationResolver {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final DepartmentRepository departmentRepository;
    private final DepartmentUserRepository departmentUserRepository;

    public Mutation(UserRepository userRepository, RoleRepository roleRepository,
                    DepartmentRepository departmentRepository, DepartmentUserRepository departmentUserRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.departmentRepository = departmentRepository;
        this.departmentUserRepository = departmentUserRepository;
    }

    public User createUser(String name, String email, Long roleId, String note) {
        Role role = roleRepository.findById(roleId).orElseThrow();
        User user = new User(name, email, roleId, note);
        return userRepository.save(user);
    }

    public Role createRole(String name, String description) {
        Role role = new Role(name, description);
        return roleRepository.save(role);
    }

    public Department createDepartment(String name, String description) {
        Department department = new Department(name, description);
        return departmentRepository.save(department);
    }

    public DepartmentUser assignUserToDepartment(Long userId, Long departmentId) {
        User user = userRepository.findById(userId).orElseThrow();
        Department department = departmentRepository.findById(departmentId).orElseThrow();
        DepartmentUser departmentUser = new DepartmentUser(user, department);
        return departmentUserRepository.save(departmentUser);
    }
}
