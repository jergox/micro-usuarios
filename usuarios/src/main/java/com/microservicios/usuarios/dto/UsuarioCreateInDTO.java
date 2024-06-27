package com.microservicios.usuarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UsuarioCreateInDTO {

    private String nombre;
    @Email(message = "Formato invalido")
    private String email;
    @NotBlank(message = "Introduce una password")
    private String password;
}
