/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 *
 * @author jm0sp
 */
public class MenuPrincipal extends JFrame {

    public JMenuBar barra;
    public JMenu baseDeDatos, login, usuario, vehiculos;
    public JMenuItem crearBaseDedatos, EliminarBaseDedatos, iniciarSesion, cerrarSesion, crearUsuario, modificarUsuario,
            visualizar, ingresar, salida, buscarRegsitros, modificarRegistros, buscarFactura, valorHora;

    public MenuPrincipal() {

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        barra = new JMenuBar();

        baseDeDatos = new JMenu("Base de datos");
        login = new JMenu("Login");
        usuario = new JMenu("Usuario");
        vehiculos = new JMenu("Vehiculos");

        crearBaseDedatos = new JMenuItem("Crear base de datos");
        EliminarBaseDedatos = new JMenuItem("Eliminar base de datos");
        iniciarSesion = new JMenuItem("Inicar sesion");
        cerrarSesion = new JMenuItem("Cerrar sesion");
        crearUsuario = new JMenuItem("Crear usuario");
        modificarUsuario = new JMenuItem("Modificar");
        visualizar = new JMenuItem("Visualizar/elminar");
        ingresar = new JMenuItem("Ingresar");
        salida = new JMenuItem("Salida");
        buscarRegsitros = new JMenuItem("Buscar registros");
        modificarRegistros = new JMenuItem("Modificar registros");
        buscarFactura = new JMenuItem("Buscar facturas");
        valorHora = new JMenuItem("Valor hora");

        baseDeDatos.add(crearBaseDedatos);
        baseDeDatos.add(EliminarBaseDedatos);

        login.add(iniciarSesion);
        login.add(cerrarSesion);

        usuario.add(crearUsuario);
        usuario.add(modificarUsuario);
        usuario.add(visualizar);

        vehiculos.add(ingresar);
        vehiculos.add(salida);
        vehiculos.add(buscarRegsitros);
        vehiculos.add(modificarRegistros);
        vehiculos.add(buscarFactura);
        vehiculos.add(valorHora);

        barra.add(baseDeDatos);
        barra.add(login);
        barra.add(usuario);
        barra.add(vehiculos);
     
    }
}