package com.sofar.spring_music_api.service;

import com.sofar.spring_music_api.domain.dto.ranking.RankingArtistaResponseDTO;
import com.sofar.spring_music_api.domain.dto.ranking.RankingResponseDTO;
import com.sofar.spring_music_api.domain.dto.voto.ArtistaVotoResponseDTO;
import com.sofar.spring_music_api.domain.entity.Evento;
import com.sofar.spring_music_api.exception.evento.EventoNaoEcontradoException;
import com.sofar.spring_music_api.repository.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingService {
    private final EventoService eventoService;
    private final EventoRepository eventoRepository;

    public List<RankingResponseDTO> listarArtistasDoEvento() {
        List<Evento> eventos = eventoRepository.findAll();
        List<RankingResponseDTO> ranking = new ArrayList<>();
        for (Evento evento : eventos) {
            List<RankingArtistaResponseDTO> rankingArtistas = new ArrayList<>();
            var artistas = eventoService.listarArtistasDoEvento(evento.getUuid());
            int somaVotos = 0;

            for (ArtistaVotoResponseDTO artista : artistas) {
                somaVotos += artista.qtdVoto();
                rankingArtistas.add(new RankingArtistaResponseDTO(artista.nomeGrupo(), artista.qtdVoto()));
            }

            ranking.add(new RankingResponseDTO(evento.getNome(), evento.getCidade(), somaVotos, rankingArtistas));
        }
        return ranking;
    }

    public List<String> listarCidades() {
        List<Evento> eventos = eventoRepository.findAll();
        return eventos.stream().map(Evento::getCidade).toList();
    }

    public List<RankingResponseDTO> listarArtistasDoEventoPorCidade(String cidade) {
        List<Evento> eventos = eventoRepository.findByCidade(cidade);
        if (eventos.isEmpty()) throw new EventoNaoEcontradoException("Nenhum evento para a cidade " + cidade);
        List<RankingResponseDTO> rankingPorCidade = new ArrayList<>();
        for (Evento evento : eventos) {
            List<RankingArtistaResponseDTO> rankingArtistas = new ArrayList<>();
            var artistas = eventoService.listarArtistasDoEvento(evento.getUuid());
            int somaVotos = 0;
            for (ArtistaVotoResponseDTO artista : artistas) {
                somaVotos += artista.qtdVoto();
                rankingArtistas.add(new RankingArtistaResponseDTO(artista.nomeGrupo(), artista.qtdVoto()));
            }
            rankingPorCidade.add(new RankingResponseDTO(evento.getNome(), evento.getCidade(), somaVotos, rankingArtistas));
        }
        return rankingPorCidade;
    }
}
