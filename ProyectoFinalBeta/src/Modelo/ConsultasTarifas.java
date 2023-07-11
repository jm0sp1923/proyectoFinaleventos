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

/**
 *
 * @author jm0sp
 */
public class ConsultasTarifas extends Conexion {

    public boolean crearTarifas(ObjTarifas tarifas) {
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE tarifas SET tarifa = ? WHERE tipoVehiculo = ?";
        String usar = "USE  " + Bd.getNombreBD() + ";";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tarifas.getTarifa());
            ps.setString(2, tarifas.getTipoVehiculo());
            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);
            ps.executeUpdate();
            usarDB.close();
            return true;
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

    public ObjTarifas tarifas(String tipoVehiculo) {
        ObjTarifas objTarifas = new ObjTarifas();

        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        Connection con = getConexion();

        String sql = "SELECT tarifa FROM tarifas WHERE tipoVehiculo = ?";
        String usar = "USE  " + Bd.getNombreBD() + ";";
        try {
            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);
            
            
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, tipoVehiculo);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                objTarifas.setTarifa(resultSet.getInt("tarifa"));
            }

            usarDB.close();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return objTarifas;
    }

}
