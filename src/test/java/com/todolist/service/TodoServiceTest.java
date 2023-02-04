package com.todolist.service;

import com.todolist.model.entity.TodoEntity;
import com.todolist.model.request.TodoRequestDto;
import com.todolist.model.response.TodoResponseDto;
import com.todolist.repository.TodoRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    private static TodoRequestDto todoRequestDto;
    private static TodoRequestDto todoRequestDto1;
    private static List<TodoEntity> list;

    @BeforeAll
    static void beforeEach() {
        todoRequestDto = new TodoRequestDto();
        todoRequestDto.setContent("TodoService Test");
        todoRequestDto.setIsDone(true);

        todoRequestDto1 = new TodoRequestDto();
        todoRequestDto1.setContent("TodoService Test1");
        todoRequestDto1.setIsDone(true);

        list = new ArrayList<>();
    }

    @Test
    @DisplayName("Todo 생성 & 저장")
    void testCreateTodo() {

        //given
        TodoEntity todoEntity = todoRequestDto.toEntity();
        given(todoRepository.save(any(TodoEntity.class))).willReturn(todoEntity);

        //when
        Long createId = todoService.createTodo(todoRequestDto);

        //then
        assertThat(createId).isEqualTo(todoEntity.getId());
    }

    @Test
    @DisplayName("Todo list 불러오기")
    void testGetTodos(){

        //given
        list.add(todoRequestDto.toEntity());
        list.add(todoRequestDto1.toEntity());
        given(todoRepository.findAll()).willReturn(list);

        //when
        List<TodoResponseDto> findAll = todoService.getTodos();

        //then
        assertThat(findAll).isNotNull();
        assertThat(findAll.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Todo 하나 불러오기")
    void testGetTodo() {

        //given
        TodoEntity todoEntity = todoRequestDto.toEntity();
        given(todoRepository.findById(anyLong())).willReturn(Optional.of(todoEntity));

        //when
        TodoResponseDto findTodoDto = todoService.getTodo(1L);

        //then
        assertThat(findTodoDto).isNotNull();
        assertThat(findTodoDto.getContent()).isEqualTo("TodoService Test");
        assertThat(findTodoDto.getIsDone()).isEqualTo(true);
    }
}