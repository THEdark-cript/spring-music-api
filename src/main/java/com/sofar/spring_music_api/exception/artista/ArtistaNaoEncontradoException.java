package com.sofar.spring_music_api.exception.artista;

public class ArtistaNaoEncontradoException extends RuntimeException {
    public ArtistaNaoEncontradoException(String message) {
        super(message);
    }
}
