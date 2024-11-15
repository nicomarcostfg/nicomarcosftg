package com.gymteam.gymteam.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymteam.gymteam.modelos.Socio;

@Repository
public interface SocioRepositorio extends JpaRepository<Socio,Long>{
	
	List<Socio> findByNombre(String nombre);
}
