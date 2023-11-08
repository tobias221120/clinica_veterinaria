package com.clinica.veteninaria.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private String color;

    @ManyToOne
    private Duenio duenio;
}
