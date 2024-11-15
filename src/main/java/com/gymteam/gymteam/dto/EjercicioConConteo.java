package com.gymteam.gymteam.dto;

public class EjercicioConConteo {
    private String nombreEjercicio;
    private long cantidadSocios;

    // Constructor
    public EjercicioConConteo(String nombreEjercicio, long cantidadSocios) {
        this.nombreEjercicio = nombreEjercicio;
        this.cantidadSocios = cantidadSocios;
    }

    // Getters y setters
    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public long getCantidadSocios() {
        return cantidadSocios;
    }

    public void setCantidadSocios(long cantidadSocios) {
        this.cantidadSocios = cantidadSocios;
    }
}

