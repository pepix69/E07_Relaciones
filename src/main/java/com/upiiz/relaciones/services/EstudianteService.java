package com.upiiz.relaciones.services;

import com.upiiz.relaciones.entities.Estudiante;
import com.upiiz.relaciones.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    //Listar todos
    public List<Estudiante> obtenerTodos(){
        return estudianteRepository.findAll();
    }

    //Listar uno
    public Optional<Estudiante> obtenerUno(Long id){return  estudianteRepository.findById(id);}

    //Guardar
    public Estudiante guardarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    //Actualizar
    public Optional<Estudiante> actualizarEstudiante(Long id, Estudiante estudiante){
        return estudianteRepository.findById(id).map(estudianteExistente -> {
            // Aquí se actualizan solo los campos necesarios
            estudianteExistente.setNombres(estudiante.getNombres());
            estudianteExistente.setCorreo(estudiante.getCorreo());
            estudianteExistente.setMatricula(estudiante.getMatricula());
            // Agrega más setters si necesitas actualizar otros campos

            return estudianteRepository.save(estudianteExistente);});
    }

    //Delete
    public void eliminarEstudiante(Long id){
        estudianteRepository.deleteById(id);
    }


}
