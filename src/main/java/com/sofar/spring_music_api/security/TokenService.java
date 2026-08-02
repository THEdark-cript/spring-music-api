package com.sofar.spring_music_api.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sofar.spring_music_api.domain.entity.Usuario;
import com.sofar.spring_music_api.exception.token.TokenInvalidoException;
import com.sofar.spring_music_api.exception.token.TokenNaoPodeSerGeradoException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.jwt.secret}")
    private String secret;

    public String gerarToken(Usuario user){
        try{
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("spring-music") // diz quem criou o token
                    .withSubject(user.getEmail()) // usuário que tá recebendo o token
                    .withClaim("nome", user.getNomeCompleto())
                    .withClaim("role", user.getRole().toString())
                    .withExpiresAt(dataExpiracao()) // tempo de expiração do token
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new TokenNaoPodeSerGeradoException("Erro ao gerar o token");
        }
    }

    public String validarToken(String token){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("spring-music")
                    .build()
                    .verify(token) // descriptografa o token
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new TokenInvalidoException("Token inválido");
        }
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
