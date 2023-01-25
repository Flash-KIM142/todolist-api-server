package com.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    //READ
    @GetMapping("/todos")
    public List<TodoEntity> getTodos(){
        return todoService.getTodos();
    }

    //CREATE
    @PostMapping("/todos")
    public String createTodo(@RequestBody TodoRequestDto todoRequestDto){
        return todoService.createTodo(todoRequestDto).toString();
//        return todoRequestDto.toString();
//        return todoService.createTodo(todoRequestDto);
    }
}
