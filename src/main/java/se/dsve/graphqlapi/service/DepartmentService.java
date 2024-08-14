package se.dsve.graphqlapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dsve.graphqlapi.model.Department;
import se.dsve.graphqlapi.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department newDepartmentData) {
        return departmentRepository.findById(id)
                .map(department -> {
                    department.setName(newDepartmentData.getName());
                    department.setDescription(newDepartmentData.getDescription());
                    return departmentRepository.save(department);
                })
                .orElseGet(() -> {
                    newDepartmentData.setId(id);
                    return departmentRepository.save(newDepartmentData);
                });
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}