package com.todolist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    //CREATE
    public TodoEntity createTodo(TodoRequestDto todoRequestDto){
        log.debug("dto -> dao");
        return todoRepository.save(todoRequestDto.toEntity());
    }

    //READ
    public List<TodoEntity> getTodos(){
        return todoRepository.findAll();
    }

    //DELETE
    public void deleteTodo(Long todoId){
        todoRepository.deleteById(todoId);
    }
}
