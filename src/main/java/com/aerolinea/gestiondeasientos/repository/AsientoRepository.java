package com.aerolinea.gestiondeasientos.repository;

import com.aerolinea.gestiondeasientos.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Long> {

    // Método personalizado para buscar asientos por ID de reserva
    List<Asiento> findByIdReserva(Long idReserva); // Mantengo este nombre
}
