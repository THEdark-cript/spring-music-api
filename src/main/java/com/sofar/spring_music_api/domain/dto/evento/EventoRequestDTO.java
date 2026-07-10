package com.sofar.spring_music_api.domain.dto.evento;

import com.sofar.spring_music_api.domain.enums.EventoStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EventoRequestDTO(
        @NotBlank @Size(max = 150) String nome,
        @NotBlank String descricao,
        @NotBlank @Size(max = 2) String estado,
        @NotBlank @Size(max = 150) String cidade,
        @NotBlank String logradouro,
        @NotBlank String bairro,
        @NotBlank LocalDateTime dataEvento,
        @NotBlank LocalDate prazoVotacao,
        @NotBlank EventoStatus status
        ) {
}
