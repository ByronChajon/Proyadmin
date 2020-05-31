
package accesodatosserver;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexiono {
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "BYR";
    private String pass = "12345";
    
    public Connection conectaro() throws Exception{
        Connection con=null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
    throw e;
    }finally{
}
    return con;
}    
}
