/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


/**
 *
 * @author jm0sp
 */
public class FormularioIngresoVehiculos extends JDialog {

    public JLabel vehiculo, VPPLACAHEME;
    public JButton mostrar, mostrarTodos, validar, cancelar;
    public JComboBox<String> tipoVehiculos;
    public JTextArea area;
    public JScrollPane texto;
    public JTextField placa;

    public FormularioIngresoVehiculos(Frame e, boolean modal) {
        super(e, modal);
        Container c = getContentPane();
        c.setLayout(null);

        vehiculo = new JLabel("Vehiculo");
        VPPLACAHEME = new JLabel("V-P-PLACA-HE-ME");

        mostrar = new JButton("Mostrar");
        mostrarTodos = new JButton("Mostrar todos");
        validar = new JButton("Validar");
        cancelar = new JButton("Cancelar");

        String vehiculosTipo[] = {"Carro", "Moto", "Bicicleta"};
        tipoVehiculos = new JComboBox<>(vehiculosTipo);
        
        area = new JTextArea(10, 10);
        texto = new JScrollPane(area, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        placa = new JTextField(15);

        vehiculo.setBounds(10, 13, 50, 40);
        tipoVehiculos.setBounds(70, 20, 100, 25);
        mostrar.setBounds(180, 20, 80, 25);
        mostrarTodos.setBounds(270, 20, 120, 25);

        texto.setBounds(30, 61, 350, 185);
        area.setEditable(false);

        VPPLACAHEME.setBounds(15, 247, 120, 40);
        placa.setBounds(130, 255, 170, 25);

        validar.setBounds(310, 255, 80, 25);

        cancelar.setBounds(160, 305, 90, 30);

        c.add(vehiculo);
        c.add(VPPLACAHEME);
        c.add(placa);
        c.add(mostrar);
        c.add(mostrarTodos);
        c.add(validar);
        c.add(cancelar);
        c.add(tipoVehiculos);
        c.add(texto);                                                                                                                                   
    } 

}

