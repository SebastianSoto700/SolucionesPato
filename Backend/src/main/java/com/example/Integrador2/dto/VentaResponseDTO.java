package com.example.Integrador2.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VentaResponseDTO(Integer id,
                               String nombreCliente,
                               String nombreVendedor,
                               BigDecimal total,
                               LocalDateTime fechaVenta,
                               List<DetalleVentaResponseDTO> detalles) {
}
