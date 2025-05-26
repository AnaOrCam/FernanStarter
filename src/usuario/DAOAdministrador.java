package usuario;


import controlador.DAOManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAOAdministrador {

    /**
     * Ejecuta un insert en la base de datos de la aplicacion
     * @author AnaOrCam
     * @param administrador se refiere al objeto administrador del cual se insertarán los datos
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean insert(Administrador administrador, DAOManager daoManager){
        String sql="INSERT INTO administrador VALUES ('"+administrador.getNombre()+"','"+administrador.getCorreo()+"','"+administrador.getContrasena()+"','"+
                administrador.getTipoUsuario()+"');";
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Ejecuta una actualización en la base de datos de la aplicacion
     * @author AnaOrCam
     * @param tipoUpdate hace referencia a la columna que se actualizará de la tabla
     * @param administrador se refiere al objeto administrador del cual se insertarán los datos
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean update(String tipoUpdate, Administrador administrador, DAOManager daoManager){
        String sql="";
        switch (tipoUpdate){
            case "nombre"-> sql="UPDATE administrador SET nombre='"+administrador.getNombre()+"';";
            case "correo"-> sql="UPDATE administrador SET correo=''"+administrador.getCorreo()+";";
            case "pass" -> sql="UPDATE administrador SET pass=''"+administrador.getContrasena()+";";
        }
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Ejecuta un delete en la base de datos
     * @author AnaOrCam
     * @param administrador se refiere al objeto administrador que se borrará de la base de datos.
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean delete(Administrador administrador, DAOManager daoManager){
        String sql="DELETE FROM administrador WHERE correo='"+administrador.getCorreo()+"';";
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Recupera un objeto Administrador desde la base de datos
     * @author AnaOrCam
     * @param correo se refiere al correo del objeto Administrador que se usará para buscar en la base de datos.
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return el objeto Administrador si se realiza la sentencia, null si no se realiza.
     */
    public Administrador read(String correo, DAOManager daoManager){
        String sql="SELECT * FROM administrador where correo='"+correo+"';";
        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()){
                Administrador administrador =new Administrador(rs.getString("nombre"),rs.getString("correo"),rs.getString("pass"),
                        TipoUsuario.valueOf(rs.getString("tipo_usuario")));
                return administrador;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera una lista de Administradores desde la base de datos
     * @author AnaOrCam
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return devuelve la lista de Administradores.
     */
    public LinkedList<Administrador> readAll(DAOManager daoManager){
        String sql="SELECT * FROM administrador";
        LinkedList<Administrador> listaAdministradores=new LinkedList<>();
        try{
            Statement stmt=daoManager.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()){
                Administrador administrador=new Administrador(rs.getString("nombre"),rs.getString("correo"),rs.getString("pass"),
                        TipoUsuario.valueOf(rs.getString("tipo_usuario")));
                listaAdministradores.add(administrador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAdministradores;
    }
}
