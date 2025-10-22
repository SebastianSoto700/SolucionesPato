package com.example.Integrador2.service;

import com.example.Integrador2.model.Producto; //METRICA 4
import com.example.Integrador2.dto.ProductoSimpleDTO;  //METRICA 4
import java.util.stream.Collectors;  //METRICA 4
import java.util.List; //METRICA 2
import com.example.Integrador2.dto.ProductosPorCategoriaDTO; //METRICA 2
import com.example.Integrador2.dto.StatDTO;
import com.example.Integrador2.repository.ProductoRepository; //METRICA 1
import org.springframework.beans.factory.annotation.Autowired; //METRICA 1
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private ProductoRepository productoRepository;

    //METRICA 1
    public StatDTO getTotalProductos() {
        long total = productoRepository.count();
        return new StatDTO(total);
    }

    //METRICA 2
    public List<ProductosPorCategoriaDTO> getProductosPorCategoria() {
        return productoRepository.countProductosByCategoria();
    }

    //METRICA 4
    public List<ProductoSimpleDTO> getProductosConBajoStock() {
        int stockBajo = 5;
        List<Producto> productos = productoRepository.findByStockLessThan(stockBajo);

        // Convertimos la lista de Producto (entidad completa) a una lista de ProductoSimpleDTO
        return productos.stream()
                .map(producto -> new ProductoSimpleDTO(
                        producto.getId(),
                        producto.getNombre(),
                        producto.getStock()))
                .collect(Collectors.toList());
    }
}
