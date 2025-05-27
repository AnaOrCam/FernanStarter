package usuario;

import controlador.DAOManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAOAmigosInvitados {

    /**
     * Ejecuta un insert en la base de datos de la aplicacion
     * @author AnaOrCam
     * @param inversor se refiere al objeto administrador del cual se insertará el correo en la base de datos
     * @param amigo se refiere al String que contiene el correo del amigo que se insertará en la base de datos
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean insert(Inversor inversor, String amigo, DAOManager daoManager){
        String sql="INSERT INTO amigos_invitados VALUES('"+inversor.getCorreo()+"','"+amigo+"');";
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Recupera una lista de amigos invitador por el Inversor desde la base de datos
     * @author AnaOrCam
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return devuelve la lista de amigos.
     */
    public LinkedList<String> readAll(Inversor inversor, DAOManager daoManager){
        String sql="SELECT * FROM amigos_invitados WHERE correo='"+inversor.getCorreo()+"';";
        LinkedList <String> listaAmigos=new LinkedList<>();
        try{
            Statement stmt=daoManager.getConnection().createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            while (rs.next()){
                listaAmigos.add(rs.getString("amigo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAmigos;
    }
}
