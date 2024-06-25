package com.microservicios.usuarios.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UsuarioCreateInDTO {

    private String nombre;
    private String email;
    private String password;
}
