package com.sofar.spring_music_api.domain.dto.artista;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ArtistaRequestDTO(
        @NotBlank @Size(max = 150) String nomeGrupo,
        @NotBlank String descricaoApresentacao,
        @NotNull UUID idEvento
) {
}
