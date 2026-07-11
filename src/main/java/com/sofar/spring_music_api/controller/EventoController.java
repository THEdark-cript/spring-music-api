package com.sofar.spring_music_api.controller;

import com.sofar.spring_music_api.domain.dto.evento.EventoRequestDTO;
import com.sofar.spring_music_api.domain.dto.evento.EventoResponseDTO;
import com.sofar.spring_music_api.domain.dto.voto.ArtistaVotoResponseDTO;
import com.sofar.spring_music_api.service.EventoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("evento")
@RequiredArgsConstructor
public class EventoController {
    private final EventoService service;

    @GetMapping("/abertos")
    public ResponseEntity<List<EventoResponseDTO>> listarEventosAbertos() {
        List<EventoResponseDTO> resposta = service.listarEventosAbertos();
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{uuid}/artistas")
    public ResponseEntity<List<ArtistaVotoResponseDTO>> listarArtistasDoEvento(@PathVariable UUID uuid) {
        List<ArtistaVotoResponseDTO> resposta = service.listarArtistasDoEvento(uuid);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<EventoResponseDTO> buscarEventoPorUuid(@PathVariable UUID uuid) {
        EventoResponseDTO resposta = service.buscarEventoPorUuid(uuid);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> cadastrarEvento(@RequestBody @Valid EventoRequestDTO dto) {
        EventoResponseDTO resposta = service.cadastrarEvento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<EventoResponseDTO> atualizarEvento(@PathVariable UUID uuid, @RequestBody @Valid EventoRequestDTO dto) {
        EventoResponseDTO resposta = service.atualizarEvento(uuid, dto);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> excluirEvento(@PathVariable UUID uuid) {
         service.excluirEvento(uuid);
         return ResponseEntity.noContent().build();
    }
}
