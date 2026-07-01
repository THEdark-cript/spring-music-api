package com.sofar.spring_music_api.domain.entity;

import com.sofar.spring_music_api.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    @Column(name = "nome_completo", nullable = false, length = 150)
    private String nomeCompleto;
    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "senha", nullable = false)
    private String senha;
    @Column(name = "tipo_usuario", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
