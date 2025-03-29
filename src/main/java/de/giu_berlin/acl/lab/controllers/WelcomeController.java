package de.giu_berlin.acl.lab.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("welcome")
public class WelcomeController {

    @GetMapping
    public String welcome() {
        final String nameEnv = System.getenv("NAME");

        if (nameEnv == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "$NAME Environment is null!");
        }

        return "Welcome, " + nameEnv;
    }
}
