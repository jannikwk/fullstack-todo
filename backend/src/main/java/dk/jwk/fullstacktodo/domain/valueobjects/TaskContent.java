package dk.jwk.fullstacktodo.domain.valueobjects;

public record TaskContent(String value) {
    private static final int MAX_LENGTH = 255;

    public TaskContent {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Task content cannot be empty");
        }

        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Task content cannot exceed " + MAX_LENGTH + " characters");
        }
    }
}