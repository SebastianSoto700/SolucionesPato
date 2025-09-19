package com.example.Integrador2.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CompraAdminDto(Integer id,
                             String proveedor,
                             String producto ,
                             int cantidad,
                             BigDecimal precio  ,
                             Boolean estado,
                             LocalDateTime fechaCreacion) {
}
