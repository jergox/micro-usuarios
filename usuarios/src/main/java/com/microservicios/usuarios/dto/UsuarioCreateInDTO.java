package com.microservicios.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UsuarioCreateInDTO {

    private String nombre;
    @NotBlank
    @Email(message = "Formato invalido")
    private String email;
    @NotNull
    @NotBlank(message = "Introduce una password")
    private String password;
}
