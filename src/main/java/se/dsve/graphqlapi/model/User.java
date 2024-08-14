package se.dsve.graphqlapi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Long roleId;
    private String note;

    @OneToMany(mappedBy = "user")
    private List<DepartmentUser> departmentUsers;

    // Constructors
    public User() {}

    public User(String name, String email, Long roleId, String note) {
        this.name = name;
        this.email = email;
        this.roleId = roleId;
        this.note = note;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<DepartmentUser> getDepartmentUsers() {
        return departmentUsers;
    }

    public void setDepartmentUsers(List<DepartmentUser> departmentUsers) {
        this.departmentUsers = departmentUsers;
    }
}