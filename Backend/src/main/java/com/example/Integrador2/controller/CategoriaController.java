package com.example.Integrador2.controller;


import com.example.Integrador2.model.Categoria;
import com.example.Integrador2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Categoria> listar(){
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
