package com.upiiz.relaciones.controllers;

import com.upiiz.relaciones.entities.Tutor;
import com.upiiz.relaciones.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relaciones/tutores")
public class TutorController {
    @Autowired
    TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<Tutor>> getTutores(){
        return ResponseEntity.ok(tutorService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tutor>> getTutorById(@PathVariable Long id){
        return ResponseEntity.ok(tutorService.obtenerUno(id));
    }

    @PostMapping
    public ResponseEntity<Tutor> guardar(@RequestBody Tutor tutor){
        return ResponseEntity.ok(tutorService.guardarTutor(tutor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Tutor>> updateTutor(@PathVariable Long id, @RequestBody Tutor tutor){
        return ResponseEntity.ok(tutorService.actualizarTutor(id, tutor));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id){
        tutorService.eliminarTutor(id);
        return ResponseEntity.noContent().build();
    }

}
