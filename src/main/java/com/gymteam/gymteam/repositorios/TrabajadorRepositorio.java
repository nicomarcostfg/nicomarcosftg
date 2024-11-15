package com.gymteam.gymteam.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymteam.gymteam.modelos.Trabajador;

@Repository
public interface TrabajadorRepositorio extends JpaRepository<Trabajador, Long> {

	Trabajador findByUsername(String username);

}

