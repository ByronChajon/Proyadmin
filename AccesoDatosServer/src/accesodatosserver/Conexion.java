package accesodatosserver;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String cadenaConexion = "jdbc:sqlserver://localhost;"+
            "databaseName=PROYECTOADMIN;user=sa;password=12345;";
    
    public Connection conectar() throws Exception{
        Connection cn=null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(cadenaConexion);
        }catch (Exception e){
    throw e;
    }finally{
}
    return cn;
}
}
