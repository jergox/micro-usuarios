package com.microservicios.usuarios.modelo;

import com.microservicios.usuarios.ValueObject.Rol;
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
    private Rol rol = Rol.Normal;

}