/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author jm0sp
 */
public class LeerArchivoLogeo {

    UsuarioObj usu= new UsuarioObj();

    public UsuarioObj ObjetoLogeo() {
        File f = new File("usuarioLogeado.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                String linea = br.readLine();
                String[] atributos = linea.split("/");

                String correo = atributos[0];
                String contraseña = atributos[1];
                
                usu.setCorreo(correo);
                usu.setContrasena(contraseña);
                
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return usu;
    }
}
