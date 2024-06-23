package com.microservicios.usuarios.Entity;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class UsuarioEntity {
    private int id;
    private String nombre;
    private String email;
}
