package com.frank.todolist.service.impl;

import com.frank.todolist.data.dao.TodoDao;
import com.frank.todolist.data.entity.TodoEntity;
import com.frank.todolist.dto.TodoDto;
import com.frank.todolist.service.TodoService;
import com.frank.todolist.util.TodoUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoDao todoDao;

    @Override
    public List<TodoDto> getTodoList(TodoDto todoDto) {
        List<TodoEntity> resultEntity = todoDao.getTodoList(TodoUtil.dtoToEntity(todoDto));

        return TodoUtil.entityListToDtoList(resultEntity);
    }

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        TodoEntity todoEntity = todoDao.createTodo(TodoUtil.dtoToEntity(todoDto));

        return TodoUtil.entityToDto(todoEntity);
    }

    @Override
    public TodoDto getTodo(TodoDto todoDto) {
        TodoEntity todoEntity = todoDao.getTodo(TodoUtil.dtoToEntity(todoDto));

        return TodoUtil.entityToDto(todoEntity);
    }

    @Override
    public void putTodo(TodoDto todoDto) {
        TodoEntity todoEntity = todoDao.getTodo(TodoUtil.dtoToEntity(todoDto));

        boolean isChanged = false;
        if(!todoEntity.getTitle().equals(todoDto.getTitle())) {
            todoEntity.setTitle(todoDto.getTitle());
            isChanged = true;
        }
        if(!todoEntity.getContent().equals(todoDto.getContent())) {
            todoEntity.setContent(todoDto.getContent());
            isChanged = true;
        }
        if(!todoEntity.getIsDone().equals(todoDto.getIsDone())) {
            todoEntity.setIsDone(todoDto.getIsDone());
            isChanged = true;
        }

        if(isChanged) todoEntity.setModifyTime(LocalDateTime.now());
    }

    @Override
    public void deleteTodo(TodoDto todoDto) {
        todoDao.deleteTodo(TodoUtil.dtoToEntity(todoDto));
    }

    @Override
    public int getTodoCount(int id) {
        return todoDao.getTodoCount(id);
    }
}
