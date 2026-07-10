package com.sofar.spring_music_api.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "artista")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// Esta classe existe para armazenar as informações do formulário do usuário artista para se cadastrar em um evento
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @UuidGenerator
    @Column(name = "uuid", nullable = false, unique = true, updatable = false)
    @Setter(AccessLevel.NONE)
    private UUID uuid;
    @Column(name = "nome_grupo", nullable = false, length = 150)
    private String nomeGrupo; // Caso seja apenas um artista, digita o nome, se não, digita o nome do grupo
    @Column(name = "descricao_apresentacao", nullable = false)
    private String descricaoApresentacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;
}
