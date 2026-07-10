package com.sofar.spring_music_api.domain.enums;

import lombok.Getter;

@Getter
public enum EventoStatus {
    ABERTO("aberto"),
    ENCERRADO("encerrado");

    private final String status;

    EventoStatus(String status) {
        this.status = status;
    }
}
