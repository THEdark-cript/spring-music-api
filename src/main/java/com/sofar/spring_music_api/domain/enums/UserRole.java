package com.sofar.spring_music_api.domain.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    ESPECTADOR("espectador"),
    ARTISTA("artistas"),
    ADMIN("admin");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}
