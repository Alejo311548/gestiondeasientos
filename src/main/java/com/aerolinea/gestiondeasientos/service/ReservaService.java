package com.aerolinea.gestiondeasientos.service;

import com.aerolinea.gestiondeasientos.model.Reserva;
import com.aerolinea.gestiondeasientos.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Servicio para gestionar reservas de aerolínea.
 */
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    /**
     * Obtiene una reserva por el nombre del pasajero.
     *
     * @param pasajero El nombre del pasajero.
     * @return La reserva asociada al pasajero.
     * @throws NoSuchElementException si no se encuentra la reserva.
     */
    public Reserva obtenerReservaPorPasajero(String pasajero) {
        Reserva reserva = reservaRepository.findByPasajero(pasajero);
        if (reserva == null) {
            throw new NoSuchElementException("No se encontró ninguna reserva para el pasajero: " + pasajero);
        }
        return reserva;
    }

    /**
     * Obtiene todas las reservas.
     *
     * @return Lista de todas las reservas.
     */
    public List<Reserva> obtenerTodasLasReservas() {
        return reservaRepository.findAll();
    }

    public Reserva actualizarAsiento(Long idReserva, String asientoSeleccionado) {
        // Encuentra la reserva específica por ID
        Reserva reserva = reservaRepository.findById(idReserva).orElse(null);

        // Si la reserva no existe
        if (reserva == null) {

            return null;
        }

        // Actualiza solo el asiento seleccionado de la reserva encontrada
        reserva.setAsientoSeleccionado(asientoSeleccionado);
        return reservaRepository.save(reserva); // Guarda solo la reserva específica
    }



}
