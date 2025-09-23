package com.example.Integrador2.service;


import com.example.Integrador2.dto.VentaAdminDto;
import com.example.Integrador2.dto.VentaCreateDto;
import com.example.Integrador2.mapper.VentaMapper;
import com.example.Integrador2.model.Cliente;
import com.example.Integrador2.model.Usuario;
import com.example.Integrador2.model.Venta;
import com.example.Integrador2.repository.ClienteRepository;
import com.example.Integrador2.repository.UsuarioRepository;
import com.example.Integrador2.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    VentaRepository ventaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VentaMapper ventaMapper;


    public List<VentaAdminDto> listar (){
        return ventaRepository.findAll()
                .stream()
                .map(ventaMapper::adminDto)
                .toList();
    }

    //Pausado temporalmente

//    @Transactional
//    public VentaAdminDto crearVenta (VentaCreateDto ventaCreateDto){
//        Venta venta= ventaMapper.toEntity(ventaCreateDto);
//
//
//        Cliente cliente = clienteRepository.findById(ventaCreateDto.clienteId())
//                .orElseThrow(() -> new RuntimeException("No se ha encontrado el id del cliente"));
//        Usuario usuario = usuarioRepository.findById(ventaCreateDto.usuarioId())
//                .orElseThrow(() -> new RuntimeException("No se ha encontrado el cliente"));
//
//        Venta ventaguardad = ventaRepository.save(venta);
//
//
//        //me huevie logica de detalleVenta para disminuir productos y ver stock disponible
//    };
}
