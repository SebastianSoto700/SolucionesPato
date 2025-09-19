package com.example.Integrador2.controller;

import com.example.Integrador2.dto.CompraAdminDto;
import com.example.Integrador2.dto.CompraCreateDto;
import com.example.Integrador2.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    CompraService compraService;

    @GetMapping()
    public ResponseEntity<List<CompraAdminDto>> listarcomprar(){
        return ResponseEntity.ok(compraService.listarComprar());
    }

    @PostMapping
    public ResponseEntity<CompraAdminDto> crearComprar (@RequestBody CompraCreateDto createdto){
        return ResponseEntity.ok(compraService.crearCompra(createdto));
    }
}
