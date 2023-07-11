/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FormularioIngresoVehiculos;
import Vista.FormularioDetalleIngresoVehiculos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.ObjIngresoVehiculos;
import Modelo.ConsultasIngresoVehiculoBd;
import java.util.ArrayList;
import javax.swing.*;

public class ControladorFormularioIngresoVehiculo implements ActionListener {

    FormularioIngresoVehiculos formularioIngresoVehiculos;
    FormularioDetalleIngresoVehiculos detalleIngresoVehiculos;
    ObjIngresoVehiculos objIngresoVehiculos;
    ConsultasIngresoVehiculoBd consultasIngresoVehiculoBd;
    ControladorFormularioDetalleIngreso controladorFormularioDetalleIngreso;
    ArrayList<ObjIngresoVehiculos> vehiculos = new ArrayList<>();

    public ControladorFormularioIngresoVehiculo(FormularioIngresoVehiculos formularioIngresoVehiculos, ObjIngresoVehiculos objIngresoVehiculos, ConsultasIngresoVehiculoBd consultasIngresoVehiculoBd, FormularioDetalleIngresoVehiculos detalleIngresoVehiculos, ControladorFormularioDetalleIngreso controladorFormularioDetalleIngreso) {

        this.formularioIngresoVehiculos = formularioIngresoVehiculos;
        this.detalleIngresoVehiculos = detalleIngresoVehiculos;
        this.consultasIngresoVehiculoBd = consultasIngresoVehiculoBd;
        this.objIngresoVehiculos = objIngresoVehiculos;
        this.controladorFormularioDetalleIngreso = controladorFormularioDetalleIngreso;

        this.formularioIngresoVehiculos.cancelar.addActionListener(this);
        this.formularioIngresoVehiculos.mostrar.addActionListener(this);
        this.formularioIngresoVehiculos.tipoVehiculos.addActionListener(this);
        this.formularioIngresoVehiculos.mostrarTodos.addActionListener(this);
        this.formularioIngresoVehiculos.validar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == formularioIngresoVehiculos.cancelar) {
            formularioIngresoVehiculos.area.setText("");
            formularioIngresoVehiculos.dispose();
        }
        if (e.getSource() == formularioIngresoVehiculos.mostrar) {
            if (formularioIngresoVehiculos.tipoVehiculos.getSelectedItem().toString().equals("Carro")) {
                formularioIngresoVehiculos.area.setText(puestosParqueaderoCarros());
            }
            if (formularioIngresoVehiculos.tipoVehiculos.getSelectedItem().toString().equals("Moto")) {
                formularioIngresoVehiculos.area.setText(puestosParqueaderoMotos());
            }
            if (formularioIngresoVehiculos.tipoVehiculos.getSelectedItem().toString().equals("Bicicleta")) {
                formularioIngresoVehiculos.area.setText(puestosParqueaderoCiclas());
            }
        }
        if (e.getSource() == formularioIngresoVehiculos.mostrarTodos) {
            formularioIngresoVehiculos.area.setText(mostrarTodosVehiculos());
        }
        if (e.getSource() == formularioIngresoVehiculos.validar) {
            if (validarVehiculo(formularioIngresoVehiculos.placa.getText())) {
                formularioIngresoVehiculos.dispose();
                iniciarValidarIngreso();
            }
        }

    }

    public String puestosParqueaderoCarros(){
        ArrayList<ObjIngresoVehiculos> vehiculosIngresados;
        vehiculosIngresados = consultasIngresoVehiculoBd.vehiculosIngresados(vehiculos);
        StringBuilder sb = new StringBuilder();
        sb.append("Carros\n\n");

        for (int i = 1; i <= 10; i++) {
            boolean encontrado = false;
            for (int j = 0; j < vehiculosIngresados.size(); j++) {
                if (vehiculosIngresados.get(j).getPuesto() == i) {
                    sb.append(vehiculosIngresados.get(j).getTipoVehiculos()).append("    ");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                sb.append(i).append("    ");
            }
        }
        return sb.toString();
    }

    public String puestosParqueaderoMotos() {
        ArrayList<ObjIngresoVehiculos> vehiculosIngresados;
        vehiculosIngresados = consultasIngresoVehiculoBd.vehiculosIngresados(vehiculos);
        StringBuilder sb = new StringBuilder();
        sb.append("Motos\n\n");

        for (int i = 11; i <= 20; i++) {
            boolean encontrado = false;
            for (int j = 0; j < vehiculosIngresados.size(); j++) {
                if (vehiculosIngresados.get(j).getPuesto() == i) {
                    sb.append(vehiculosIngresados.get(j).getTipoVehiculos()).append("    ");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                sb.append(i).append("    ");
            }
        }
        return sb.toString();
    }

    public String puestosParqueaderoCiclas() {
        ArrayList<ObjIngresoVehiculos> vehiculosIngresados;
        vehiculosIngresados = consultasIngresoVehiculoBd.vehiculosIngresados(vehiculos);
        StringBuilder sb = new StringBuilder();
        sb.append("Bicicletas\n\n");

        for (int i = 21; i <= 25; i++) {
            boolean encontrado = false;
            for (int j = 0; j < vehiculosIngresados.size(); j++) {
                if (vehiculosIngresados.get(j).getPuesto() == i) {
                    sb.append(vehiculosIngresados.get(j).getTipoVehiculos()).append("    ");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                sb.append(i).append("    ");
            }
        }
        return sb.toString();
    }

    public String mostrarTodosVehiculos() {
        StringBuilder sb = new StringBuilder();
        sb.append(puestosParqueaderoCarros());
        sb.append("\n\n");
        sb.append(puestosParqueaderoMotos());
        sb.append("\n\n");
        sb.append(puestosParqueaderoCiclas());
        return sb.toString();
    }
    
    public void iniciarValidarIngreso() {
        detalleIngresoVehiculos.setTitle("Detalle ingreso");
        detalleIngresoVehiculos.setSize(300, 350);
        detalleIngresoVehiculos.setVisible(true);
    }

    public boolean validarVehiculo(String datos) {

        String[] partes = datos.split("-");

        if (partes.length != 5) {
            JOptionPane.showMessageDialog(null, "Ingrese un formato de datos valido (V-P-PLACA-HE-ME)", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String v = partes[0].toUpperCase();
        String p = partes[1];
        String placa = partes[2];
        String he = partes[3];
        String me = partes[4];

        //Validar V es un caracter
        if (esNumeroEntero(v)) {
            System.out.println(v);
            JOptionPane.showMessageDialog(null, "El tipo de vehiculo no puede ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Validar horas son enteros 
        int horaEntrada, minEntrada;
        if (esNumeroEntero(he)) {
            horaEntrada = Integer.parseInt(he);
        } else {
            JOptionPane.showMessageDialog(null, "La hora debe estar dada en un numero entre [00 - 23]", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (esNumeroEntero(me)) {
            minEntrada = Integer.parseInt(me);
        } else {
            JOptionPane.showMessageDialog(null, "La hora debe estar dada en un numero entre [00 - 23]", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Validar rango de horas y minutos
        if (horaEntrada < 0 || horaEntrada > 23 || minEntrada < 0 || minEntrada > 59) {
            JOptionPane.showMessageDialog(null, "La hora debe estar dada en un numero entre [00 - 23]  y los minutos entre [0 - 59]", "Error", JOptionPane.ERROR_MESSAGE);
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

        switch (v) {
            case "C" -> {
                if (!placa.isEmpty()) {
                    if (placa.length() == 6) {
                        if (placa.substring(0, 3).matches("[A-Z]{3}")) {
                            if (placa.substring(3).matches("\\d{3}")) {
                                if (!placaIngresada(placa)) {
                                    if (puesto >= 1 && puesto <= 10) {
                                        if (!puestoOcuapado(puesto)) {
                                            objIngresoVehiculos.setTipoVehiculos(v);
                                            objIngresoVehiculos.setPuesto(puesto);
                                            objIngresoVehiculos.setPlaca(placa);
                                            objIngresoVehiculos.setHoraEntrada(horaEntrada);
                                            objIngresoVehiculos.setMinEntrada(minEntrada);
                                            controladorFormularioDetalleIngreso.llenarDatos(objIngresoVehiculos);
                                            return true;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El puesto " + puesto + " esta ocuapado", "Error", JOptionPane.ERROR_MESSAGE);
                                            return false;
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Vehiculos tipo C, puesto [1-10]", "Error", JOptionPane.ERROR_MESSAGE);
                                        return false;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "El vehiculo con placa " + placa + " Ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                                    return false;
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "La placa debe tener el formato ABC123", "Error", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "La placa debe tener el formato ABC123", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "La placa debe tener 6 digitos", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Formato de placa no valido", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

            case "M" -> {
                if (!placa.isEmpty()) {
                    if (placa.length() == 6) {
                        if (placa.substring(0, 3).matches("[A-Za]{3}")) {
                            if (placa.substring(3, 5).matches("\\d{2}")) {
                                if (placa.substring(5).matches("[A-Z]{1}")) {
                                    if (!placaIngresada(placa)) {
                                        if (puesto >= 11 && puesto <= 20) {
                                            if (!puestoOcuapado(puesto)) {
                                                objIngresoVehiculos.setTipoVehiculos(v);
                                                objIngresoVehiculos.setPuesto(puesto);
                                                objIngresoVehiculos.setPlaca(placa);
                                                objIngresoVehiculos.setHoraEntrada(horaEntrada);
                                                objIngresoVehiculos.setMinEntrada(minEntrada);
                                                controladorFormularioDetalleIngreso.llenarDatos(objIngresoVehiculos);
                                                return true;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "El puesto " + puesto + " esta ocuapado", "Error", JOptionPane.ERROR_MESSAGE);
                                                return false;
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Vehiculos tipo M, puesto [11-20]", "Error", JOptionPane.ERROR_MESSAGE);
                                            return false;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El vehiculo con placa " + placa + " Ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
                                        return false;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "La placa debe tener el formato ABC12D", "Error", JOptionPane.ERROR_MESSAGE);
                                    return false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "La placa debe tener el formato ABC12D", "Error", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "La placa debe tener el formato ABC12D", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La placa debe tener 6 digitos", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Formato de placa no valido", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            case "B" -> {
                if (!placa.isEmpty()) {
                    if (placa.length() == 4) {
                        if (placa.substring(0, 4).matches("^0000$")) {
                            if (puesto >= 21 && puesto <= 25) {
                                if (!puestoOcuapado(puesto)) {
                                    objIngresoVehiculos.setTipoVehiculos(v);
                                    objIngresoVehiculos.setPuesto(puesto);
                                    objIngresoVehiculos.setPlaca(placa);
                                    objIngresoVehiculos.setHoraEntrada(horaEntrada);
                                    objIngresoVehiculos.setMinEntrada(minEntrada);
                                    controladorFormularioDetalleIngreso.llenarDatos(objIngresoVehiculos);
                                    return true;
                                } else {
                                    JOptionPane.showMessageDialog(null, "El puesto " + puesto + " esta ocuapado", "Error", JOptionPane.ERROR_MESSAGE);
                                    return false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Vehiculos tipo B, puesto [21-25]", "Error", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "La placa de las ciclas debe ser 0000", "Error", JOptionPane.ERROR_MESSAGE);
                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La placa de las ciclas debe ser 0000", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Formato de placa no valido", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        return true;

    }

    public boolean esNumeroEntero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean puestoOcuapado(int p) {
        boolean encontrado;
        encontrado = consultasIngresoVehiculoBd.puestosOCupados(p);
        return encontrado;
    }

    public boolean placaIngresada(String placa) {
        boolean encontrado;
        encontrado = consultasIngresoVehiculoBd.placaIngresada(placa);
        return encontrado;
    }

}
