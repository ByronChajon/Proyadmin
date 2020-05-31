package daoproyecto;

import accesodatosserver.Conexion;
import entidadesproyecto.Cliente;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOCliente {

    public void Registrar(Cliente cliente) throws Exception {
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql = "insert into CLIENTE (NOMBRE, APELLIDO, NIT, DIRECCION, TELEFONO)"
                + "values ( '" + cliente.getNombre() + "','"
                + cliente.getApellido() + "','"
                + cliente.getNit() + "','"
                + cliente.getDireccion() + "','"
                + cliente.getTelefono() + "')";
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

    public List<Cliente> listar() throws Exception {
        List<Cliente> clientes = null;
        Cliente cli;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "Select ID_CLIENTE, NOMBRE, APELLIDO, NIT, DIRECCION, TELEFONO from CLIENTE order by NOMBRE";

        con = new Conexion();
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            clientes = new ArrayList<>();
            while (rs.next() == true) {
                cli = new Cliente();
                cli.setCliente(rs.getInt("ID_CLIENTE"));
                cli.setNombre(rs.getString("NOMBRE"));
                cli.setApellido(rs.getString("APELLIDO"));
                cli.setNit(rs.getString("NIT"));
                cli.setDireccion(rs.getString("DIRECCION"));
                cli.setTelefono(rs.getInt("TELEFONO"));

                clientes.add(cli);
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
        return clientes;

    }

    public Cliente leer(Cliente clientes) throws Exception {
        Cliente cli = null;
        Conexion con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        String sql = "select NOMBRE, APELLIDO, NIT, DIRECCION, TELEFONO from CLIENTE where ID_CLIENTE = " + clientes.getCliente();

        con = new Conexion();
        try {
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next() == true) {
                cli = new Cliente();
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
            if (cn != null && cn.isClosed() == false) {
                cn.close();
            }
            cn = null;
        }
        return cli;
    }

    public void actualizar(Cliente cli) throws Exception {
        Conexion con;
        Connection cn = null;
        Statement st = null;
        String sql;

        sql = "update CLIENTE set NOMBRE = '" + cli.getNombre()
                + "', APELLIDO = '" + cli.getApellido()
                + "', NIT = '" + cli.getNit()
                + "', DIRECCION = '" + cli.getDireccion()
                + "', TELEFONO = '" + cli.getTelefono()
                + "' where ID_CLIENTE = " + cli.getCliente();

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
