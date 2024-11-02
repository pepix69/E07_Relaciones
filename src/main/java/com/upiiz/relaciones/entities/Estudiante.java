package com.upiiz.relaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nombres;

    private String correo;
    private String matricula;

    // Un estudiente tiene un perfil
    @OneToOne(targetEntity = Perfil.class)
    private Perfil perfil;

    // Muchos estudiantes tienen un tutor
    @ManyToOne(targetEntity = Tutor.class)
    private Tutor tutor;

    // Cursos - Muchos estudientes pueden tener muchos cursos
    @ManyToMany(targetEntity = Curso.class)
    private List<Curso> curso;
}
