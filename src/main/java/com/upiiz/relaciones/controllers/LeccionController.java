package com.upiiz.relaciones.controllers;

import com.upiiz.relaciones.entities.Leccion;
import com.upiiz.relaciones.services.LeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lecciones")
public class LeccionController {
    @Autowired
    LeccionService leccionService;

    @GetMapping
    public ResponseEntity<List<Leccion>> getLecciones(){
        return ResponseEntity.ok(leccionService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Leccion>> getLeccionById(@PathVariable Long id){
        return ResponseEntity.ok(leccionService.obtenerUno(id));
    }

    @PostMapping
    public ResponseEntity<Leccion> guardar(@RequestBody Leccion leccion){
        return ResponseEntity.ok(leccionService.guardarLeccion(leccion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Leccion>> updateLeccion(@PathVariable Long id, @RequestBody Leccion leccion){
        return ResponseEntity.ok(leccionService.actualizarLeccion(id, leccion));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLeccion(@PathVariable Long id){
        leccionService.eliminarLeccion(id);
        return ResponseEntity.noContent().build();
    }
}

