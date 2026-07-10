package com.sofar.spring_music_api.domain.dto.usuario;

import com.sofar.spring_music_api.domain.enums.UserRole;

import java.util.UUID;

public record UsuarioResponseDTO(
        UUID uuid,
        String nomeCompleto,
        String cpf,
        String email,
        UserRole role
) {
}
