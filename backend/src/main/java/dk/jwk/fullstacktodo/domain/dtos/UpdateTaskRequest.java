package dk.jwk.fullstacktodo.domain.dtos;

public record UpdateTaskRequest(String taskText, boolean completed) {
}
