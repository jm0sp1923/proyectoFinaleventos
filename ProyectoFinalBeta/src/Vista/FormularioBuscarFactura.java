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
public class FormularioBuscarFactura extends JDialog {

    public JLabel numfactura, vehiculoL, nombreClienteL, placaL, horaEntradaL, minEntradaL, horaSalida, minutoSalida, valorHora, horas, totalApagar;
    public JTextField numfacturaT, vehiculoT, nombreClienteT, placaT, horaEntradaT, minEntradaT, horaSalidaT, minutoSalidaT, valorHoraT, horasT, totalApagarT;
    public JButton cancelar, buscar;

    public FormularioBuscarFactura(Frame e, boolean modal) {
        //super(e, modal);
        Container c = getContentPane();
        c.setLayout(null);
        numfactura = new JLabel("Num° facura");
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

        numfacturaT = new JTextField(10);
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
        buscar = new JButton("Buscar");
        cancelar = new JButton("Cancelar");

        numfactura.setBounds(15, 5, 100, 50);
        numfacturaT.setBounds(130, 20, 70, 20);
        buscar.setBounds(210, 20, 90, 20);
        vehiculoL.setBounds(15, 35, 60, 50);
        vehiculoT.setBounds(130, 50, 170, 20);
        nombreClienteL.setBounds(15, 65, 100, 40);
        nombreClienteT.setBounds(130, 80, 170, 20);
        placaL.setBounds(15, 95, 50, 40);
        placaT.setBounds(130, 110, 170, 20);
        horaEntradaL.setBounds(15, 125, 100, 40);
        horaEntradaT.setBounds(130, 140, 170, 20);
        minEntradaL.setBounds(15, 155, 100, 40);
        minEntradaT.setBounds(130, 170, 170, 20);
        
        horaSalida.setBounds(15, 185, 100, 40);
        horaSalidaT.setBounds(130, 200, 170, 20);
        
        valorHora.setBounds(15, 215, 100, 40);
        valorHoraT.setBounds(130, 230, 170, 20);
        horas.setBounds(15, 245, 100, 40);
        horasT.setBounds(130, 260, 170, 20);
        totalApagar.setBounds(15, 275, 100, 40);
        totalApagarT.setBounds(130, 290, 170, 20);

        cancelar.setBounds(110, 330, 100, 20);

        c.add(numfactura);
        c.add(numfacturaT);
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
        c.add(buscar);
        c.add(cancelar);

    }

}
