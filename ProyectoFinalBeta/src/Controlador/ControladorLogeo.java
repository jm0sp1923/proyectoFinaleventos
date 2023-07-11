/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FormularioLogeo;
import Modelo.CrearArchivoLogeo;
import Modelo.UsuarioObj;
import Modelo.ConsultasUsuario;
import javax.swing.JOptionPane;

/**
 *
 * @author jm0sp
 */
public class ControladorLogeo implements ActionListener {

    FormularioLogeo formularioLogeo;
    UsuarioObj usu;
    ConsultasUsuario consultasUsuario;

    public ControladorLogeo(FormularioLogeo formularioLogeo, UsuarioObj usu, ConsultasUsuario consultasUsuario) {

        this.formularioLogeo = formularioLogeo;
        this.usu = usu;
        this.consultasUsuario = consultasUsuario;
        this.formularioLogeo.aceptar.addActionListener(this);
        this.formularioLogeo.cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioLogeo.aceptar) {
            logearse();
        }
    }

    public void logearse() {
         UsuarioObj usun =  new UsuarioObj();
        usun.setCorreo(formularioLogeo.correoT.getText());
        usun.setContrasena(formularioLogeo.contrasenaT.getText());
        usun = consultasUsuario.buscarUsuariocorreo(usun);
        if (usun == null) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            limpiar();
        } else {
            new CrearArchivoLogeo(usun);
            JOptionPane.showMessageDialog(null, "Logeado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
            formularioLogeo.dispose();
        }

    }
    
    public void limpiar(){
        formularioLogeo.contrasenaT.setText("");
        formularioLogeo.correoT.setText("");
    }

}
