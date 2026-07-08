package com.sofar.spring_music_api.service;

import com.sofar.spring_music_api.domain.dto.evento.EventoRequestDTO;
import com.sofar.spring_music_api.domain.dto.evento.EventoResponseDTO;
import com.sofar.spring_music_api.domain.entity.Evento;
import com.sofar.spring_music_api.exception.evento.DataEventoInvalidaException;
import com.sofar.spring_music_api.exception.evento.EventoNaoEcontradoException;
import com.sofar.spring_music_api.exception.evento.PrazoVotacaoInvalidoException;
import com.sofar.spring_music_api.mapper.EventoMapper;
import com.sofar.spring_music_api.repository.EventoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class EventoService {
    private final EventoRepository repository;
    private final EventoMapper mapper;

    private Evento pesquisarEventoPorId(int id) {
        return repository.findById(id).orElseThrow(() -> new EventoNaoEcontradoException("Evento não encontrado"));
    }

    public EventoResponseDTO buscarEventoPorId(int id) {
        Evento evento = pesquisarEventoPorId(id);
        return mapper.toResponse(evento);
    }

    public EventoResponseDTO cadastrarEvento(EventoRequestDTO dto) {
        if (dto.dataEvento().isBefore(LocalDateTime.now())) {
            throw new DataEventoInvalidaException("A data informada não é permitida porque já passou");
        }
        if (ChronoUnit.DAYS.between(dto.prazoVotacao(), dto.dataEvento()) < 7) {
            throw new PrazoVotacaoInvalidoException("O prazo para encerrar a votação deve ser de no mínimo uma semana antes da data do evento");
        }
        Evento evento = mapper.toEntity(dto);
        Evento novoEvento = repository.save(evento);
        return mapper.toResponse(novoEvento);
    }

    @Transactional
    public EventoResponseDTO atualizarEvento(int id, EventoRequestDTO dto) {
        Evento evento = pesquisarEventoPorId(id);
        Evento eventoAtualizado = mapper.updateEntity(evento, dto);
        return mapper.toResponse(eventoAtualizado);
    }

    public void excluirEvento(int id) {
        Evento evento = pesquisarEventoPorId(id);
        repository.delete(evento);
    }
}
