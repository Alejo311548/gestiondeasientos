// src/services/SeatService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/asientos';

export const getSeatDetails = async (reservaId) => { // Aceptar el ID de la reserva como parámetro
    try {
        const response = await axios.get(`${API_URL}/reserva/${reservaId}`); // Construir la URL con el ID de la reserva
        return response; // Asegúrate de que `response.data` sea manejado en el componente.
    } catch (error) {
        console.error("Error al obtener los detalles de los asientos:", error);
        throw error; // Lanza el error para que sea manejado en el componente.
    }
};


