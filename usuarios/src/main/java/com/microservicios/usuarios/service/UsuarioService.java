package com.microservicios.usuarios.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.usuarios.dto.UsuarioDTO;
import com.microservicios.usuarios.dto.UsuarioSinIdDTO;
import com.microservicios.usuarios.mappers.UsuarioMapper;
import com.microservicios.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO getUsuarioById(int idUsuario) {

        var userDTO = usuarioRepository.getUsuarioById(idUsuario);

        return UsuarioMapper.entity2dto(userDTO);
    }

    public UsuarioDTO createUsuario(UsuarioSinIdDTO usuarioDTO){
        return UsuarioMapper.entity2dto(usuarioRepository.crearUsuario(UsuarioMapper.dto2Entity(usuarioDTO)));
    }

    public Map<String, Object> deleteUsuarioById(int usuarioId) {
        boolean eliminado = usuarioRepository.eliminarUsuario(usuarioId);

        Map<String, Object> response = new HashMap<>();;
        response.put("Estado", "Usuario Eliminado.");

        return response;
    }
}
