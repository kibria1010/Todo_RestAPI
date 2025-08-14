package org.example.rest_api.todo;

import org.example.rest_api.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoJpaResource {

    private TodoService todoService;
    private TodoRepository todoRepository;

    public TodoJpaResource(TodoService todoService, TodoRepository todoRepository) {
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retriveTodos(@PathVariable String username) {
        //return todoService.findByUsername(username);
        return todoRepository.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retriveTodos(@PathVariable int id) {
        //return todoService.findById(id);
        return todoRepository.findById(id).get();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodos(@PathVariable String username, @PathVariable int id) {
        //todoService.deleteById(id);
        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodos(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        //todoService.updateTodo(todo);
        todoRepository.save(todo);
        return todo;
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodos(@PathVariable String username, @RequestBody Todo todo) {
        //todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
        todo.setId(null);
        todo.setUsername(username);
        return todoRepository.save(todo);
    }
}

