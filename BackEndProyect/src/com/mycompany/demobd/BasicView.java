/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demobd;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Lulu
 */
public class BasicView implements Serializable{
    
    private List<UsuarioTO> usuarios;
    
    private UsuarioService service;
    
    @PostConstruct
    public void init(){
    }
}
