package com.sofar.spring_music_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "artista_evento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArtistaEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_artista", nullable = false)
    private Artista artista;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;
}
