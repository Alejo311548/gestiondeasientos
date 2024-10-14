package com.aerolinea.gestiondeasientos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

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

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha_vuelo")
    private LocalDate fechaVuelo;

    @Column(name = "hora_vuelo")
    private LocalTime horaVuelo;

    @Column(name = "numero_vuelo")
    private String numeroVuelo;

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

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getFechaVuelo() {
        return fechaVuelo;
    }

    public LocalTime getHoraVuelo() {
        return horaVuelo;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    // Setters
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    public void setAsientoSeleccionado(String asientoSeleccionado) {
        this.asientoSeleccionado = asientoSeleccionado;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaVuelo(LocalDate fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public void setHoraVuelo(LocalTime horaVuelo) {
        this.horaVuelo = horaVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }
}



