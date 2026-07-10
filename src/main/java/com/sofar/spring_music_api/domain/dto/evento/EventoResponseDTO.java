package com.sofar.spring_music_api.domain.dto.evento;

import com.sofar.spring_music_api.domain.enums.EventoStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponseDTO(
        UUID uuid,
        String nome,
        String descricao,
        String estado,
        String cidade,
        String logradouro,
        String bairro,
        LocalDateTime dataEvento,
        LocalDate prazoVotacao,
        EventoStatus status
) {
}
