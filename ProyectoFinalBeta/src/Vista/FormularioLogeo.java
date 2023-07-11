/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Container;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jm0sp
 */
public class FormularioLogeo extends JDialog {

    public JLabel correoL, contrasenaL;
    public JTextField correoT, contrasenaT;
    public JButton aceptar,cancelar;

    public FormularioLogeo(Frame e, boolean modal) {

        Container c = getContentPane();
        c.setLayout(null);

        correoL = new JLabel("Correo");
        contrasenaL = new JLabel("Contrasena");
        correoT = new JTextField(10);
        contrasenaT = new JTextField(10);
        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");
        correoL.setBounds(15, 10, 80, 40);
        correoT.setBounds(90, 25, 120, 20);
        contrasenaL.setBounds(15, 40, 80, 40);
        contrasenaT.setBounds(90, 55, 120, 20);
        aceptar.setBounds(10, 90, 100, 20);
        cancelar.setBounds(120, 90, 100, 20);
        c.add(correoL);
        c.add(correoT);
        c.add(contrasenaL);
        c.add(contrasenaT);
        c.add(aceptar);
        c.add(cancelar);

    }

}


