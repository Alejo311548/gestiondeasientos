package com.aerolinea.gestiondeasientos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "pasajero")
    private String pasajero;

    @Column(name = "itinerario")
    private String itinerario;

    @Column(name = "asiento_seleccionado")
    private String asientoSeleccionado;

    // Getters
    public Long getIdReserva() {
        return idReserva;
    }

    public String getPasajero() {
        return pasajero;
    }

    public String getItinerario() {
        return itinerario;
    }

    public String getAsientoSeleccionado() {
        return asientoSeleccionado;
    }
}


