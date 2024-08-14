package se.dsve.graphqlapi.resolver;

import se.dsve.graphqlapi.model.User;
import se.dsve.graphqlapi.model.Role;
import se.dsve.graphqlapi.model.Department;
import se.dsve.graphqlapi.model.DepartmentUser;
import se.dsve.graphqlapi.repository.UserRepository;
import se.dsve.graphqlapi.repository.RoleRepository;
import se.dsve.graphqlapi.repository.DepartmentRepository;
import se.dsve.graphqlapi.repository.DepartmentUserRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final DepartmentRepository departmentRepository;
    private final DepartmentUserRepository departmentUserRepository;

    public Query(UserRepository userRepository, RoleRepository roleRepository,
                 DepartmentRepository departmentRepository, DepartmentUserRepository departmentUserRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.departmentRepository = departmentRepository;
        this.departmentUserRepository = departmentUserRepository;
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Iterable<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Iterable<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public Iterable<DepartmentUser> findAllDepartmentUsers() {
        return departmentUserRepository.findAll();
    }

    public String hello() {
        return "Hello, world!";
    }
}
