package com.example.Integrador2.dto;

import java.math.BigDecimal;

public record CompraCreateDto(Integer proveedorId,
                              Integer productoId,
                              int cantidad,
                              BigDecimal precio) {
}
