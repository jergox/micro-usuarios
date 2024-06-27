package com.microservicios.usuarios.dto;

import java.io.Serializable;

import com.microservicios.usuarios.ValueObject.Rol;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
    @Email
    @NotNull
    private String email;
    private Rol rol;
}
