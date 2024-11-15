package com.gymteam.gymteam.dto;

public class SocioConConteo {
    private String nombreSocio;
    private long cantidadEjercicios;

    // Constructor
    public SocioConConteo(String nombreSocio, long cantidadEjercicios) {
        this.nombreSocio = nombreSocio;
        this.cantidadEjercicios = cantidadEjercicios;
    }

    // Getters y setters
    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public long getCantidadEjercicios() {
        return cantidadEjercicios;
    }

    public void setCantidadEjercicios(long cantidadEjercicios) {
        this.cantidadEjercicios = cantidadEjercicios;
    }
}

