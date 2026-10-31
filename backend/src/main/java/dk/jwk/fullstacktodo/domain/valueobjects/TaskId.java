package dk.jwk.fullstacktodo.domain.valueobjects;

import java.util.UUID;

public record TaskId(UUID value) {
    public TaskId {
        if (value == null || value.toString().isEmpty()) {
            throw new IllegalArgumentException("TaskId cannot be null or empty");
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

    @Override
    public String toString() {
        return value.toString();
    }
}
