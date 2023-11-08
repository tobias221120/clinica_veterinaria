package com.clinica.veteninaria.controller;


import com.clinica.veteninaria.model.Duenio;
import com.clinica.veteninaria.service.DuenioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/duenios")
public class DuenioController {
    @Autowired
    private DuenioService duenioService;

    @GetMapping
    public ResponseEntity<List<Duenio>> obtenerTodosLosDuenios() {
        List<Duenio> duenios = duenioService.obtenerTodosLosDuenios();
        return new ResponseEntity<>(duenios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Duenio> obtenerDuenioPorId(@PathVariable Long id) {
        Duenio duenio = duenioService.obtenerDuenioPorId(id);
        return new ResponseEntity<>(duenio, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Duenio> crearDuenio(@RequestBody Duenio duenio) {
        log.info("NUEVO DUENIO: " + duenio);
        Duenio duenioCreado = duenioService.crearDuenio(duenio);
        return new ResponseEntity<>(duenioCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Duenio> actualizarDuenio(@PathVariable Long id, @RequestBody Duenio duenio) {
        Duenio duenioActualizado = duenioService.actualizarDuenio(id, duenio);
        return new ResponseEntity<>(duenioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDuenio(@PathVariable Long id) {
        duenioService.eliminarDuenio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
