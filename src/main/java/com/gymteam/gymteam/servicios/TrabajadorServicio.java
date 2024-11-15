package com.gymteam.gymteam.servicios;

import java.util.List;

import com.gymteam.gymteam.modelos.Trabajador;

public interface TrabajadorServicio{
		
	Trabajador altaTrabajador(Trabajador trabajador);
	
	void bajaTrabajador(Trabajador trabajador);
	
	List<Trabajador> obtenerTodos();
        
        Trabajador Existe(String ussername);

}
