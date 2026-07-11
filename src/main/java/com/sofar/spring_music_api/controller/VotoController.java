package com.sofar.spring_music_api.controller;

import com.sofar.spring_music_api.domain.dto.voto.VotoRequestDTO;
import com.sofar.spring_music_api.service.VotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("voto")
@RequiredArgsConstructor
public class VotoController {
    private final VotoService service;

    @PostMapping
    public ResponseEntity<Void> cadastrarVoto(@RequestBody @Valid VotoRequestDTO dto, Authentication authentication) {
        service.cadastrarVoto(dto, authentication);
        return ResponseEntity.noContent().build();
    }
}
