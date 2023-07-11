package Controlador;

import Modelo.ConsultasFactura;
import Modelo.ConsultasUsuario;
import Modelo.ObjFactura;
import Modelo.UsuarioObj;
import Vista.FormularioEditarRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class ControladorFormularioEditarRegistro implements ActionListener {

    FormularioEditarRegistro editarRegistro;
    ConsultasFactura consultasFactura;
    ConsultasUsuario consultasUsuario;
    UsuarioObj usu;
    ObjFactura objFactura;
    String tipoB = "";

    public ControladorFormularioEditarRegistro(FormularioEditarRegistro editarRegistro, ConsultasFactura consultasFactura,
            ObjFactura objFactura, ConsultasUsuario consultasUsuario, UsuarioObj usu) {
        this.editarRegistro = editarRegistro;
        this.consultasFactura = consultasFactura;
        this.objFactura = objFactura;
        this.consultasUsuario = consultasUsuario;
        this.usu = usu;
        this.editarRegistro.buscar.addActionListener(this);
        this.editarRegistro.usuariosC.addActionListener(this);
        this.editarRegistro.modificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == editarRegistro.usuariosC) {
            tipoB = editarRegistro.usuariosC.getSelectedItem().toString();
            if (!tipoB.equals("Todos")) {
                editarRegistro.codigoT.setEnabled(true);
                editarRegistro.codigoT.setText("");
            } else {
                editarRegistro.codigoT.setEnabled(false);
                editarRegistro.codigoT.setText("");
            }
        }
        if (e.getSource() == editarRegistro.buscar) {
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
        if(e.getSource() == editarRegistro.modificar){
            editarRegistros();
        }
        
        if(e.getSource() == editarRegistro.cancelar){
            editarRegistro.dispose();
        }
    }

    public void llenarTablaPlaca() {
        objFactura.setPlaca(editarRegistro.codigoT.getText());
        ArrayList<ObjFactura> arregloFacturas = new ArrayList<>();
        ArrayList<ObjFactura> facturas = consultasFactura.buscarFacutrasPlaca(arregloFacturas, objFactura);
        if (facturas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen facturas con esa placa", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < facturas.size(); i++) {
                ObjFactura factura = facturas.get(i);
                String nombreEm = nombreEmpleado(factura);
                Object[] user = {factura.getNumFactura(), factura.getTipoVehiculo(), factura.getPlaca(), factura.getNombreCliente(), "12:00", "12:30", factura.getHoras(), factura.getValorHora(), factura.getTotalPagar(), nombreEm, false};
                editarRegistro.modelo.addRow(user);
            }
        }
    }

    public void llenarTablaFactura() {
        objFactura = new ObjFactura();

        objFactura.setNumFactura(Integer.parseInt(editarRegistro.codigoT.getText()));
        objFactura = consultasFactura.buscarFactura(objFactura);
        if (objFactura == null) {
            JOptionPane.showMessageDialog(null, "No existe ese numero de factura", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombreEm = nombreEmpleado(objFactura);
            Object[] user = {objFactura.getNumFactura(), objFactura.getTipoVehiculo(), objFactura.getPlaca(), objFactura.getNombreCliente(), "12:00", "12:30", objFactura.getHoras(), objFactura.getValorHora(), objFactura.getTotalPagar(), nombreEm, false};
            editarRegistro.modelo.addRow(user);
        }
    }

    public void llenarTablaTodos() {
        ArrayList<ObjFactura> arregloFacturas = new ArrayList<>();
        ArrayList<ObjFactura> facturas = consultasFactura.buscarTodasLasFacturas(arregloFacturas);
        for (int i = 0; i < facturas.size(); i++) {
            ObjFactura factura = facturas.get(i);
            Object[] user = {factura.getNumFactura(), factura.getTipoVehiculo(), factura.getPlaca(), factura.getNombreCliente(), "12:00", "12:30", factura.getHoras(), factura.getValorHora(), factura.getTotalPagar(), factura.getCodigoEmpleado(), false};
            editarRegistro.modelo.addRow(user);
        }
    }

    public void llenarTablaEmpleado() {
        objFactura.setCodigoEmpleado(Integer.parseInt(editarRegistro.codigoT.getText()));
        ArrayList<ObjFactura> arregloFacturas = new ArrayList<>();
        ArrayList<ObjFactura> facturas = consultasFactura.buscarFacutrasEmpleados(arregloFacturas, objFactura);
        if (facturas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No existen facturas con ese codigo empleado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            for (int i = 0; i < facturas.size(); i++) {
                ObjFactura factura = facturas.get(i);
                String nombreEm = nombreEmpleado(factura);
                Object[] user = {factura.getNumFactura(), factura.getTipoVehiculo(), factura.getPlaca(), factura.getNombreCliente(), "12:00", "12:30", factura.getHoras(), factura.getValorHora(), factura.getTotalPagar(), nombreEm, false};
                editarRegistro.modelo.addRow(user);
            }
        }
    }

    public void editarRegistros() {
        for (int i = 0; i < editarRegistro.modelo.getRowCount(); i++) {
            boolean modificar = (boolean) editarRegistro.modelo.getValueAt(i, 10);
            System.out.println(modificar);
            if (modificar) {
                
                String tipoVehiculo =  editarRegistro.modelo.getValueAt(i, 1).toString();
                String placa =  editarRegistro.modelo.getValueAt(i, 2).toString();
                String nomCliente =  editarRegistro.modelo.getValueAt(i, 3).toString();
                String hEntrada =  editarRegistro.modelo.getValueAt(i, 4).toString();
                String  hSalida =  editarRegistro.modelo.getValueAt(i, 5).toString();
                double  horas = (double) editarRegistro.modelo.getValueAt(i, 6);
                int  valorHora = (int) editarRegistro.modelo.getValueAt(i, 7);
                double totalPagar = (double) editarRegistro.modelo.getValueAt(i, 8);
                String nombreEmple = (String) editarRegistro.modelo.getValueAt(i, 9).toString();
                
                int numFactura = (int) editarRegistro.modelo.getValueAt(i, 0);
                
                objFactura.setNumFactura(numFactura);
                objFactura.setTipoVehiculo(tipoVehiculo);
                objFactura.setPlaca(placa);
                objFactura.setNombreCliente(nomCliente);
                objFactura.setHoraEntrada("12:30");
                objFactura.setHoraSalida("12:30");
                objFactura.setHoras(horas);
                objFactura.setValorHora(valorHora);
                objFactura.setTotalPagar(totalPagar);
                objFactura.setNombreEmpleado(nombreEmple);
                if (consultasFactura.modificarFactura(objFactura)) {
                    JOptionPane.showMessageDialog(null, "Usuario modificado", "Exito", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar usuario", "Error ", JOptionPane.ERROR_MESSAGE);
                }
            }
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
        int a = editarRegistro.modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            editarRegistro.modelo.removeRow(i);
        }
    }
}
