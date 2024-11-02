package com.upiiz.relaciones.controllers;

import com.upiiz.relaciones.entities.Perfil;
import com.upiiz.relaciones.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/perfiles")
public class PerfilController {
    @Autowired
    PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<Perfil>> getPerfiles(){
        return ResponseEntity.ok(perfilService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Perfil>> getPerfilById(@PathVariable Long id){
        return ResponseEntity.ok(perfilService.obtenerUno(id));
    }

    @PostMapping
    public ResponseEntity<Perfil> guardar(@RequestBody Perfil perfil){
        return ResponseEntity.ok(perfilService.guardarPerfil(perfil));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Perfil>> updatePerfil(@PathVariable Long id, @RequestBody Perfil perfil){
        return ResponseEntity.ok(perfilService.actualizarPerfil(id, perfil));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePerfil(@PathVariable Long id){
        perfilService.eliminarPerfil(id);
        return ResponseEntity.noContent().build();
    }
}
