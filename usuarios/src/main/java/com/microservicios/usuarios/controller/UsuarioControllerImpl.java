package com.microservicios.usuarios.controller;

import com.microservicios.usuarios.dto.UsuarioCreateInDTO;
import com.microservicios.usuarios.mappers.UsuarioMapper;
import com.microservicios.usuarios.modelo.UsuarioModel;
import com.microservicios.usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import com.microservicios.usuarios.dto.UsuarioDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("usuario")
public class UsuarioControllerImpl {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable("id") Long id) {
        
        UsuarioModel model = usuarioService.obtenerUsuarioById(id);
        
        ResponseEntity response = new ResponseEntity<>(UsuarioMapper.INSTANCE.toDTO(model), HttpStatus.OK);

        return response;
    }

    @GetMapping("{email}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable("email") String email) {

        UsuarioModel model = usuarioService.obtenerUsuarioByEmail(email);

        ResponseEntity response = new ResponseEntity<>(UsuarioMapper.INSTANCE.toDTO(model), HttpStatus.OK);

        return response;
    }

    @PostMapping()
    public ResponseEntity createUsuario(@RequestBody UsuarioCreateInDTO request) {
        
        UsuarioModel usuario = usuarioService.crearUsuario(UsuarioMapper.INSTANCE.toModel(request));

        UsuarioDTO dto = UsuarioMapper.INSTANCE.toDTO(usuario);

        ResponseEntity response = new ResponseEntity<>(dto, HttpStatus.OK);

        return response;
    }
    

    @DeleteMapping("{id}")
    public ResponseEntity deleteUsuarioById(@PathVariable("id") Long id) {
        UsuarioModel eliminado = usuarioService.eliminarUsuarioById(id);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("usuario", eliminado);
        respuesta.put("Mensaje", "eliminado correctamente");

        ResponseEntity response = new ResponseEntity<>(respuesta, HttpStatus.OK);
        return response;
    }

    @GetMapping()
    public ResponseEntity<UsuarioDTO> getUsuarioById() {

        List<UsuarioModel> modelos = usuarioService.obtenerUsuarios();

        List<UsuarioDTO> dtos = UsuarioMapper.INSTANCE.toDtoList(modelos);

        ResponseEntity response = new ResponseEntity<>(dtos, HttpStatus.OK);

        return response;
    }

    @PutMapping("{id}")
    public ResponseEntity createUsuario(@PathVariable("id") Long id, @RequestBody UsuarioCreateInDTO request) {

        UsuarioModel usuario = usuarioService.modificarUsuario(id, UsuarioMapper.INSTANCE.toModel(request));

        UsuarioDTO dto = UsuarioMapper.INSTANCE.toDTO(usuario);

        ResponseEntity response = new ResponseEntity<>(dto, HttpStatus.OK);

        return response;
    }

}
