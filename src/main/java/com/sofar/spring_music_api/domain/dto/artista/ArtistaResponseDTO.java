package com.sofar.spring_music_api.domain.dto.artista;

import com.sofar.spring_music_api.domain.dto.usuario.UsuarioResponseDTO;

import java.util.UUID;

public record ArtistaResponseDTO(
        UUID uuid,
        String nomeGrupo,
        String descricaoApresentacao,
        UsuarioResponseDTO usuario
) {
}
