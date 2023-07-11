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
public class CrearArchivoLogeo {
    public CrearArchivoLogeo(UsuarioObj usu) {
        try {
            FileWriter f = new FileWriter("usuarioLogeado.txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print(usu.getCorreo()+ "/");
            pw.print(usu.getContrasena()+ "/");
            pw.println();
            pw.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
