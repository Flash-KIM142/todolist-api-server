package com.todolist.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="todos")
@Getter
@Builder
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

    public void update(String content, boolean isDone){
        this.content = content;
        this.isDone = isDone;
    }

}