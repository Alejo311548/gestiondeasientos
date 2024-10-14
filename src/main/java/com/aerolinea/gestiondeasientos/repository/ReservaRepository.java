package com.aerolinea.gestiondeasientos.repository;

import com.aerolinea.gestiondeasientos.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz para el repositorio de reservas.
 * Extiende JpaRepository para proporcionar operaciones CRUD.
 */
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    /**
     * Busca una reserva por el nombre del pasajero.
     *
     * @param pasajero El nombre del pasajero.
     * @return La reserva asociada al pasajero.
     */
    Reserva findByPasajero(String pasajero);

    /**
     * Obtiene todas las reservas.
     *
     * @return Lista de todas las reservas.
     */
    List<Reserva> findAll();
}
