package com.microservicios.usuarios.mappers;

import org.springframework.stereotype.Component;

import com.microservicios.usuarios.Entity.UsuarioEntity;
import com.microservicios.usuarios.dto.UsuarioDTO;
import com.microservicios.usuarios.dto.UsuarioSinIdDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
public class UsuarioMapper {
    private int id;
    private String nombre;
    private String email;

    public static UsuarioEntity dto2Entity(UsuarioDTO dto){
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    public static UsuarioDTO entity2dto(UsuarioEntity entity){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public static UsuarioEntity dto2Entity(UsuarioSinIdDTO dto){
        UsuarioEntity entity = new UsuarioEntity();
        entity.setEmail(dto.getEmail());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
