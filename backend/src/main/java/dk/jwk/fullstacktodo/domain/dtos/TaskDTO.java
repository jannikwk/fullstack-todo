package dk.jwk.fullstacktodo.domain.dtos;

import dk.jwk.fullstacktodo.domain.valueobjects.TaskContent;
import dk.jwk.fullstacktodo.domain.valueobjects.TaskId;

public record TaskDTO(TaskId id, TaskContent constent, boolean completed) {
}
