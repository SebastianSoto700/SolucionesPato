package com.example.Integrador2.controller;

import com.example.Integrador2.dto.ClienteAdminDto;
import com.example.Integrador2.dto.ProductoAdminDto;
import com.example.Integrador2.model.Cliente;
import com.example.Integrador2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_USER')")
@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_USER')")
    @GetMapping
    public ResponseEntity<List<ClienteAdminDto>> listarClientes (){
        return ResponseEntity.ok(clienteService.listarCliente());
    }

    @PostMapping
    public ResponseEntity<ClienteAdminDto> crearCliente (@RequestBody ClienteAdminDto dto){
        return ResponseEntity.ok(clienteService.crearCliente(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteAdminDto> editarCliente(@PathVariable Integer id, @RequestBody ClienteAdminDto dto){
        return ResponseEntity.ok(clienteService.actualizarCliente(id,dto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClienteAdminDto> eliminarCliente(@PathVariable Integer id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }


}
