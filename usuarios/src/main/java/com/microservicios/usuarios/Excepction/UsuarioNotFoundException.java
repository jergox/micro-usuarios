package com.microservicios.usuarios.Excepction;

public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(Long id){
        super("No encontrado el usuario con id: " + id);
    }

    public UsuarioNotFoundException(String email){
        super("No encontrado el usuario con email: " + email);
    }
}
