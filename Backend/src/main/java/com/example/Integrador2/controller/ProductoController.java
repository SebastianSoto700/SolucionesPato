package com.example.Integrador2.controller;


import com.example.Integrador2.dto.ProductoAdminDto;
import com.example.Integrador2.dto.ProductoGiovanniDto;
import com.example.Integrador2.dto.ProductoUpdateDto;
import com.example.Integrador2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @GetMapping("/admin")
    public ResponseEntity<List<ProductoAdminDto>> listarProductosAdmin(){
        return ResponseEntity.ok(productoService.listarproductosAdmin());
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ProductoGiovanniDto>> listarCliente(){
        return ResponseEntity.ok(productoService.listarProductoGiovanni());
    }

    @PostMapping
    public ResponseEntity<ProductoAdminDto> crearProducto(@RequestBody ProductoUpdateDto dto){
        return ResponseEntity.ok(productoService.crearProducto(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoAdminDto> editarProductos(@PathVariable Integer id, @RequestBody ProductoUpdateDto dto){
        return ResponseEntity.ok(productoService.actualizarProducto(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProductos(@PathVariable Integer id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException, IOException {
        String uploadDir = "uploads/productos/";
        File directorio;
        directorio = new File(uploadDir);
        if (!directorio.exists()) {
            directorio.mkdirs(); // crea carpeta si no existe
        }

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        Files.write(filePath, file.getBytes());

        // devolver la ruta relativa para guardar en BD
        return ResponseEntity.ok("/uploads/productos/" + fileName);
    }


}
