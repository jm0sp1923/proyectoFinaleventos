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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jm0sp
 */
public class FormularioModificarUsuario extends JDialog {

    public JLabel codigoL, nombreL, correoL, contrasenaL, nivel;
    public JTextField codigoT, nombreT, correoT, contrasenaT;
    public JButton buscar, actualizar, cancelar;
    public JComboBox<String> nivelcombo;

    public FormularioModificarUsuario(Frame e, boolean modal) {
        super(e, modal);
        Container c = getContentPane();
        c.setLayout(null);

        codigoL = new JLabel("Codigo");
        nombreL = new JLabel("Nombre");
        correoL = new JLabel("Correo");
        contrasenaL = new JLabel("Contrasena");
        nivel = new JLabel("Nivel");

        codigoT = new JTextField('5');
        nombreT = new JTextField(10);
        correoT = new JTextField(10);
        contrasenaT = new JTextField(10);

        String niveles[] = {"Nivel 1", "Nivel 2", "Nivel 3"};
        nivelcombo = new JComboBox<String>(niveles);

        actualizar = new JButton("Actualizar");
        cancelar = new JButton("Cancelar");
        buscar = new JButton("Buscar");

        codigoL.setBounds(15, 15, 40, 40);
        codigoT.setBounds(110, 25, 65, 22);
        buscar.setBounds(185, 25, 75, 20);
        nombreL.setBounds(15, 55, 70, 40);
        nombreT.setBounds(110, 65, 150, 22);
        correoL.setBounds(15, 95, 40, 40);
        correoT.setBounds(110, 105, 150, 22);
        contrasenaL.setBounds(15, 135, 80, 40);
        contrasenaT.setBounds(110, 145, 150, 22);
        nivel.setBounds(15, 175, 50, 40);
        nivelcombo.setBounds(110, 185, 70, 20);
        actualizar.setBounds(20, 225, 100, 30);
        cancelar.setBounds(150, 225, 100, 30);

        c.add(codigoL);
        c.add(codigoT);
        c.add(buscar);
        c.add(nombreL);
        c.add(nombreT);
        c.add(correoL);
        c.add(correoT);
        c.add(contrasenaL);
        c.add(contrasenaT);
        c.add(nivel);
        c.add(nivelcombo);
        c.add(actualizar);
        c.add(cancelar);


    }
}
