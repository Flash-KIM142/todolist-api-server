package com.todolist.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.todolist.model.entity.TodoEntity;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
