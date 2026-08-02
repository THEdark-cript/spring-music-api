package com.sofar.spring_music_api.exception;

import com.sofar.spring_music_api.exception.artista.ArtistaNaoEncontradoException;
import com.sofar.spring_music_api.exception.evento.DataEventoInvalidaException;
import com.sofar.spring_music_api.exception.evento.EventoNaoEcontradoException;
import com.sofar.spring_music_api.exception.evento.PrazoVotacaoInvalidoException;
import com.sofar.spring_music_api.exception.token.TokenInvalidoException;
import com.sofar.spring_music_api.exception.token.TokenNaoPodeSerGeradoException;
import com.sofar.spring_music_api.exception.usuario.UsuarioNaoEncontradoException;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<RestErrorMessage> tratarRequestNotPermitted(RequestNotPermitted exception) {
        RestErrorMessage erro = new RestErrorMessage(HttpStatus.TOO_MANY_REQUESTS, "Muitas requisições. Por favor, aguarde um momento.");
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(erro);
    }

    // TOKEN:
    @ExceptionHandler(TokenInvalidoException.class)
    public ResponseEntity<RestErrorMessage> handleTokenInvalido(TokenInvalidoException ex) {
        RestErrorMessage erro = new RestErrorMessage(HttpStatus.UNAUTHORIZED, ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erro);
    }

    @ExceptionHandler(TokenNaoPodeSerGeradoException.class)
    public ResponseEntity<RestErrorMessage> handleTokenInvalido(TokenNaoPodeSerGeradoException ex) {
        RestErrorMessage erro = new RestErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    // EVENTOS:
    @ExceptionHandler(EventoNaoEcontradoException.class)
    public ResponseEntity<RestErrorMessage> handleEventoNaoEncontrado(EventoNaoEcontradoException ex) {
        RestErrorMessage erro = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(DataEventoInvalidaException.class)
    public ResponseEntity<RestErrorMessage> handleDataEventoInvalida(DataEventoInvalidaException ex) {
        RestErrorMessage erro = new RestErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }

    @ExceptionHandler(PrazoVotacaoInvalidoException.class)
    public ResponseEntity<RestErrorMessage> handlePrazoVotacaoInvalido(PrazoVotacaoInvalidoException ex) {
        RestErrorMessage erro = new RestErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(erro);
    }

    // USUARIOS:
    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<RestErrorMessage> handleUsuarioNaoEncontrado(UsuarioNaoEncontradoException ex) {
        RestErrorMessage erro = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    // ARTISTAS:
    @ExceptionHandler(ArtistaNaoEncontradoException.class)
    public ResponseEntity<RestErrorMessage> handleArtistaNaoEncontrado(ArtistaNaoEncontradoException ex) {
        RestErrorMessage erro = new RestErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
