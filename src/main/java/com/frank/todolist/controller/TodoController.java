package com.frank.todolist.controller;

import com.frank.todolist.dto.TodoDto;
import com.frank.todolist.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    TodoService todoService;

    @GetMapping(value = "/todo")
    public ResponseEntity<List<TodoDto>> getTodoList(@RequestBody TodoDto todoDto){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodoList(todoDto));
    }

    @PostMapping(value = "/todo")
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto){
        todoDto.setId(0);
        return ResponseEntity.status(HttpStatus.OK).body(todoService.createTodo(todoDto));
    }

    @GetMapping(value = "/todo/{id}")
    public ResponseEntity<TodoDto> getTodo(@RequestBody TodoDto todoDto, @PathVariable int id){
        todoDto.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodo(todoDto));
    }

    @PutMapping(value = "/todo/{id}")
    public ResponseEntity<TodoDto> putTodo(@RequestBody TodoDto todoDto, @PathVariable int id){
        todoDto.setId(id);
        todoService.putTodo(todoDto);

        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodo(todoDto));
    }

    @DeleteMapping(value = "/todo/{id}")
    public ResponseEntity<TodoDto> deleteTodo(@RequestBody TodoDto todoDto, @PathVariable int id){
        todoDto.setId(id);
        todoService.deleteTodo(todoDto);

        if(todoService.getTodoCount(todoDto.getId()) > 0){
            todoDto.setResult("delete_fail");
            return ResponseEntity.status(HttpStatus.OK).body(todoDto);
        }else{
            todoDto.setResult("delete_success");
            return ResponseEntity.status(HttpStatus.OK).body(todoDto);
        }
    }
}
