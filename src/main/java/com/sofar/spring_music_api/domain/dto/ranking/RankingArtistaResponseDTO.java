package com.sofar.spring_music_api.domain.dto.ranking;

import java.util.UUID;

public record RankingArtistaResponseDTO(
        UUID idArtista,
        String nome,
        int qtdVoto
) {
}
