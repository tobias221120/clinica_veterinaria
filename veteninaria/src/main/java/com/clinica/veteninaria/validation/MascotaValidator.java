package com.clinica.veteninaria.validation;

import com.clinica.veteninaria.model.Mascota;
import org.springframework.stereotype.Component;

@Component
public class MascotaValidator {
    public void validarMascota(Mascota mascota) {
        if (mascota.getNombre() == null || mascota.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la mascota no puede estar vacío.");
        }

        if (mascota.getEspecie() == null || mascota.getEspecie().isEmpty()) {
            throw new IllegalArgumentException("La especie de la mascota no puede estar vacía.");
        }

        if (mascota.getRaza() == null || mascota.getRaza().isEmpty()) {
            throw new IllegalArgumentException("La raza de la mascota no puede estar vacía.");
        }


    }
}
