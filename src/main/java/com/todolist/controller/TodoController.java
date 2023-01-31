package com.todolist.controller;

import com.todolist.model.request.TodoUpdateRequestDto;
import com.todolist.model.response.BaseResponseDto;
import com.todolist.model.response.TodoListResponseDto;
import com.todolist.model.request.TodoRequestDto;
import com.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping(value="/todos")
public class TodoController {

    private final TodoService todoService;

    //READ
    @GetMapping
    public ResponseEntity<TodoListResponseDto> getTodos(){

        return new ResponseEntity<>(
                new TodoListResponseDto(
                        HttpStatus.OK.value(),
                        "data successfully received",
                        todoService.getTodos()), HttpStatus.OK);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<BaseResponseDto> createTodo(@RequestBody TodoRequestDto todoRequestDto){

        return new ResponseEntity<>(
                new BaseResponseDto(
                        HttpStatus.CREATED.value(),
                        "data successfully created",
                        todoService.createTodo(todoRequestDto)), HttpStatus.CREATED);
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDto> updateTodoById(
            @PathVariable Long id,
            @RequestBody TodoUpdateRequestDto todoUpdateRequestDto){

            return new ResponseEntity<>(
                new BaseResponseDto(
                        HttpStatus.OK.value(),
                        "data successfully updated",
                        todoService.updateTodoById(id, todoUpdateRequestDto)), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDto> deleteTodoById(@PathVariable Long id){

        return new ResponseEntity<>(
                new BaseResponseDto(
                        HttpStatus.OK.value(),
                        "data successfully deleted",
                        todoService.deleteTodoById(id)), HttpStatus.OK);
    }
}