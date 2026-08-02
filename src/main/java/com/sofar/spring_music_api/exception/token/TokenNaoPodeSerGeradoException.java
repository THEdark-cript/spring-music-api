package com.sofar.spring_music_api.exception.token;

public class TokenNaoPodeSerGeradoException extends RuntimeException {
    public TokenNaoPodeSerGeradoException(String message) {
        super(message);
    }
}
