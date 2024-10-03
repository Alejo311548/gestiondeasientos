document.getElementById('buscar').addEventListener('click', function() {
    const pasajero = document.getElementById('pasajero').value;
    const resultadoDiv = document.getElementById('resultado');

    fetch(`http://localhost:8080/api/reservas/pasajero/${pasajero}`)
        .then(response => {
            // Verificar si la respuesta es OK
            if (!response.ok) {
                throw new Error('Reserva no encontrada');
            }
            // Verificar si la respuesta tiene un cuerpo
            return response.text().then(text => {
                // Intentar analizar el JSON solo si hay texto
                return text ? JSON.parse(text) : null;
            });
        })
        .then(data => {
            if (data) {

                resultadoDiv.innerHTML = `<p>ID Reserva: ${data.idReserva}</p>
                                          <p>Asiento Seleccionado: ${data.asientoSeleccionado}</p>
                                          <p>Itinerario: ${data.itinerario}</p>
                                          <p>Pasajero: ${data.pasajero}</p>`;
            } else {
                resultadoDiv.innerHTML = `<p style="color:red;">No se encontró información.</p>`;
            }
        })
        .catch(error => {
            resultadoDiv.innerHTML = `<p style="color:red;">${error.message}</p>`;
        });
});
