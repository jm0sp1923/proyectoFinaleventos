/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jm0sp
 */
public class ConsultasUsuario extends Conexion {

    public boolean crearUsuario(UsuarioObj usu) {
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
         if(Bd.getNombreBD() == null ){
         JOptionPane.showMessageDialog(null, "No se ha creado una base de datos","Error",JOptionPane.ERROR_MESSAGE);
            return false;
         }
        
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT into usuario(nivel,nombre,correo,contrasena) values (?,?,?,?)";
        String usar = "USE " + Bd.getNombreBD() + ";";
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNivel());
            ps.setString(2, usu.getNombre());
            ps.setString(3, usu.getCorreo());
            ps.setString(4, usu.getContrasena());
            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);
            ps.executeUpdate();
            usarDB.close();
            return true;
        }catch(java.sql.SQLIntegrityConstraintViolationException e){
            JOptionPane.showMessageDialog(null, "Ya hay un usuario con ese correo","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }catch (SQLException e) {
            System.err.println(e);
            return false;
         
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public int codigoUsuario() {
        int codigo = 0;
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        Connection con = getConexion();

        String sql = "SELECT codigo FROM usuario ORDER BY codigo DESC LIMIT 1";
        String usar = "USE " + Bd.getNombreBD() + ";";

        try {
            Statement usarDB = con.createStatement();
            usarDB.executeUpdate(usar);

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                codigo = resultSet.getInt("codigo");
            }
            con.close();
        } catch (SQLException e) {
            System.err.println("Error metodo codigoUsuario: " + e);
        }
        return codigo;
    }

    public UsuarioObj datosUsuarioBuscar(UsuarioObj usu) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String sql = "SELECT nivel, nombre, correo, contrasena FROM usuario WHERE codigo = ?";
        String usar = "USE " + Bd.getNombreBD() + ";";
        boolean resultadoEncontrado = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            Statement usarDB = con.createStatement();
            int codigoSelect = usu.getCodigo();

            ps.setInt(1, codigoSelect);
            usarDB.executeUpdate(usar);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                usu.setNivel(resultSet.getString("nivel"));
                usu.setNombre(resultSet.getString("nombre"));
                usu.setCorreo(resultSet.getString("correo"));
                usu.setContrasena(resultSet.getString("contrasena"));
                resultadoEncontrado = true;
            }

            resultSet.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (!resultadoEncontrado) {
            usu = null;
        }
        return usu;
    }

    public boolean modificarUsuario(UsuarioObj usu) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String usar = "USE " + Bd.getNombreBD() + ";";
        String sql = "UPDATE usuario SET nivel = ?, nombre = ?,correo = ?, contrasena = ? WHERE codigo = ?";
        try {
            PreparedStatement ps;
            Statement usarDB = con.createStatement();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getNivel());
            ps.setString(2, usu.getNombre());
            ps.setString(3, usu.getCorreo());
            ps.setString(4, usu.getContrasena());
            ps.setInt(5, usu.getCodigo());
            usarDB.executeUpdate(usar);
            ps.executeUpdate();
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

    public ArrayList<UsuarioObj> visualizarUsuariosPorNiveles(ArrayList<UsuarioObj> arregloUsuario, UsuarioObj usuN) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String usar = "USE " + Bd.getNombreBD() + ";";
        String sql = "SELECT * FROM usuario WHERE nivel = ?";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            Statement usarDB = con.createStatement();

            statement.setString(1, usuN.getNivel());

            usarDB.executeUpdate(usar);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UsuarioObj usu = new UsuarioObj();
                usu.setCodigo(resultSet.getInt("codigo"));
                usu.setNivel(resultSet.getString("nivel"));
                usu.setNombre(resultSet.getString("nombre"));
                usu.setCorreo(resultSet.getString("correo"));
                usu.setContrasena(resultSet.getString("contrasena"));
                arregloUsuario.add(usu);
            }
        } catch (SQLException e) {
            System.err.println("Error metodo visualizarTodosLosUsuarios" + e);
        }
        return arregloUsuario;
    }

    public void eliminarUsuarioPorCodigo(UsuarioObj usu) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();

        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        String sql = "DELETE FROM usuario WHERE codigo = ?";
        String usar = "USE " + Bd.getNombreBD() + ";";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            Statement usarDB = con.createStatement();

            ps.setInt(1, usu.getCodigo());
            usarDB.executeUpdate(usar);
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
  public UsuarioObj buscarUsuariocorreo(UsuarioObj usuN) {
        Connection con = getConexion();
        LeerArchivoConfiguracionBd leer = new LeerArchivoConfiguracionBd();
        BDobj Bd = leer.ObjetoBdConfig();
        boolean resultadoEncontrado = false;
        if (Bd.getNombreBD() == null) {
            JOptionPane.showMessageDialog(null, "No se ha creado una base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        String usar = "USE " + Bd.getNombreBD() + ";";
        String sql = "SELECT * FROM usuario WHERE correo = ? AND contrasena = ?";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            Statement usarDB = con.createStatement();

            statement.setString(1, usuN.getCorreo());
            statement.setString(2, usuN.getContrasena());
            usarDB.executeUpdate(usar);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UsuarioObj usu = new UsuarioObj();
                usu.setCodigo(resultSet.getInt("codigo"));
                usu.setNivel(resultSet.getString("nivel"));
                usu.setNombre(resultSet.getString("nombre"));
                usu.setCorreo(resultSet.getString("correo"));
                usu.setContrasena(resultSet.getString("contrasena"));
                resultadoEncontrado = true;
            }
        } catch (SQLException e) {
            System.err.println("Error metodo BuscarPorCorreo" + e);
        }
        if (!resultadoEncontrado) {
            usuN = null;
        }
        return usuN;
    }
}
