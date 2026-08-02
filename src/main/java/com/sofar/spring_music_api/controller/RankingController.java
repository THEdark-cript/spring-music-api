package com.sofar.spring_music_api.controller;

import com.sofar.spring_music_api.domain.dto.ranking.RankingCidadeResponseDTO;
import com.sofar.spring_music_api.domain.dto.ranking.RankingResponseDTO;
import com.sofar.spring_music_api.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
@RequiredArgsConstructor
public class RankingController {
    private final RankingService service;

    @GetMapping
    public ResponseEntity<List<RankingResponseDTO>> listarArtistasDoEvento() {
        List<RankingResponseDTO> resposta = service.listarArtistasDoEvento();
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/cidades")
    public ResponseEntity<List<RankingCidadeResponseDTO>> listarCidades() {
        List<RankingCidadeResponseDTO> resposta = service.listarCidades();
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/cidade")
    public ResponseEntity<List<RankingResponseDTO>> listarArtistasDoEventoPorCidade(@RequestParam String nome) {
        List<RankingResponseDTO> resposta = service.listarArtistasDoEventoPorCidade(nome);
        return ResponseEntity.ok(resposta);
    }
}
