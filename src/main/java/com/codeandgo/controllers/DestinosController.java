package com.codeandgo.controllers;

import com.codeandgo.models.Destinos;
import com.codeandgo.repositories.DestinosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinosController {

    @Autowired
    private DestinosRepository dr;

    @GetMapping("/alldestinos")
    public List<Destinos> getAllDestinos() {
        return dr.findAll();
    }

    @GetMapping("/{idDestino}")
    public ResponseEntity<Destinos> getDestinoById(@PathVariable Long idDestino) {
        Destinos destinos = dr.findById(idDestino).orElse(null);

        if (destinos != null) {
            return ResponseEntity.ok(destinos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveDestinos")
    public ResponseEntity<Destinos> saveDestinos(@RequestBody Destinos destinos) {
        Destinos savedDestino = dr.save(destinos);
        return new ResponseEntity<>(savedDestino, HttpStatus.CREATED);
    }

    @PutMapping("/{idDestino}")
    public ResponseEntity<Destinos> updateDestino(@PathVariable Long idDestino, @RequestBody Destinos destinoUpdated) {
        Destinos destinos = dr.findById(idDestino).orElse(null);

        if (destinos != null) {
            destinos.setLocal(destinoUpdated.getLocal());
            destinos.setDataIda(destinoUpdated.getDataIda());
            destinos.setDataVolta(destinoUpdated.getDataVolta());

            Destinos updatedDestino = dr.save(destinos);
            return ResponseEntity.ok(updatedDestino);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idDestino}")
    public ResponseEntity<String> deleteDestinos(@PathVariable Long idDestino) {
        Destinos destinos = dr.findById(idDestino).orElse(null);

        if (destinos != null) {
            dr.delete(destinos);
            return ResponseEntity.ok("Destino with ID " + idDestino + " deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

