/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalbeta;

import Modelo.*;
import Controlador.*;
import Vista.*;

public class Main {

    public static void main(String[] args) {
        //Inicio Ventana principal 
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        ControladorInicio cn = new ControladorInicio(menuPrincipal);
        cn.inicio();

        //Instancia de formularios
        FormularioCrearBD formulariocreardb = new FormularioCrearBD(null, true);
        EliminarBaseDeDatos eliminarBd = new EliminarBaseDeDatos(null, true);
        FormularioCrearUsuario formularioCrearUsuario = new FormularioCrearUsuario(null, true);
        FormularioModificarUsuario formularioModificarUsuario = new FormularioModificarUsuario(null, true);
        FormularioVisualizarEliminarUsuario formularioVisualizarEliminarUsuario = new FormularioVisualizarEliminarUsuario(null, true);
        FormularioIngresoVehiculos formularioIngresoVehiculos = new FormularioIngresoVehiculos(null, true);
        FormularioDetalleIngresoVehiculos detalleIngresoVehiculos = new FormularioDetalleIngresoVehiculos(null, true);
        FormularioDetalleIngresoVehiculos formularioDetalleIngresoVehiculos = new FormularioDetalleIngresoVehiculos(null, true);
        FormularioSalidaVehiculos formularioSalidaVehiculos = new FormularioSalidaVehiculos(null, true);
        FormularioValorHora formularioValorHora = new FormularioValorHora(null, true);
        FormularioValidarSalidaVehiculos formularioValidarSalidaVehiculos = new FormularioValidarSalidaVehiculos(null, true);
        FormularioBuscarFactura buscarFactura = new FormularioBuscarFactura(null,true);
        FormularioBuscarRegistros buscarRegistros = new FormularioBuscarRegistros(null, true);
        FormularioEditarRegistro editarRegistro = new FormularioEditarRegistro(null, true);
        FormularioLogeo formularioLogeo = new FormularioLogeo(null, true);
        //Instanciar Objetos de tipo base de datos
        UsuarioObj usu = new UsuarioObj();
        BDobj bd = new BDobj();
        ObjIngresoVehiculos objIngresoVehiculos = new ObjIngresoVehiculos();
        ObjTarifas objTarifas = new ObjTarifas();
        ObjFactura objFactura = new ObjFactura();
        //Instancia Consultas
        ConsultasUsuario consultasUsuario = new ConsultasUsuario();
        ConsultasIngresoVehiculoBd consultasIngresoVehiculoBd = new ConsultasIngresoVehiculoBd();
        ConsultasTarifas consultasTarifas = new ConsultasTarifas();
        ConsultasFactura consultasFactura = new ConsultasFactura();
        //Iniciar Controladores
        ControladorBarra cb = new ControladorBarra(formulariocreardb, eliminarBd, formularioCrearUsuario, formularioModificarUsuario, formularioVisualizarEliminarUsuario, formularioIngresoVehiculos,formularioSalidaVehiculos,formularioValorHora,buscarFactura,buscarRegistros,editarRegistro,formularioLogeo,menuPrincipal);
        ControladorFormularioCrearBD fcbd = new ControladorFormularioCrearBD(formulariocreardb, bd);
        ControladorFormularioEliminarBd controladorFormularioEliminarBd = new ControladorFormularioEliminarBd(eliminarBd, bd);
        ControladorFormularioCrearUsuario controladorFormularioCrearUsuario = new ControladorFormularioCrearUsuario(usu, formularioCrearUsuario, consultasUsuario);
        ControladorFormularioModificarUsuario controladorFormularioModificarUsuario = new ControladorFormularioModificarUsuario(formularioModificarUsuario, usu, consultasUsuario);
        ControladorFormularioVisualizar controladorFormularioVisualizar = new ControladorFormularioVisualizar(formularioVisualizarEliminarUsuario, usu, consultasUsuario);
        ControladorFormularioDetalleIngreso controladorFormularioDetallleIngreso = new ControladorFormularioDetalleIngreso(consultasIngresoVehiculoBd, objIngresoVehiculos, detalleIngresoVehiculos);
        ControladorFormularioIngresoVehiculo controladorFormularioIngresoVehiculo = new ControladorFormularioIngresoVehiculo(formularioIngresoVehiculos, objIngresoVehiculos, consultasIngresoVehiculoBd, detalleIngresoVehiculos, controladorFormularioDetallleIngreso);
        ControladorFormularioValidarSalida controladorFormularioValidarSalida = new ControladorFormularioValidarSalida(formularioValidarSalidaVehiculos, objFactura,consultasFactura,consultasUsuario,usu);
        ControladorFormularioSalidaVehiculos controladorSalidaVehiculos = new ControladorFormularioSalidaVehiculos(formularioSalidaVehiculos, objIngresoVehiculos, consultasIngresoVehiculoBd,formularioValidarSalidaVehiculos,consultasTarifas,objTarifas,controladorFormularioValidarSalida,objFactura);
        ControladorFormularioValorHora controladorFormularioValorHora = new ControladorFormularioValorHora(formularioValorHora, objTarifas, consultasTarifas);
        ControladorFormularioBuscarFactura controladorBuscarFactura = new ControladorFormularioBuscarFactura(buscarFactura, objFactura, consultasFactura);
        ControladorFormularioBuscarRegistro buscarRegistro = new ControladorFormularioBuscarRegistro(buscarRegistros, consultasFactura, objFactura,consultasUsuario,usu);
        ControladorFormularioEditarRegistro controladorFormularioEditarRegistro = new ControladorFormularioEditarRegistro(editarRegistro, consultasFactura, objFactura, consultasUsuario, usu);
        ControladorLogeo controladorLogeo = new ControladorLogeo(formularioLogeo, usu,consultasUsuario);
    } 
}
