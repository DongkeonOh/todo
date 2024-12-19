package com.frank.todolist.data.dao.impl;

import com.frank.todolist.data.dao.TodoDao;
import com.frank.todolist.data.entity.TodoEntity;
import com.frank.todolist.data.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoDaoImpl implements TodoDao {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<TodoEntity> getTodoList(TodoEntity todoEntity) {
        return todoRepository.findByUser(todoEntity.getUser());
    }

    @Override
    public TodoEntity createTodo(TodoEntity todoEntity) {
        return todoRepository.save(todoEntity);
    }

    @Override
    public TodoEntity getTodo(TodoEntity todoEntity) {
        return todoRepository.getReferenceById(todoEntity.getId());
    }

    @Override
    public void deleteTodo(TodoEntity todoEntity) {
        todoRepository.deleteById(todoEntity.getId());
    }

    public int getTodoCount(int id){
        return todoRepository.countById(id);
    }
}
