package com.aerolinea.gestiondeasientos.controller;

import com.aerolinea.gestiondeasientos.model.Reserva;
import com.aerolinea.gestiondeasientos.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/pasajero/{pasajero}")
    public Reserva obtenerReserva(@PathVariable String pasajero) {
        return reservaService.obtenerReservaPorPasajero(pasajero);
    }
}

