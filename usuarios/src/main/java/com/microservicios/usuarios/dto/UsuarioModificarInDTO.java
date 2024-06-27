package com.microservicios.usuarios.dto;

import com.microservicios.usuarios.ValueObject.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UsuarioModificarInDTO {

    private String nombre;
    @Email
    @NotNull
    private String email;
    private String password;
    private Rol rol;
}
