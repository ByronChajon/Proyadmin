
package daoproyecto;

import accesodatosserver.Conexion;
import entidadesproyecto.Venta;
import java.sql.Connection;
import java.sql.Statement;

public class DAOVenta {
    
    public void Registrar (Venta venta) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql = "insert into VENTA (ID_CLIENTE, FECHA, TOTAL)"
                + "values ( '" + venta.getCliente() + "','"
                + venta.getFecha() + "','"
                + venta.getTotal() + "')";
        con = new Conexion();
        try{
            cn= con.conectar();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e){
            throw e;
        }finally {
            if (st != null && st.isClosed() == false){
                st.close();
            }
            st = null;
            if (cn != null && cn.isClosed() == false){
                cn.close();
            }
            cn = null;
        }
        
    }
}
