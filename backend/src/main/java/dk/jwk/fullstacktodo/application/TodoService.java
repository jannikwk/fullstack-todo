package dk.jwk.fullstacktodo.application;

import dk.jwk.fullstacktodo.domain.Task;
import dk.jwk.fullstacktodo.domain.dtos.CreateTaskRequest;
import dk.jwk.fullstacktodo.domain.dtos.TaskDTO;
import dk.jwk.fullstacktodo.domain.dtos.UpdateTaskRequest;
import dk.jwk.fullstacktodo.domain.interfaces.TodoRepository;
import dk.jwk.fullstacktodo.domain.valueobjects.TaskContent;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TaskDTO createTask(CreateTaskRequest request) {
        Task newTask = Task.create(request.taskText());
        todoRepository.save(newTask);
        return toDto(newTask);
    }

    public List<TaskDTO> getAllTasks() {
        return todoRepository.findAll().stream().map(this::toDto).toList();
    }

    public TaskDTO getTaskById(Long id) {
        Task task = todoRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task with id " + id + " not found"));
        return toDto(task);
    }

    public TaskDTO updateTask(Long id, UpdateTaskRequest request) {
        Task existing = todoRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Task with id " + id + " not found"));

        if (request.taskText() != null) {
            existing.changeContent(new TaskContent(request.taskText()));
        }

        existing.complete();

        todoRepository.save(existing);
        return toDto(existing);
    }

    public boolean deleteTask(Long id) {
        if (!todoRepository.existsById(id)) {
            return false;
        }

        todoRepository.deleteById(id);
        return true;
    }

    private TaskDTO toDto(Task task) {
        return new TaskDTO(task.getId(), task.getTaskContent(), task.isCompleted());
    }
}
