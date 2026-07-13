package com.sofar.spring_music_api.repository;

import com.sofar.spring_music_api.domain.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    Optional<Evento> findByUuid(UUID uuid);
    List<Evento> findByCidade(String cidade);
}
