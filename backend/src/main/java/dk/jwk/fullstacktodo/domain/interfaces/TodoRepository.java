package dk.jwk.fullstacktodo.domain.interfaces;

import dk.jwk.fullstacktodo.domain.Task;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Task save(Task task);

    List<Task> findAll();

    Optional<Task> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);
}
