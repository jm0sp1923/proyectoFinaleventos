/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultasFactura extends Conexion {

    public boolean crearFactura(ObjFactura factura) {
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        PreparedStatement ps = null;
        Connection con = getConexion();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String sql = "INSERT into facturas(tipoVehiculo,placa,codigoCliente,nombreCliente,horaEntrada,horaSalida,valorHora,horas,totalPagar,codigoEmpleado) values (?,?,?,?,?,?,?,?,?,?)";
        String usar = "USE " + Bd.getNombreBD() + ";";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, factura.getTipoVehiculo());
            ps.setString(2, factura.getPlaca());
            ps.setInt(3, factura.getCodigoCliente());
            ps.setString(4, factura.getNombreCliente());
            ps.setString(5, factura.getHoraEntrada());
            ps.setString(6, factura.getHoraSalida());
            ps.setInt(7, factura.getValorHora());
            ps.setDouble(8, factura.getHoras());
            ps.setDouble(9, factura.getTotalPagar());

            //factura.getCodigoEmpleado();
            ps.setInt(10, 1);
            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);
            ps.executeUpdate();
            usarDB.close();
            return true;
        } catch (SQLException e) {
            System.err.println("Error metodo crear Factura"+e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ObjFactura buscarFactura(ObjFactura factura) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String sql = "SELECT * FROM facturas WHERE numFactura = ?";
        String usar = "USE " + Bd.getNombreBD() + ";";
        boolean resultadoEncontrado = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            Statement usarDB = con.createStatement();

            int numfactura = factura.numFactura;

            ps.setInt(1, numfactura);
            usarDB.executeUpdate(usar);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                factura.setTipoVehiculo(resultSet.getString("tipoVehiculo"));
                factura.setPlaca(resultSet.getString("placa"));
                factura.setCodigoCliente(resultSet.getInt("codigoCliente"));
                factura.setNombreCliente(resultSet.getString("nombreCliente"));
                factura.setHoraEntrada(resultSet.getString("horaEntrada"));
                factura.setHoraSalida(resultSet.getString("horaSalida"));
                factura.setValorHora(resultSet.getInt("valorHora"));
                factura.setHoras(resultSet.getDouble("horas"));
                factura.setTotalPagar(resultSet.getDouble("totalPagar"));
                factura.setCodigoEmpleado(resultSet.getInt("codigoEmpleado"));
                resultadoEncontrado = true;
            }
            resultSet.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error buscar facturas " + e);
        }
        if (!resultadoEncontrado) {
            factura = null;
        }
        return factura;
    }

    public ArrayList<ObjFactura> buscarTodasLasFacturas(ArrayList<ObjFactura> arregloUsuario) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String usar = "USE " + Bd.getNombreBD() + ";";
        String sql = "SELECT * FROM facturas";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            Statement usarDB = con.createStatement();

            usarDB.executeUpdate(usar);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ObjFactura factura = new ObjFactura();
                factura.setNumFactura(resultSet.getInt("numFactura"));
                factura.setTipoVehiculo(resultSet.getString("tipoVehiculo"));
                factura.setPlaca(resultSet.getString("placa"));
                factura.setCodigoCliente(resultSet.getInt("codigoCliente"));
                factura.setNombreCliente(resultSet.getString("nombreCliente"));
                factura.setHoraEntrada(resultSet.getString("horaEntrada"));
                factura.setHoraSalida(resultSet.getString("horaSalida"));
                factura.setValorHora(resultSet.getInt("valorHora"));
                factura.setHoras(resultSet.getDouble("horas"));
                factura.setTotalPagar(resultSet.getDouble("totalPagar"));
                factura.setCodigoEmpleado(resultSet.getInt("codigoEmpleado"));
                arregloUsuario.add(factura);
            }
        } catch (SQLException e) {
            System.err.println("Error metodo buscarFactura" + e);
        }
        return arregloUsuario;
    }

    public ArrayList<ObjFactura> buscarFacutrasEmpleados(ArrayList<ObjFactura> arregloUsuario, ObjFactura facturaN) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String usar = "USE " + Bd.getNombreBD() + ";";
        String sql = "SELECT * FROM facturas WHERE codigoEmpleado = ?";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            Statement usarDB = con.createStatement();

            statement.setInt(1, facturaN.getCodigoEmpleado());
            usarDB.executeUpdate(usar);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ObjFactura factura = new ObjFactura();
                factura.setNumFactura(resultSet.getInt("numFactura"));
                factura.setTipoVehiculo(resultSet.getString("tipoVehiculo"));
                factura.setPlaca(resultSet.getString("placa"));
                factura.setCodigoCliente(resultSet.getInt("codigoCliente"));
                factura.setNombreCliente(resultSet.getString("nombreCliente"));
                factura.setHoraEntrada(resultSet.getString("horaEntrada"));
                factura.setHoraSalida(resultSet.getString("horaSalida"));
                factura.setValorHora(resultSet.getInt("valorHora"));
                factura.setHoras(resultSet.getDouble("horas"));
                factura.setTotalPagar(resultSet.getDouble("totalPagar"));
                factura.setCodigoEmpleado(resultSet.getInt("codigoEmpleado"));
                arregloUsuario.add(factura);
            }
        } catch (SQLException e) {
            System.err.println("Error metodo buscarFactura empleado" + e);
        }
        return arregloUsuario;
    }

    public ArrayList<ObjFactura> buscarFacutrasPlaca(ArrayList<ObjFactura> arregloUsuario, ObjFactura facturaN) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String usar = "USE " + Bd.getNombreBD() + ";";
        String sql = "SELECT * FROM facturas WHERE placa = ?";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            Statement usarDB = con.createStatement();

            statement.setString(1, facturaN.getPlaca());
            usarDB.executeUpdate(usar);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ObjFactura factura = new ObjFactura();
                factura.setNumFactura(resultSet.getInt("numFactura"));
                factura.setTipoVehiculo(resultSet.getString("tipoVehiculo"));
                factura.setPlaca(resultSet.getString("placa"));
                factura.setCodigoCliente(resultSet.getInt("codigoCliente"));
                factura.setNombreCliente(resultSet.getString("nombreCliente"));
                factura.setHoraEntrada(resultSet.getString("horaEntrada"));
                factura.setHoraSalida(resultSet.getString("horaSalida"));
                factura.setValorHora(resultSet.getInt("valorHora"));
                factura.setHoras(resultSet.getDouble("horas"));
                factura.setTotalPagar(resultSet.getDouble("totalPagar"));
                factura.setCodigoEmpleado(resultSet.getInt("codigoEmpleado"));
                arregloUsuario.add(factura);
            }
        } catch (SQLException e) {
            System.err.println("Error metodo buscarFactura placa" + e);
        }
        return arregloUsuario;
    }

    public boolean modificarFactura(ObjFactura factura) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String usar = "USE " + Bd.getNombreBD() + ";";
        String sql = "UPDATE facturas SET tipoVehiculo = ?, placa = ?, codigoCliente = ?, nombreCliente = ?, "
           + "horaEntrada = ?, horaSalida = ?, valorHora = ?, horas = ?, totalPagar = ?, codigoEmpleado = ? "
           + "WHERE `numFactura` = ?";
        try {
            PreparedStatement ps;
            Statement usarDB = con.createStatement();
            ps = con.prepareStatement(sql);
            ps.setString(1, factura.getTipoVehiculo());
            ps.setString(2, factura.getPlaca());
            ps.setInt(3, factura.getCodigoCliente());
            ps.setString(4, factura.getNombreCliente());
            ps.setString(5, factura.getHoraEntrada());
            ps.setString(6, factura.getHoraSalida());
            ps.setInt(7, factura.getValorHora());
            ps.setDouble(8, factura.getHoras());
            ps.setDouble(9, factura.getTotalPagar());
            ps.setInt(10, factura.getCodigoEmpleado());
            ps.setInt(11, factura.getNumFactura());
            usarDB.executeUpdate(usar);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error modificar factura"+e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

}
