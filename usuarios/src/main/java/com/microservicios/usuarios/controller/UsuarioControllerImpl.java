package com.microservicios.usuarios.controller;

import org.springframework.web.bind.annotation.RestController;

import com.microservicios.usuarios.dto.UsuarioDTO;
import com.microservicios.usuarios.dto.UsuarioSinIdDTO;
import com.microservicios.usuarios.service.UsuarioService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("usuario")
public class UsuarioControllerImpl {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable("id") int id) {
        
        var usuariodto = usuarioService.getUsuarioById(id);
        
        ResponseEntity response = new ResponseEntity<>(usuariodto, HttpStatus.OK);

        return response;
    }

    @PostMapping()
    public ResponseEntity postMethodName(@RequestBody UsuarioSinIdDTO request) {
        
        UsuarioDTO usuario = usuarioService.createUsuario(request);

        ResponseEntity response = new ResponseEntity<>(usuario, HttpStatus.OK);

        return response;
    }
    

    @DeleteMapping("{id}")
    public Map<String, Object> deleteUsuarioById(@PathVariable("id") int id) {
        return usuarioService.deleteUsuarioById(id);
    }

}
