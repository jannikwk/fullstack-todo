package dk.jwk.fullstacktodo.domain.valueobjects;

import java.util.UUID;

public record TaskId(UUID value) {
    public TaskId {
        if (value == null) {
            throw new IllegalArgumentException("TaskId cannot be null");
        }
    }

    public static TaskId generate() {
        return new TaskId(UUID.randomUUID());
    }

    public static TaskId of(String uuidString) {
        if (uuidString == null || uuidString.isBlank()) {
            throw new IllegalArgumentException("UUID string cannot be null or empty");
        }
        return new TaskId(UUID.fromString(uuidString));
    }

    public static TaskId of(UUID value) {
        return new TaskId(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
