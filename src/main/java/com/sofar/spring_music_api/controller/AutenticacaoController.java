package com.sofar.spring_music_api.controller;

import com.sofar.spring_music_api.domain.dto.autenticacao.AutenticacaoRequestDTO;
import com.sofar.spring_music_api.domain.dto.autenticacao.AutenticacaoResponseDTO;
import com.sofar.spring_music_api.domain.dto.autenticacao.CadastroRequestDTO;
import com.sofar.spring_music_api.domain.entity.Usuario;
import com.sofar.spring_music_api.repository.UsuarioRepository;
import com.sofar.spring_music_api.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AutenticacaoController {
    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository repository;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<AutenticacaoResponseDTO> login(@RequestBody @Valid AutenticacaoRequestDTO dados){
        var emailSenha = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var autenticacao = this.authenticationManager.authenticate(emailSenha);
        var token = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());
        return ResponseEntity.ok(new AutenticacaoResponseDTO(token));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid CadastroRequestDTO dados){
        if(this.repository.findByEmail(dados.email()) != null) return ResponseEntity.badRequest().build();
        String senhaCriptografada = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario novoUsuario = new Usuario(dados.nomeCompleto(), dados.cpf(),dados.email(), senhaCriptografada, dados.role());

        this.repository.save(novoUsuario);

        return ResponseEntity.ok().build();
    }
}
