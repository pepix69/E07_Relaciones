package com.upiiz.relaciones.services;

import com.upiiz.relaciones.entities.Tutor;
import com.upiiz.relaciones.repositories.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    TutorRepository tutorRepository;

    //Listar todos
    public List<Tutor> obtenerTodos(){
        return tutorRepository.findAll();
    }

    //Listar uno
    public Optional<Tutor> obtenerUno(Long id){return  tutorRepository.findById(id);}

    //Guardar
    public Tutor guardarTutor(Tutor tutor){
        return tutorRepository.save(tutor);
    }

    //Actualizar
    public Optional<Tutor> actualizarTutor(Long id, Tutor tutor){
        return tutorRepository.findById(id).map(tutorExistente -> {
            // Aquí se actualizan solo los campos necesarios
            tutorExistente.setNombre(tutor.getNombre());
            tutorExistente.setCorreo(tutor.getCorreo());
            tutorExistente.setEscolaridad(tutor.getEscolaridad());
            // Agrega más setters si necesitas actualizar otros campos

            return tutorRepository.save(tutorExistente);});
    }

    //Delete
    public void eliminarTutor(Long id){
        tutorRepository.deleteById(id);
    }

}
