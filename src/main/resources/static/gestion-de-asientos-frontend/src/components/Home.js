// src/components/Home.js
import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css'; // Para estilos

const Home = () => {
    return (
        <div className="home">
            <nav className="navbar">
                <h1>CodeF@ctory 2024-2</h1>
                <ul>
                    <li>
                        <Link to="/ver-reservas">Ver Reservas</Link>
                    </li>
                    <li>
                        <Link to="/gestionar-asientos">Gestionar Asientos</Link> {/* Componente existente */}
                    </li>
                    <li>
                        <Link to="/gestionar-pasajeros">Gestionar Pasajeros</Link> {/* Nuevo enlace */}
                    </li>
                </ul>
            </nav>
            <h2>Bienvenido al módulo de gestión de asientos</h2>
        </div>
    );
};

export default Home;
