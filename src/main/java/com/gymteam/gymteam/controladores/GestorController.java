package com.gymteam.gymteam.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.gymteam.gymteam.modelos.Ejercicio;
import com.gymteam.gymteam.modelos.Socio;
import com.gymteam.gymteam.modelos.SocioEjercicio;
import com.gymteam.gymteam.servicios.EjercicioServicio;
import com.gymteam.gymteam.servicios.SocioEjercicioServicio;
import com.gymteam.gymteam.servicios.SocioServicio;
import com.gymteam.gymteam.dto.EjercicioConConteo;
import com.gymteam.gymteam.dto.SocioConConteo;

@RestController
@RequestMapping("/gestor")
public class GestorController {

    @Autowired
    private EjercicioServicio ejercicioServicio;

    @Autowired
    private SocioEjercicioServicio socioEjercicioServicio;

    @Autowired
    private SocioServicio socioServicio;

    @GetMapping("/bienvenido")
    public String bienvenido() {
        return "bienvenido";
    }
    // Métodos de EjercicioServicio
    @GetMapping("/ejercicios")
    public List<Ejercicio> obtenerTodosEjercicios() {
        return ejercicioServicio.obtenerTodo();
    }

    @GetMapping("/ejercicios/{nombre}")
    public List<Ejercicio> obtenerEjercicioPorNombre(@PathVariable String nombre) {
        return ejercicioServicio.obtenerTodoxNombre(nombre);
    }

    @PostMapping("/ejercicios")
    public Ejercicio altaEjercicio(@RequestBody Ejercicio ejercicio) {
        return ejercicioServicio.altaEjercicio(ejercicio);
    }

    @DeleteMapping("/ejercicios")
    public String bajaEjercicio(@RequestBody Ejercicio ejercicio) {
        ejercicioServicio.bajaEjercicio(ejercicio);
        return "Ejercicio eliminado correctamente.";
    }

    @PutMapping("/ejercicios")
    public Ejercicio modificarEjercicio(@RequestBody Ejercicio ejercicio) {
        return ejercicioServicio.modificarEjercicio(ejercicio);
    }

    // Métodos de SocioEjercicioServicio
    @PostMapping("/socioejercicio/anadir")
    public String añadirEjercicioASocio(@RequestBody SocioEjercicio socioEjercicio) {
        socioEjercicioServicio.añadirEjercicioASocio(socioEjercicio.getSocio(), socioEjercicio.getEjercicio());
        return "Ejercicio añadido al socio correctamente.";
    }

    @DeleteMapping("/socioejercicio/eliminar")
    public String eliminarEjercicioDeSocio(@RequestBody SocioEjercicio socioEjercicio) {
        socioEjercicioServicio.eliminarEjercicioDeSocio(socioEjercicio.getSocio(), socioEjercicio.getEjercicio());
        return "Ejercicio eliminado del socio correctamente.";
    }

    @GetMapping("/socioejercicio/ejercicios")
    public List<Ejercicio> listarEjerciciosDeSocio(@RequestBody Socio socio) {
        
        return socioEjercicioServicio.listarEjerciciosDeSocio(socio);
    }

    @GetMapping("/socioejercicio/ejercicios/conteo")
    public List<EjercicioConConteo> obtenerEjerciciosConConteo() {
        return socioEjercicioServicio.obtenerEjerciciosConConteo();
    }

    @GetMapping("/socioejercicio/socios/conteo")
    public List<SocioConConteo> obtenerSociosConConteo() {
        return socioEjercicioServicio.obtenerSociosConConteo();
    }

    // Métodos de SocioServicio
    @GetMapping("/socios")
    public List<Socio> obtenerTodosSocios() {
        return socioServicio.ObtenerTodo();
    }

    @GetMapping("/socios/{nombre}")
    public List<Socio> obtenerSocioPorNombre(@PathVariable String nombre) {
        return socioServicio.ObtenerPorNombre(nombre);
    }

    @PostMapping("/socios")
    public Socio altaSocio(@RequestBody Socio socio) {
        return socioServicio.Alta(socio);
    }

    @DeleteMapping("/socios")
    public String bajaSocio(@RequestBody Socio socio) {
        socioServicio.Baja(socio);
        return "Socio eliminado correctamente.";
    }
}



