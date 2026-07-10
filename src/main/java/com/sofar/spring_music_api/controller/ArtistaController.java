package com.sofar.spring_music_api.controller;

import com.sofar.spring_music_api.domain.dto.artista.ArtistaEventoResponseDTO;
import com.sofar.spring_music_api.domain.dto.artista.ArtistaRequestDTO;
import com.sofar.spring_music_api.domain.dto.artista.ArtistaResponseDTO;
import com.sofar.spring_music_api.service.ArtistaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artista")
@RequiredArgsConstructor
public class ArtistaController {
    private final ArtistaService service;

    @GetMapping("/eventos")
    public List<ArtistaEventoResponseDTO> listarEventosDoUsuarioLogado(Authentication authentication) {
        return service.listarEventosDoUsuarioLogado(authentication);
    }

    @PostMapping
    public ArtistaResponseDTO cadastrarArtista(@RequestBody @Valid ArtistaRequestDTO dto, Authentication authentication) {
        return service.cadastrarArtista(dto, authentication);
    }
}
