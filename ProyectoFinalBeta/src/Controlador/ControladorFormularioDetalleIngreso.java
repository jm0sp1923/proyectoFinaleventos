/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionListener;

import Modelo.ConsultasIngresoVehiculoBd;
import Modelo.ObjIngresoVehiculos;
import Vista.FormularioDetalleIngresoVehiculos;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ControladorFormularioDetalleIngreso implements ActionListener {

    ConsultasIngresoVehiculoBd consultasIngresoVehiculoBd;
    ObjIngresoVehiculos ObjIngresoVehiculos;
    FormularioDetalleIngresoVehiculos detalleIngresoVehiculos;

    public ControladorFormularioDetalleIngreso(ConsultasIngresoVehiculoBd consultasIngresoVehiculoBd, ObjIngresoVehiculos ObjIngresoVehiculos, FormularioDetalleIngresoVehiculos detalleIngresoVehiculos) {
        this.consultasIngresoVehiculoBd = consultasIngresoVehiculoBd;
        this.ObjIngresoVehiculos = ObjIngresoVehiculos;
        this.detalleIngresoVehiculos = detalleIngresoVehiculos;

        this.detalleIngresoVehiculos.guardar.addActionListener(this);
        this.detalleIngresoVehiculos.cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == detalleIngresoVehiculos.guardar) {
            ObjIngresoVehiculos.setPlaca(detalleIngresoVehiculos.placaT.getText());
            ObjIngresoVehiculos.setPuesto(Integer.parseInt(detalleIngresoVehiculos.puestoT.getText()));
            ObjIngresoVehiculos.setCodigoCliente(Integer.parseInt(detalleIngresoVehiculos.codigoClienteT.getText()));
            ObjIngresoVehiculos.setTipoVehiculos(detalleIngresoVehiculos.vehiculoT.getText());
            ObjIngresoVehiculos.setHoraEntrada(Integer.parseInt(detalleIngresoVehiculos.horaEntradaT.getText()));
            ObjIngresoVehiculos.setMinEntrada(Integer.parseInt(detalleIngresoVehiculos.minEntradaT.getText()));

            if (consultasIngresoVehiculoBd.ingresarVehiculo(ObjIngresoVehiculos)) {
                JOptionPane.showMessageDialog(null, "Vehiculo ingresado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                detalleIngresoVehiculos.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al ingresar", "Error ", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource() == detalleIngresoVehiculos.cancelar){
            detalleIngresoVehiculos.dispose();
        }
    }

    public void llenarDatos(ObjIngresoVehiculos objIngresoVehiculos) {
        detalleIngresoVehiculos.vehiculoT.setText(objIngresoVehiculos.getTipoVehiculos());
        detalleIngresoVehiculos.placaT.setText(objIngresoVehiculos.getPlaca());
        detalleIngresoVehiculos.puestoT.setText(objIngresoVehiculos.getPuesto()+"");
        detalleIngresoVehiculos.horaEntradaT.setText(objIngresoVehiculos.getHoraEntrada() + "");
        detalleIngresoVehiculos.minEntradaT.setText(objIngresoVehiculos.getMinEntrada() + "");
    }

}
