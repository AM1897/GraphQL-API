package se.dsve.graphqlapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dsve.graphqlapi.model.DepartmentUser;
import se.dsve.graphqlapi.repository.DepartmentUserRepository;

import java.util.List;

@Service
public class DepartmentUserService {

    @Autowired
    private DepartmentUserRepository departmentUserRepository;

    public List<DepartmentUser> getAllDepartmentUsers() {
        return departmentUserRepository.findAll();
    }

    public DepartmentUser getDepartmentUserById(Long id) {
        return departmentUserRepository.findById(id).orElse(null);
    }

    public DepartmentUser createDepartmentUser(DepartmentUser departmentUser) {
        return departmentUserRepository.save(departmentUser);
    }

    public void deleteDepartmentUser(Long id) {
        departmentUserRepository.deleteById(id);
    }
}
