package com.aerolinea.gestiondeasientos.service;

import com.aerolinea.gestiondeasientos.model.Asiento;
import com.aerolinea.gestiondeasientos.repository.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoService {

    @Autowired
    private AsientoRepository asientoRepository;

    // Obtener asientos por ID de reserva
    public List<Asiento> obtenerAsientosPorReserva(Long idReserva) {
        return asientoRepository.findByIdReserva(idReserva); // Mantengo este nombre
    }
}
