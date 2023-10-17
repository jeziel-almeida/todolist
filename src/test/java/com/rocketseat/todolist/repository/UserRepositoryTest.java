package com.rocketseat.todolist.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.rocketseat.todolist.dto.UserDTO;
import com.rocketseat.todolist.model.User;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;
    
    @Test
    @DisplayName("given an username, should find user by username")
    void testFindByUsernameCase1() {

        this.createUser(new UserDTO("anyName", "anyUsername", "anyPassword"));

        User result = userRepository.findByUsername("anyUsername");

        Assertions.assertNotNull(result);

    }

    @Test
    @DisplayName("when username doesn't exist, should return null")
    void testFindByUsernameCase2() {

        User result = userRepository.findByUsername("anyUsername");

        Assertions.assertNull(result);

    }

    public User createUser(UserDTO userDTO) {
        User newUser = new User(userDTO);
        this.entityManager.persist(newUser);
        return newUser;
    }
}
