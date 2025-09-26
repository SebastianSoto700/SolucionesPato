package com.example.Integrador2.dto;

import java.math.BigDecimal;

public record DetalleVentaResponseDTO(String nombreProducto,
                                      int cantidad,
                                      BigDecimal precio,
                                      BigDecimal subtotal) {
}
