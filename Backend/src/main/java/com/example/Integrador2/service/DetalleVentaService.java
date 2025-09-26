package com.example.Integrador2.service;


import com.example.Integrador2.repository.DetallaVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService {

    @Autowired
    private DetallaVentaRepository detallaVentaRepository;
}
