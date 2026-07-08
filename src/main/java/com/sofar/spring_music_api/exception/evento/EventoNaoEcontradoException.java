package com.sofar.spring_music_api.exception.evento;

public class EventoNaoEcontradoException extends RuntimeException {
    public EventoNaoEcontradoException(String message) {
        super(message);
    }
}
