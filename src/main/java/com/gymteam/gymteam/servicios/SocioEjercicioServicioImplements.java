package com.gymteam.gymteam.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymteam.gymteam.dto.EjercicioConConteo;
import com.gymteam.gymteam.dto.SocioConConteo;
import com.gymteam.gymteam.modelos.Ejercicio;
import com.gymteam.gymteam.modelos.Socio;
import com.gymteam.gymteam.modelos.SocioEjercicio;
import com.gymteam.gymteam.repositorios.SocioEjercicioRepositorio;

@Service
public class SocioEjercicioServicioImplements implements SocioEjercicioServicio {

    @Autowired
    private SocioEjercicioRepositorio socioejerciciorepositorio;

    

    @Override
    public void eliminarEjercicioDeSocio(Socio socio, Ejercicio ejercicio) {
        // Lógica para eliminar un ejercicio de un socio
    	socioejerciciorepositorio.deleteBySocioAndEjercicio(socio, ejercicio);
    }

    @Override
    public List<Ejercicio> listarEjerciciosDeSocio(Socio socio) {
        // Lógica para obtener todos los ejercicios de un socio específico
        return socioejerciciorepositorio.findEjercicioBySocio(socio);
    }

    public List<EjercicioConConteo> obtenerEjerciciosConConteo() {
        return socioejerciciorepositorio.contarSociosPorEjercicio();
    }

    public List<SocioConConteo> obtenerSociosConConteo() {
        return socioejerciciorepositorio.contarEjerciciosPorSocio();
    }
    @Override
    public void añadirEjercicioASocio(Socio socio, Ejercicio ejercicio) {
        
        if (!socioejerciciorepositorio.existsBySocioAndEjercicio(socio, ejercicio)) {
            socioejerciciorepositorio.save(new SocioEjercicio(socio, ejercicio));
        }
    }

}


