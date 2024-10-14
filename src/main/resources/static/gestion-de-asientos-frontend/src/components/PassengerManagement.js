// src/components/PassengerManagement.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './PassengerManagement.css';

const PassengerManagement = () => {
    const [passengers, setPassengers] = useState([]);
    const [selectedSeats, setSelectedSeats] = useState({}); // Estado para almacenar los asientos seleccionados

    useEffect(() => {
        const fetchPassengers = async () => {
            try {
                const response = await axios.get('/api/reservas');
                setPassengers(response.data);
            } catch (error) {
                console.error("Error fetching passengers:", error);
            }
        };

        fetchPassengers();
    }, []);

    const handleSeatChange = async (idReserva) => {
        const newSeat = selectedSeats[idReserva]; // Obtener el nuevo asiento

        if (!newSeat) return; // No hacer nada si no hay asiento seleccionado

        try {
            const response = await axios.put(`/api/reservas/${idReserva}/asiento`, {
                asientoSeleccionado: newSeat,
            });
            // Actualizar la lista de pasajeros
            setPassengers(passengers.map(passenger =>
                passenger.idReserva === idReserva ? response.data : passenger
            ));
            setSelectedSeats(prev => ({ ...prev, [idReserva]: '' })); // Limpiar el asiento para este pasajero
        } catch (error) {
            console.error("Error updating seat:", error);
        }
    };

    const handleInputChange = (idReserva, value) => {
        setSelectedSeats(prev => ({ ...prev, [idReserva]: value })); // Actualizar el estado del asiento seleccionado para este pasajero
    };

    return (
        <div className="passenger-management-container">
            <h2>CodeF@actory 2024-2</h2>
            <h1>Módulo de gestión de asientos</h1>
            <h1>Gestión de Pasajeros</h1>
            <table className="passenger-table">
                <thead>
                <tr>
                    <th>ID Reserva</th>
                    <th>Pasajero</th>
                    <th>Asiento Seleccionado</th>
                    <th>Origen</th>
                    <th>Destino</th>
                    <th>Número de Vuelo</th>
                    <th>Modificar Asiento</th>
                </tr>
                </thead>
                <tbody>
                {passengers.map((passenger) => (
                    <tr key={passenger.idReserva}>
                        <td>{passenger.idReserva}</td>
                        <td>{passenger.pasajero}</td>
                        <td>{passenger.asientoSeleccionado || 'No asignado'}</td>
                        <td>{passenger.origen}</td>
                        <td>{passenger.destino}</td>
                        <td>{passenger.numeroVuelo}</td>
                        <td>
                            <input
                                type="text"
                                placeholder="Nuevo asiento"
                                value={selectedSeats[passenger.idReserva] || ''} // Obtener el asiento seleccionado para este pasajero
                                onChange={(e) => handleInputChange(passenger.idReserva, e.target.value)} // Llamar a la función para actualizar el asiento
                            />
                            <button onClick={() => handleSeatChange(passenger.idReserva)}>
                                Actualizar
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default PassengerManagement;
