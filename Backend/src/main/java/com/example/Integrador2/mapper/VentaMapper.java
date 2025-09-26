package com.example.Integrador2.mapper;

import com.example.Integrador2.dto.VentaAdminDto;
import com.example.Integrador2.dto.VentaCreateDto;
import com.example.Integrador2.model.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VentaMapper {

    @Mapping(source = "usuario.nombre", target = "usuario")
    @Mapping(source = "cliente.nombre", target = "cliente")
    VentaAdminDto adminDto (Venta venta);

    @Mapping(source = "usuarioId" , target = "usuario.id")
    @Mapping(source = "clienteId" , target = "cliente.id")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Venta toEntity (VentaCreateDto ventaCreateDto);

}
