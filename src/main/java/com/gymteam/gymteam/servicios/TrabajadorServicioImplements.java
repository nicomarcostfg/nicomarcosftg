package com.gymteam.gymteam.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymteam.gymteam.modelos.Trabajador;
import com.gymteam.gymteam.repositorios.TrabajadorRepositorio;

@Service
public class TrabajadorServicioImplements implements TrabajadorServicio{

	@Autowired
	TrabajadorRepositorio trabajadorrepositorio;
	@Override
	public Trabajador altaTrabajador(Trabajador trabajador) {
		
		return trabajadorrepositorio.save(trabajador);
	}

	@Override
	public void bajaTrabajador(Trabajador trabajador) {
		trabajadorrepositorio.delete(trabajador);
		
	}

	@Override
	public List<Trabajador> obtenerTodos() {
		
		return trabajadorrepositorio.findAll();
               
	}

        public Trabajador Existe(String ussername){
            return trabajadorrepositorio.findByUsername(ussername);
        }
}
