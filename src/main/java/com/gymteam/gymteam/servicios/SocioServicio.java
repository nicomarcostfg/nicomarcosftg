package com.gymteam.gymteam.servicios;

import java.util.List;

import com.gymteam.gymteam.modelos.Socio;

public interface SocioServicio {
	
	public List<Socio> ObtenerTodo();
	
	public List<Socio> ObtenerPorNombre(String nombre);
	
	public Socio Alta(Socio socio);
	
	public void Baja(Socio socio);
	
	

}
