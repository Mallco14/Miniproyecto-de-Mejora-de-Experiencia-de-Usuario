package hunt.software.gestionradios.Util;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBD {
    //Aqui falta completar los datos por temas de seguridad.
    public static final String BASE_URL ="jdbc:sqlserver://nombre_maquina\\SQLEXPRESS;database=nombre_databsae;encrypt=false";
    /**
     * Se recomienda en variables de entorno
     * **/
    public static final String USERNAME ="";
    public static final String PASSWORD ="";



    public Connection getConnection() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(BASE_URL, USERNAME, PASSWORD);
            if (conn != null) {
                //Muestra en consola, no relevantante
                System.out.println("Connect to Database");
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());


            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos : " + e.getMessage());
        }
        return conn;
    }



}
