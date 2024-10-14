// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './components/Home'; // Ensure this component exists
import SeatManagement from './components/SeatManagement';
import SeatSelection from './components/SeatSelection';
import PassengerManagement from './components/PassengerManagement';
import './App.css';

function App() {
    return (
        <Router>
            <div className="App">
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/ver-reservas" element={<SeatManagement />} />
                    <Route path="/gestionar-asientos" element={<SeatSelection />} />
                    <Route path="/gestionar-pasajeros" element={<PassengerManagement />} /> {/* Changed component to element */}
                </Routes>
            </div>
        </Router>
    );
}

export default App;
