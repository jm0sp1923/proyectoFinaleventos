/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConsultasIngresoVehiculoBd extends Conexion {

    public boolean ingresarVehiculo(ObjIngresoVehiculos vehiculo) {

        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT into ingresovehiculos(placa,puesto,codigo_cliente,tipoVehiculo,horaEntrada,minutoEntrada) values (?,?,?,?,?,?)";
        String usar = "USE " + Bd.getNombreBD() + ";";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca());
            ps.setInt(2, vehiculo.getPuesto());
            ps.setInt(3, vehiculo.getCodigoCliente());
            ps.setString(4, vehiculo.getTipoVehiculos());
            ps.setInt(5, vehiculo.getHoraEntrada());
            ps.setInt(6, vehiculo.getMinEntrada());
            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);
            ps.executeUpdate();
            usarDB.close();
            return true;

        } catch (java.sql.SQLIntegrityConstraintViolationException t) {
            JOptionPane.showMessageDialog(null, "No existe ese usuario en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ArrayList<ObjIngresoVehiculos> vehiculosIngresados(ArrayList<ObjIngresoVehiculos> vehiculos) {
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM ingresovehiculos";
        String usar = "USE " + Bd.getNombreBD() + ";";
        try {

            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                ObjIngresoVehiculos ingre = new ObjIngresoVehiculos();
                ingre.setPlaca(rs.getString("placa"));
                ingre.setPuesto(rs.getInt("puesto"));
                ingre.setCodigoCliente(rs.getInt("codigo_cliente"));
                ingre.setTipoVehiculos(rs.getString("tipoVehiculo"));
                ingre.setHoraEntrada(rs.getInt("horaEntrada"));
                ingre.setMinEntrada(rs.getInt("minutoEntrada"));

                vehiculos.add(ingre);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return vehiculos;
    }

    public boolean puestosOCupados(int p) {

        boolean encontrado = false;
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "SELECT puesto FROM ingresovehiculos";
        String usar = "USE " + Bd.getNombreBD() + ";";

        try {
            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                if (rs.getInt("puesto") == p) {
                    return true;
                }

            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

        return encontrado;

    }

    public boolean placaIngresada(String placa) {

        boolean encontrado = false;
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "SELECT placa FROM ingresovehiculos";
        String usar = "USE " + Bd.getNombreBD() + ";";

        try {
            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                if (rs.getString("placa").equals(placa)) {
                    return true;
                }

            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }

        }

        return encontrado;
    }

    public boolean validarVehiculoExiste(ObjIngresoVehiculos objIngresoVehiculos) {
        boolean encontrado = false;
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM ingresovehiculos WHERE puesto = ? AND placa = ? AND tipoVehiculo = ?";
        String usar = "USE " + Bd.getNombreBD() + ";";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, objIngresoVehiculos.getPuesto());
            ps.setString(2, objIngresoVehiculos.getPlaca());
            ps.setString(3, objIngresoVehiculos.getTipoVehiculos());
            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                encontrado = true;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return encontrado;
    }

    public ObjIngresoVehiculos vehiculoIngresado(ObjIngresoVehiculos objIngresoVehiculos) {
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM ingresovehiculos WHERE puesto = ? AND placa = ?";
        String usar = "USE " + Bd.getNombreBD() + ";";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, objIngresoVehiculos.getPuesto());
            ps.setString(2, objIngresoVehiculos.getPlaca());

            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                objIngresoVehiculos.setPlaca(rs.getString("placa"));
                objIngresoVehiculos.setPuesto(rs.getInt("puesto"));
                objIngresoVehiculos.setCodigoCliente(rs.getInt("codigo_cliente"));
                objIngresoVehiculos.setTipoVehiculos(rs.getString("tipoVehiculo"));
                objIngresoVehiculos.setHoraEntrada(rs.getInt("horaEntrada"));
                objIngresoVehiculos.setMinEntrada(rs.getInt("minutoEntrada"));
                
            }
 
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return objIngresoVehiculos;
    }
}
