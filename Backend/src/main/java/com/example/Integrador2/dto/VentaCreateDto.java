package com.example.Integrador2.dto;

import java.math.BigDecimal;

public record VentaCreateDto(Integer clienteId,
                             Integer usuarioId,
                             BigDecimal total
                             ) {
}
