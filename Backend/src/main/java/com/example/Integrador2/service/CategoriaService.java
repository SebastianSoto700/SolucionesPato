package com.example.Integrador2.service;

import com.example.Integrador2.model.Categoria;
import com.example.Integrador2.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria agregarCategoria( Categoria categoria){
        categoria.setFechaCreacion(java.time.LocalDateTime.now());
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategoria (){
        return  categoriaRepository.findByEstadoTrue();
    }

    @Transactional
    public Categoria actualizarCategoria(Integer id, Categoria categoria){
        Categoria categoria1 = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("categoria no encontrado"));
        categoria1.actualizar(categoria);
        return categoria1;
    }

    @Transactional
    public void eliminarCategoria(Integer id){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        categoria.eliminar();
    }


}
