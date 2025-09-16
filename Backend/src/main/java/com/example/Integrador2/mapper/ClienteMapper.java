package com.example.Integrador2.mapper;

import com.example.Integrador2.dto.ClienteAdminDto;
import com.example.Integrador2.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


    //De entidad a dto
    ClienteAdminDto toAdminDto(Cliente cliente);


    //de DTO a entidad
    @Mapping(target = "fechaCreacion", ignore = true)
    Cliente toEntity(ClienteAdminDto dto);


    //Actualizamos un cliente.
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    void updateEntityFromDto (ClienteAdminDto dto, @MappingTarget Cliente cliente);


}
