/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Vista.FormularioValorHora;
import Modelo.ObjTarifas;
import Modelo.ConsultasTarifas;
import javax.swing.JOptionPane;

public class ControladorFormularioValorHora implements ActionListener {

    FormularioValorHora formularioValorHora;
    ObjTarifas objTarifas;
    ConsultasTarifas consultasTarifas;

    public ControladorFormularioValorHora(FormularioValorHora formularioValorHora, ObjTarifas objTarifas, ConsultasTarifas consultasTarifas) {

        this.formularioValorHora = formularioValorHora;
        this.objTarifas = objTarifas;
        this.consultasTarifas = consultasTarifas;

        this.formularioValorHora.guardar.addActionListener(this);
        this.formularioValorHora.cancelar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioValorHora.guardar) {
            ponerTarifas();
            formularioValorHora.dispose();
        }
        if (e.getSource() == formularioValorHora.cancelar) {
            formularioValorHora.dispose();
        }
    }

    public void ponerTarifas() {
        if (!formularioValorHora.horaCarroT.getText().isEmpty()) {
            if (esNumeroEntero(formularioValorHora.horaCarroT.getText())) {
                objTarifas.setTipoVehiculo("C");
                objTarifas.setTarifa(Integer.parseInt(formularioValorHora.horaCarroT.getText()));
                consultasTarifas.crearTarifas(objTarifas);
            } else {
                JOptionPane.showMessageDialog(null, "El valor de la hora debe ser un numero entero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (!formularioValorHora.horaMotoT.getText().isEmpty()) {
            if (esNumeroEntero(formularioValorHora.horaMotoT.getText())) {
                objTarifas.setTipoVehiculo("M");
                objTarifas.setTarifa(Integer.parseInt(formularioValorHora.horaMotoT.getText()));
                consultasTarifas.crearTarifas(objTarifas);
            } else {
                JOptionPane.showMessageDialog(null, "El valor de la hora debe ser un numero entero", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (!formularioValorHora.horaBicicletaT.getText().isEmpty()) {
            if (esNumeroEntero(formularioValorHora.horaBicicletaT.getText())) {
                objTarifas.setTipoVehiculo("B");
                objTarifas.setTarifa(Integer.parseInt(formularioValorHora.horaBicicletaT.getText()));
                consultasTarifas.crearTarifas(objTarifas);
            } else {
                JOptionPane.showMessageDialog(null, "El valor de la hora debe ser un numero entero", "Error", JOptionPane.ERROR_MESSAGE);
            }
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

}
