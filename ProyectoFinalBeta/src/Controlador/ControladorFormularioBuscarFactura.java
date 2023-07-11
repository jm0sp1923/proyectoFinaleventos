/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FormularioBuscarFactura;
import Modelo.ConsultasFactura;
import Modelo.ObjFactura;
import javax.swing.JOptionPane;

public class ControladorFormularioBuscarFactura implements ActionListener {

    FormularioBuscarFactura buscarFactura;
    ObjFactura factura;
    ConsultasFactura consultasFactura;

    public ControladorFormularioBuscarFactura(FormularioBuscarFactura buscarFactura, ObjFactura factura, ConsultasFactura consultasFactura) {
        this.buscarFactura = buscarFactura;
        this.factura = factura;
        this.consultasFactura = consultasFactura;
        this.buscarFactura.buscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buscarFactura.buscar) {
            buscarFactura();
        }
        if (e.getSource() == buscarFactura.cancelar) {
            limpiarDatos();
            buscarFactura.dispose();
        }
    }

    public void buscarFactura() {
        ObjFactura facturN = new ObjFactura();
        facturN.setNumFactura(Integer.parseInt(buscarFactura.numfacturaT.getText()));
        facturN = consultasFactura.buscarFactura(facturN);
        if (facturN == null) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado la factura", "Error", JOptionPane.ERROR_MESSAGE);
            limpiarDatos();
        } else {
            llenarDatos(facturN);
        }
    }

    void llenarDatos(ObjFactura factura) {
        buscarFactura.vehiculoT.setText(factura.getTipoVehiculo());
        buscarFactura.nombreClienteT.setText(factura.getNombreCliente());
        buscarFactura.placaT.setText(factura.getPlaca());
        buscarFactura.horaEntradaT.setText(factura.getHoraEntrada() + "");
        //buscarFactura.minEntradaT.setText(factura.getMinEntrada()+"");
        buscarFactura.horaSalidaT.setText(factura.getHoraSalida() + "");
        //buscarFactura.minutoSalidaT.setText(factura.getMinSalida()+"");
        buscarFactura.valorHoraT.setText(factura.getValorHora() + "");
        buscarFactura.horasT.setText(factura.getHoras() + "");
        buscarFactura.totalApagarT.setText(factura.getTotalPagar() + "");

    }

    void limpiarDatos() {
        buscarFactura.numfacturaT.setText("");
        buscarFactura.vehiculoT.setText("");
        buscarFactura.nombreClienteT.setText("");
        buscarFactura.placaT.setText("");
        buscarFactura.horaEntradaT.setText("");
        buscarFactura.minEntradaT.setText("");
        buscarFactura.horaSalidaT.setText("");
        buscarFactura.minutoSalidaT.setText("");
        buscarFactura.valorHoraT.setText("");
        buscarFactura.horasT.setText("");
        buscarFactura.totalApagarT.setText("");
    }
}
