/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.UsuarioObj;
import Modelo.ConsultasUsuario;
import java.awt.event.ActionListener;
import Vista.FormularioVisualizarEliminarUsuario;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorFormularioVisualizar implements ActionListener {

    FormularioVisualizarEliminarUsuario formularioVisualizarEliminarUsuario;
    ConsultasUsuario consultasUsuario;
    String tipoB;
    UsuarioObj usu;

    public ControladorFormularioVisualizar(FormularioVisualizarEliminarUsuario formularioVisualizarEliminarUsuario,
            UsuarioObj usu, ConsultasUsuario consultasUsuario
    ) {

        this.formularioVisualizarEliminarUsuario = formularioVisualizarEliminarUsuario;
        this.consultasUsuario = consultasUsuario;
        this.usu = usu;

        this.formularioVisualizarEliminarUsuario.buscar.addActionListener(this);
        this.formularioVisualizarEliminarUsuario.nivel.addActionListener(this);
        this.formularioVisualizarEliminarUsuario.cancelar.addActionListener(this);
        this.formularioVisualizarEliminarUsuario.eliminar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioVisualizarEliminarUsuario.buscar) {

            if (tipoB.equals("Codigo")) {
                LimpiarTabla();
                llenarTablaCodigo();
            } else {
                LimpiarTabla();
                llenarTablaNivel();
            }

        }
        if (e.getSource() == formularioVisualizarEliminarUsuario.nivel) {
            tipoB = formularioVisualizarEliminarUsuario.nivel.getSelectedItem().toString();
            if (tipoB.equals("Codigo")) {
                formularioVisualizarEliminarUsuario.codigoT.setEnabled(true);
            } else {
                formularioVisualizarEliminarUsuario.codigoT.setEnabled(false);
                formularioVisualizarEliminarUsuario.codigoT.setText("");
            }
        }

        if (e.getSource() == formularioVisualizarEliminarUsuario.eliminar) {
            eliminarUsuarios();
            LimpiarTabla();
        }

        if (e.getSource() == formularioVisualizarEliminarUsuario.cancelar) {
            LimpiarTabla();
            formularioVisualizarEliminarUsuario.dispose();

        }
    }

    //Cambiar metodos para solucionar eliminar
    public void llenarTablaCodigo() {
        String codigoText = formularioVisualizarEliminarUsuario.codigoT.getText();
        if (!codigoText.isEmpty()) {
            usu.setCodigo(Integer.parseInt(codigoText));
            UsuarioObj usuarios = consultasUsuario.datosUsuarioBuscar(usu);
            if (usuarios == null) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el usuario", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Object[] user = {usuarios.getCodigo(), usuarios.getNivel(), usuarios.getNombre(), usuarios.getCorreo(), usuarios.getContrasena(), false};
                formularioVisualizarEliminarUsuario.modelo.addRow(user);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el codigo del usuario a buscar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void llenarTablaNivel() {
        usu.setNivel(formularioVisualizarEliminarUsuario.nivel.getSelectedItem().toString());
        ArrayList<UsuarioObj> arregloUsuario = new ArrayList<>();
        ArrayList<UsuarioObj> usuarios = consultasUsuario.visualizarUsuariosPorNiveles(arregloUsuario, usu);
        for (int i = 0; i < usuarios.size(); i++) {
            UsuarioObj usuario = usuarios.get(i);
            Object[] user = {usuario.getCodigo(), usuario.getNivel(), usuario.getNombre(), usuario.getCorreo(), usuario.getContrasena(), false};
            formularioVisualizarEliminarUsuario.modelo.addRow(user);
        }

    }

    void LimpiarTabla() {
        int a = formularioVisualizarEliminarUsuario.modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            formularioVisualizarEliminarUsuario.modelo.removeRow(i);
        }
    }

    public void eliminarUsuarios() {
        for (int i = 0; i < formularioVisualizarEliminarUsuario.modelo.getRowCount(); i++) {
            boolean eliminar = (boolean) formularioVisualizarEliminarUsuario.modelo.getValueAt(i, 5);
            if (eliminar) {
                int codigo = (int) formularioVisualizarEliminarUsuario.modelo.getValueAt(i, 0);
                usu.setCodigo(codigo);
                consultasUsuario.eliminarUsuarioPorCodigo(usu);
            }
        }
    }

}
