package com.microservicios.usuarios.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microservicios.usuarios.dto.UsuarioDTO;
import com.microservicios.usuarios.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("usuario")
public class UsuarioControllerImpl {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable("id") String id) {
        
        var usuariodto = usuarioService.getUsuarioById(id);
        
        ResponseEntity response = new ResponseEntity<>(usuariodto, HttpStatus.OK);

        return response;
    }

}
