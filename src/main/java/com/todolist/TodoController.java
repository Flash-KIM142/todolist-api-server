package com.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public TodoEntity createTodo(TodoEntity todoEntity){
        return todoService.createTodo(todoEntity);
    }
}
