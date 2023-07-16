/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.demobd;

/**
 *
 * @author Lulu
 */
public class TesterServicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServicioUsuario su = new ServicioUsuario();
            for (UsuarioTO u : su.demeUsuarios()) {
                System.out.println("Nombre: "+ u.getClave());
                
            }
        } catch (Exception e) {
        }
    }
    
}
