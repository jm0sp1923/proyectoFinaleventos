/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.FormularioValidarSalidaVehiculos;
import Modelo.ObjFactura;
import Modelo.ConsultasUsuario;
import Modelo.UsuarioObj;
import Modelo.ConsultasFactura;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ControladorFormularioValidarSalida implements ActionListener {

    FormularioValidarSalidaVehiculos formularioValidarSalidaVehiculos;
    ObjFactura objFactura;
    ConsultasFactura consultasFactura;
    
    ConsultasUsuario consultasUsuario;
    UsuarioObj usu;

    public ControladorFormularioValidarSalida(FormularioValidarSalidaVehiculos formularioValidarSalidaVehiculos,
            ObjFactura objFactura, ConsultasFactura consultasFactura,
            ConsultasUsuario consultasUsuario, UsuarioObj usu) {

        this.formularioValidarSalidaVehiculos = formularioValidarSalidaVehiculos;
        this.objFactura = objFactura;
        this.consultasFactura = consultasFactura;
        
        this.consultasUsuario = consultasUsuario;
        this.usu = usu;

        this.formularioValidarSalidaVehiculos.guardar.addActionListener(this);
        this.formularioValidarSalidaVehiculos.cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formularioValidarSalidaVehiculos.guardar) {
            consultasFactura.crearFactura(objFactura);
            formularioValidarSalidaVehiculos.dispose();
        }

        if (e.getSource() == formularioValidarSalidaVehiculos.cancelar) {
            formularioValidarSalidaVehiculos.dispose();
        }
    }

    public void llenarDatos(ObjFactura objFactura) {

        
        usu.setCodigo(objFactura.getCodigoCliente());
        usu = consultasUsuario.datosUsuarioBuscar(usu);
        objFactura.setNombreCliente(usu.getNombre());

        llenarTextFields(objFactura);
    }

    public void llenarTextFields(ObjFactura factura) {

        String[] partesHoraEntrada = factura.getHoraEntrada().split(":");
        int horaEntrada = Integer.parseInt(partesHoraEntrada[0]);
        int minEntrada = Integer.parseInt(partesHoraEntrada[1]);
       
        
        String[] partesHoraSalida = factura.getHoraSalida().split(":");
        int horaSalida = Integer.parseInt(partesHoraSalida[0]);
        int minSalida = Integer.parseInt(partesHoraSalida[1]);

        
      
       double horas = (horaSalida - horaEntrada) + (minSalida - minEntrada) / 60.0;
       DecimalFormat formato = new DecimalFormat("#.##");
       
       double truncado = Double.parseDouble(formato.format(horas).replace(",", ".")); 
        
       
        factura.setHoras(truncado);
       
        double totalApagar = objFactura.getHoras() * objFactura.getValorHora();
        factura.setTotalPagar(totalApagar);

        formularioValidarSalidaVehiculos.vehiculoT.setText(factura.getTipoVehiculo());
        formularioValidarSalidaVehiculos.nombreClienteT.setText(factura.getNombreCliente() + "");
        formularioValidarSalidaVehiculos.placaT.setText(factura.getPlaca());
        formularioValidarSalidaVehiculos.horaEntradaT.setText(horaEntrada + "");
        formularioValidarSalidaVehiculos.minEntradaT.setText(minEntrada + "");
        formularioValidarSalidaVehiculos.horaSalidaT.setText(horaSalida + "");
        formularioValidarSalidaVehiculos.minutoSalidaT.setText(minSalida + "");
        formularioValidarSalidaVehiculos.valorHoraT.setText(factura.getValorHora() + "");
        formularioValidarSalidaVehiculos.horasT.setText(factura.getHoras()+"");
        formularioValidarSalidaVehiculos.totalApagarT.setText(factura.getTotalPagar() + "");
        
        
    }

}
