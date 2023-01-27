package com.todolist.service;

import com.todolist.model.entity.TodoEntity;
import com.todolist.repository.TodoRepository;
import com.todolist.model.request.TodoRequestDto;
import com.todolist.model.response.TodoResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<TodoResponseVo> getTodos(){

        List<TodoEntity> entityList = todoRepository.findAll();

        List<TodoResponseVo> dtoList = new ArrayList<>();

        for(TodoEntity e: entityList){
            dtoList.add(TodoResponseVo.of(e));
        }

        return dtoList;
    }

    //DELETE
    public void deleteTodo(Long todoId){
        todoRepository.deleteById(todoId);
    }
}
