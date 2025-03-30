package de.giu_berlin.acl.lab.models;

import jakarta.persistence.Entity;

import java.util.Random;
import java.util.UUID;

@Entity
public class User {
    private UUID id = UUID.randomUUID();
    private String name;
    private Integer age;
    private String email;

    public User() {
    }

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public static User generateRandom() {
        Random rand = new Random();

        return new User(
                "Name " + rand.nextInt(),
                rand.nextInt(99),
                "email." + rand.nextInt() + "@mail.com"
        );
    }
}
