package com.sofar.spring_music_api.repository;

import com.sofar.spring_music_api.domain.entity.Artista;
import com.sofar.spring_music_api.domain.entity.Usuario;
import com.sofar.spring_music_api.domain.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
    @Query("SELECT COUNT(*) FROM Voto v WHERE v.artista = :artista")
    int contadorVotosArtista(@Param("artista") Artista artista);
    List<Voto> findByEspectador(Usuario espectador);
}
