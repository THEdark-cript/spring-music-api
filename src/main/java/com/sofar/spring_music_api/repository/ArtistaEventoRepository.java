package com.sofar.spring_music_api.repository;

import com.sofar.spring_music_api.domain.entity.ArtistaEvento;
import com.sofar.spring_music_api.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistaEventoRepository extends JpaRepository<ArtistaEvento, Integer> {
    List<ArtistaEvento> findByArtista_Usuario(Usuario usuario);
}
