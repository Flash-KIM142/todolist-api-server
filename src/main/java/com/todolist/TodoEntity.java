package com.todolist;

import javax.persistence.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="todos")
@Getter
@NoArgsConstructor
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean isDone;

//    private LocalDate createdAt;  지금은 가장 필수적인 필드들을 작성하는 데만 집중. 이 필드는 후에 다시 작성.
}
