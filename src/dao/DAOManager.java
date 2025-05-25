package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOManager {

    private Connection connection=null;
    private final String URL="";
    private final String user="root";
    private final String pass="root";

    /**
     * Abre la base de datos
     * @author anaOrCam
     */
    public void open(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cierra la base de datos
     * @author anaOrCam
     */
    public void close(){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Ejecuta las sentencias SQL para hacer cambios en la base de datos del proyecto
     * @author anaOrCam
     * @return true si la sentencia de ejecuta y false si no se ejecuta.
     */
    public boolean ejecutaSentencia(String SentenciaSql){
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(SentenciaSql);
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Getter de la conexión
     * @author anaOrCam
     * @return devuelve el objeto Connection de la base de datos
     */
    public Connection getConnection (){
        return connection;
    }
}
