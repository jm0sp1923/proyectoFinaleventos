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
public class FormularioDetalleIngresoVehiculos extends JDialog {

    public JLabel vehiculoL, placaL, horaEntradaL, minEntradaL, codigoClienteL,puestoL;
    public JTextField vehiculoT, placaT, horaEntradaT, minEntradaT, codigoClienteT,puestoT;
    public JButton guardar, cancelar;

    public FormularioDetalleIngresoVehiculos(Frame e, boolean modal) {
        super(e, modal);
        Container c = getContentPane();
        c.setLayout(null);
        vehiculoL = new JLabel("Vehiculo");
        placaL = new JLabel("Placa");
        puestoL = new JLabel("Puesto");
        horaEntradaL = new JLabel("Hora entrada");
        minEntradaL = new JLabel("Min entrada");
        codigoClienteL = new JLabel("Codigo cliente");

        vehiculoT = new JTextField(10);
        vehiculoT.setEditable(false);
        placaT = new JTextField(10);
        placaT.setEditable(false);
        puestoT = new JTextField(10);
        puestoT.setEditable(false);
        horaEntradaT = new JTextField(10);
        horaEntradaT.setEditable(false);
        minEntradaT = new JTextField(10);
        minEntradaT.setEditable(false);
        codigoClienteT = new JTextField(10);

        guardar = new JButton("Guardar");
        cancelar = new JButton("Cancelar");

        vehiculoL.setBounds(15, 10, 50, 40);
        vehiculoT.setBounds(120, 20, 150, 20);
        placaL.setBounds(15, 50, 40, 40);
        placaT.setBounds(120, 60, 150, 20);
        puestoL.setBounds(15, 90, 80, 40);
        puestoT.setBounds(120, 100, 150, 20);
        horaEntradaL.setBounds(15, 130, 80, 40);
        horaEntradaT.setBounds(120, 140, 150, 20);
        minEntradaL.setBounds(15, 170, 90, 40);
        minEntradaT.setBounds(120, 180, 150, 20);
        codigoClienteL.setBounds(15, 220, 90, 20);
        codigoClienteT.setBounds(120, 220, 150, 20);
        guardar.setBounds(30, 260, 100, 20);
        cancelar.setBounds(150, 260, 100, 20);

        c.add(vehiculoL);
        c.add(vehiculoT);
        c.add(placaL);
        c.add(placaT);
        c.add(puestoL);
        c.add(puestoT);        
        c.add(horaEntradaL);
        c.add(horaEntradaT);
        c.add(minEntradaL);
        c.add(minEntradaT);
        c.add(codigoClienteL);
        c.add(codigoClienteT);
        c.add(guardar);
        c.add(cancelar);

    }

}
