package com.upiiz.relaciones.repositories;

import com.upiiz.relaciones.entities.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeccionRepository extends JpaRepository<Leccion, Long> {
}
