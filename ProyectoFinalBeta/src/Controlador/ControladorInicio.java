/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.MenuPrincipal;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


/**
 *
 * @author jm0sp
 */
public class ControladorInicio{
    
    MenuPrincipal menu;

    public ControladorInicio(MenuPrincipal menu) {
        this.menu = menu;
    }
   
    public void inicio() {
        //menu.setLocationRelativeTo(null);
        menu.setTitle("PARQUEADERO");
        menu.setJMenuBar(menu.barra);
        menu.setResizable(false);
        menu.setSize(400, 400);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu.setVisible(true);
    }    
}
