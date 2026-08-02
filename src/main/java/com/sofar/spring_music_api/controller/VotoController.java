package com.sofar.spring_music_api.controller;

import com.sofar.spring_music_api.domain.dto.voto.EspectadorVotoResponse;
import com.sofar.spring_music_api.domain.dto.voto.VotoRequestDTO;
import com.sofar.spring_music_api.service.VotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<EspectadorVotoResponse>> listarVotosDoEspectador(Authentication authentication) {
        var resposta = service.listarVotosDoEspectador(authentication);
        return ResponseEntity.ok(resposta);
    }
}
