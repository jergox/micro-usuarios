package com.microservicios.usuarios.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.el.stream.Stream;
import org.springframework.stereotype.Repository;

import com.microservicios.usuarios.Entity.UsuarioEntity;


@Repository
public class UsuarioRepository {

    static List<UsuarioEntity> usuariosList = new ArrayList<UsuarioEntity>();
    static int idUsuario = 0;

    public List<UsuarioEntity> getAll() {
        return usuariosList;
    }

    public UsuarioEntity getUsuarioById(int idUsuario){
        UsuarioEntity respuesta = usuariosList.stream().filter(u -> u.getId() == idUsuario).findFirst().get();

        return respuesta;
    }

    public UsuarioEntity crearUsuario(UsuarioEntity usuarioEntity) {
        usuarioEntity.setId(idUsuario);
        idUsuario++;
        usuariosList.add(usuarioEntity);
        System.out.println(usuariosList.size());

        return usuarioEntity;
    }

    public boolean eliminarUsuario(int idUsuario) {

        boolean eliminado = false;

        usuariosList = usuariosList.stream().filter(u -> u.getId() != idUsuario).collect(Collectors.toList());

        return eliminado;
    }

}
