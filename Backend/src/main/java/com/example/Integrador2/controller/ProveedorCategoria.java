package com.example.Integrador2.controller;

import com.example.Integrador2.dto.ProveedorUpdateDto;
import com.example.Integrador2.model.Proveedor;
import com.example.Integrador2.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorCategoria {

    @Autowired
    ProveedorService proveedorService;

    @PostMapping
    public void registrarProveedor(@RequestBody Proveedor proveedor){
        proveedorService.agregarProveedor(proveedor);
    }

    @GetMapping
    public List<Proveedor> listar (){
       return proveedorService.listarProveedor();
    }

    @PutMapping("/{id}")
    public Proveedor actualizar(@PathVariable Integer id, @RequestBody ProveedorUpdateDto updateDto){
        return proveedorService.actualizarProveedor(id,updateDto);
    }

    @DeleteMapping("/{id}")
    public void eliminar (@PathVariable Integer id){
        proveedorService.eliminar(id);
    }



}
