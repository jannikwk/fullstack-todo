package dk.jwk.fullstacktodo.domain.interfaces;

import dk.jwk.fullstacktodo.domain.Task;
import dk.jwk.fullstacktodo.domain.valueobjects.TaskId;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Task save(Task task);

    List<Task> findAll();

    Optional<Task> findById(TaskId id);

    boolean existsById(TaskId id);

    void deleteById(TaskId id);
}
