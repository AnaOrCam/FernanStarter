package controlador;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAOManager implements Serializable {

    private Connection connection=null;
    private String url;
    private String user;
    private String pass;
    private static DAOManager singleton;

    /**
     * Constructor del objeto DAOManager
     * @author anaOrCam
     */
    private DAOManager(){
        try{
            Properties properties=new Properties();
            properties.load(new FileReader("./src/datos/setup.properties"));
            connection=null;
            url= properties.getProperty("URL_BBDD");
            user= properties.getProperty("user");
            pass= properties.getProperty("pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implantación del patrón Singleton
     * @author anaOrCam
     */
    public static DAOManager DAOManagerSingletonInstance(){
        if (singleton==null){
            singleton=new DAOManager();
            return singleton;
        }else return null;
    }

    /**
     * Abre la base de datos
     * @author anaOrCam
     */
    public void open(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,pass);
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
