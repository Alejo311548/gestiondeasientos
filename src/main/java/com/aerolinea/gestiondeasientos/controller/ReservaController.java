package com.aerolinea.gestiondeasientos.controller;

import com.aerolinea.gestiondeasientos.model.AsientoDTO;
import com.aerolinea.gestiondeasientos.model.Reserva;
import com.aerolinea.gestiondeasientos.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/pasajero/{pasajero}")
    public ResponseEntity<Reserva> obtenerReserva(@PathVariable String pasajero) {
        Reserva reserva = reservaService.obtenerReservaPorPasajero(pasajero);
        if (reserva != null) {
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Nuevo método para obtener todas las reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerTodasLasReservas() {
        List<Reserva> reservas = reservaService.obtenerTodasLasReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @PutMapping("/{idReserva}/asiento")
    public ResponseEntity<Reserva> actualizarAsiento(@PathVariable Long idReserva, @RequestBody AsientoDTO asientoDTO) {
        Reserva reservaActualizada = reservaService.actualizarAsiento(idReserva, asientoDTO.getAsientoSeleccionado());

        if (reservaActualizada == null) {
            // Retorna un 404 Not Found si la reserva no existe
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(reservaActualizada);
    }


}
