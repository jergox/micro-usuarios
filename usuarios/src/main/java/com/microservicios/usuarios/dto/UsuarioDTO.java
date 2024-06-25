package com.microservicios.usuarios.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String email;
}
