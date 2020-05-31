
package daoproyecto;
import accesodatosserver.Conexiono;
import entidadesproyecto.Clienteo;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOClienteo {
    public void Registro (Clienteo cliente) throws Exception{
        Conexiono cn;
        Connection con = null;
        Statement st = null;
        String sql = "insert into CLIENTE (ID_CLIENTE, NOMBRE, APELLIDO, NIT, DIRECCION, TELEFONO)"
                + "values ( '" + cliente.getCliente() + "','"
                + cliente.getNombre() + "','"
                + cliente.getApellido() + "','"
                + cliente.getNit() + "','"
                + cliente.getDireccion() + "','"
                + cliente.getTelefono() + "')";
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
    
    public List<Clienteo> listar() throws Exception {
        List<Clienteo> clientes = null;
        Clienteo cli;
        Conexiono cn;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select ID_CLIENTE, NOMBRE, APELLIDO, NIT, DIRECCION, TELEFONO from CLIENTE order by NOMBRE";
        
        cn = new Conexiono();
        try {
            con = cn.conectaro();
            st = con.createStatement();
            rs = st.executeQuery(sql);
            clientes = new ArrayList<>();
            while (rs.next() == true){
                cli = new Clienteo();
                cli.setCliente(rs.getInt("ID_CLIENTE"));
                cli.setNombre(rs.getString("NOMBRE"));
                cli.setApellido(rs.getString("APELLIDO"));
                cli.setNit(rs.getString("NIT"));
                cli.setDireccion(rs.getString("DIRECCION"));
                cli.setTelefono(rs.getInt("TELEFONO"));
                
                clientes.add(cli);
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
        return clientes;
        
    }
    
        public Clienteo leer(Clienteo clientes) throws Exception {
        Clienteo cli = null;
        Conexiono cn;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String sql = "select NOMBRE, APELLIDO, NIT, DIRECCION, TELEFONO from CLIENTE where ID_CLIENTE = " + clientes.getCliente();

        cn = new Conexiono();
        try {
            con = cn.conectaro();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next() == true) {
                cli = new Clienteo();
                cli.setCliente(clientes.getCliente());
                cli.setNombre(rs.getString("NOMBRE"));
                cli.setApellido(rs.getString("APELLIDO"));
                cli.setNit(rs.getString("NIT"));
                cli.setDireccion(rs.getString("DIRECCION"));
                cli.setTelefono(rs.getInt("TELEFONO"));
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
        return cli;
    }

    public void actualizar(Clienteo cli) throws Exception {
        Conexiono cn;
        Connection con = null;
        Statement st = null;
        String sql;

        sql = "update CLIENTE set NOMBRE = '" + cli.getNombre()
                + "', APELLIDO = '" + cli.getApellido()
                + "', NIT = '" + cli.getNit()
                + "', DIRECCION = '" + cli.getDireccion()
                + "', TELEFONO = '" + cli.getTelefono()
                + "' where ID_CLIENTE = " + cli.getCliente();

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
