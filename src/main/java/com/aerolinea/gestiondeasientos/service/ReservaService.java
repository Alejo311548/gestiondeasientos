package com.aerolinea.gestiondeasientos.service;

import com.aerolinea.gestiondeasientos.model.Reserva;
import com.aerolinea.gestiondeasientos.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva obtenerReservaPorPasajero(String pasajero) {
        return reservaRepository.findByPasajero(pasajero);
    }
}

