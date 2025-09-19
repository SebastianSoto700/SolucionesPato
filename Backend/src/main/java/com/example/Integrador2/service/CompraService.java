package com.example.Integrador2.service;

import com.example.Integrador2.dto.CompraAdminDto;
import com.example.Integrador2.dto.CompraCreateDto;
import com.example.Integrador2.mapper.CompraMapper;
import com.example.Integrador2.model.Compra;
import com.example.Integrador2.model.Producto;
import com.example.Integrador2.model.Proveedor;
import com.example.Integrador2.repository.CompraRepository;
import com.example.Integrador2.repository.ProductoRepository;
import com.example.Integrador2.repository.ProveedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private CompraMapper compraMapper;


    public List<CompraAdminDto> listarComprar(){
        return compraRepository.findAll()
                .stream()
                .map(compraMapper::dto)
                .toList();
    }


    @Transactional
    public CompraAdminDto crearCompra(CompraCreateDto dto){
        System.out.println(dto.precio());
        Compra compra = compraMapper.toEntity(dto);
        System.out.println(compra.getPrecio());


        Producto producto = productoRepository.findById(dto.productoId())
                .orElseThrow(() -> new RuntimeException("No se ha encontrado el producto con el ID"));
        compra.setProducto(producto);

        Proveedor proveedor = proveedorRepository.findById(dto.proveedorId())
                .orElseThrow(() -> new RuntimeException("No se ha encontrado el proveedor"));
        compra.setProveedor(proveedor);



        Compra guardada = compraRepository.save(compra);


        //actualizamos el stock del producto
        producto.setStock(producto.getStock() + dto.cantidad());
        productoRepository.save(producto);

        return compraMapper.dto(guardada);


    }
}
