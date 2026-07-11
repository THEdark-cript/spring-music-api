package com.sofar.spring_music_api.repository;

import com.sofar.spring_music_api.domain.entity.Artista;
import com.sofar.spring_music_api.domain.entity.ArtistaEvento;
import com.sofar.spring_music_api.domain.entity.Evento;
import com.sofar.spring_music_api.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistaEventoRepository extends JpaRepository<ArtistaEvento, Integer> {
    List<ArtistaEvento> findByArtista_Usuario(Usuario usuario);
    @Query("SELECT ae.artista FROM ArtistaEvento ae WHERE ae.evento = :evento")
    List<Artista> findByEvento(@Param("evento") Evento evento);
}
