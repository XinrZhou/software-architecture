package com.example.softwarearchitecture.repository;

import com.example.softwarearchitecture.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest() {
        User user = User.builder()
                .account("admin")
                .password("admin")
                .role(User.ADMIN)
                .build();
        userRepository.save(user);
    }

    @Test
    public void findUserById() {
        userRepository.findById(2).ifPresent(u -> log.debug(u.getAccount()));
    }

    @Test
    public void findByAid() {
        log.debug(userRepository.getClass().getName());
        userRepository.find(1).ifPresent(u -> log.debug(u.getAccount()));
    }
}
