
package daoproyecto;

import accesodatosserver.Conexion;
import entidadesproyecto.Mercaderia;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOMercaderia {
    
    public void Registrar (Mercaderia mercaderia) throws Exception{
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql = "insert into MERCADERIA (PRODUCTO, PRESENTACION, PRECIO)"
                + "values ( '" + mercaderia.getProducto() + "','"
                + mercaderia.getPresentacion() + "','"
                + mercaderia.getPrecio() + "')";
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
    
    public List<Mercaderia> listar() throws Exception {
        List<Mercaderia> mercaderias = null;
        Mercaderia mer;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select ID_PRODUCTO, PRODUCTO, PRESENTACION, PRECIO from MERCADERIA order by PRODUCTO";
        
        con = new Conexion();
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            mercaderias = new ArrayList<>();
            while (rs.next() == true){
                mer = new Mercaderia();
                mer.setCodigoproducto(rs.getInt("ID_PRODUCTO"));
                mer.setProducto(rs.getString("PRODUCTO"));
                mer.setPresentacion(rs.getString("PRESENTACION"));
                mer.setPrecio(rs.getDouble("PRECIO"));
                
                mercaderias.add(mer);
            }
        }catch (Exception e){
            throw e;
        } finally {
        if (rs != null && rs.isClosed() == false){
            rs.close();
        }
        rs = null;
        if (st != null && st.isClosed() == false){
            st.close();
        }
        st = null;
        if (cn != null && cn.isClosed() == false){
            cn.close();
        }
        cn = null;
    }
        return mercaderias;
        
    }
     public Mercaderia leer(Mercaderia mercaderias) throws Exception {
        Mercaderia mer = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        String sql = "select PRODUCTO, PRESENTACION, PRECIO from MERCADERIA where ID_PRODUCTO = " + mercaderias.getCodigoproducto();

        con = new Conexion();
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next() == true) {
                mer = new Mercaderia();
                mer.setCodigoproducto(mercaderias.getCodigoproducto());
                mer.setProducto(rs.getString("PRODUCTO"));
                mer.setPresentacion(rs.getString("PRESENTACION"));
                mer.setPrecio(rs.getDouble("PRECIO"));
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
        return mer;
    }

    public void actualizar(Mercaderia mer) throws Exception {
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;

        sql = "update MERCADERIA set PRODUCTO = '" + mer.getProducto()
                + "', PRESENTACION = '" + mer.getPresentacion()
                + "', PRECIO = '" + mer.getPrecio()
                + "' where ID_PRODUCTO = " + mer.getCodigoproducto();
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
}
