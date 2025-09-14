package com.example.Integrador2.dto;

public record ProductoUpdateDto(Integer id,
                                String nombre,
                                String descripcion,
                                Integer stock,
                                Double precio,
                                Integer categoriaId,
                                String imagen) {
}
