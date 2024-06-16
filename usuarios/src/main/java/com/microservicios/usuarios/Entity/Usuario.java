package com.microservicios.usuarios.Entity;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class Usuario {
    private String id;
    private String nombre;
    private String email;
}
