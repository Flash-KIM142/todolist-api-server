package com.todolist.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.todolist.model.response.TodoResponseVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TodoListResponseDto {

    private int status;
    private int length;
    private String message;

    @JsonProperty("data")
    private Object object;

    public TodoListResponseDto(int status, String message, List<TodoResponseVo> todoResponseVoList){
        int length = 0;

        for(TodoResponseVo o: todoResponseVoList){
            length++;
        }

        this.status = status;
        this.message = message;
        this.length = length;
        this.object = todoResponseVoList;
    }
}
