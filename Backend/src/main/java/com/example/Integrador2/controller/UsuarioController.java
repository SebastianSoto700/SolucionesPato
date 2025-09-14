package com.example.Integrador2.controller;


import com.example.Integrador2.dto.UsuarioUpdateDto;
import com.example.Integrador2.model.Usuario;
import com.example.Integrador2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    public void registrarUsuario(@RequestBody  Usuario usuario){
        usuarioService.crearUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listarUsuarios();
    }


    @PutMapping("/{id}")
    public  Usuario actualizar(@PathVariable Integer id, @RequestBody UsuarioUpdateDto dto){
        return usuarioService.actualizarUsuario(id,dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
    }
}
