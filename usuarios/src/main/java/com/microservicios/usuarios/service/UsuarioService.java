package com.microservicios.usuarios.service;

import com.microservicios.usuarios.modelo.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {

    public UsuarioModel crearUsuario(UsuarioModel modelo);

    public UsuarioModel obtenerUsuarioById(Long idUsuario);

    public UsuarioModel obtenerUsuarioByEmail(String email);

    public UsuarioModel eliminarUsuarioById(Long idUsuario);

    public UsuarioModel modificarUsuario(Long id, UsuarioModel model);

    public List<UsuarioModel> obtenerUsuarios();
}
