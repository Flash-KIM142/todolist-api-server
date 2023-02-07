package com.todolist.service;

import com.todolist.exception.TodoNotFoundException;
import com.todolist.model.entity.TodoEntity;
import com.todolist.model.request.TodoUpdateRequestDto;
import com.todolist.repository.TodoRepository;
import com.todolist.model.request.TodoRequestDto;
import com.todolist.model.response.TodoResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    //CREATE
    public Long createTodo(TodoRequestDto todoRequestDto){

        return todoRepository.save(todoRequestDto.toEntity()).getId();
    }

    //READ ALL
    public List<TodoResponseDto> getTodos(){

        List<TodoEntity> entityList = todoRepository.findAll();
        List<TodoResponseDto> dtoList = new ArrayList<>();

        for(TodoEntity e: entityList){
            dtoList.add(TodoResponseDto.of(e));
        }

        return dtoList;
    }

    //READ ONE
    public TodoResponseDto getTodo(Long id){

        Optional<TodoEntity> findTodo = todoRepository.findById(id);

        if(!findTodo.isPresent()){
            throw new TodoNotFoundException(id);
        }

        return TodoResponseDto.of(findTodo.get());
    }

    //UPDATE
    public boolean updateTodoById(Long id, TodoUpdateRequestDto todoUpdateRequestDto){

        TodoEntity todoEntity = todoRepository.findById(id).<TodoNotFoundException>orElseThrow(() -> {
            throw new TodoNotFoundException("failure to update the data");
        });

        todoEntity.update(todoUpdateRequestDto.getContent(), todoUpdateRequestDto.getIsDone());
        todoRepository.save(todoEntity);
        return true;
    }

    //DELETE
    public boolean deleteTodoById(Long id){

        if(!todoRepository.existsById(id)){
            throw new TodoNotFoundException(id);
        }

        todoRepository.deleteById(id);
        return true;
    }
}