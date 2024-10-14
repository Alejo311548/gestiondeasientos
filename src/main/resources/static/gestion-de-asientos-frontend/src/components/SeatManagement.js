// src/components/SeatManagement.js
import React, { useState } from 'react';
import { getReservationDetailsByPassenger } from '../services/ReservationService';
import './SeatManagement.css';

const SeatManagement = () => {
    const [passengerName, setPassengerName] = useState('');
    const [reservationDetails, setReservationDetails] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const handleSearch = async () => {
        setLoading(true);
        setError(null);
        try {
            const response = await getReservationDetailsByPassenger(passengerName);
            setReservationDetails(response.data);
        } catch (error) {
            setError('El usuario no tiene reservas');
        } finally {
            setLoading(false);
        }
    };

    const handleNewSearch = () => {
        setPassengerName('');
        setReservationDetails(null);
        setLoading(false);
        setError(null);
    };

    return (
        <div className="seat-management-container">
            <h1>CodeF@ctory 2024-2</h1>
            <h1>Módulo de Gestión de Asientos</h1>
            <div className="input-group">
                <input
                    type="text"
                    placeholder="Introduce el nombre del pasajero"
                    value={passengerName}
                    onChange={(e) => setPassengerName(e.target.value)}
                    className="input-field"
                />
                <button onClick={handleSearch} disabled={loading} className="button search-button">
                    Buscar
                </button>
                <button onClick={handleNewSearch} className="button new-search-button">
                    Nueva Búsqueda
                </button>
            </div>
            {loading && <p className="loading-message">Cargando...</p>}
            {error && <p className="error-message">{error}</p>}
            {reservationDetails && (
                <div className="result-container">
                    <h2>Detalles de la Reserva</h2>
                    <div className="reservation-details">
                        <p><strong>Código de Reserva:</strong> {reservationDetails.idReserva}</p>
                        <p><strong>Pasajero:</strong> {reservationDetails.pasajero}</p>
                        <p><strong>Itinerario:</strong> {reservationDetails.itinerario}</p>
                        <p><strong>Asiento Seleccionado:</strong> {reservationDetails.asientoSeleccionado}</p>
                        <p><strong>Origen:</strong> {reservationDetails.origen}</p>
                        <p><strong>Destino:</strong> {reservationDetails.destino}</p>
                        <p><strong>Fecha:</strong> {reservationDetails.fechaVuelo}</p>
                        <p><strong>Hora:</strong> {reservationDetails.horaVuelo}</p>
                        <p><strong>Número de Vuelo:</strong> {reservationDetails.numeroVuelo}</p>
                    </div>
                </div>
            )}
        </div>
    );
};

export default SeatManagement;
