package com.sofar.spring_music_api.exception.token;

import com.auth0.jwt.exceptions.JWTVerificationException;

public class TokenInvalidoException extends JWTVerificationException {
    public TokenInvalidoException(String message) {
        super(message);
    }
}
