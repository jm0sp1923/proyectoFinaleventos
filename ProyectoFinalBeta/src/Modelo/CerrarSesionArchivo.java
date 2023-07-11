/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jm0sp
 */
public class CerrarSesionArchivo {

    public void vaciarArchivo() {
        try {
            FileWriter archivo = new FileWriter("usuarioLogeado.txt");
            archivo.write("");
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
