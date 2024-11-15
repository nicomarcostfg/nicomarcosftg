package com.gymteam.gymteam.servicios;

import java.util.List;

import com.gymteam.gymteam.dto.EjercicioConConteo;
import com.gymteam.gymteam.dto.SocioConConteo;
import com.gymteam.gymteam.modelos.Ejercicio;
import com.gymteam.gymteam.modelos.Socio;

public interface SocioEjercicioServicio {

    void añadirEjercicioASocio(Socio socio, Ejercicio ejercicio);
    
    void eliminarEjercicioDeSocio(Socio socio, Ejercicio ejercicio);
    
    List<Ejercicio> listarEjerciciosDeSocio(Socio socio);
    
    List<EjercicioConConteo> obtenerEjerciciosConConteo();
    
    List<SocioConConteo> obtenerSociosConConteo();
    
}

