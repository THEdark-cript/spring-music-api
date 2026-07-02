package com.sofar.spring_music_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
