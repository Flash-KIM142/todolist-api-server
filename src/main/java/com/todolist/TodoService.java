package com.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    //CREATE
    public TodoEntity createTodo(TodoEntity todoEntity){
        return todoRepository.save(todoEntity);
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
