package com.sofar.spring_music_api.domain.dto.voto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record VotoRequestDTO(
        @NotNull UUID uuidArtista,
        @NotNull UUID uuidEvento
        ) {
}
