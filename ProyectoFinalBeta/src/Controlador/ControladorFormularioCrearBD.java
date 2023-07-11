/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import Vista.FormularioCrearBD;
import java.awt.event.ActionListener;
import Modelo.BDobj;
import Modelo.CrearArchivoBaseDeDatos;
import Modelo.CrearBD;

/**
 *
 * @author jm0sp
 */
public class ControladorFormularioCrearBD implements ActionListener {

    FormularioCrearBD fb;
    BDobj bd;
    public ControladorFormularioCrearBD(FormularioCrearBD fb,BDobj bd) {
        this.fb = fb;
        this.bd = bd;
        fb.crearBase.addActionListener(this);
        fb.cancelar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fb.crearBase) {
            bd.setNombreBD(fb.nombreBDL.getText());
            bd.setUsuarioBD(fb.usuarioBdT.getText());
            bd.setContrasenaBD(fb.contrasenaBdT.getText());
            crear();
            new CrearArchivoBaseDeDatos(bd);
            fb.dispose();
        }
        if(e.getSource() == fb.cancelar){
            fb.dispose();
        }
    }
    
    void crear() {
        new CrearBD(fb);
    }
}
