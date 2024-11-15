package com.gymteam.gymteam.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gymteam.gymteam.modelos.Trabajador;
import com.gymteam.gymteam.modelos.TrabajadorDetails;
import com.gymteam.gymteam.repositorios.TrabajadorRepositorio;

@Service
public class TrabajadorDetailsService implements UserDetailsService {

    @Autowired
    private TrabajadorRepositorio trabajadorRepositorio;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Trabajador trabajador = trabajadorRepositorio.findByUsername(username);
        if (trabajador == null) {
            throw new UsernameNotFoundException("Trabajador no encontrado");
        }
        return new TrabajadorDetails(trabajador);
    }
}


