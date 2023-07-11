/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author jm0sp
 */
public class EliminarBaseDeDatos extends JDialog {

    public JButton eliminar, cancelar;

    public EliminarBaseDeDatos(Frame e, boolean modal){
        super(e, modal);
        Container c = getContentPane();
        c.setLayout(null);

        eliminar = new JButton("Eliminar base de datos");
        cancelar = new JButton("Cancelar");

        eliminar.setBounds(15, 20, 180, 25);
        cancelar.setBounds(210, 20, 140, 25);

        c.add(eliminar);
        c.add(cancelar);     
       
    }

}

