package com.upiiz.relaciones.services;

import com.upiiz.relaciones.entities.Curso;
import com.upiiz.relaciones.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    //Listar todos
    public List<Curso> obtenerTodos(){
        return cursoRepository.findAll();
    }

    //Listar uno
    public Optional<Curso> obtenerUno(Long id){return  cursoRepository.findById(id);}

    //Guardar
    public Curso guardarCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    //Actualizar
    public Optional<Curso> actualizarCurso(Long id, Curso curso){
        return cursoRepository.findById(id).map(cursoExistente -> {
            // Aquí se actualizan solo los campos necesarios
            cursoExistente.setTitulo(curso.getTitulo());
            cursoExistente.setDescripcion(curso.getDescripcion());
            cursoExistente.setLecciones(curso.getLecciones());
            // Agrega más setters si necesitas actualizar otros campos

            return cursoRepository.save(cursoExistente);});
    }

    //Delete
    public void eliminarCurso(Long id){
        cursoRepository.deleteById(id);
    }


}
