package com.todolist.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.todolist.model.entity.TodoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TodoRequestDto {

    private String content;
    @JsonProperty("isDone")
    private Boolean isDone;

    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .content(content)
                .isDone(isDone)
                .build();
    }
}
