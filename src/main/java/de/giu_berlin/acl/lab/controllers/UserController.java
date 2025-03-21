package de.giu_berlin.acl.lab.controllers;

import de.giu_berlin.acl.lab.models.User;
import de.giu_berlin.acl.lab.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("hello")
    public String helloTest() {
        return "Hello!";
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getUserById(
            @PathVariable(name = "id") UUID id
    ) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(
            @RequestBody User user
    ) {
        return userService.createUser(user);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleUserNotFoundException(ResponseStatusException e) {
        return new ResponseEntity<>(e.getReason(), e.getStatusCode());
    }
}
