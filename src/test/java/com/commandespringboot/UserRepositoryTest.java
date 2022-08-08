package com.commandespringboot;

import com.commandespringboot.models.User;
import com.commandespringboot.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
/*
    @Autowired
    private UserRepository userRepository;
    @Test
    public  void testAddUser(){

        User user = new User();
        user.setNom("admin");
        user.setPrenom("admin");
        user.setUserName("admin@gmail.com");
        user.setPassword("passer");
        user.setRoles("ROLE_ADMIN");

        User okay = userRepository.saveAndFlush(user);

        Assertions.assertThat(okay).isNotNull();
        Assertions.assertThat(okay.getId()).isGreaterThan(0);
    }*/
}
