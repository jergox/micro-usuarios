package com.microservicios.usuarios.service.impl;

import com.microservicios.usuarios.Entity.UsuarioEntity;
import com.microservicios.usuarios.Excepction.UsuarioNotFoundException;
import com.microservicios.usuarios.ValueObject.Rol;
import com.microservicios.usuarios.mappers.UsuarioMapper;
import com.microservicios.usuarios.modelo.UsuarioModel;
import com.microservicios.usuarios.repository.UsuarioRepository;
import com.microservicios.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UsuarioModel crearUsuario(UsuarioModel modelo) {
        Optional<UsuarioEntity> optional = usuarioRepository.findByEmail(modelo.getEmail());

        if (optional.isPresent()){
            throw new RuntimeException("Ya existe el usuario con email: " + modelo.getEmail());
        } else {
            UsuarioEntity preEntity = UsuarioMapper.INSTANCE.toEntity(modelo);
            //Le damos un valor por defecto
            //preEntity.setRol(Rol.Normal);

            UsuarioEntity entity = usuarioRepository.save(preEntity);
            UsuarioModel model = UsuarioMapper.INSTANCE.toModel(entity);
            return model;
        }
    }

    @Override
    public UsuarioModel obtenerUsuarioByEmail(String email) {
        Optional<UsuarioEntity> optional = usuarioRepository.findByEmail(email);

        if (optional.isPresent()) {
            return UsuarioMapper.INSTANCE.toModel(optional.get());
        } else {
            throw new UsuarioNotFoundException(email);
        }
    }

    @Override
    public UsuarioModel obtenerUsuarioById(Long idUsuario) {
        Optional<UsuarioEntity> optional = usuarioRepository.findById(idUsuario);

        if (optional.isPresent()) {
            return UsuarioMapper.INSTANCE.toModel(optional.get());
        } else {
            throw new UsuarioNotFoundException(idUsuario);
        }
    }

    @Override
    @Transactional
    public UsuarioModel eliminarUsuarioById(Long idUsuario) {

        Optional<UsuarioEntity> optional = usuarioRepository.findById(idUsuario);

        if (optional.isPresent()) {
            usuarioRepository.deleteById(idUsuario);
            return UsuarioMapper.INSTANCE.toModel(optional.get());
        } else {
            throw new UsuarioNotFoundException(idUsuario);
        }
    }

    @Override
    @Transactional
    public UsuarioModel modificarUsuario(Long id, UsuarioModel model) {
        UsuarioEntity actual = usuarioRepository.findById(id).orElseThrow(
                () -> new UsuarioNotFoundException(id)
        );

        if (model.getNombre() != null){
            actual.setNombre(model.getNombre());
        }
        if (model.getEmail() != null){
            actual.setEmail(model.getEmail());
        }
        if (model.getPassword() != null){
            actual.setPassword(model.getPassword());
        }
        if (model.getRol() != null){
            actual.setRol(model.getRol());
        }

        UsuarioEntity modificado = usuarioRepository.save(actual);

        return UsuarioMapper.INSTANCE.toModel(modificado);
    }

    @Override
    public List<UsuarioModel> obtenerUsuarios() {
        List<UsuarioEntity> entidades = usuarioRepository.findAll();

        List<UsuarioModel> modelos = UsuarioMapper.INSTANCE.entityListToModelList(entidades);
        return modelos;
    }
}
