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
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jm0sp
 */
public class FormularioCrearUsuario  extends JDialog {

    public JLabel nombreL, correoL, contrasenaL, nivel;
    public JTextField nombreT, correoT, contrasenaT;
    public JButton crear, cancelar;
    public JComboBox<String> nivelcombo;

   public FormularioCrearUsuario(Frame e, boolean modal) {
        super(e, modal);
        Container c = getContentPane();
        c.setLayout(null);
        nombreL = new JLabel("Nombre");
        correoL = new JLabel("Correo");
        contrasenaL = new JLabel("Contrasena");
        nivel = new JLabel("Nivel");

        nombreT = new JTextField(10);
        correoT = new JTextField(10);
        contrasenaT = new JTextField(10);

        String niveles[] = {"Nivel 1", "Nivel 2", "Nivel 3"};
        nivelcombo = new JComboBox<String>(niveles);

        crear = new JButton("Crear");
        cancelar = new JButton("Cancelar");

        nombreL.setBounds(15, 15, 70, 40);
        nombreT.setBounds(110, 25, 120, 22);
        correoL.setBounds(15, 55, 40, 40);
        correoT.setBounds(110, 65, 120, 22);
        contrasenaL.setBounds(15, 95, 80, 40);
        contrasenaT.setBounds(110, 105, 120, 22);
        nivel.setBounds(15, 135, 50, 40);
        nivelcombo.setBounds(110, 145, 70, 20);
        crear.setBounds(50, 185, 80, 30);
        cancelar.setBounds(150, 185, 90, 30);

        c.add(nombreL);
        c.add(nombreT);
        c.add(correoL);
        c.add(correoT);
        c.add(contrasenaL);
        c.add(contrasenaT);
        c.add(nivel);
        c.add(nivelcombo);
        c.add(crear);
        c.add(cancelar);

    }


}
