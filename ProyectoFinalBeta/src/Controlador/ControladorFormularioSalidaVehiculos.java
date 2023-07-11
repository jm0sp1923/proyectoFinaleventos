/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FormularioSalidaVehiculos;
import Vista.FormularioValidarSalidaVehiculos;
import Modelo.ObjIngresoVehiculos;
import Modelo.ObjFactura;
import javax.swing.JOptionPane;
import Modelo.ConsultasIngresoVehiculoBd;
import Modelo.ConsultasTarifas;
import Modelo.ObjTarifas;

public class ControladorFormularioSalidaVehiculos implements ActionListener {

    FormularioSalidaVehiculos formularioSalidaVehiculos;
    ObjIngresoVehiculos objIngresoVehiculos;
    ObjFactura objFactura;
    ConsultasTarifas consultasTarifas;
    ObjTarifas objTarifas;
    ConsultasIngresoVehiculoBd consultasIngresoVehiculoBd;
    FormularioValidarSalidaVehiculos formularioValidarSalidaVehiculos;
    ControladorFormularioValidarSalida controladorFormularioValidarSalida;

    public ControladorFormularioSalidaVehiculos(FormularioSalidaVehiculos formularioSalidaVehiculos, ObjIngresoVehiculos objIngresoVehiculos,
            ConsultasIngresoVehiculoBd consultasIngresoVehiculoBd, FormularioValidarSalidaVehiculos formularioValidarSalidaVehiculos,
            ConsultasTarifas consultasTarifas, ObjTarifas objTarifas,
            ControladorFormularioValidarSalida controladorFormularioValidarSalida, ObjFactura objFactura) {

        this.formularioSalidaVehiculos = formularioSalidaVehiculos;
        this.controladorFormularioValidarSalida = controladorFormularioValidarSalida;
        this.formularioValidarSalidaVehiculos = formularioValidarSalidaVehiculos;
        this.objIngresoVehiculos = objIngresoVehiculos;
        this.objFactura = objFactura;
        this.consultasTarifas = consultasTarifas;
        this.objTarifas = objTarifas;
        this.consultasIngresoVehiculoBd = consultasIngresoVehiculoBd;

        this.formularioSalidaVehiculos.validar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioSalidaVehiculos.validar) {
            if (validarVehiculo(formularioSalidaVehiculos.placa.getText())) {
                formularioSalidaVehiculos.dispose();
                iniciarValidarSalida();
            }
        }
    }

    public void iniciarValidarSalida() {
        formularioValidarSalidaVehiculos.setTitle("Validar salida");
        formularioValidarSalidaVehiculos.setSize(280, 420);
        formularioValidarSalidaVehiculos.setVisible(true);
    }

    public boolean validarVehiculo(String datos) {
        String[] partes = datos.split("-");

        if (partes.length != 5) {
            JOptionPane.showMessageDialog(null, "Ingrese un formato de datos valido (V-P-PLACA-HS-MS)", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String v = partes[0].toUpperCase();
        String p = partes[1];
        String placa = partes[2];
        String hs = partes[3];
        String ms = partes[4];

        //Validar V es un caracter
        if (esNumeroEntero(v)) {
            JOptionPane.showMessageDialog(null, "El tipo de vehiculo no puede ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        int horaSalida, minSalida;
        if (esNumeroEntero(hs)) {
            horaSalida = Integer.parseInt(hs);
        } else {
            JOptionPane.showMessageDialog(null, "La hora debe estar dada en un numero entre [00 - 23]", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (esNumeroEntero(ms)) {
            minSalida = Integer.parseInt(ms);
        } else {
            JOptionPane.showMessageDialog(null, "La hora debe estar dada en un numero entre [00 - 23]", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Validar rango de horas y minutos
        if (horaSalida < 0 || horaSalida > 23 || minSalida < 0 || minSalida > 59) {
            JOptionPane.showMessageDialog(null, "La hora debe estar dada en un numero entre [00 - 23] y los minutos entre [0 - 59]", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Validar V es un tipo de vehiculo valido
        if (!("C".equals(v) || "M".equals(v) || "B".equals(v))) {
            JOptionPane.showMessageDialog(null, "Tipo de vehiculo no valido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Validar puesto es un numero
        int puesto;
        if (esNumeroEntero(p)) {
            puesto = Integer.parseInt(p);
        } else {
            JOptionPane.showMessageDialog(null, "El puesto debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        objIngresoVehiculos.setPuesto(puesto);
        objIngresoVehiculos.setPlaca(placa);
        objIngresoVehiculos.setTipoVehiculos(v);

        objTarifas = consultasTarifas.tarifas(objIngresoVehiculos.getTipoVehiculos());
        System.out.println(objTarifas.getTarifa());
        if (objTarifas.getTarifa() == 0) {
            JOptionPane.showMessageDialog(null, "No se han ingresado tarifas", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        objFactura.setValorHora(objTarifas.getTarifa());

        if (consultasIngresoVehiculoBd.validarVehiculoExiste(objIngresoVehiculos)) {
            objIngresoVehiculos = consultasIngresoVehiculoBd.vehiculoIngresado(objIngresoVehiculos);
            if (validarHora(objIngresoVehiculos, horaSalida, minSalida)) {

                String horaEntradaMin = String.format("%02d:%02d", objIngresoVehiculos.getHoraEntrada(), objIngresoVehiculos.getMinEntrada());
                String horaSalidaMin = String.format("%02d:%02d", horaSalida, minSalida);

                objFactura.setTipoVehiculo(objIngresoVehiculos.getTipoVehiculos());
                objFactura.setCodigoCliente(objIngresoVehiculos.getCodigoCliente());
                objFactura.setPlaca(objIngresoVehiculos.getPlaca());
                objFactura.setHoraEntrada(horaEntradaMin);
                objFactura.setHoraSalida(horaSalidaMin);
               
                controladorFormularioValidarSalida.llenarDatos(objFactura);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "La hora es menor", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe ese vehiculo en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean esNumeroEntero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validarHora(ObjIngresoVehiculos objIngresoVehiculos, int horaSalida, int minSalida) {
        if (objIngresoVehiculos.getHoraEntrada() > horaSalida) {
            return false;
        } else if (objIngresoVehiculos.getHoraEntrada() == horaSalida) {
            if (objIngresoVehiculos.getMinEntrada() < minSalida) {
                return true;
            } else if (objIngresoVehiculos.getMinEntrada() > minSalida) {
                return false;
            } else {
                return true;
            }

        } else {
            return true;
        }

    }

}
