package com.example.Integrador2.dto;

import com.example.Integrador2.model.DetalleVenta;

import java.util.List;

public record VentaRequestDTO(Integer clienteId, List<DetalleVenta> detalles) {
}
