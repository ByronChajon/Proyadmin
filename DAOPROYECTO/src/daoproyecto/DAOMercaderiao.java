
package daoproyecto;
import accesodatosserver.Conexiono;
import entidadesproyecto.Mercaderiao;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOMercaderiao {
    public void Registro (Mercaderiao mercaderia) throws Exception{
        Conexiono cn;
        Connection con = null;
        Statement st = null;
                String sql = "insert into MERCADERIA (ID_PRODUCTO, PRODUCTO, PRESENTACION, PRECIO)"
                + "values ( '" + mercaderia.getCodigoproducto() + "','"
                + mercaderia.getProducto() + "','"
                + mercaderia.getPresentacion() + "','"
                + mercaderia.getPrecio() +  "')";
        cn = new Conexiono();
        try{
            con= cn.conectaro();
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e){
            throw e;
        }finally {
            if (st != null && st.isClosed() == false){
                st.close();
            }
            st = null;
            if (con != null && con.isClosed() == false){
                con.close();
            }
            con = null;
        }
        
    }
    
        public List<Mercaderiao> listar() throws Exception {
        List<Mercaderiao> mercaderias = null;
        Mercaderiao mer;
        Conexiono cn;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select ID_PRODUCTO, PRODUCTO, PRESENTACION, PRECIO from MERCADERIA order by PRODUCTO";
        
        cn = new Conexiono();
        try {
            con = cn.conectaro();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            mercaderias = new ArrayList<>();
            while (rs.next() == true){
                mer = new Mercaderiao();
                mer.setCodigoproducto(rs.getInt("ID_PRODUCTO"));
                mer.setProducto(rs.getString("PRODUCTO"));
                mer.setPresentacion(rs.getString("PRESENTACION"));
                mer.setPrecio(rs.getInt("PRECIO"));
                
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
        if (con != null && con.isClosed() == false){
            con.close();
        }
        con = null;
    }
        return mercaderias;
        
    }
    
        public Mercaderiao leer(Mercaderiao mercaderias) throws Exception {
        Mercaderiao mer = null;
        Conexiono cn;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String sql = "select PRODUCTO, PRESENTACION, PRECIO from MERCADERIA where ID_PRODUCTO = " + mercaderias.getCodigoproducto();

        cn = new Conexiono();
        try {
            con = cn.conectaro();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next() == true) {
                mer = new Mercaderiao();
                mer.setCodigoproducto(mercaderias.getCodigoproducto());
                mer.setProducto(rs.getString("PRODUCTO"));
                mer.setPresentacion(rs.getString("PRESENTACION"));
                mer.setPrecio(rs.getInt("PRECIO"));
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
            if (con != null && con.isClosed() == false) {
                con.close();
            }
            con = null;
        }
        return mer;
    }

    public void actualizar(Mercaderiao mer) throws Exception {
        Conexiono cn;
        Connection con = null;
        Statement st = null;
        String sql;

        sql = "update MERCADERIA set PRODUCTO = '" + mer.getProducto()
                + "', PRESENTACION = '" + mer.getPresentacion()
                + "', PRECIO = '" + mer.getPrecio()
                + "' where ID_PRODUCTO = " + mer.getCodigoproducto();
        cn = new Conexiono();
        try {
            con = cn.conectaro();
            st = con.createStatement();
            st.executeUpdate(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            if (st != null && st.isClosed() == false) {
                st.close();
            }
            st = null;
            if (con != null && con.isClosed() == false) {
                con.close();
            }
            con = null;
        }
    }   
        
}
