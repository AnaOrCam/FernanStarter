package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOAdministrador {

    public boolean insert(Administrador administrador, DAOManager daoManager){
        String sql="INSERT INTO administrador VALUES ();";
        return daoManager.ejecutaSentencia(sql);
    }

    public boolean delete(Administrador administrador, DAOManager daoManager){
        String sql="'DELETE FROM administrador WHERE correo='";
        return daoManager.ejecutaSentencia(sql);
    }

    public Administrador read(String correo, DAOManager daoManager){
        String sql="SELECT * FROM administrador where correo='"+correo+"';";
        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            Administrador administrador =
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
