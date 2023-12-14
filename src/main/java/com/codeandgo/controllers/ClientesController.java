package com.codeandgo.controllers;

import com.codeandgo.models.Clientes;
import com.codeandgo.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository cr;

    @GetMapping("/allclientes")
    public ResponseEntity<List<Clientes>> getAllClientes() {
        List<Clientes> clientesList = cr.findAll();
        return ResponseEntity.ok(clientesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> getClientById(@PathVariable Long id) {
        return cr.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/saveclientes")
    public ResponseEntity<Clientes> saveClient(@RequestBody Clientes clientes) {
        Clientes clientesCreated = cr.save(clientes);
        return new ResponseEntity<>(clientesCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> updateClientes(@PathVariable Long id, @RequestBody Clientes clientesUpdated) {
        return cr.findById(id)
                .map(clientes -> {
                    clientes.setName(clientesUpdated.getName());
                    clientes.setCpf(clientesUpdated.getCpf());
                    Clientes updatedCliente = cr.save(clientes);
                    return ResponseEntity.ok(updatedCliente);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientes(@PathVariable Long id) {
        return cr.findById(id)
                .map(clientes -> {
                    cr.delete(clientes);
                    return ResponseEntity.ok(id + " Deleted");
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

