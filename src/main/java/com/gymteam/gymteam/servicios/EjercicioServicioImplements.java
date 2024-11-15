package com.gymteam.gymteam.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymteam.gymteam.modelos.Ejercicio;
import com.gymteam.gymteam.repositorios.EjercicioRepositorio;

@Service
public class EjercicioServicioImplements implements EjercicioServicio{
	
	@Autowired
	EjercicioRepositorio ejerciciorepositorio;
	
	@Override
	public List<Ejercicio> obtenerTodo() {
		
		return ejerciciorepositorio.findAll();
	}

	@Override
	public List<Ejercicio> obtenerTodoxNombre(String nombre) {
		
		return ejerciciorepositorio.findByNombre(nombre);
	}

	@Override
	public Ejercicio altaEjercicio(Ejercicio ejercicio) {
		
		return ejerciciorepositorio.save(ejercicio);
	}

	@Override
	public void bajaEjercicio(Ejercicio ejercicio) {
		ejerciciorepositorio.delete(ejercicio);
		
	}

	@Override
	public Ejercicio modificarEjercicio(Ejercicio ejercicio) {
		
		return ejerciciorepositorio.save(ejercicio);
	}

}
