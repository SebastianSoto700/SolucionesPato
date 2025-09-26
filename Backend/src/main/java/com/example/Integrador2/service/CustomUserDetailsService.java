package com.example.Integrador2.service;

import com.example.Integrador2.model.Usuario;
import com.example.Integrador2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    //Por esta ves no usamos el Autowired

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("--- Buscando usuario: " + username + " ---");

        Usuario usuarioEncontrado = usuarioRepository.findByCorreo(username)
                .orElseThrow(() -> {
                    // ESTA PARTE SOLO SE EJECUTA SI NO SE ENCUENTRA EL USUARIO
                    System.out.println("--- Usuario NO encontrado en la BD: " + username + " ---");
                    return new UsernameNotFoundException("No se ha encontrado a este usuario"); // Es mejor usar esta excepción
                });
        String contrasenaDesdeBD = usuarioEncontrado.getContrasena();
        String contrasenaLimpia = contrasenaDesdeBD.trim();

        // ESTA PARTE SOLO SE EJECUTA SI SÍ SE ENCUENTRA EL USUARIO
        System.out.println("--- Usuario ENCONTRADO en la BD: " + usuarioEncontrado.getCorreo() + " ---");
        System.out.println(">>> Contraseña desde la BD: [" + contrasenaLimpia.length() + "]");


        return new User(
                usuarioEncontrado.getCorreo(),
                contrasenaLimpia,
                usuarioEncontrado.isEstado(),
                true,
                true,
                true,// <-- ESTO ES LO NUEVO: le dice a Spring si el usuario está habilitado
                Collections.singleton(new SimpleGrantedAuthority(usuarioEncontrado.getRol()))
        );
    }
}
