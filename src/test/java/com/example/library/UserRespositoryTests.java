package com.example.library;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.example.library.Repository.UserRepository;

@DataJpaTest
public class UserRespositoryTests {
    

        @Autowired
        private UserRepository UserRepository;

            //JUnit Test for save users

    @Test
    public void saveUserTest(){

        User user = User.builder()
            .firstName("Muhammad")
            .lastName("Zeeshan")
            .email("muhammadzeeshan1806@gmail.com")
            .phoneNo("+8618868232491")
            .build();

        UserRepository.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    public void getUserTest(){

        User user = UserRepository.findById(1).get();

        Assertions.assertThat(user.getId()).isEqualTo(1L);
    }

    @Test
    public void getListofUser(){

        java.util.List<User> users = UserRepository.findAll();

        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    public void updateUserTest(){
        User user = UserRepository.findById(1).get();
        user.setId(1);

        User userUpdatedUser = UserRepository.save(user);

        Assertions.assertThat(userUpdatedUser.getId()).isEqualTo(1L);
    }

    @Test
    public void deleteUserTest(){

        User user = UserRepository.findById(1).get();

        UserRepository.delete(user);

        User user2 = null;
        Optional<User> optionalUser = UserRepository.findbyEmail("muhammadzeeshan1806@gmail.com");

        if (optionalUser.isPresent()) {
            user2 = optionalUser.get();
        }

        Assertions.assertThat(user).isNull();
    }
}
