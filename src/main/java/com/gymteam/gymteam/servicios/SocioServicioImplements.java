package com.gymteam.gymteam.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymteam.gymteam.modelos.Socio;
import com.gymteam.gymteam.repositorios.SocioRepositorio;

@Service
public class SocioServicioImplements implements SocioServicio{

	@Autowired
	SocioRepositorio sociorepositorio;
	
	@Override
	public List<Socio> ObtenerTodo() {
		
		return sociorepositorio.findAll();
	}

	@Override
	public List<Socio> ObtenerPorNombre(String nombre) {
		
		return sociorepositorio.findByNombre(nombre);
	}

	@Override
	public Socio Alta(Socio socio) {
		return sociorepositorio.save(socio);
	}

	@Override
	public void Baja(Socio socio) {
		sociorepositorio.delete(socio);
		
	}

}
