package com.sofar.spring_music_api.service;

import com.sofar.spring_music_api.domain.dto.voto.EspectadorVotoResponse;
import com.sofar.spring_music_api.domain.dto.voto.VotoRequestDTO;
import com.sofar.spring_music_api.domain.entity.Artista;
import com.sofar.spring_music_api.domain.entity.Evento;
import com.sofar.spring_music_api.domain.entity.Usuario;
import com.sofar.spring_music_api.domain.entity.Voto;
import com.sofar.spring_music_api.repository.VotoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VotoService {
    private final VotoRepository votoRepository;
    private final ArtistaService artistaService;
    private final EventoService eventoService;
    private final AutorizacaoService autorizacaoService;

    @Transactional
    public void cadastrarVoto(VotoRequestDTO dto, Authentication authentication) {
        Usuario usuario = autorizacaoService.usuarioLogado(authentication);
        Artista artista = artistaService.buscarArtistaPorUuid(dto.uuidArtista());
        Evento evento = eventoService.pesquisarEntidadeEventoPorUuid(dto.uuidEvento());
        Voto voto = new Voto();
        voto.setEspectador(usuario);
        voto.setArtista(artista);
        voto.setEvento(evento);
        voto.setDataVoto(LocalDateTime.now());
        votoRepository.save(voto);
    }

    public List<EspectadorVotoResponse> listarVotosDoEspectador(Authentication authentication) {
        Usuario usuario = autorizacaoService.usuarioLogado(authentication);
        List<Voto> votos = votoRepository.findByEspectador(usuario);
        return votos.stream()
                .map(voto -> new EspectadorVotoResponse(
                        voto.getEspectador().getUuid(),
                        voto.getArtista().getUuid(),
                        voto.getEvento().getNome()))
                .toList();
    }
}
