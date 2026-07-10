package com.sofar.spring_music_api.repository;

import com.sofar.spring_music_api.domain.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
}
