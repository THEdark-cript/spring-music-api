package com.sofar.spring_music_api.domain.dto.ranking;

import java.util.List;

public record RankingResponseDTO(
        String nomeEvento,
        String cidadeEvento,
        int qtdVotosTotaisEvento,
        List<RankingArtistaResponseDTO> artistas
) {
}
