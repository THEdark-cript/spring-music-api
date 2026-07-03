package com.sofar.spring_music_api.domain.dto.autenticacao;

import com.sofar.spring_music_api.domain.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CadastroRequestDTO(
        @NotBlank @Size(max = 150) String nomeCompleto,
        @NotBlank @CPF String cpf,
        @NotBlank @Email @Size(max = 100) String email,
        @NotBlank @Size(min = 8, message = "A senha tem que ter no mínimo 8 dígitos") String senha,
        @NotNull UserRole role
        ) {
}
