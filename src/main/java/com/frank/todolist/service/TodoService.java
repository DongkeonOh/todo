package com.frank.todolist.service;

import com.frank.todolist.dto.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> getTodoList(TodoDto todoDto);
    TodoDto createTodo(TodoDto todoDto);
    TodoDto getTodo(TodoDto todoDto);
    void putTodo(TodoDto todoDto);
    void deleteTodo(TodoDto todoDto);
    int getTodoCount(int id);
}
