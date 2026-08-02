package com.sofar.spring_music_api.domain.dto.voto;

import java.util.UUID;

public record EspectadorVotoResponse(
        UUID espectador,
        UUID artista,
        String nomeEvento
) {
}
