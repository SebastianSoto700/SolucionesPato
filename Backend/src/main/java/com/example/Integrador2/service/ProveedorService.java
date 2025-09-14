package com.example.Integrador2.service;

import com.example.Integrador2.dto.ProveedorUpdateDto;
import com.example.Integrador2.model.Categoria;
import com.example.Integrador2.model.Proveedor;
import com.example.Integrador2.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor agregarProveedor(Proveedor proveedor){
        proveedor.setFechaCreacion(java.time.LocalDateTime.now());
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> listarProveedor(){
        return proveedorRepository.findByEstadoTrue();
    }

    @Transactional
    public Proveedor actualizarProveedor(Integer id, ProveedorUpdateDto updateDto){
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        proveedor.actualizar(updateDto);
        return proveedor;
    }

    @Transactional
    public void  eliminar(Integer id){
        Proveedor proveedor = proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));
        proveedor.eliminar();
    }

}
