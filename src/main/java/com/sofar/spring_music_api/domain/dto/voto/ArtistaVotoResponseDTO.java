package com.sofar.spring_music_api.domain.dto.voto;

import java.util.UUID;

public record ArtistaVotoResponseDTO(
        UUID uuidArtista,
        String nomeGrupo,
        String descricaoApresentacao,
        int qtdVoto
) {
}
