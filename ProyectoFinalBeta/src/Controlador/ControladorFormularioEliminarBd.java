/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.BDobj;
import Modelo.EliminarBd;
import java.awt.event.ActionListener;
import Vista.EliminarBaseDeDatos;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ControladorFormularioEliminarBd implements ActionListener {

    EliminarBaseDeDatos eliminarBaseDeDatos;
    BDobj Bd;

    public ControladorFormularioEliminarBd(EliminarBaseDeDatos eliminarBaseDeDatos, BDobj Bd) {
        this.eliminarBaseDeDatos = eliminarBaseDeDatos;
        this.Bd = Bd;
        this.eliminarBaseDeDatos.eliminar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == eliminarBaseDeDatos.eliminar) {
            if (eliminarBD()) {
                JOptionPane.showMessageDialog(null, "La base de datos ha sido eliminada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                eliminarBaseDeDatos.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "La base de datos no existe", "Eliminado", JOptionPane.ERROR_MESSAGE);
                eliminarBaseDeDatos.dispose();
            }

        }
        if (e.getSource() == eliminarBaseDeDatos.cancelar) {
            eliminarBaseDeDatos.dispose();
        }
    }

    public boolean eliminarBD() {
        EliminarBd ebd = new EliminarBd();
        boolean borrar = ebd.Eliminarbd();
        return borrar;
    }
}
