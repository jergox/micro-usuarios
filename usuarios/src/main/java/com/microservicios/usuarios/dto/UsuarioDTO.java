package com.microservicios.usuarios.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class UsuarioDTO {
    private int id;
    private String nombre;
    //Agregar la validacion de javax
    private String email;
}
