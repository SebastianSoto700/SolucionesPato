package com.example.Integrador2.dto;

import java.time.LocalDateTime;

public record ProductoAdminDto(Integer id,
                               String nombre,
                               String descripcion,
                               Integer stock,
                               Double precio,
                               String categoria,
                               String imagen,
                               Boolean estado,
                               LocalDateTime fechaCreacion) {
}
