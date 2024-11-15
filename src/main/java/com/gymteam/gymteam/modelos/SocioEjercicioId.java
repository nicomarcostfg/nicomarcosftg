package com.gymteam.gymteam.modelos;

import java.io.Serializable;
import java.util.Objects;

public class SocioEjercicioId implements Serializable {

    private static final long serialVersionUID = 1L;
	private Long socio;
    private Long ejercicio;

    public SocioEjercicioId() {}

    public SocioEjercicioId(Long socio, Long ejercicio) {
        this.socio = socio;
        this.ejercicio = ejercicio;
    }

    // Getters y setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocioEjercicioId that = (SocioEjercicioId) o;
        return Objects.equals(socio, that.socio) && Objects.equals(ejercicio, that.ejercicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socio, ejercicio);
    }
}


