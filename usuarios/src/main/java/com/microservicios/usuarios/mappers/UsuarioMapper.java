package com.microservicios.usuarios.mappers;

import com.microservicios.usuarios.Entity.UsuarioEntity;
import com.microservicios.usuarios.dto.UsuarioCreateInDTO;
import com.microservicios.usuarios.dto.UsuarioModificarInDTO;
import com.microservicios.usuarios.modelo.UsuarioModel;
import com.microservicios.usuarios.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO toDTO(UsuarioModel model);
    UsuarioEntity toEntity(UsuarioModel model);
    UsuarioCreateInDTO toCreateDTO(UsuarioModel model);
    UsuarioModificarInDTO toModificarDTO(UsuarioModel model);

    UsuarioModel toModel(UsuarioDTO dto);
    UsuarioModel toModel(UsuarioEntity entity);
    UsuarioModel toModel(UsuarioCreateInDTO createDto);
    UsuarioModel toModel(UsuarioModificarInDTO modificarDto);

    List<UsuarioDTO> toDtoList(List<UsuarioModel> models);
    List<UsuarioEntity> toEntityList(List<UsuarioModel> models);

    List<UsuarioModel> entityListToModelList(List<UsuarioEntity> entities);
    List<UsuarioModel> dtoListToModelList(List<UsuarioDTO> dtos);
}
