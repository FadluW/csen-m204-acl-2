package de.giu_berlin.acl.lab.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.giu_berlin.acl.lab.models.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {

    public List<User> fetchAll() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("users.json");
            InputStream inputStream = resource.getInputStream();
            return objectMapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "File not found: " + e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public User fetchById(UUID id) {
        Optional<User> fetchedUser = fetchAll().stream().filter(user -> user.getId().equals(id)).findFirst();

        if (fetchedUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID: " + id + " not found!");
        }

        return fetchedUser.get();
    }

    public User save(User user) {
        return user;
    }
}
