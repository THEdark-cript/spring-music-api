package com.sofar.spring_music_api.mapper;

import com.sofar.spring_music_api.domain.dto.evento.EventoRequestDTO;
import com.sofar.spring_music_api.domain.dto.evento.EventoResponseDTO;
import com.sofar.spring_music_api.domain.entity.Evento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventoMapper {
    @Mapping(target = "id", ignore = true)
    Evento toEntity(EventoRequestDTO dto);
    Evento updateEntity(@MappingTarget Evento entity, EventoRequestDTO dto);
    EventoResponseDTO toResponse(Evento evento);
}
