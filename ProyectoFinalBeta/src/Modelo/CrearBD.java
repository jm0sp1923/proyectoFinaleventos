/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.FormularioCrearBD;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author jm0sp
 */
public class CrearBD extends Conexion {

    public String name;
    FormularioCrearBD fb;

    public CrearBD(FormularioCrearBD fb) {
        this.fb = fb;
        name = fb.nombreBDL.getText();
        Conexion conector = new Conexion();
        String usar = "USE " + name + ";";

        try {

            try {
                Connection con = getConexion();
                String sqlCrearBD = "CREATE DATABASE IF NOT EXISTS " + name;
                Statement statementBD = con.createStatement();
                statementBD.executeUpdate(sqlCrearBD);
                statementBD.close();
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
            try {
                Connection con = getConexion();
                String crearTablaUsuario = "CREATE TABLE IF NOT EXISTS `usuario` ("
                        + "  `codigo` int(11) NOT NULL AUTO_INCREMENT,"
                        + "  `nivel` varchar(50) NOT NULL,"
                        + "  `nombre` varchar(50) NOT NULL,"
                        + "  `correo` varchar(50) NOT NULL,"
                        + "  `contrasena` varchar(50) NOT NULL,"
                        + "  PRIMARY KEY (`codigo`),"
                        + "  UNIQUE KEY `correo` (`correo`)"
                        + ");";

                Statement usarDB = con.createStatement();
                usarDB.executeUpdate(usar);
                Statement tablaUsuario = con.createStatement();
                tablaUsuario.executeUpdate(crearTablaUsuario);
                usarDB.close();
                tablaUsuario.close();
                con.close();
            } catch (SQLException a) {
                System.err.println("Error al crear la tabla usuarios " + a);
            }

            try {
                Connection con = getConexion();
                String crearTablaIngresoVehiculos = "CREATE TABLE IF NOT EXISTS `ingresovehiculos` ("
                        + "  `placa` varchar(50) NOT NULL,"
                        + "  `puesto` int(11) NOT NULL,"
                        + "  `codigo_cliente` int(11) NOT NULL,"
                        + "  `tipoVehiculo` varchar(50) NOT NULL,"
                        + "  `horaEntrada` int(11) NOT NULL,"
                        + "  `minutoEntrada` int(11) NOT NULL,"
                        + "  UNIQUE KEY `puesto` (`puesto`),"
                        + "  KEY `FK_Codigo_cliente` (`codigo_cliente`),"
                        + "  KEY `placa` (`placa`),"
                        + "  CONSTRAINT `FK_Codigo_cliente` FOREIGN KEY (`codigo_cliente`) REFERENCES `usuario` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE"
                        + ");";
                Statement usarDB = con.createStatement();
                usarDB.executeUpdate(usar);
                Statement tablaEntradaVehiculos = con.createStatement();
                tablaEntradaVehiculos.executeUpdate(crearTablaIngresoVehiculos);
                tablaEntradaVehiculos.close();
                usarDB.close();
                con.close();
            } catch (SQLException b) {
                System.out.println("Error al crear la tabla ingresoVehiculos " + b);
            }

            try {
                Connection con = getConexion();
                String crearTablaTarifas = "CREATE TABLE IF NOT EXISTS `tarifas` ("
                        + "  `tipoVehiculo` varchar(50) NOT NULL,"
                        + "  `tarifa` double NOT NULL DEFAULT 0,"
                        + "  PRIMARY KEY (`tipoVehiculo`)"
                        + ");";
                Statement usarDB = con.createStatement();
                usarDB.executeUpdate(usar);
                Statement crearTarifas = con.createStatement();
                crearTarifas.executeUpdate(crearTablaTarifas);
                usarDB.close();
                con.close();

            } catch (SQLException b) {
                System.out.println("Error al crear la tabla Tarifas " + b);

            }

            try {

                Connection con = getConexion();
                String crearTablaTarifas = "INSERT INTO tarifas (tipoVehiculo) VALUES (\"C\"),(\"M\"),(\"B\");";
                Statement usarDB = con.createStatement();
                usarDB.executeUpdate(usar);
                Statement crearTarifas = con.createStatement();
                crearTarifas.executeUpdate(crearTablaTarifas);
                usarDB.close();
                con.close();
            } catch (SQLException b) {

            }

            try {
                Connection con = getConexion();
                String crearTablaFacturas = "CREATE TABLE IF NOT EXISTS `facturas` ("
                        + "  `numFactura` int(11) NOT NULL AUTO_INCREMENT,"
                        + "  `tipoVehiculo` varchar(50) NOT NULL,"
                        + "  `placa` varchar(50) DEFAULT NULL,"
                        + "  `codigoCliente` int(11) NOT NULL DEFAULT 0,"
                        + "  `nombreCliente` varchar(50) NOT NULL DEFAULT '0',"
                        + "  `horaEntrada` varchar(50) NOT NULL DEFAULT '',"
                        + "  `horaSalida` varchar(50) NOT NULL DEFAULT '',"
                        + "  `valorHora` int(11) NOT NULL DEFAULT 0,"
                        + "  `horas` double NOT NULL DEFAULT 0,"
                        + "  `totalPagar` double NOT NULL DEFAULT 0,"
                        + "  `codigoEmpleado` int(11) NOT NULL DEFAULT 0,"
                        + "  PRIMARY KEY (`numFactura`),"
                        + "  KEY `placa` (`placa`),"
                        + "  KEY `CodigoEmpleado` (`codigoEmpleado`),"
                        + "  KEY `codigoCliente` (`codigoCliente`),"
                        + "  KEY `tipoVehiculo` (`tipoVehiculo`),"
                        + "  CONSTRAINT `CodigoEmpleado` FOREIGN KEY (`codigoEmpleado`) REFERENCES `usuario` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,"
                        + "  CONSTRAINT `TIPO_TARIFA` FOREIGN KEY (`tipoVehiculo`) REFERENCES `tarifas` (`tipoVehiculo`) ON DELETE CASCADE ON UPDATE CASCADE"
                        + ");";
                Statement usarDB = con.createStatement();
                usarDB.executeUpdate(usar);
                Statement crearFactura = con.createStatement();
                crearFactura.executeUpdate(crearTablaFacturas);
                usarDB.close();
                con.close();

            } catch (SQLException b) {
                System.out.println("Error al crear la tabla Facturas " + b);
            }

            JOptionPane.showMessageDialog(null, "La base de datos ha sido creada", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, "La base de datos no ha sido creadad", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(t);
        }

    }

}
