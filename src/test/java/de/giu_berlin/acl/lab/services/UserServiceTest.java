package de.giu_berlin.acl.lab.services;

import de.giu_berlin.acl.lab.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void createUser_withValidInput_shouldReturnSameNameAndEmail() {
        User dummyUser = new User(
                "Name",
                22,
                "email.1@mail.com"
        );

        User actualUser = userService.createUser(dummyUser);

        assertEquals(dummyUser.getName(), actualUser.getName());
        assertEquals(dummyUser.getEmail(), actualUser.getEmail());
    }
}