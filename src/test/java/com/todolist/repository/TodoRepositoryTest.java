package com.todolist.repository;

import com.todolist.model.entity.TodoEntity;
import com.todolist.model.entity.UserEntity;
import com.todolist.model.request.TodoRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    private static TodoRequestDto todoRequestDto;
    private static TodoEntity todo;
    private static UserEntity user;

    @BeforeEach
    void setUp() {
        user = UserEntity.builder()
                .email("abc@gmail.com")
                .username("gary")
                .password("1234")
                .build();

        userRepository.save(user);

        todoRequestDto = TodoRequestDto.builder()
                .content("content")
                .isDone(true)
                .build();

    }

    @Test
    @DisplayName("Todo 저장 with User")
    void testSaveWithUser() {

        //given
        todo = TodoEntity.builder()
                .content(todoRequestDto.getContent())
                .isDone(todoRequestDto.getIsDone())
                .user(user)
                .build();

        //when
        TodoEntity savedTodo = todoRepository.save(todo);

        //then
        assertThat(savedTodo).isEqualTo(todo);
        assertNotNull(savedTodo.getId());
        assertThat(savedTodo.getUser()).isEqualTo(user);

    }

}