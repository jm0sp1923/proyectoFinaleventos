/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;



import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorBarra implements ActionListener {

    FormularioCrearBD formulariocrardb;
    EliminarBaseDeDatos eliminarBd;
    FormularioCrearUsuario formularioCrearUsuario;
    FormularioModificarUsuario formularioModificarUsuario;
    FormularioVisualizarEliminarUsuario formularioVisualizarEliminarUsuario;
    FormularioIngresoVehiculos formularioIngresoVehiculos;
    FormularioSalidaVehiculos formularioSalidaVehiculos;
    FormularioValorHora formularioValorHora;
    FormularioBuscarFactura buscarFactura;
    FormularioBuscarRegistros buscarRegistros;
    FormularioEditarRegistro editarRegistro;
    FormularioLogeo formularioLogeo;
    MenuPrincipal menu;

    public ControladorBarra(FormularioCrearBD formulariocreardb, EliminarBaseDeDatos eliminarBd,
            FormularioCrearUsuario formularioCrearUsuario, FormularioModificarUsuario formularioModificarUsuario,
            FormularioVisualizarEliminarUsuario formularioVisualizarEliminarUsuario,
            FormularioIngresoVehiculos formularioIngresoVehiculos, FormularioSalidaVehiculos formularioSalidaVehiculos,
            FormularioValorHora formularioValorHora, FormularioBuscarFactura buscarFactura,
            FormularioBuscarRegistros buscarRegistros, FormularioEditarRegistro editarRegistro,
            FormularioLogeo  formularioLogeo,
            MenuPrincipal menu) {

        //Inicializar vistas
        this.formulariocrardb = formulariocreardb;
        this.eliminarBd = eliminarBd;
        this.formularioCrearUsuario = formularioCrearUsuario;
        this.formularioModificarUsuario = formularioModificarUsuario;
        this.formularioVisualizarEliminarUsuario = formularioVisualizarEliminarUsuario;
        this.formularioIngresoVehiculos = formularioIngresoVehiculos;
        this.formularioSalidaVehiculos = formularioSalidaVehiculos;
        this.formularioValorHora = formularioValorHora;
        this.buscarFactura = buscarFactura;
        this.buscarRegistros = buscarRegistros;
        this.editarRegistro = editarRegistro;
        this.formularioLogeo = formularioLogeo;
        this.menu = menu;

        //Agregar Actions a los botones
        this.menu.crearBaseDedatos.addActionListener(this);
        this.menu.EliminarBaseDedatos.addActionListener(this);
        this.menu.crearUsuario.addActionListener(this);
        this.menu.modificarUsuario.addActionListener(this);
        this.menu.visualizar.addActionListener(this);
        this.menu.ingresar.addActionListener(this);
        this.menu.salida.addActionListener(this);
        this.menu.valorHora.addActionListener(this);
        this.menu.buscarFactura.addActionListener(this);
        this.menu.buscarRegsitros.addActionListener(this);
        this.menu.modificarRegistros.addActionListener(this);
        this.menu.iniciarSesion.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.crearBaseDedatos) {
            iniciarFormularioBD();
        }
        if (e.getSource() == menu.EliminarBaseDedatos) {
            eliminarBD();
        }
        if (e.getSource() == menu.crearUsuario) {
            iniciarFomularioCrearUsuario();
        }
        if (e.getSource() == menu.modificarUsuario) {
            iniciarFormularioModificarUsuario();
        }
        if (e.getSource() == menu.visualizar) {
            iniciarVisualizarEliminarUsuario();
        }
        if (e.getSource() == menu.salida) {
            iniciarSalidaVehiculo();
        }
        if (e.getSource() == menu.ingresar) {
            iniciarIngresoVehiculo();
        }
        if (e.getSource() == menu.valorHora) {
            iniciarValorHora();
        }
        if (e.getSource() == menu.buscarFactura) {
            iniciarBuscarFactura();
        }
        if (e.getSource() == menu.buscarRegsitros) {
            iniciarBuscarRegistros();
        }
        if(e.getSource() == menu.modificarRegistros){
            iniciarModificarRegistro();
        }
        if(e.getSource() == menu.iniciarSesion){
            iniciarLogeo();
        }

    }

    public void iniciarFormularioBD() {
        formulariocrardb.setTitle("Crear base de datos");
        formulariocrardb.setSize(350, 220);
        formulariocrardb.setVisible(true);
    }

    public void eliminarBD() {
        eliminarBd.setTitle("Crear base de datos");
        eliminarBd.setSize(380, 120);
        eliminarBd.setVisible(true);
    }

    public void iniciarFomularioCrearUsuario() {
        reiniciarCampoCrearUsuario();
        formularioCrearUsuario.setTitle("Crear usuario");
        formularioCrearUsuario.setSize(300, 300);
        formularioCrearUsuario.setVisible(true);

    }

    public void reiniciarCampoCrearUsuario() {
        formularioCrearUsuario.nivelcombo.setSelectedIndex(0);
        formularioCrearUsuario.nombreT.setText("");
        formularioCrearUsuario.correoT.setText("");
        formularioCrearUsuario.contrasenaT.setText("");
    }

    public void iniciarFormularioModificarUsuario() {
        reiniciarCamposModificarUsuario();
        formularioModificarUsuario.setTitle("Modificar usuario");
        formularioModificarUsuario.setSize(300, 330);
        formularioModificarUsuario.setVisible(true);
    }

    public void reiniciarCamposModificarUsuario() {
        formularioModificarUsuario.codigoT.setText("");
        formularioModificarUsuario.nivelcombo.setSelectedIndex(0);
        formularioModificarUsuario.nombreT.setText("");
        formularioModificarUsuario.correoT.setText("");
        formularioModificarUsuario.contrasenaT.setText("");
    }

    public void iniciarVisualizarEliminarUsuario() {
        formularioVisualizarEliminarUsuario.setTitle("Eliminar usuario");
        formularioVisualizarEliminarUsuario.setSize(490, 500);
        formularioVisualizarEliminarUsuario.setVisible(true);
    }

    public void iniciarIngresoVehiculo() {
        formularioIngresoVehiculos.setTitle("Ingreso vehiculo");
        formularioIngresoVehiculos.setSize(430, 400);
        formularioIngresoVehiculos.setVisible(true);
    }

    public void iniciarSalidaVehiculo() {
        formularioSalidaVehiculos.setTitle("Salida vehiculos");
        formularioSalidaVehiculos.setSize(300, 160);
        formularioSalidaVehiculos.setVisible(true);
    }

    public void iniciarValorHora() {
        formularioValorHora.setTitle("Valor hora");
        formularioValorHora.setSize(260, 220);
        formularioValorHora.setVisible(true);
    }

    public void iniciarBuscarFactura() {
        buscarFactura.setTitle("Buscar factura");
        buscarFactura.setSize(330, 410);
        buscarFactura.setVisible(true);
    }

    public void iniciarBuscarRegistros() {
        buscarRegistros.setTitle("Buscar registros");
        buscarRegistros.setSize(820, 500);
        buscarRegistros.setVisible(true);
    }
    
    public void iniciarModificarRegistro(){
        editarRegistro.setTitle("Editar registros");
        editarRegistro.setSize(820, 500);
        editarRegistro.setVisible(true);
    }
    
    public void iniciarLogeo(){
        formularioLogeo.setTitle("Logeo");
        formularioLogeo.setSize(260, 180);
        formularioLogeo.setVisible(true);

    }
    

}
