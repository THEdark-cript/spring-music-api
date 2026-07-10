package com.sofar.spring_music_api.service;

import com.sofar.spring_music_api.domain.dto.artista.ArtistaEventoResponseDTO;
import com.sofar.spring_music_api.domain.dto.artista.ArtistaRequestDTO;
import com.sofar.spring_music_api.domain.dto.artista.ArtistaResponseDTO;
import com.sofar.spring_music_api.domain.entity.Artista;
import com.sofar.spring_music_api.domain.entity.ArtistaEvento;
import com.sofar.spring_music_api.domain.entity.Evento;
import com.sofar.spring_music_api.domain.entity.Usuario;
import com.sofar.spring_music_api.exception.evento.EventoNaoEcontradoException;
import com.sofar.spring_music_api.mapper.ArtistaMapper;
import com.sofar.spring_music_api.mapper.EventoMapper;
import com.sofar.spring_music_api.repository.ArtistaEventoRepository;
import com.sofar.spring_music_api.repository.ArtistaRepository;
import com.sofar.spring_music_api.repository.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtistaService {
    private final ArtistaRepository artistaRepository;
    private final EventoRepository eventoRepository;
    private final ArtistaEventoRepository artistaEventoRepository;
    private final EventoMapper eventoMapper;
    private final ArtistaMapper artistaMapper;
    private final AutorizacaoService autorizacaoService;

    public List<ArtistaEventoResponseDTO> listarEventosDoUsuarioLogado(Authentication authentication) {
        Usuario usuario = autorizacaoService.usuarioLogado(authentication);
        List<ArtistaEvento> inscricoes = artistaEventoRepository.findByArtista_Usuario(usuario);
        return inscricoes.stream()
                .map(inscricao -> new ArtistaEventoResponseDTO(
                    artistaMapper.toResponse(inscricao.getArtista()),
                    eventoMapper.toResponse(inscricao.getEvento())
                )).toList();
    }

    public ArtistaResponseDTO cadastrarArtista(ArtistaRequestDTO dto, Authentication authentication) {
        Usuario usuario = autorizacaoService.usuarioLogado(authentication);
        Evento evento = eventoRepository.findByUuid(dto.idEvento()).orElseThrow(() -> new EventoNaoEcontradoException("Evento não encontrado"));
        Artista artista = artistaMapper.toEntity(dto);
        artista.setUsuario(usuario);
        Artista novoArtista = artistaRepository.save(artista);

        ArtistaEvento relacionamento = new ArtistaEvento();
        relacionamento.setArtista(novoArtista);
        relacionamento.setEvento(evento);
        artistaEventoRepository.save(relacionamento);
        return artistaMapper.toResponse(novoArtista);
    }
}
