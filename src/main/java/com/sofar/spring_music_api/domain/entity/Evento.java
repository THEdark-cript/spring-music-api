package com.sofar.spring_music_api.domain.entity;

import com.sofar.spring_music_api.domain.enums.EventoStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "evento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @UuidGenerator
    @Column(name = "uuid", nullable = false, unique = true, updatable = false)
    @Setter(AccessLevel.NONE)
    private UUID uuid;
    @Column(name = "nome", nullable = false, length = 150)
    private String nome;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "estado", nullable = false, length = 2)
    private String estado;
    @Column(name = "cidade", nullable = false, length = 150)
    private String cidade;
    @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "data_evento", nullable = false)
    private LocalDateTime dataEvento;
    @Column(name = "prazo_votacao", nullable = false)
    private LocalDate prazoVotacao;
    @Column(name = "status", length = 9, nullable = false)
    @Enumerated(EnumType.STRING)
    private EventoStatus status;
}
