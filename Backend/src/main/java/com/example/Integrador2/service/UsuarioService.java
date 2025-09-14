package com.example.Integrador2.service;

import com.example.Integrador2.dto.UsuarioUpdateDto;
import com.example.Integrador2.model.Usuario;
import com.example.Integrador2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario crearUsuario(Usuario usuario){
        usuario.setFechaCreacion(java.time.LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return  usuarioRepository.findByEstadoTrue();
    }

    @Transactional
    public Usuario actualizarUsuario (Integer id, UsuarioUpdateDto usuartiodto){
        Usuario usuario = usuarioRepository.findById(id)  // <-- cambiar aquí
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.actualizar(usuartiodto);
        return usuario;
    }

    @Transactional
    public void eliminarUsuario(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.eliminar();
    }
}
