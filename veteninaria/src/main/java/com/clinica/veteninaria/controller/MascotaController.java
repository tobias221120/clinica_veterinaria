package com.clinica.veteninaria.controller;

import com.clinica.veteninaria.dto.MascotaDuenioDTO;
import com.clinica.veteninaria.model.Mascota;
import com.clinica.veteninaria.service.MascotaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @PostMapping
    public ResponseEntity<Mascota> crearMascota(@RequestBody Mascota mascota) {
        log.info("NUEVA MASCOTA : " + mascota);
        Mascota mascotaCreada = mascotaService.crearMascota(mascota);
        return new ResponseEntity<>(mascotaCreada, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascota) {
        Mascota mascotaActualizada = mascotaService.actualizarMascota(id, mascota);
        return new ResponseEntity<>(mascotaActualizada, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerMascota(@PathVariable Long id) {
        Mascota mascota = mascotaService.obtenerMascotaPorId(id);
        return new ResponseEntity<>(mascota, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotaService.eliminarMascota(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/masco-duenios")
    public ResponseEntity<List<MascotaDuenioDTO>> getMascotaDuenios() {
        List<MascotaDuenioDTO> mascotaDuenios = mascotaService.getMascoDuenios();
        return new ResponseEntity<>(mascotaDuenios, HttpStatus.OK);
    }

}
