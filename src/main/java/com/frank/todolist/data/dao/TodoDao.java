package com.frank.todolist.data.dao;

import com.frank.todolist.data.entity.TodoEntity;

import java.util.List;

public interface TodoDao {
    List<TodoEntity> getTodoList(TodoEntity todoEntity);
    TodoEntity createTodo(TodoEntity todoEntity);
    TodoEntity getTodo(TodoEntity todoEntity);
    void deleteTodo(TodoEntity todoEntity);
    int getTodoCount(int id);
}
