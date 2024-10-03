package com.aerolinea.gestiondeasientos.repository;

import com.aerolinea.gestiondeasientos.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Reserva findByPasajero(String pasajero);
}

