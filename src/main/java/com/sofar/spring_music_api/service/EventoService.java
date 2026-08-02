package com.sofar.spring_music_api.service;

import com.sofar.spring_music_api.domain.dto.evento.EventoRequestDTO;
import com.sofar.spring_music_api.domain.dto.evento.EventoResponseDTO;
import com.sofar.spring_music_api.domain.dto.voto.ArtistaVotoResponseDTO;
import com.sofar.spring_music_api.domain.entity.Artista;
import com.sofar.spring_music_api.domain.entity.Evento;
import com.sofar.spring_music_api.domain.enums.EventoStatus;
import com.sofar.spring_music_api.exception.evento.DataEventoInvalidaException;
import com.sofar.spring_music_api.exception.evento.EventoNaoEcontradoException;
import com.sofar.spring_music_api.exception.evento.PrazoVotacaoInvalidoException;
import com.sofar.spring_music_api.mapper.EventoMapper;
import com.sofar.spring_music_api.repository.ArtistaEventoRepository;
import com.sofar.spring_music_api.repository.EventoRepository;
import com.sofar.spring_music_api.repository.VotoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventoService {
    private final EventoRepository eventoRepository;
    private final ArtistaEventoRepository artistaEventoRepository;
    private final VotoRepository votoRepository;
    private final EventoMapper eventoMapper;

    public List<EventoResponseDTO> listarTodosEventos() {
        return eventoRepository.findAll().stream().map(eventoMapper::toResponse).toList();
    }

    // Este método serve para quando o usuário (artista) se cadastrar em um evento, ele possa selecionar em que o status de inscição está aberto
    public List<EventoResponseDTO> listarEventosAbertos() {
        return eventoRepository.findAll()
                .stream()
                .filter(evento -> evento.getStatus().equals(EventoStatus.ABERTO))
                .map(eventoMapper::toResponse)
                .toList();
    }

    // Método exclusivo para espectadores
    public List<ArtistaVotoResponseDTO> listarArtistasDoEvento(UUID uuid) {
        Evento evento = pesquisarEntidadeEventoPorUuid(uuid);
        List<Artista> artistas = artistaEventoRepository.findByEvento(evento);
        return artistas.stream()
                .map((artista -> new ArtistaVotoResponseDTO(
                        artista.getUuid(),
                        artista.getNomeGrupo(),
                        artista.getDescricaoApresentacao(),
                        contadorVotosDoArtista(artista))))
                .toList();
    }

    public Evento pesquisarEntidadeEventoPorUuid(UUID uuid) {
        return eventoRepository.findByUuid(uuid).orElseThrow(() -> new EventoNaoEcontradoException("Evento não encontrado"));
    }

    public EventoResponseDTO buscarEventoPorUuid(UUID uuid) {
        Evento evento = pesquisarEntidadeEventoPorUuid(uuid);
        return eventoMapper.toResponse(evento);
    }

    @Transactional
    public EventoResponseDTO cadastrarEvento(EventoRequestDTO dto) {
        if (dto.dataEvento().isBefore(LocalDateTime.now())) {
            throw new DataEventoInvalidaException("A data informada não é permitida porque já passou");
        }
        if (ChronoUnit.DAYS.between(dto.prazoVotacao(), dto.dataEvento()) < 7) {
            throw new PrazoVotacaoInvalidoException("O prazo para encerrar a votação deve ser de no mínimo uma semana antes da data do evento");
        }
        Evento evento = eventoMapper.toEntity(dto);
        Evento novoEvento = eventoRepository.save(evento);
        return eventoMapper.toResponse(novoEvento);
    }

    @Transactional
    public EventoResponseDTO atualizarEvento(UUID uuid, EventoRequestDTO dto) {
        if (dto.dataEvento().isBefore(LocalDateTime.now())) {
            throw new DataEventoInvalidaException("A data informada não é permitida porque já passou");
        }
        if (ChronoUnit.DAYS.between(dto.prazoVotacao(), dto.dataEvento()) < 7) {
            throw new PrazoVotacaoInvalidoException("O prazo para encerrar a votação deve ser de no mínimo uma semana antes da data do evento");
        }
        Evento evento = pesquisarEntidadeEventoPorUuid(uuid);
        Evento eventoAtualizado = eventoMapper.updateEntity(evento, dto);
        return eventoMapper.toResponse(eventoAtualizado);
    }

    public void excluirEvento(UUID uuid) {
        Evento evento = pesquisarEntidadeEventoPorUuid(uuid);
        eventoRepository.delete(evento);
    }

    private int contadorVotosDoArtista(Artista artista) {
        return votoRepository.contadorVotosArtista(artista);
    }
}
