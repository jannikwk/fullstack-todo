package dk.jwk.fullstacktodo.controllers;

import dk.jwk.fullstacktodo.application.TodoService;
import dk.jwk.fullstacktodo.domain.dtos.CreateTaskRequest;
import dk.jwk.fullstacktodo.domain.dtos.TaskDTO;
import dk.jwk.fullstacktodo.domain.dtos.UpdateTaskRequest;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> addTodo(
        @RequestBody CreateTaskRequest request
    ) {
        TaskDTO savedTask = todoService.createTask(request);
        URI location = URI.create("/api/todos/" + savedTask.id());
        return ResponseEntity.created(location).body(savedTask);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTodos() {
        List<TaskDTO> tasks = todoService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTodoById(@PathVariable Long id) {
        TaskDTO task = todoService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTodo(
        @PathVariable Long id,
        @RequestBody UpdateTaskRequest request
    ) {
        TaskDTO updatedTask = todoService.updateTask(id, request);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        boolean deleted = todoService.deleteTask(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
