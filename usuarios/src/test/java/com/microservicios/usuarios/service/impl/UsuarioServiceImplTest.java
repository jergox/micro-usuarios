package com.microservicios.usuarios.service.impl;

import com.microservicios.usuarios.Entity.UsuarioEntity;
import com.microservicios.usuarios.Excepction.UsuarioNotFoundException;
import com.microservicios.usuarios.ValueObject.Rol;
import com.microservicios.usuarios.mappers.UsuarioMapper;
import com.microservicios.usuarios.modelo.UsuarioModel;
import com.microservicios.usuarios.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @InjectMocks
    private UsuarioServiceImpl usuarioServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Nested
    class CrearUsuario {

        @Test
        public void testCrearUsuarioWhenUsuarioExiste() {
            //inicio
            UsuarioModel model = new UsuarioModel() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
            }};

            //objetivo
            UsuarioEntity entity = new UsuarioEntity() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
                setRol(Rol.Normal);
            }};

            when(usuarioRepository.findByEmail(model.getEmail())).thenReturn(Optional.of(entity));

            //llamamos al metodo
            RuntimeException exception = assertThrows(RuntimeException.class, () -> {
                usuarioServiceImpl.crearUsuario(model);
            });

            assertEquals("Ya existe el usuario con email: " + model.getEmail(), exception.getMessage());

            verify(usuarioRepository, times(1)).findByEmail(model.getEmail());
            verify(usuarioRepository, never()).save(any(UsuarioEntity.class));
        }

        @Test
        public void testCrearUsuarioWhenUsuarioNoExiste() {
            //inicio
            UsuarioModel model = new UsuarioModel() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
            }};

            //objetivo
            UsuarioEntity entity = new UsuarioEntity() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
                setRol(Rol.Normal);
            }};

            when(usuarioRepository.findByEmail(model.getEmail())).thenReturn(Optional.empty());
            when(usuarioMapper.toEntity(model)).thenReturn(entity);
            when(usuarioRepository.save(entity)).thenReturn(entity);
            when(usuarioMapper.toModel(entity)).thenReturn(model);

            //llamamos al metodo
            UsuarioModel modelResult = usuarioServiceImpl.crearUsuario(model);

            // verificamos el resultado
            assertEquals(model, modelResult);

            verify(usuarioRepository, times(1)).findByEmail(model.getEmail());
            verify(usuarioRepository, times(1)).save(entity);

        }
    }

    @Nested
    class ObtenerUsuarioByEmail {

        @Test
        public void testObtenerUsuarioByEmailWhenEmailNoExiste() {

            UsuarioModel model = new UsuarioModel() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
            }};

            UsuarioEntity entity = new UsuarioEntity() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
                setRol(Rol.Normal);
            }};

            when(usuarioRepository.findByEmail(model.getEmail())).thenReturn(Optional.empty());

            //llamamos al metodo
            UsuarioNotFoundException exception = assertThrows(UsuarioNotFoundException.class, () -> {
                usuarioServiceImpl.obtenerUsuarioByEmail(model.getEmail());
            });

            assertEquals("No encontrado el usuario con email: " + model.getEmail(), exception.getMessage());

            verify(usuarioRepository, times(1)).findByEmail(model.getEmail());

        }

        @Test
        public void testObtenerUsuarioByEmailWhenEmailExiste() {

            UsuarioModel model = new UsuarioModel() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
            }};

            UsuarioEntity entity = new UsuarioEntity() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
                setRol(Rol.Normal);
            }};

            when(usuarioRepository.findByEmail(model.getEmail())).thenReturn(Optional.of(entity));

            UsuarioModel modelResponse = usuarioServiceImpl.obtenerUsuarioByEmail(model.getEmail());

            assertEquals(model, modelResponse);

            verify(usuarioRepository, times(1)).findByEmail(model.getEmail());
        }
    }

    @Nested
    class ObtenerUsuarioById {

        @Test
        public void testObtenerUsuarioByIdWhenIdNoExiste() {

            UsuarioModel model = new UsuarioModel() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
            }};

            UsuarioEntity entity = new UsuarioEntity() {{
                setEmail("my@ma.il");
                setPassword("pass");
                setNombre("nombre");
                setRol(Rol.Normal);
            }};

            when(usuarioRepository.findById(model.getId())).thenReturn(Optional.empty());

            //llamamos al metodo
            UsuarioNotFoundException exception = assertThrows(UsuarioNotFoundException.class, () -> {
                usuarioServiceImpl.obtenerUsuarioById(model.getId());
            });

            assertEquals("No encontrado el usuario con id: " + model.getId(), exception.getMessage());

            verify(usuarioRepository, times(1)).findById(model.getId());
        }
    }

}