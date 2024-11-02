package com.upiiz.relaciones.controllers;

import com.upiiz.relaciones.entities.Estudiante;
import com.upiiz.relaciones.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {

    @Autowired
    EstudianteService cursoService;

    @GetMapping
    public ResponseEntity<List<Estudiante>> getEstudiantes(){
        return ResponseEntity.ok(cursoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Estudiante>> getEstudianteById(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.obtenerUno(id));
    }

    @PostMapping
    public ResponseEntity<Estudiante> guardar(@RequestBody Estudiante curso){
        return ResponseEntity.ok(cursoService.guardarEstudiante(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Estudiante>> updateEstudiante(@PathVariable Long id, @RequestBody Estudiante curso){
        return ResponseEntity.ok(cursoService.actualizarEstudiante(id, curso));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id){
        cursoService.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
