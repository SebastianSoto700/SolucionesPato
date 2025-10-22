package com.example.Integrador2.controller;

import com.example.Integrador2.dto.ProductoSimpleDTO; //METRICA 4
import java.util.List; //METRICA 2
import com.example.Integrador2.dto.ProductosPorCategoriaDTO;  //METRICA 2
import com.example.Integrador2.dto.StatDTO; //METRICA 1
import com.example.Integrador2.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; //METRICA 1
import org.springframework.web.bind.annotation.GetMapping; //METRICA 1
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    //METRICA 1
    @GetMapping("/total-productos")
    public ResponseEntity<StatDTO> getTotalProductos() {
        return ResponseEntity.ok(dashboardService.getTotalProductos());
    }

    //METRICA 2
    @GetMapping("/productos-por-categoria")
    public ResponseEntity<List<ProductosPorCategoriaDTO>> getProductosPorCategoria() {
        return ResponseEntity.ok(dashboardService.getProductosPorCategoria());
    }

    //METRICA 4
    @GetMapping("/productos-bajo-stock")
    public ResponseEntity<List<ProductoSimpleDTO>> getProductosBajoStock() {
        return ResponseEntity.ok(dashboardService.getProductosConBajoStock());
    }

}
