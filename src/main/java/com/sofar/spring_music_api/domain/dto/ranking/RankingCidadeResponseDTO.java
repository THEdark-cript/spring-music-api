package com.sofar.spring_music_api.domain.dto.ranking;

import java.util.UUID;

public record RankingCidadeResponseDTO(
        UUID idEvento,
        String cidade

) {
}
