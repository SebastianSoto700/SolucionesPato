package com.example.Integrador2.service;


import com.example.Integrador2.dto.ProductoAdminDto;
import com.example.Integrador2.dto.ProductoGiovanniDto;
import com.example.Integrador2.dto.ProductoUpdateDto;
import com.example.Integrador2.mapper.ProductoMapper;
import com.example.Integrador2.model.Categoria;
import com.example.Integrador2.model.Producto;
import com.example.Integrador2.repository.CategoriaRepository;
import com.example.Integrador2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductoAdminDto> listarproductosAdmin() {
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::todtoAdmin)
                .toList();
    }

    public List<ProductoGiovanniDto> listarProductoGiovanni() {
        return productoRepository.findAll()
                .stream()
                .filter(Producto::getEstado)
                .map(productoMapper::toclienteDto)
                .toList();
    }

    public ProductoAdminDto crearProducto(ProductoUpdateDto dto) {
        Producto producto = productoMapper.toEntity(dto);

        Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new RuntimeException("No encontramos esa categoria"));
        producto.setCategoria(categoria);

        Producto guardar = productoRepository.save(producto);

        return productoMapper.todtoAdmin(guardar);
    }

    @Transactional
    public ProductoAdminDto actualizarProducto(Integer id, ProductoUpdateDto dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        productoMapper.updateEntityFromDto(dto, producto);

        if (dto.categoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(dto.categoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            producto.setCategoria(categoria);
        }

        Producto actualizar = productoRepository.save(producto);

        return productoMapper.todtoAdmin(actualizar);
    }

    @Transactional
    public void eliminarProducto(Integer id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID no encontrado"));
        producto.eliminar();
    }


}
