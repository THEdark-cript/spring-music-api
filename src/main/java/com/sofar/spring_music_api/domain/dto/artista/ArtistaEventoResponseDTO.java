package com.sofar.spring_music_api.domain.dto.artista;

import com.sofar.spring_music_api.domain.dto.evento.EventoResponseDTO;

public record ArtistaEventoResponseDTO(
        ArtistaResponseDTO artista,
        EventoResponseDTO evento
) {
}
