package com.sofar.spring_music_api.repository;

import com.sofar.spring_music_api.domain.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
}
