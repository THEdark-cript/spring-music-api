package com.sofar.spring_music_api.domain.dto.evento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EventoResponseDTO(
        String nome,
        String descricao,
        String estado,
        String cidade,
        String logradouro,
        String bairro,
        LocalDateTime dataEvento,
        LocalDate prazoVotacao
) {
}
