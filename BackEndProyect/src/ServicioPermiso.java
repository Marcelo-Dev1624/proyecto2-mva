
import com.mycompany.demobd.ICrud;
import com.mycompany.demobd.PermisoTO;
import com.mycompany.demobd.Servicio;
import com.mycompany.demobd.UsuarioTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lulu
 */
public class ServicioPermiso extends Servicio implements ICrud<PermisoTO> {
    
    public void insertar(PermisoTO permisoTO) throws SQLException, Exception {

        PreparedStatement ps = null;
        Connection conn = super.getConection();
        try {

            ps = super.getConection().prepareStatement("INSERT INTO `proyecto2`.`TICKET` (`tipo`, `motivo`, `remitente`, `receptor`, `estado`) VALUES (?, ?, ?, ?, ?)");
            //ps.setInt(1, permisoTO.getNumTicket());
            ps.setString(1, permisoTO.getTipo());
            ps.setString(2, permisoTO.getMotivo());
            ps.setString(3, permisoTO.getRemitente());
            ps.setString(4, permisoTO.getReceptor());
            ps.setString(5, "pendiente");
            ps.executeUpdate();

        } catch (Exception e) {

        } finally {

            super.cerrar(ps);
            super.cerrar(conn);
        }
    }
    
    public List<PermisoTO> demePermisosReceptor(String receptor) throws SQLException, Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = super.getConection();

        List<PermisoTO> retorno = new ArrayList<PermisoTO>();
        try {
            ps = getConection().prepareStatement("SELECT * FROM TICKET WHERE RECEPTOR = ? ");
            ps.setString(1, receptor);
            rs = ps.executeQuery();
            while (rs.next()) {

                int numTicket = rs.getInt("numTicket");
                String tipo = rs.getString("tipo");
                String motivo = rs.getString("motivo");
                String remitente = rs.getString("remitente");
                //String receptor1 = rs.getString("receptor");
                String estado = rs.getString("estado");
                PermisoTO permisoTO = new PermisoTO(numTicket, tipo, motivo, remitente, receptor, estado);
                retorno.add(permisoTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.cerrar(conn);
            super.cerrar(rs);
            super.cerrar(ps);
        }
        return retorno;

    }
    public List<PermisoTO> demePermisosRemitente(String remitente) throws SQLException, Exception {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = super.getConection();

        List<PermisoTO> retorno = new ArrayList<PermisoTO>();
        try {
            ps = getConection().prepareStatement("SELECT numTicket, tipo, motivo, receptor, estado FROM TICKET WHERE REMITENTE = ? ");
            ps.setString(1, remitente);
            rs = ps.executeQuery();
            while (rs.next()) {

                int numTicket = rs.getInt("numTicket");
                String tipo = rs.getString("tipo");
                String motivo = rs.getString("motivo");
                //String remitente = rs.getString("remitente");
                String receptor = rs.getString("receptor");
                String estado = rs.getString("estado");
                PermisoTO permisoTO = new PermisoTO(numTicket, tipo, motivo, remitente, receptor, estado);
                retorno.add(permisoTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            super.cerrar(conn);
            super.cerrar(rs);
            super.cerrar(ps);
        }
        return retorno;

    }

    public void aprobar(int numTicket) throws SQLException, Exception {

        PreparedStatement ps = null;
        Connection conn = super.getConection();
        try {

            ps = super.getConection().prepareStatement("UPDATE proyecto2.ticket SET estado = 'aprobado' WHERE numTicket = ?");
            ps.setInt(1, numTicket);
            ;
            

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            super.cerrar(ps);
            super.cerrar(conn);
        }
    }
    
    public void rechazar(int numTicket) throws SQLException, Exception {

        PreparedStatement ps = null;
        Connection conn = super.getConection();
        try {

            ps = super.getConection().prepareStatement("UPDATE proyecto2.ticket SET estado = 'rechazado' WHERE numTicket = ?");
            ps.setInt(1, numTicket);
            ;
            

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            super.cerrar(ps);
            super.cerrar(conn);
        }
    }
}
