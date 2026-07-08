package com.sofar.spring_music_api.repository;

import com.sofar.spring_music_api.domain.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
