package com.example.Integrador2.service;



import com.example.Integrador2.mapper.VentaMapper;
import com.example.Integrador2.model.Cliente;
import com.example.Integrador2.model.Usuario;
import com.example.Integrador2.model.Venta;
import com.example.Integrador2.repository.ClienteRepository;
import com.example.Integrador2.repository.ProductoRepository;
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
    ProductoRepository productoRepository;

    @Autowired
    VentaMapper ventaMapper;


    




}



