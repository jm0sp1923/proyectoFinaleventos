/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FormularioBuscarRegistros;
import Modelo.ConsultasFactura;
import Modelo.ConsultasUsuario;
import Modelo.UsuarioObj;
import Modelo.ObjFactura;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorFormularioBuscarRegistro implements ActionListener {

    FormularioBuscarRegistros buscarRegistro;
    ConsultasFactura consultasFactura;
    ConsultasUsuario consultasUsuario;
    UsuarioObj usu;
    ObjFactura objFactura;
    String tipoB = "";

    public ControladorFormularioBuscarRegistro(FormularioBuscarRegistros buscarRegistros, ConsultasFactura consultasFactura,
            ObjFactura objFactura, ConsultasUsuario consultasUsuario, UsuarioObj usu) {
        this.buscarRegistro = buscarRegistros;
        this.consultasFactura = consultasFactura;
        this.objFactura = objFactura;
        this.consultasUsuario = consultasUsuario;
        this.usu = usu;
        this.buscarRegistro.buscar.addActionListener(this);
        this.buscarRegistro.usuariosC.addActionListener(this);
        this.buscarRegistro.cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buscarRegistro.usuariosC) {
            tipoB = buscarRegistro.usuariosC.getSelectedItem().toString();
            if (!tipoB.equals("Todos")) {
                buscarRegistro.codigoT.setEnabled(true);
                buscarRegistro.codigoT.setText("");
            } else {
                buscarRegistro.codigoT.setEnabled(false);
                buscarRegistro.codigoT.setText("");
            }
        }
        if (e.getSource() == buscarRegistro.buscar) {
            if (tipoB.equals("Todos")) {
                LimpiarTabla();
                llenarTablaTodos();
            }
            if (tipoB.equals("Empleado")) {
                LimpiarTabla();
                llenarTablaEmpleado();
            }
            if (tipoB.equals("Placa")) {
                LimpiarTabla();
                llenarTablaPlaca();
            }
            if (tipoB.equals("Factura")) {
                LimpiarTabla();
                llenarTablaFactura();
            }

        }
        if (e.getSource() == buscarRegistro.cancelar) {
            buscarRegistro.dispose();
        }
    }

    public void llenarTablaPlaca() {
        if (buscarRegistro.codigoT.getText().isEmpty()) {
            objFactura.setPlaca(buscarRegistro.codigoT.getText());
            ArrayList<ObjFactura> arregloFacturas = new ArrayList<>();
            ArrayList<ObjFactura> facturas = consultasFactura.buscarFacutrasPlaca(arregloFacturas, objFactura);
            if (facturas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No existen facturas con esa placa", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < facturas.size(); i++) {
                    ObjFactura factura = facturas.get(i);
                    String nombreEm = nombreEmpleado(factura);
                    Object[] user = {factura.getNumFactura(), factura.getTipoVehiculo(), factura.getPlaca(), factura.getNombreCliente(), factura.getHoraEntrada(), factura.getHoraSalida(), factura.getHoras(), factura.getValorHora(), factura.getTotalPagar(), nombreEm};
                    buscarRegistro.modelo.addRow(user);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el numero de placa", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void llenarTablaFactura() {

        objFactura = new ObjFactura();
        if (!buscarRegistro.codigoT.getText().isEmpty()) {

            objFactura.setNumFactura(Integer.parseInt(buscarRegistro.codigoT.getText()));
            objFactura = consultasFactura.buscarFactura(objFactura);
            if (objFactura == null) {
                JOptionPane.showMessageDialog(null, "No existe ese numero de factura", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String nombreEm = nombreEmpleado(objFactura);
                Object[] user = {objFactura.getNumFactura(), objFactura.getTipoVehiculo(), objFactura.getPlaca(), objFactura.getNombreCliente(), objFactura.getHoraEntrada(), objFactura.getHoraSalida(), objFactura.getHoras(), objFactura.getValorHora(), objFactura.getTotalPagar(), nombreEm};
                buscarRegistro.modelo.addRow(user);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el numero de la factura", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void llenarTablaTodos() {
        ArrayList<ObjFactura> arregloFacturas = new ArrayList<>();
        ArrayList<ObjFactura> facturas = consultasFactura.buscarTodasLasFacturas(arregloFacturas);
        for (int i = 0; i < facturas.size(); i++) {
            ObjFactura factura = facturas.get(i);
            String nombreEm = nombreEmpleado(factura);
            Object[] user = {factura.getNumFactura(), factura.getTipoVehiculo(), factura.getPlaca(), factura.getNombreCliente(), factura.getHoraEntrada(), factura.getHoraSalida(), factura.getHoras(), factura.getValorHora(), factura.getTotalPagar(), nombreEm};
            buscarRegistro.modelo.addRow(user);
        }
    }

    public void llenarTablaEmpleado() {
        if (!buscarRegistro.codigoT.getText().isEmpty()) {
            objFactura.setCodigoEmpleado(Integer.parseInt(buscarRegistro.codigoT.getText()));
            ArrayList<ObjFactura> arregloFacturas = new ArrayList<>();
            ArrayList<ObjFactura> facturas = consultasFactura.buscarFacutrasEmpleados(arregloFacturas, objFactura);
            if (facturas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No existen facturas con ese codigo empleado", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                for (int i = 0; i < facturas.size(); i++) {
                    ObjFactura factura = facturas.get(i);
                    String nombreEm = nombreEmpleado(factura);
                    Object[] user = {factura.getNumFactura(), factura.getTipoVehiculo(), factura.getPlaca(), factura.getNombreCliente(), factura.getHoraEntrada(), factura.getHoraSalida(), factura.getHoras(), factura.getValorHora(), factura.getTotalPagar(), nombreEm};
                    buscarRegistro.modelo.addRow(user);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el codigo del empleado", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public String nombreEmpleado(ObjFactura objFactura) {
        String nombreEm;
        usu.setCodigo(objFactura.getCodigoEmpleado());
        usu = consultasUsuario.datosUsuarioBuscar(usu);
        nombreEm = usu.getNombre();
        return nombreEm;
    }

    void LimpiarTabla() {
        int a = buscarRegistro.modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            buscarRegistro.modelo.removeRow(i);
        }
    }
}
