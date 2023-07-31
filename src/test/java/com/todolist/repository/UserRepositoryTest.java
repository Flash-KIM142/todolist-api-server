package com.todolist.repository;

import com.todolist.exception.UserNotFoundException;
import com.todolist.model.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("User 저장")
    void testSaveUser(){

        //given
        UserEntity user = UserEntity.builder()
                .email("email")
                .username("name")
                .password("password")
                .build();

        //when
        UserEntity savedUser = userRepository.save(user);

        //then
        assertThat(savedUser).isEqualTo(user);
        assertNotNull(savedUser.getId());

    }

    @Test
    @DisplayName("id로 user 찾기")
    void testFindUserById(){

        //given
        Long userId1 = userRepository.save(UserEntity.builder()
                .email("user1email")
                .username("user1")
                .password("password1")
                .build()).getId();

        Long userId2 = userRepository.save(UserEntity.builder()
                .email("user2email")
                .username("user2")
                .password("password2")
                .build()).getId();

        //when
        UserEntity findUser1 = userRepository.findById(userId1)
                .orElseThrow(() -> new UserNotFoundException(userId1));

        UserEntity findUser2 = userRepository.findById(userId2)
                .orElseThrow(() -> new UserNotFoundException(userId2));

        //then
        assertThat(userRepository.count()).isEqualTo(2);
        assertThat(findUser1.getUsername()).isEqualTo("user1");
        assertThat(findUser1.getPassword()).isEqualTo("password1");
        assertThat(findUser1.getTodos().size()).isEqualTo(0);
        assertThat(findUser2.getUsername()).isEqualTo("user2");
        assertThat(findUser2.getPassword()).isEqualTo("password2");
        assertThat(findUser2.getTodos().size()).isEqualTo(0);
    }
}