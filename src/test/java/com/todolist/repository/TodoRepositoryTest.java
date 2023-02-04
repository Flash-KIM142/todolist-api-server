package com.todolist.repository;

import com.todolist.model.entity.TodoEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class TodoRepositoryTest {

    @Mock
    private TodoRepository todoRepository;

    @Test
    @DisplayName("Todo 저장")
    void testSave(){

        //given
        TodoEntity todoEntity = new TodoEntity("save Test", true);
        given(todoRepository.save(todoEntity)).willReturn(todoEntity);

        //when
        TodoEntity saveTodoEntity = todoRepository.save(todoEntity);

        //then
        then(todoRepository).should(times(1)).save(todoEntity);
        assertThat(saveTodoEntity).isEqualTo(todoEntity);
    }

    @Test
    @DisplayName("Todo 한 개 불러오기")
    void testFindById(){

        //given
        TodoEntity todoEntity = new TodoEntity(1L, "findById Test", false);
        given(todoRepository.findById(1L)).willReturn(Optional.of(todoEntity));

        //when
        Optional<TodoEntity> findTodoEntity = todoRepository.findById(1L);

        //then
        then(todoRepository).should(times(1)).findById(1L);
        assertTrue(findTodoEntity.isPresent());
        assertThat(findTodoEntity.get()).isEqualTo(todoEntity);
    }
}