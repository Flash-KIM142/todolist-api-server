package com.todolist.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponseDto {

    private int status;
    private String message;

    @JsonProperty("data")
    private Object object; // client 로부터 받게될 data

}
