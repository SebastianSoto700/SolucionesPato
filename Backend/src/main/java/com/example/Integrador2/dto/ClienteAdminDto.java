package com.example.Integrador2.dto;

import java.time.LocalDateTime;

public record ClienteAdminDto(Integer id,
                              String nombre,
                              String telefono,
                              String correo,
                              Boolean estado,
                              LocalDateTime fechaCreacion
                              ) {
}
