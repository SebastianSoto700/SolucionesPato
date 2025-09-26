package com.example.Integrador2.mapper;

import com.example.Integrador2.dto.DetalleVentaResponseDTO;
import com.example.Integrador2.dto.VentaResponseDTO;
import com.example.Integrador2.model.DetalleVenta;
import com.example.Integrador2.model.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VentaMapper {

    @Mapping(source = "cliente.nombre", target = "nombreCliente")
    @Mapping(source = "usuario.nombre", target = "nombreVendedor")
    @Mapping(source = "fechaVenta", target = "fechaVenta") // Coincide, pero es bueno ser explícito
    @Mapping(source = "detalles", target = "detalles") // Mapea la lista de detalles anidada
    VentaResponseDTO toVentaResponseDTO(Venta venta);

    @Mapping(source = "producto.nombre", target = "nombreProducto")
    DetalleVentaResponseDTO toDetalleVentaResponseDTO(DetalleVenta detalleVenta);

}
