package dao;

import usuario.Gestor;
import usuario.TipoUsuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAOGestor {

    /**
     * Ejecuta un insert en la base de datos de la aplicacion
     * @author AnaOrCam
     * @param gestor se refiere al objeto administrador del cual se insertarán los datos
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean insert(Gestor gestor, DAOManager daoManager){
        final String bloqueado="1";
        final String noBloqueado="0";
        String estado=gestor.isBloqueado()?bloqueado:noBloqueado;
        String sql="INSERT INTO gestor VALUES ('"+gestor.getNombre()+"','"+gestor.getCorreo()+"','"+gestor.getContrasena()+"','"+
                gestor.getTipoUsuario()+"','"+estado+"');";
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Ejecuta una actualización en la base de datos de la aplicacion
     * @author AnaOrCam
     * @param tipoUpdate hace referencia a la columna que se actualizará de la tabla
     * @param gestor se refiere al objeto administrador del cual se insertarán los datos
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean update(String tipoUpdate, Gestor gestor, DAOManager daoManager){
        final String bloqueado="1";
        final String noBloqueado="0";
        String sql="";
        switch (tipoUpdate) {
            case "nombre" -> sql = "UPDATE gestor SET nombre='" + gestor.getNombre() + "';";
            case "correo" -> sql = "UPDATE gestor SET correo='" + gestor.getCorreo() + "';";
            case "pass" -> sql = "UPDATE gestor SET pass='" + gestor.getContrasena() + "';";
            case "bloqueado" -> {
                String numBloqueado=gestor.isBloqueado()?bloqueado:noBloqueado;
                sql = "UPDATE gestor SET bloqueado='"+numBloqueado+"';";
            }
        }
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Ejecuta un delete en la base de datos
     * @author AnaOrCam
     * @param correo se refiere al correo del objeto administrador que se borrará de la base de datos.
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean delete(String correo, DAOManager daoManager){
        String sql="DELETE FROM gestor WHERE correo='"+correo+"';";
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Recupera un objeto Gestor desde la base de datos
     * @author AnaOrCam
     * @param correo se refiere al correo del objeto Gestor que se usará para buscar en la base de datos.
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return el objeto Gestor si se realiza la sentencia, null si no se realiza.
     */
    public Gestor read(String correo, DAOManager daoManager){
        String sql="SELECT * FROM gestor WHERE correo='"+correo+"';";
        try{
            Statement stmt=daoManager.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()){
                Gestor gestor;
                if (rs.getString("bloqueado")=="0") {
                    gestor = new Gestor(rs.getString("nombre"), rs.getString("correo"), rs.getString("pass"),
                            TipoUsuario.valueOf(rs.getString("tipo_usuario")),false);
                }else{
                    gestor = new Gestor(rs.getString("nombre"), rs.getString("correo"), rs.getString("pass"),
                            TipoUsuario.valueOf(rs.getString("tipo_usuario")),true);
                }
                return gestor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera una lista de Gestores desde la base de datos
     * @author AnaOrCam
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return devuelve la lista de Gestores.
     */
    public LinkedList<Gestor> readAll(DAOManager daoManager){
        String sql="SELECT * FROM gestor";
        LinkedList<Gestor> listaGestores=new LinkedList<>();
        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()){
                Gestor gestor;
                if (rs.getString("bloqueado")=="0") {
                    gestor = new Gestor(rs.getString("nombre"), rs.getString("correo"), rs.getString("pass"),
                            TipoUsuario.valueOf(rs.getString("tipo_usuario")),false);
                }else{
                    gestor = new Gestor(rs.getString("nombre"), rs.getString("correo"), rs.getString("pass"),
                            TipoUsuario.valueOf(rs.getString("tipo_usuario")),true);
                }
                listaGestores.add(gestor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaGestores;
    }
}
