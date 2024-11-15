package com.gymteam.gymteam.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(SocioEjercicioId.class)
public class SocioEjercicio {

    @Id
    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @Id
    @ManyToOne
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;

    public SocioEjercicio() {}

    public SocioEjercicio(Socio socio, Ejercicio ejercicio) {
        this.socio = socio;
        this.ejercicio = ejercicio;
    }

    // Getters y setters

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
}



