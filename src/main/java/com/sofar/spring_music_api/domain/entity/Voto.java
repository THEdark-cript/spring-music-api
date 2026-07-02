package com.sofar.spring_music_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "voto",
    uniqueConstraints = {
        @UniqueConstraint(
                name = "uk_voto_espectador_artista_evento",
                columnNames = {"id_espectador", "id_artista", "id_evento"}
        )
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_espectador", nullable = false)
    private Usuario espectador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

    @Column(name = "data_voto", nullable = false)
    private LocalDateTime dataVoto = LocalDateTime.now();
}