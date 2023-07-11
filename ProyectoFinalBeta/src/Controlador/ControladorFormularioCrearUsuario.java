/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConsultasUsuario;
import Modelo.UsuarioObj;
import java.awt.event.ActionListener;
import Vista.FormularioCrearUsuario;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ControladorFormularioCrearUsuario implements ActionListener {

    UsuarioObj usu;
    FormularioCrearUsuario formularioCrearUsuario;
    ConsultasUsuario consultasUsuario;

    public ControladorFormularioCrearUsuario(UsuarioObj usu, FormularioCrearUsuario formularioCrearUsuario, ConsultasUsuario consultasUsuario) {
        this.usu = usu;
        this.formularioCrearUsuario = formularioCrearUsuario;
        this.consultasUsuario = consultasUsuario;
        this.formularioCrearUsuario.crear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formularioCrearUsuario.crear) {
            if (validarDatos()) {
                crearUsuario();
            }

        }

    }

    public boolean validarDatos() {
        if (formularioCrearUsuario.nivelcombo != null) {
            if (!formularioCrearUsuario.nombreT.getText().isEmpty() && formularioCrearUsuario.nombreT.getText().matches("^[^0-9]+$")){
                if (!formularioCrearUsuario.contrasenaT.getText().isEmpty()) {
                    if (!formularioCrearUsuario.correoT.getText().isEmpty()) {
                        if (validarEmail(formularioCrearUsuario.correoT.getText())) {
                            return true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Formato de correo electrónico incorrecto. Asegúrese de usar el formato ejemplo@dominio.com", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese el correo del usuario", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese la contraseña del usuario", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el nombre del usuario", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el nivel del usuario", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void crearUsuario() {

        usu.setNivel(formularioCrearUsuario.nivelcombo.getSelectedItem().toString());
        usu.setNombre(formularioCrearUsuario.nombreT.getText());
        usu.setCorreo(formularioCrearUsuario.correoT.getText());
        usu.setContrasena(formularioCrearUsuario.contrasenaT.getText());

        if (consultasUsuario.crearUsuario(usu)) {
            JOptionPane.showMessageDialog(null, "Usuario creado con codigo " + consultasUsuario.codigoUsuario(), "Exito", JOptionPane.INFORMATION_MESSAGE);
            formularioCrearUsuario.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error al crear usuario", "Error ", JOptionPane.ERROR_MESSAGE);
            formularioCrearUsuario.dispose();
        }

    }

    boolean validarEmail(String email) {
        // Expresión regular para validar el formato del correo electrónico
        String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Verificar si el correo electrónico coincide con el patrón
        return email.matches(patron);
    }
}
