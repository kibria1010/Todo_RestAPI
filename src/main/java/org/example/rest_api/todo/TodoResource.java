package org.example.rest_api.todo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {


    private TodoService todoService;

    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/users/{username}/todos")
    public List<Todo> retriveTodos(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/users/{username}/todos/{id}")
    public Todo retriveTodos(@PathVariable int id) {
        return todoService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodos(@PathVariable String username, @PathVariable int id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodos(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        todoService.updateTodo(todo);
        return todo;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/users/{username}/todos")
    public Todo createTodos(@PathVariable String username, @RequestBody Todo todo) {
        todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        return todo;
    }
}

