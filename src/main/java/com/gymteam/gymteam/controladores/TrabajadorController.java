package com.gymteam.gymteam.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.gymteam.gymteam.modelos.Trabajador;
import com.gymteam.gymteam.servicios.TrabajadorServicio;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

@Service
public class TrabajadorController {

    @Autowired
    private TrabajadorServicio trabajadorServicio;

    
    

    private DefaultListModel<Trabajador> modeloLista;

    public Trabajador altaTrabajador(Trabajador trabajador) {
        return trabajadorServicio.altaTrabajador(trabajador);
    }

    public void bajaTrabajador(Trabajador trabajador) {
        trabajadorServicio.bajaTrabajador(trabajador);

        
        Trabajador encontrado = trabajadorServicio.Existe(trabajador.getUsername());
        if (encontrado == null) {
            JOptionPane.showMessageDialog(null, "Eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error: El trabajador no ha sido eliminado.");
        }
    }

    public List<Trabajador> obtenerTodos() {
        return trabajadorServicio.obtenerTodos();
    }

    public JList<Trabajador> cargarListado(JList<Trabajador> listado) {
        
        
        modeloLista = new DefaultListModel<>();
        listado.setModel(modeloLista);
        
        modeloLista.removeAllElements();
        
        List<Trabajador> trabajadores = obtenerTodos();
        
        if (trabajadores != null && !trabajadores.isEmpty()) {
            for (Trabajador trabajador : trabajadores) {
                modeloLista.addElement(trabajador);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay trabajadores para mostrar.");
        }
        listado.revalidate();
        listado.repaint();
		return listado;
    }
}

