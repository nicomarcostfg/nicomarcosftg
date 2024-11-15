package com.gymteam.gymteam.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gymteam.gymteam.dto.EjercicioConConteo;
import com.gymteam.gymteam.dto.SocioConConteo;
import com.gymteam.gymteam.modelos.Ejercicio;
import com.gymteam.gymteam.modelos.Socio;
import com.gymteam.gymteam.modelos.SocioEjercicio;
import com.gymteam.gymteam.modelos.SocioEjercicioId;

@Repository
public interface SocioEjercicioRepositorio extends JpaRepository<SocioEjercicio, SocioEjercicioId> {

    void deleteBySocioAndEjercicio(Socio socio, Ejercicio ejercicio);

    @Query("SELECT e FROM SocioEjercicio se JOIN se.ejercicio e WHERE se.socio = :socio")
    List<Ejercicio> findEjercicioBySocio(@Param("socio") Socio socio);


    @Query("SELECT new com.gymteam.gymteam.dto.EjercicioConConteo(e.nombre, COUNT(se.socio)) " +
           "FROM SocioEjercicio se JOIN se.ejercicio e " +
           "GROUP BY e.nombre")
    List<EjercicioConConteo> contarSociosPorEjercicio();
    
    @Query("SELECT new com.gymteam.gymteam.dto.SocioConConteo(s.nombre, COUNT(se.ejercicio)) " +
            "FROM SocioEjercicio se JOIN se.socio s " +
            "GROUP BY s.nombre")
     List<SocioConConteo> contarEjerciciosPorSocio();
    
    boolean existsBySocioAndEjercicio(Socio socio, Ejercicio ejercicio);
 
}


