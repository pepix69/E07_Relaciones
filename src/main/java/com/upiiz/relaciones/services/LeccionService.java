package com.upiiz.relaciones.services;

import com.upiiz.relaciones.entities.Leccion;
import com.upiiz.relaciones.repositories.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeccionService {

    @Autowired
    LeccionRepository leccionRepository;

    //Listar todos
    public List<Leccion> obtenerTodos(){
        return leccionRepository.findAll();
    }

    //Listar uno
    public Optional<Leccion> obtenerUno(Long id){return  leccionRepository.findById(id);}

    //Guardar
    public Leccion guardarLeccion(Leccion leccion){
        return leccionRepository.save(leccion);
    }

    //Actualizar
    public Optional<Leccion> actualizarLeccion(Long id, Leccion leccion){
        return leccionRepository.findById(id).map(leccionExistente -> {
            // Aquí se actualizan solo los campos necesarios
            leccionExistente.setTitulo(leccion.getTitulo());
            leccionExistente.setContenido(leccion.getContenido());

            // Agrega más setters si necesitas actualizar otros campos
            return leccionRepository.save(leccionExistente);});
    }

    //Delete
    public void eliminarLeccion(Long id){
        leccionRepository.deleteById(id);
    }

}
