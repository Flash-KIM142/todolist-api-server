package com.todolist.repository;

import com.todolist.model.entity.TodoEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    @DisplayName("Todo 저장")
    void testSave() {

        //given
        TodoEntity todoEntity = new TodoEntity("save Test", true);

        //when
        TodoEntity saveTodoEntity = todoRepository.save(todoEntity);

        //then
        assertThat(saveTodoEntity).isEqualTo(todoEntity);
    }

    @Test
    @DisplayName("Todo 한 개 불러오기")
    void testFindById() {

        //given
        TodoEntity todoEntity = todoRepository.save(new TodoEntity(1L, "findById Test", false));

        //when
        Optional<TodoEntity> findTodoEntity = todoRepository.findById(1L);

        //then
        assertTrue(findTodoEntity.isPresent());
        assertThat(findTodoEntity.get()).isEqualTo(todoEntity);
    }
}