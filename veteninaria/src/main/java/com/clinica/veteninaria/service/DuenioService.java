package com.clinica.veteninaria.service;

import com.clinica.veteninaria.exception.DuenioNotFoundException;
import com.clinica.veteninaria.model.Duenio;
import com.clinica.veteninaria.repository.DuenioRepository;
import com.clinica.veteninaria.validation.DuenioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService {
    @Autowired
    private DuenioRepository duenioRepository;

    @Autowired
    private DuenioValidator duenioValidator;

    public List<Duenio> obtenerTodosLosDuenios() {
        return duenioRepository.findAll();
    }

    public Duenio obtenerDuenioPorId(Long id) {
        return duenioRepository.findById(id).orElse(null);
    }

    public Duenio crearDuenio(Duenio duenio) {
        duenioValidator.validarDuenio(duenio);
        return duenioRepository.save(duenio);
    }

    public Duenio actualizarDuenio(Long id, Duenio duenioActualizado) {
        Duenio duenioExistente = duenioRepository.findById(id).orElse(null);
        if (duenioExistente == null) {
            throw new DuenioNotFoundException("El dueño con ID " + id + " no existe.");
        }

        duenioValidator.validarDuenio(duenioActualizado);

        duenioExistente.setNombre(duenioActualizado.getNombre());
        duenioExistente.setApellido(duenioActualizado.getApellido());

        return duenioRepository.save(duenioExistente);
    }

    public void eliminarDuenio(Long id) {
        duenioRepository.deleteById(id);
    }
}