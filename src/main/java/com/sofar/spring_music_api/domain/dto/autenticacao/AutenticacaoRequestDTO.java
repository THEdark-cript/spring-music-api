package com.sofar.spring_music_api.domain.dto.autenticacao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AutenticacaoRequestDTO(
        @NotBlank @Email @Size(max = 100) String email,
        @NotBlank @Size(min = 8) String senha
) {
}
