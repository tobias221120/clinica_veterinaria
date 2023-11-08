package com.clinica.veteninaria.service;

import com.clinica.veteninaria.dto.MascotaDuenioDTO;
import com.clinica.veteninaria.exception.MascotaExcetion;
import com.clinica.veteninaria.model.Duenio;
import com.clinica.veteninaria.model.Mascota;
import com.clinica.veteninaria.repository.DuenioRepository;
import com.clinica.veteninaria.repository.MascotaRepository;
import com.clinica.veteninaria.validation.MascotaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;
    @Autowired
    private DuenioRepository duenioRepository;
    @Autowired
    private MascotaValidator mascotaValidator;

    public Mascota crearMascota(Mascota mascota) {

        mascotaValidator.validarMascota(mascota);
        if (mascota.getDuenio() != null) {
            Long duenioId = mascota.getDuenio().getId();
            Duenio duenio = duenioRepository.findById(duenioId).orElse(null);
            if (duenio == null) {
                throw new MascotaExcetion("El dueño con ID " + duenioId + " no existe.");
            }
            mascota.setDuenio(duenio);
        }

        return mascotaRepository.save(mascota);
    }

    public Mascota obtenerMascotaPorId(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    public Mascota actualizarMascota(Long id, Mascota mascotaActualizada) {
        Mascota mascotaExistente = mascotaRepository.findById(id).orElse(null);

        if (mascotaExistente == null) {
            throw new MascotaExcetion("La mascota con ID " + id + " no existe.");
        }



        mascotaValidator.validarMascota(mascotaActualizada);


        mascotaExistente.setNombre(mascotaActualizada.getNombre());
        mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
        mascotaExistente.setRaza(mascotaActualizada.getRaza());
        mascotaExistente.setColor(mascotaActualizada.getColor());

        return mascotaRepository.save(mascotaExistente);
    }

    public void eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    public List<MascotaDuenioDTO> getMascoDuenios() {
        List<Mascota> listaMascotas = mascotaRepository.findAll();
        List<MascotaDuenioDTO> listaMascoDuenio = new ArrayList<>();

        for (Mascota mascota : listaMascotas) {
            MascotaDuenioDTO mascoDuenioDTO = new MascotaDuenioDTO();

            mascoDuenioDTO.setNombre_mascota(mascota.getNombre());
            mascoDuenioDTO.setEspecie(mascota.getEspecie());
            mascoDuenioDTO.setRaza(mascota.getRaza());

            Duenio duenio = mascota.getDuenio();
            mascoDuenioDTO.setNombre_duenio(duenio.getNombre());
            mascoDuenioDTO.setApellido_duenio(duenio.getApellido());

            listaMascoDuenio.add(mascoDuenioDTO);
        }

        return listaMascoDuenio;
    }
}