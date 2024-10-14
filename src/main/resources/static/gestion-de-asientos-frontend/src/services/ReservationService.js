// src/services/ReservationService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/reservas'; // Endpoint de la API

// Obtener los detalles de la reserva por nombre de pasajero
export const getReservationDetailsByPassenger = (passengerName) => {
    return axios.get(`${API_URL}/pasajero/${passengerName}`);
};

