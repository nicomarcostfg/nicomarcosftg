package com.gymteam.gymteam.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymteam.gymteam.modelos.Ejercicio;

@Repository
public interface EjercicioRepositorio extends JpaRepository<Ejercicio, Long> {

	List<Ejercicio> findByNombre(String nombre);
	
}

