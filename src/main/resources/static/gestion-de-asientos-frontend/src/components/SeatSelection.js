import React, { useState } from 'react';
import { getSeatDetails } from '../services/SeatService';
import './SeatSelection.css';

const SeatSelection = () => {
    const [asientos, setAsientos] = useState([]);
    const [loading, setLoading] = useState(false);
    const [reservaId, setReservaId] = useState('');

    const handleInputChange = (event) => {
        setReservaId(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        if (!reservaId) {
            alert("Por favor ingrese un ID de reserva.");
            return;
        }

        setLoading(true);
        try {
            const response = await getSeatDetails(reservaId);
            setAsientos(response.data || []);
        } catch (error) {
            console.error("Error al obtener los asientos:", error);
            setAsientos([]);
        } finally {
            setLoading(false);
        }
    };

    if (loading) {
        return <div className="loading">Cargando asientos...</div>;
    }

    return (

        <div className="seat-selection-container">
            <h1>CodeF@ctory 2024-2</h1>
            <h1>Módulo de Gestión de Asientos</h1>
            <h1 className="seat-selection-title">Consulta de asientos asignados</h1>
            <form onSubmit={handleSubmit} className="reservation-form">
                <input
                    type="text"
                    value={reservaId}
                    onChange={handleInputChange}
                    placeholder="Ingrese el ID de la reserva"
                    required
                    className="reservation-input"
                />
                <button type="submit" className="reservation-button">Consultar Asientos</button>
            </form>
            <div className="seat-selection">
                {asientos.length > 0 ? (
                    asientos.map((asiento) => (
                        <div key={asiento.idAsiento} className={`seat ${asiento.disponibilidad ? 'available' : 'unavailable'}`}>
                            <img
                                src={asiento.disponibilidad ? '/images/available-seat.png' : '/images/unavailable-seat.png'}
                                alt={asiento.descripcion}
                                className="seat-image"
                            />
                            <div className="seat-info">
                                <p className="seat-number">Asiento: {asiento.idAsiento}</p>
                                <p className="seat-description">Descripción: {asiento.descripcion || 'No disponible'}</p>
                                <p className="seat-status">Estado: {asiento.disponibilidad ? 'Disponible' : 'No Disponible'}</p>
                                {/* Mostrar origen, destino y fecha de vuelo */}
                                <p className="seat-origin">Origen: {asiento.origen}</p>
                                <p className="seat-destination">Destino: {asiento.destino}</p>
                                <p className="seat-date">Fecha de Vuelo: {asiento.fechaVuelo}</p>
                            </div>
                        </div>
                    ))
                ) : (
                    <p className="no-seats">No se encontraron asientos para el ID de reserva ingresado.</p>
                )}
            </div>
        </div>
    );
};

export default SeatSelection;
