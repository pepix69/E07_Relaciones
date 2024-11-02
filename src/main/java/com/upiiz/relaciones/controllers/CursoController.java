package com.upiiz.relaciones.controllers;

import com.upiiz.relaciones.entities.Curso;
import com.upiiz.relaciones.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relaciones/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos(){
        return ResponseEntity.ok(cursoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> getCursoById(@PathVariable Long id){
        return ResponseEntity.ok(cursoService.obtenerUno(id));
    }

    @PostMapping
    public ResponseEntity<Curso> guardar(@RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.guardarCurso(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Curso>> updateCurso(@PathVariable Long id, @RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.actualizarCurso(id, curso));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCurso(@PathVariable Long id){
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
