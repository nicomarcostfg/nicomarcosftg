package com.gymteam.gymteam;

import com.gymteam.gymteam.controladores.TrabajadorController;
import com.gymteam.gymteam.modelos.Trabajador;
import javax.swing.*;

import org.springframework.stereotype.Component;

@Component
public class AdminWindow extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private final TrabajadorController trabajadorController;

    /**
     * Constructor que recibe TrabajadorController
     */
    public AdminWindow(TrabajadorController trabajadorController) {
        this.trabajadorController = trabajadorController;
        initComponents();
    }

    /**
     * Método para inicializar los componentes de la interfaz.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        UssernameTexto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PaswordTexto = new javax.swing.JTextField();
        BotonAlta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Listado = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        botonBaja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("username");

        jLabel2.setText("password");

        BotonAlta.setText("Dar De Alta Trabajador");
        BotonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAltaActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(Listado);

        jLabel3.setText("LISTADO DE TRABAJADORES: Seleccione trabajador para dar de baja");

        botonBaja.setText("Dar de Baja Trabajador");
        botonBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBajaActionPerformed(evt);
            }
        });

        // Configuración de diseño de los componentes
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(UssernameTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(PaswordTexto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonAlta))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(botonBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(UssernameTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(BotonAlta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PaswordTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonBaja)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }

    private void BotonAltaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        trabajadorController.altaTrabajador(new Trabajador(UssernameTexto.getText(), PaswordTexto.getText()));
        setListado(trabajadorController.cargarListado(getListado())); 
    }                                         

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
    	setListado(trabajadorController.cargarListado(getListado())); 
    }                                 

    private void botonBajaActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Trabajador selectedTrabajador = Listado.getSelectedValue();
        if (selectedTrabajador != null) {
            trabajadorController.bajaTrabajador(selectedTrabajador);
            setListado(trabajadorController.cargarListado(getListado())); 
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un trabajador para dar de baja.");
        }
    }                                         

    public JList<Trabajador> getListado() {
        return Listado;
    }

    public void setListado(JList<Trabajador> Listado) {
        this.Listado = Listado;
    }

    public JTextField getPaswordTexto() {
        return PaswordTexto;
    }

    public void setPaswordTexto(JTextField PaswordTexto) {
        this.PaswordTexto = PaswordTexto;
    }

    public JTextField getUssernameTexto() {
        return UssernameTexto;
    }

    public void setUssernameTexto(JTextField UssernameTexto) {
        this.UssernameTexto = UssernameTexto;
    }

    // Variables declaration - no modificar                     
    private javax.swing.JButton BotonAlta;
    private javax.swing.JList<Trabajador> Listado;
    private javax.swing.JTextField PaswordTexto;
    private javax.swing.JTextField UssernameTexto;
    private javax.swing.JButton botonBaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration                   
}
