package com.todolist.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) { super("There's no such user with the id" + id); }

    public UserNotFoundException(String msg) { super(msg); }
}
