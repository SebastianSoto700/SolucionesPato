package com.example.Integrador2.controller;


import com.example.Integrador2.model.Categoria;
import com.example.Integrador2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public void registrarCategoria(@RequestBody Categoria categoria){
        categoriaService.agregarCategoria(categoria);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<Categoria> listar(Authentication authentication){
        return  categoriaService.listarCategoria();
    }

    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Integer id, @RequestBody Categoria categoria){
        return categoriaService.actualizarCategoria(id,categoria);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        categoriaService.eliminarCategoria(id);
    }

}
