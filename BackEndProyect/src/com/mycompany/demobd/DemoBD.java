/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.demobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laboratorio
 */
public class DemoBD {

    private static Connection conn = null;

    public static void main(String[] args) {
        try {
            UsuarioTO usuarioTO_1 = new UsuarioTO("test", "Jose Andres","admin");
            //insertar(usuarioTO_1);

            //usuarioTO_1 = new UsuarioTO(6, "Mariana");
            //insertar(usuarioTO_1);
            //usuarioTO_1 = new UsuarioTO(1, "CARLOS");
            modificar(usuarioTO_1);

            //usuarioTO_1 = new UsuarioTO(5, "Carlos");
            eliminar(usuarioTO_1);
            List<UsuarioTO> listaRetorno = demeUsuarios();
            for (UsuarioTO usuarioTO : listaRetorno) {
                System.out.println("ID: " + usuarioTO.getCorreo() + " Nombre: " + usuarioTO.getClave());
            }

        //    System.out.println("Este es el nombre: " + demeUsuario().getNombre());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                    conn = null;
                }
            } catch (Exception e) {
            }
        }

    }

    public static Connection getConection() throws Exception {
        //Paso 1       

        try {
            if (conn != null && !conn.isClosed()) {
                return conn;

            } else {
                //Paso 1
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Paso 2
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root", "root", "root");
                System.out.println("CONEXION: " + conn);

            }
        } catch (Exception e) {
        }

        return conn;
    }

    public static void insertar(UsuarioTO usuarioTO) {

        PreparedStatement ps = null;
        try {
            ps = getConection().prepareStatement("INSERT INTO usuario VALUES(?,?)");
            ps.setString(1, usuarioTO.getCorreo());
            ps.setString(2, usuarioTO.getClave());
            ps.executeUpdate();

        } catch (Exception e) {
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception e) {
            }
        }
    }

    public static void modificar(UsuarioTO usuarioTO) {

        PreparedStatement ps = null;
        try {
            ps = getConection().prepareStatement(
                    "UPDATE proyecto2.usuario SET nombre = ? WHERE id = ?");
            ps.setString(2, usuarioTO.getCorreo());
            ps.setString(1, usuarioTO.getClave());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception e) {
            }

        }

    }

    public static void eliminar(UsuarioTO usuarioTO) {

        PreparedStatement ps = null;
        try {
            ps = getConection().prepareStatement(
                    "DELETE FROM usuario WHERE id = VALUE(?); ");
            ps.setString(1, usuarioTO.getCorreo());
            ps.executeQuery();

        } catch (Exception e) {
        } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception e) {
            }

        }

    }

    public static List<UsuarioTO> demeUsuarios() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UsuarioTO> retorno = new ArrayList<UsuarioTO>();
        try {
            ps = getConection().prepareStatement("SELECT ID,NOMBRE FROM USUARIO");
            rs = ps.executeQuery();
            while (rs.next()) {

                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                
                //UsuarioTO usuarioTO = new UsuarioTO(id, nombre, rol);
                //retorno.add(usuarioTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception e) {
            }
        }
        return retorno;

    }

    public static UsuarioTO demeUsuario(String pk) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        UsuarioTO retorno = null;
        try {
            ps = getConection().prepareStatement("SELECT ID,NOMBRE FROM USUARIO WHERE id = ?");
            ps.setString(1, pk);
            rs = ps.executeQuery();
            if (rs.next()) {

                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
               // retorno = new UsuarioTO(id, nombre);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                    rs = null;
                }
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                    ps = null;
                }
            } catch (Exception e) {
            }
        }
        return retorno;

    }

}
