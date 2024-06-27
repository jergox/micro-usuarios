package com.microservicios.usuarios.service;

public interface AutenticacionService {

    public void logIn(String email, String password);
    public void logOut(String token);
    public void verificarToken(String token);
}
