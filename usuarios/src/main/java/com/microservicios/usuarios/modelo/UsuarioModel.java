package com.microservicios.usuarios.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class UsuarioModel {

    private Long id;
    private String nombre;
    private String email;
    private String password;

}