package daoproyecto;

import accesodatosserver.Conexion;
import entidadesproyecto.Detalle;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAODetalle {

    public void Registrar(Detalle detalle) throws Exception {
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql = "insert into DETALLE (UNIDADES, ID_PRODUCTO, SUBTOTAL, ID_VENTA)"
                + "values ( '" + detalle.getUnidades() + "','"
                + detalle.getCodigoproducto() + "','"
                + detalle.getSubtotal() + "','"
                + detalle.getVenta() + "')";
        con = new Conexion();
        try {
            cn = con.conectar();
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            if (st != null && st.isClosed() == false) {
                st.close();
            }
            st = null;
            if (cn != null && cn.isClosed() == false) {
                cn.close();
            }
            cn = null;
        }

    }

    public List<Detalle> listar() throws Exception {
        List<Detalle> detalles = null;
        Detalle det;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select ID_DETALLE, UNIDADES, ID_PRODUCTO, SUBTOTAL, ID_VENTA from DETALLE"; //AGREGAR WHERE

        con = new Conexion();
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            detalles = new ArrayList<>();
            while (rs.next() == true) {
                det = new Detalle();
                det.setDetalle(rs.getInt("ID_DETALLE"));
                det.setUnidades(rs.getInt("UNIDADES"));
                //det.setCodigoproducto(Mercaderia.mercaderias(rs.getInt("ID_PRODUCTO")));
                det.setSubtotal(rs.getDouble("PRECIO"));

                detalles.add(det);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null && rs.isClosed() == false) {
                rs.close();
            }
            rs = null;
            if (st != null && st.isClosed() == false) {
                st.close();
            }
            st = null;
            if (cn != null && cn.isClosed() == false) {
                cn.close();
            }
            cn = null;
        }
        return detalles;

    }

    public Detalle leer(Detalle detalles) throws Exception {
        Detalle det = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        String sql = "select UNIDADES, ID_PRODUCTO, SUBTOTAL,ID_VENTA from MERCADERIA where ID_DETALLE = " + detalles.getDetalle();

        con = new Conexion();
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next() == true) {
                det = new Detalle();
                det.setDetalle(detalles.getDetalle());
                det.setUnidades(rs.getInt("UNIDADES"));
                //det.setCodigoproducto(rs.getInt("ID_PRODUCTO"));
                det.setSubtotal(rs.getDouble("SUBTOTAL"));
                //det.setVenta(rs.getInt("ID_VENTA"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null && rs.isClosed() == false) {
                rs.close();
            }
            rs = null;
            if (st != null && st.isClosed() == false) {
                st.close();
            }
            st = null;
            if (cn != null && cn.isClosed() == false) {
                cn.close();
            }
            cn = null;
        }
        return det;
    }

}
