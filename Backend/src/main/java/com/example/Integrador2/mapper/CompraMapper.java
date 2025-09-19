package com.example.Integrador2.mapper;

import com.example.Integrador2.dto.CompraAdminDto;
import com.example.Integrador2.dto.CompraCreateDto;
import com.example.Integrador2.model.Compra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompraMapper {

    @Mapping(source = "proveedor.nombre" , target = "proveedor")
    @Mapping(source = "producto.nombre" , target = "producto")
    CompraAdminDto dto(Compra compra);


    @Mapping(source = "productoId", target = "producto.id")
    @Mapping(source = "proveedorId", target = "proveedor.id")
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Compra toEntity (CompraCreateDto compraCreateDto);
}
