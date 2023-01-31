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

@Slf4j
@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    //CREATE
    public TodoEntity createTodo(TodoRequestDto todoRequestDto){

        return todoRepository.save(todoRequestDto.toEntity());
    }

    //READ
    public List<TodoResponseDto> getTodos(){

        List<TodoEntity> entityList = todoRepository.findAll();
        List<TodoResponseDto> dtoList = new ArrayList<>();

        for(TodoEntity e: entityList){
            dtoList.add(TodoResponseDto.of(e));
        }

        return dtoList;
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