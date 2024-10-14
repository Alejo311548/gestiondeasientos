package com.aerolinea.gestiondeasientos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asientos")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsiento; // Cambié id_asiento a idAsiento

    @Column(name = "id_reserva", nullable = false)
    private Long idReserva; // Mantengo este nombre

    @Column(name = "id_vuelo", nullable = false)
    private String idVuelo; // Mantengo este nombre

    @Column(name = "origen", nullable = false)
    private String origen; // Mantengo este nombre

    @Column(name = "destino", nullable = false)
    private String destino; // Mantengo este nombre

    @Column(name = "fecha_vuelo", nullable = false)
    private String fechaVuelo; // Mantengo este nombre

    @Column(name = "cantidad_pasajeros", nullable = false)
    private int cantidadPasajeros; // Mantengo este nombre

    @Column(name = "disponibilidad", nullable = false)
    private boolean disponibilidad; // Mantengo este nombre

    @Column(name = "descripcion", nullable = true)
    private String descripcion; // Mantengo este nombre

    // Getters y Setters

    public Long getIdAsiento() {
        return idAsiento; // Cambié id_asiento a idAsiento
    }

    public void setIdAsiento(Long idAsiento) { // Cambié id_asiento a idAsiento
        this.idAsiento = idAsiento;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
