package com.todolist.model.response;

import com.todolist.model.entity.TodoEntity;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Builder
public class TodoResponseDto {

    private final Long id;
    private final String content;
    private final boolean isDone;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static TodoResponseDto of(TodoEntity todoEntity){
        return TodoResponseDto.builder()
                .id(todoEntity.getId())
                .content(todoEntity.getContent())
                .isDone(todoEntity.getIsDone())
                .createdAt(todoEntity.getCreatedAt())
                .updatedAt(todoEntity.getUpdatedAt())
                .build();
    }
}