package com.todolist.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(Long id){
        super("There's no such data with id." + id);
    }

    public TodoNotFoundException(String msg){
        super(msg);
    }
}
