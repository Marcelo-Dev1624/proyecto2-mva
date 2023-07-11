/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demobd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lulu
 */
public class UsuarioService {

    private List<UsuarioTO> usuarios;

    
    
    public List<UsuarioTO> getProducts() {
        return new ArrayList<>(usuarios);
    }
    
    

}
