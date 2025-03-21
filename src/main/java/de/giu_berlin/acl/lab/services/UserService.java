package de.giu_berlin.acl.lab.services;

import de.giu_berlin.acl.lab.models.User;
import de.giu_berlin.acl.lab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.fetchAll();
    }

    public User getUserById(UUID id) {
        return userRepository.fetchById(id);
    }

    public User createUser(User inputUser) {
        User userWithId = new User(
                inputUser.getName(),
                inputUser.getAge(),
                inputUser.getEmail()
        );

        return userRepository.save(userWithId);
    }
}
