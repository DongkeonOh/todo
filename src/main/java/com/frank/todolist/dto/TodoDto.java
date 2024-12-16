package com.frank.todolist.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TodoDto {
    private String user;
    private int id;
    private String title;
    private String content;
    private String isDone;
    private int sequence;
}
