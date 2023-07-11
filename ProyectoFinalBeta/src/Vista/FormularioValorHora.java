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
public class FormularioValorHora extends JDialog{
    public JLabel horaCarro, horaMoto,horaBicicleta;
    public JTextField horaCarroT, horaMotoT,horaBicicletaT;
    public JButton guardar,cancelar;

    public FormularioValorHora(Frame e, boolean modal) {
        
        
        Container c = getContentPane();
        c.setLayout(null);
        horaCarro = new JLabel("Hora carro");
        horaMoto = new JLabel("Hora moto");
        horaBicicleta = new JLabel("Hora bicicleta");
        horaCarroT = new JTextField(10);
        horaMotoT = new JTextField(10);
        horaBicicletaT = new JTextField(10);
        
        guardar = new JButton("guardar");
        cancelar = new JButton("Cancelar");

        horaCarro.setBounds(15, 10, 80, 40);
        horaCarroT.setBounds(100, 20, 120, 20);
        horaMoto.setBounds(15, 40, 80, 40);
        horaMotoT .setBounds(100, 50, 120, 20);
         horaBicicleta.setBounds(15, 70, 80, 40);
        horaBicicletaT.setBounds(100, 80, 120, 20);
        guardar.setBounds(25, 120, 90, 20);
        cancelar.setBounds(130, 120, 90, 20);

        c.add(horaCarro);
        c.add(horaCarroT);
        c.add(horaMoto);
        c.add(horaMotoT);
        c.add(horaBicicleta);
        c.add(horaBicicletaT);
        c.add(guardar);
        c.add(cancelar);

    }
   
}
