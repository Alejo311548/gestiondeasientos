package com.aerolinea.gestiondeasientos.model;

public class AsientoDTO {
    private String asientoSeleccionado;

    // Constructor vacío (opcional, pero recomendado)
    public AsientoDTO() {
    }

    // Constructor para facilitar la creación de objetos
    public AsientoDTO(String asientoSeleccionado) {
        this.asientoSeleccionado = asientoSeleccionado;
    }

    // Getter para obtener el valor de asientoSeleccionado
    public String getAsientoSeleccionado() {
        return asientoSeleccionado;
    }

    // Setter para establecer el valor de asientoSeleccionado
    public void setAsientoSeleccionado(String asientoSeleccionado) {
        this.asientoSeleccionado = asientoSeleccionado;
    }

    // Método toString para facilitar la visualización del objeto
    @Override
    public String toString() {
        return "AsientoDTO{" +
                "asientoSeleccionado='" + asientoSeleccionado + '\'' +
                '}';
    }

    // Método equals para comparar objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AsientoDTO)) return false;

        AsientoDTO that = (AsientoDTO) o;

        return asientoSeleccionado != null ? asientoSeleccionado.equals(that.asientoSeleccionado) : that.asientoSeleccionado == null;
    }

    // Método hashCode para utilizar en colecciones
    @Override
    public int hashCode() {
        return asientoSeleccionado != null ? asientoSeleccionado.hashCode() : 0;
    }
}
