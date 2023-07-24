package com.todolist.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="todos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Boolean isDone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Builder
    public TodoEntity(String content, Boolean isDone){
        this.content = content;
        this.isDone = isDone;
    }

    public void update(String content, boolean isDone){
        this.content = content;
        this.isDone = isDone;
    }
}