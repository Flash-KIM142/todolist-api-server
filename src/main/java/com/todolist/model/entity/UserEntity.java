package com.todolist.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TodoEntity> todos = new ArrayList<>();

    @Builder
    public UserEntity(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void update(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void addTodo(TodoEntity todo){
        this.todos.add(todo);
        // TodoEntity 입장에서도 user 의 정보를 세팅해주는 작업 필요 @JoinColumn 필요할 것
    }
}