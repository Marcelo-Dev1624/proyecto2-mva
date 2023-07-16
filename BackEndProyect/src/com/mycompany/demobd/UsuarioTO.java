/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demobd;

import java.io.Serializable;

/**
 *
 * @author laboratorio
 */
public class UsuarioTO implements Serializable {

    private String correo;
    private String clave;
    private String nombre;
    private String apellido;
    private String estado;
    private String rol;

    public UsuarioTO() {
    }

    public UsuarioTO(String correo, String clave,String rol) {
        this.correo = correo;
        this.clave = clave;
        this.rol = rol;
    }
    

    public UsuarioTO(String correo, String clave, String nombre, String apellido, String estado) {
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }
    

    public UsuarioTO(String correo, String nombre, String apellido, String estado) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public UsuarioTO(String correo, String clave, String nombre, String apellido, String estado, String rol) {
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.rol = rol;
    }
    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
