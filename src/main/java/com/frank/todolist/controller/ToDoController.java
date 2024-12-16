package com.frank.todolist.controller;

import com.frank.todolist.dto.TodoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ToDoController.class);

    @GetMapping(value = "/todo")
    public ResponseEntity<TodoDto> getTodoList(@RequestBody TodoDto todoDto){

        return ResponseEntity.status(HttpStatus.OK).body(todoDto);
    }

    @PostMapping(value = "/todo")
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto){

        return ResponseEntity.status(HttpStatus.OK).body(todoDto);
    }

    @GetMapping(value = "/todo/{id}")
    public ResponseEntity<TodoDto> getTodo(@RequestBody TodoDto todoDto){

        return ResponseEntity.status(HttpStatus.OK).body(todoDto);
    }

    @PutMapping(value = "/todo/{id}")
    public ResponseEntity<TodoDto> putTodo(@RequestBody TodoDto todoDto){

        return ResponseEntity.status(HttpStatus.OK).body(todoDto);
    }

    @DeleteMapping(value = "/todo/{id}")
    public ResponseEntity<TodoDto> deleteTodo(@RequestBody TodoDto todoDto){

        return ResponseEntity.status(HttpStatus.OK).body(todoDto);
    }
}
