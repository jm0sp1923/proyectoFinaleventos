/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author jm0sp
 */
public class CrearArchivoBaseDeDatos {

    public CrearArchivoBaseDeDatos(BDobj bd) {
        try {
            FileWriter f = new FileWriter("configuracionBaseDatos.txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print(bd.getNombreBD()+ "/");
            pw.print(bd.getUsuarioBD()+ "/");
            pw.print(bd.getContrasenaBD()+ "/");
            pw.println();
            pw.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
