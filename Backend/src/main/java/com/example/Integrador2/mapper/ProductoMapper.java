package com.example.Integrador2.mapper;

import com.example.Integrador2.dto.ProductoAdminDto;
import com.example.Integrador2.dto.ProductoGiovanniDto;
import com.example.Integrador2.dto.ProductoUpdateDto;
import com.example.Integrador2.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductoMapper {


    @Mapping(source = "categoria.nombre" , target = "categoria")
    ProductoGiovanniDto toclienteDto(Producto producto);

    @Mapping(source = "categoria.nombre", target = "categoria")
    ProductoAdminDto todtoAdmin(Producto producto);

    @Mapping(source = "categoriaId", target = "categoria.id")
    Producto toEntity(ProductoUpdateDto productoCrateDTO);

    @Mapping(source = "categoriaId", target = "categoria.id")
    void updateEntityFromDto(ProductoUpdateDto dtoupdate, @MappingTarget Producto producto);

}
