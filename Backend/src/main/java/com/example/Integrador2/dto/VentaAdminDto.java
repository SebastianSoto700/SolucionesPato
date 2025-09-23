package com.example.Integrador2.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VentaAdminDto(Integer id,
                            String cliente,
                            String usuario,
                            BigDecimal total,
                            Boolean estado,
                            LocalDateTime fechaCreacion) {
}
