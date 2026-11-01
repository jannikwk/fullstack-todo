package dk.jwk.fullstacktodo.infrastructure;

import dk.jwk.fullstacktodo.domain.Task;
import dk.jwk.fullstacktodo.domain.interfaces.TodoRepository;
import dk.jwk.fullstacktodo.domain.valueobjects.TaskId;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private final Map<TaskId, Task> database = new ConcurrentHashMap<>();

    @Override
    public Task save(Task task) {
        database.put(task.getId(), task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Optional<Task> findById(TaskId id) {
        return Optional.ofNullable(database.get(id));
    }

    @Override
    public boolean existsById(TaskId id) {
        return database.containsKey(id);
    }

    @Override
    public void deleteById(TaskId id) {
        database.remove(id);
    }
}
