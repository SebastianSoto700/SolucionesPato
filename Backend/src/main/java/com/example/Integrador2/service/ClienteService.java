package com.example.Integrador2.service;


import com.example.Integrador2.dto.ClienteAdminDto;
import com.example.Integrador2.mapper.ClienteMapper;
import com.example.Integrador2.model.Cliente;
import com.example.Integrador2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public List<ClienteAdminDto>  listarCliente (){
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toAdminDto) //nos ahorramos poner el .get por cada campo de cliente
                .toList();
    }


    @Transactional
    public ClienteAdminDto crearCliente(ClienteAdminDto admiDto){
        Cliente cliente = clienteMapper.toEntity(admiDto); //de dto a entidad
        Cliente guardar = clienteRepository.save(cliente);

        return clienteMapper.toAdminDto(guardar); // de entidad a dto
    }

    @Transactional
    public ClienteAdminDto actualizarCliente (Integer id, ClienteAdminDto adminDto){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado dicho id"));

        clienteMapper.updateEntityFromDto(adminDto, cliente); //actualizamos solo los campos del DTO

        Cliente actualizado = clienteRepository.save(cliente);
        return clienteMapper.toAdminDto(actualizado);
    }

    @Transactional
    public void eliminarCliente(Integer id ){
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se ha encontrado el id"));
        cliente.eliminar();
    }

}
