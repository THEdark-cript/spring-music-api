package com.sofar.spring_music_api.exception;

import com.sofar.spring_music_api.exception.evento.DataEventoInvalidaException;
import com.sofar.spring_music_api.exception.evento.EventoNaoEcontradoException;
import com.sofar.spring_music_api.exception.evento.PrazoVotacaoInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

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
}
