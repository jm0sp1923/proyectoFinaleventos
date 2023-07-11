/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.UsuarioObj;
import Modelo.ConsultasUsuario;
import java.awt.event.ActionListener;
import Vista.FormularioModificarUsuario;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ControladorFormularioModificarUsuario implements ActionListener {

    FormularioModificarUsuario formularioModificarUsuario;
    ConsultasUsuario consultasUsuario;
    UsuarioObj usu;

    public ControladorFormularioModificarUsuario(FormularioModificarUsuario formularioModificarUsuario, UsuarioObj usu, ConsultasUsuario consultasUsuario) {
        this.formularioModificarUsuario = formularioModificarUsuario;
        this.usu = usu;
        this.consultasUsuario = consultasUsuario;
        this.formularioModificarUsuario.buscar.addActionListener(this);
        this.formularioModificarUsuario.actualizar.addActionListener(this);
        this.formularioModificarUsuario.cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioModificarUsuario.buscar) {
            codigoBuscar();
        }

        if (e.getSource() == formularioModificarUsuario.actualizar) {
            if (validarDatos()) {
                usu.setCodigo(Integer.parseInt(formularioModificarUsuario.codigoT.getText()));
                usu.setNivel(formularioModificarUsuario.nivelcombo.getSelectedItem().toString());
                usu.setNombre(formularioModificarUsuario.nombreT.getText());
                usu.setCorreo(formularioModificarUsuario.correoT.getText());
                usu.setContrasena(formularioModificarUsuario.contrasenaT.getText());
                if (consultasUsuario.modificarUsuario(usu)) {
                    JOptionPane.showMessageDialog(null, "Usuario modificado ", "Exito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarDatos();
                    formularioModificarUsuario.dispose();
                } else {
                    limpiarDatos();
                    JOptionPane.showMessageDialog(null, "Error al modificar usuario", "Error ", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == formularioModificarUsuario.cancelar) {
            limpiarDatos();
            formularioModificarUsuario.dispose();
        }
    }

    public boolean validarDatos() {
        if (formularioModificarUsuario.nivelcombo != null) {
            if (!formularioModificarUsuario.nombreT.getText().isEmpty() && formularioModificarUsuario.nombreT.getText().matches("^[^0-9]+$")){
                if (!formularioModificarUsuario.contrasenaT.getText().isEmpty()) {
                    if (!formularioModificarUsuario.correoT.getText().isEmpty()) {
                        if (validarEmail(formularioModificarUsuario.correoT.getText())) {
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

    boolean validarEmail(String email) {
        // Expresión regular para validar el formato del correo electrónico
        String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Verificar si el correo electrónico coincide con el patrón
        return email.matches(patron);
    }

    void codigoBuscar() {
        UsuarioObj usuario = new UsuarioObj();
        usuario.setCodigo(Integer.parseInt(formularioModificarUsuario.codigoT.getText()));
        if (esNumeroEntero(usuario.getCodigo() + "")) {
            usu = consultasUsuario.datosUsuarioBuscar(usuario);
            if (usu == null) {
                limpiarDatos();
                JOptionPane.showMessageDialog(null, "No se encontro un usuario con ese codigo", "Error ", JOptionPane.ERROR_MESSAGE);
            } else {
                llenarDatos(usu);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un codigo valido", "Error ", JOptionPane.ERROR_MESSAGE);

        }

    }

    public boolean esNumeroEntero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    void llenarDatos(UsuarioObj usuarioBuscar) {
        formularioModificarUsuario.nivelcombo.setSelectedItem(usuarioBuscar.getNivel());
        formularioModificarUsuario.nombreT.setText(usuarioBuscar.getNombre());
        formularioModificarUsuario.correoT.setText(usuarioBuscar.getCorreo());
        formularioModificarUsuario.contrasenaT.setText(usuarioBuscar.getContrasena());
    }

    void limpiarDatos() {
        formularioModificarUsuario.codigoT.setText("");
        formularioModificarUsuario.nivelcombo.setSelectedItem(null);
        formularioModificarUsuario.nombreT.setText("");
        formularioModificarUsuario.correoT.setText("");
        formularioModificarUsuario.contrasenaT.setText("");
    }

}
