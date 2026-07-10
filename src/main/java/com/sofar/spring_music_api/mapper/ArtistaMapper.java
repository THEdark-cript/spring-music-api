package com.sofar.spring_music_api.mapper;

import com.sofar.spring_music_api.domain.dto.artista.ArtistaRequestDTO;
import com.sofar.spring_music_api.domain.dto.artista.ArtistaResponseDTO;
import com.sofar.spring_music_api.domain.entity.Artista;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArtistaMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    Artista toEntity(ArtistaRequestDTO dto);
    ArtistaResponseDTO toResponse(Artista artista);
}
