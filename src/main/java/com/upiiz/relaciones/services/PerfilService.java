package com.upiiz.relaciones.services;

import com.upiiz.relaciones.entities.Perfil;
import com.upiiz.relaciones.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;

    //Listar todos
    public List<Perfil> obtenerTodos(){
        return perfilRepository.findAll();
    }

    //Listar uno
    public Optional<Perfil> obtenerUno(Long id){return  perfilRepository.findById(id);}

    //Guardar
    public Perfil guardarPerfil(Perfil perfil){
        return perfilRepository.save(perfil);
    }

    //Actualizar
    public Optional<Perfil> actualizarPerfil(Long id, Perfil perfil){
        return perfilRepository.findById(id).map(perfilExistente -> {
            // Aquí se actualizan solo los campos necesarios
            perfilExistente.setBiografia(perfil.getBiografia());
            perfilExistente.setFoto(perfil.getFoto());

            // Agrega más setters si necesitas actualizar otros campos
            return perfilRepository.save(perfilExistente);});
    }

    //Delete
    public void eliminarPerfil(Long id){
        perfilRepository.deleteById(id);
    }


}
