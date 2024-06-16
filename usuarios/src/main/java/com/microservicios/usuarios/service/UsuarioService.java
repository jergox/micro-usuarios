package com.microservicios.usuarios.service;

import org.springframework.stereotype.Service;

import com.microservicios.usuarios.dto.UsuarioDTO;

@Service
public class UsuarioService {

    public UsuarioDTO getUsuarioById(String idUsuario) {

        UsuarioDTO userDTO = new UsuarioDTO();
        userDTO.setId("01");
        userDTO.setNombre("nombre1");
        userDTO.setEmail("ma.mail@jot.mal");

        return userDTO;
    }
}
