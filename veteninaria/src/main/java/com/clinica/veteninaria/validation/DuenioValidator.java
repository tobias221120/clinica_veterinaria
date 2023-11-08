package com.clinica.veteninaria.validation;

import com.clinica.veteninaria.model.Duenio;
import org.springframework.stereotype.Component;

@Component
public class DuenioValidator {
    public void validarDuenio(Duenio duenio) {
        if (duenio.getNombre() == null || duenio.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del dueño no puede estar vacío.");
        }

        if (duenio.getApellido() == null || duenio.getApellido().isEmpty()) {
            throw new IllegalArgumentException("El apellido del dueño no puede estar vacío.");
        }




    }}
