/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author jm0sp
 */
public class EliminarBd extends Conexion {

    public boolean Eliminarbd() {
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        try {
            Statement stmt = con.createStatement();
            String sql = "DROP DATABASE "+Bd.getNombreBD();
            stmt.executeUpdate(sql);
            vaciarArchivo();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error Eliminar BD" + e);
            return false;
        }
        
    }
  
    public static void vaciarArchivo() {
        try {
            FileWriter archivo = new FileWriter("configuracionBaseDatos.txt");
            archivo.write("");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
