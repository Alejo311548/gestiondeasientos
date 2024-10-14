package com.aerolinea.gestiondeasientos.controller;

import com.aerolinea.gestiondeasientos.model.Asiento;
import com.aerolinea.gestiondeasientos.service.AsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/asientos")
public class AsientoController {

    @Autowired
    private AsientoService asientoService;

    // Obtener asientos por ID de reserva (incluye disponibilidad y descripción)
    @GetMapping("/reserva/{idReserva}") // Cambié id_reserva a idReserva
    public ResponseEntity<List<Asiento>> obtenerAsientosPorReserva(@PathVariable Long idReserva) { // Cambié id_reserva a idReserva
        List<Asiento> asientos = asientoService.obtenerAsientosPorReserva(idReserva); // Cambié id_reserva a idReserva
        if (asientos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(asientos, HttpStatus.OK);
    }
}
