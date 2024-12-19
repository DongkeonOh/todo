package com.frank.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    private int id;
    private String title;
    private String content;
    private String isDone;
    private String user;
    private String result;
}
