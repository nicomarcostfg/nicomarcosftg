package com.gymteam.gymteam.servicios;
import java.util.List;
import com.gymteam.gymteam.modelos.Ejercicio;

public interface EjercicioServicio {
    
    public List<Ejercicio> obtenerTodo();

    
    public List<Ejercicio> obtenerTodoxNombre(String nombre);

    
    public Ejercicio altaEjercicio(Ejercicio ejercicio);

    
    public void bajaEjercicio(Ejercicio ejercicio);

     
    public Ejercicio modificarEjercicio(Ejercicio ejercicio);
    
}
