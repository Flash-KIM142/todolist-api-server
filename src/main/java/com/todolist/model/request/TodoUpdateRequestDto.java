package com.todolist.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoUpdateRequestDto {

    private String content;
    private Boolean isDone;
}
