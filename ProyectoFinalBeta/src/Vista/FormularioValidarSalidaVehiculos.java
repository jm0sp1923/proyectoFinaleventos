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
public class FormularioValidarSalidaVehiculos extends JDialog {

    public JLabel vehiculoL, nombreClienteL, placaL, horaEntradaL, minEntradaL, horaSalida, minutoSalida, valorHora, horas, totalApagar;
    public JTextField vehiculoT, nombreClienteT, placaT, horaEntradaT, minEntradaT, horaSalidaT, minutoSalidaT, valorHoraT, horasT, totalApagarT;
    public JButton guardar, cancelar;

    public FormularioValidarSalidaVehiculos(Frame e, boolean modal) {
        super(e, modal);
        Container c = getContentPane();
        c.setLayout(null);

        vehiculoL = new JLabel("Vehiculo");
        nombreClienteL = new JLabel("Nombre cliente");
        placaL = new JLabel("Placa");
        horaEntradaL = new JLabel("Hora entrada");
        minEntradaL = new JLabel("Min entrada");
        horaSalida = new JLabel("Hora salida");
        minutoSalida = new JLabel("Minuto salida");
        valorHora = new JLabel("valor hora");
        horas = new JLabel("Horas");
        totalApagar = new JLabel("Total a pagar");

        vehiculoT = new JTextField(10);
        nombreClienteT = new JTextField(10);
        placaT = new JTextField(10);
        horaEntradaT = new JTextField(10);
        minEntradaT = new JTextField(10);
        horaSalidaT = new JTextField(10);
        minutoSalidaT = new JTextField(10);
        valorHoraT = new JTextField(10);
        horasT = new JTextField(10);
        totalApagarT = new JTextField(10);

        guardar = new JButton("Guardar");
        cancelar = new JButton("Cancelar");

        vehiculoL.setBounds(15, 5, 60, 50);
        vehiculoT.setBounds(130, 20, 120, 20);
        nombreClienteL.setBounds(15, 35, 100, 40);
        nombreClienteT.setBounds(130, 50, 120, 20);
        placaL.setBounds(15, 65, 50, 40);
        placaT.setBounds(130, 80, 120, 20);
        horaEntradaL.setBounds(15, 95, 100, 40);
        horaEntradaT.setBounds(130, 110, 120, 20);
        minEntradaL.setBounds(15, 125, 100, 40);
        minEntradaT.setBounds(130, 140, 120, 20);
        horaSalida.setBounds(15, 155, 100, 40);
        horaSalidaT.setBounds(130, 170, 120, 20);
        
        minutoSalida.setBounds(15, 185, 100, 40);
        minutoSalidaT.setBounds(130, 200, 120, 20);
        
        valorHora.setBounds(15, 215, 100, 40);
        valorHoraT.setBounds(130, 230, 120, 20);
        
        horas.setBounds(15, 245, 100, 40);
        horasT.setBounds(130, 260, 120, 20);
        totalApagar.setBounds(15, 275, 100, 40);
        totalApagarT.setBounds(130, 290, 120, 20);
        
        guardar.setBounds(25,330,100,20);
        cancelar.setBounds(145,330,100,20);

        vehiculoT.setEditable(false);
        nombreClienteT.setEditable(false);
        placaT.setEditable(false);
        horaEntradaT.setEditable(false);
        minEntradaT.setEditable(false);
        horaSalidaT.setEditable(false);
        minutoSalidaT.setEditable(false);
        valorHoraT.setEditable(false);
        horasT.setEditable(false);
        totalApagarT.setEditable(false);
        
        c.add(vehiculoL);
        c.add(vehiculoT);
        c.add(nombreClienteL);
        c.add(nombreClienteT);
        c.add(placaL);
        c.add(placaT);
        c.add(horaEntradaL);
        c.add(horaEntradaT);
        c.add(minEntradaL);
        c.add(minEntradaT);
        c.add(horaSalida);
        c.add(horaSalidaT);
        c.add(minutoSalida);
        c.add(minutoSalidaT);
        c.add(valorHora);
        c.add(valorHoraT);
        c.add(horas);
        c.add(horasT);
        c.add(totalApagar);
        c.add(totalApagarT);
        c.add(guardar);
        c.add(cancelar);
        
    }
       
}

