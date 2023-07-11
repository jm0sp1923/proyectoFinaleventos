/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.*;
import javax.swing.*;




/**
 *
 * @author jm0sp
 */
public class FormularioCrearBD extends JDialog {

    public JButton crearBase,cancelar;
    JLabel nombreBD,usuarioBd,contrasenaBd;
    public JTextField nombreBDL,usuarioBdT,contrasenaBdT;
    
    public FormularioCrearBD(Frame e, boolean modal) {
        super(e, modal);
        Container c = getContentPane();
        c.setLayout(null);
        nombreBD = new JLabel("Base de Datos");
        nombreBDL = new JTextField(10);
        usuarioBd = new JLabel("Usuario");
        usuarioBdT = new JTextField(10);
        contrasenaBd = new JLabel("Contrasena");
        contrasenaBdT = new JTextField(10);
        
        crearBase = new JButton("Crear base datos");
        cancelar = new JButton("Cancelar");
        
        nombreBD.setBounds(20, 15, 160, 35);
        nombreBDL.setBounds(120, 20, 150, 20);
        usuarioBd.setBounds(20, 55, 160, 35);
        usuarioBdT.setBounds(120, 60, 150, 20);
        contrasenaBd.setBounds(20, 96, 160, 35);
        contrasenaBdT.setBounds(120, 100, 150, 20);
        crearBase.setBounds(15, 140, 140, 25);
        cancelar.setBounds(170, 140, 140, 25);
        
        
        
        usuarioBdT.setText("root");
        usuarioBdT.setEditable(false);
        contrasenaBdT.setText("");
        contrasenaBdT.setEditable(false);
        
        c.add(nombreBD);
        c.add(nombreBDL);

        c.add(usuarioBd);
        c.add(usuarioBdT);
        
        c.add(contrasenaBd);
        c.add(contrasenaBdT);

        c.add(crearBase);
        c.add(cancelar);
        
    }

}
