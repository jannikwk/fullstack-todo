package dk.jwk.fullstacktodo.domain.dtos;

import java.util.UUID;

public record TaskDTO(UUID id, String content, boolean completed) {
}
