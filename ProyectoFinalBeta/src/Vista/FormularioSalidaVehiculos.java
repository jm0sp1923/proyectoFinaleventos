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
public class FormularioSalidaVehiculos extends JDialog{

    public JLabel VPPLACAHEME;
    public JTextField placa;
    public JButton validar,cancelar;

    public FormularioSalidaVehiculos(Frame e, boolean modal){
        super(e,modal);
        Container c = getContentPane();
        c.setLayout(null);
        VPPLACAHEME = new JLabel("V-P-PLACA-HS-MS");
        placa = new JTextField(20);
        validar = new JButton("Validar");
        cancelar = new JButton("Cancelar");

        VPPLACAHEME.setBounds(20,25, 120, 20);
        placa.setBounds(135,25, 120, 20);
        validar.setBounds(30, 70, 100, 20);
        cancelar.setBounds(150, 70, 100, 20);
        
        c.add(VPPLACAHEME);
        c.add(placa);
        c.add(validar);
        c.add(cancelar);
        
   

    }

   
}

