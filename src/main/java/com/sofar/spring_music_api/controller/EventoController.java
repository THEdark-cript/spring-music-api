package com.sofar.spring_music_api.controller;

import com.sofar.spring_music_api.domain.dto.evento.EventoRequestDTO;
import com.sofar.spring_music_api.domain.dto.evento.EventoResponseDTO;
import com.sofar.spring_music_api.service.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("evento")
@RequiredArgsConstructor
public class EventoController {
    private final EventoService service;

    @GetMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> buscarEventoPorId(@PathVariable int id) {
        EventoResponseDTO resposta = service.buscarEventoPorId(id);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping
    public ResponseEntity<EventoResponseDTO> cadastrarEvento(@RequestBody EventoRequestDTO dto) {
        EventoResponseDTO resposta = service.cadastrarEvento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoResponseDTO> atualizarEvento(@PathVariable int id, @RequestBody EventoRequestDTO dto) {
        EventoResponseDTO resposta = service.atualizarEvento(id, dto);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEvento(@PathVariable int id) {
         service.excluirEvento(id);
         return ResponseEntity.noContent().build();
    }
}
