
package se.dsve.graphqlapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.dsve.graphqlapi.model.User;
import se.dsve.graphqlapi.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User newUserData) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUserData.getName());
                    user.setEmail(newUserData.getEmail());
                    user.setRoleId(newUserData.getRoleId());
                    user.setNote(newUserData.getNote());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUserData.setId(id);
                    return userRepository.save(newUserData);
                });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}