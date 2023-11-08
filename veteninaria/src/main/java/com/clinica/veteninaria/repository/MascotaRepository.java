package com.clinica.veteninaria.repository;

import com.clinica.veteninaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota,Long> {
}
