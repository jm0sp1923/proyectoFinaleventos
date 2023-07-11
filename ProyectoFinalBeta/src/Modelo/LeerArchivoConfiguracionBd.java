/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;


public class LeerArchivoConfiguracionBd {

    BDobj bdObj = new BDobj();  
    public BDobj ObjetoBdConfig(){ 
        File f = new File("configuracionBaseDatos.txt");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {
                String linea = br.readLine();
                String[] atributos = linea.split("/");

                String nombreBd = atributos[0];
                //String usuario = atributos[1];
                //String contrasena = atributos[2];

                
                 bdObj.setNombreBD(nombreBd);
                //usu.setUsuarioBD(usuario);
                //usu.setContrasenaBD(contrasena); 
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return  bdObj;
    }
}
