package com.sofar.spring_music_api.service;

import com.sofar.spring_music_api.domain.entity.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AutorizacaoService {
    public Usuario usuarioLogado(Authentication authentication) {
        return (Usuario) authentication.getPrincipal();
    }
}
