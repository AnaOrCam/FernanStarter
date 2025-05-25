package dao;

import usuario.Inversor;
import usuario.TipoUsuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAOInversor {

    /**
     * Ejecuta un insert en la base de datos de la aplicacion
     * @author AnaOrCam
     * @param inversor se refiere al objeto administrador del cual se insertarán los datos
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean insert(Inversor inversor, DAOManager daoManager){
        final String bloqueado="1";
        final String desbloqueado="0";
        String estado=inversor.isBloqueado()?bloqueado:desbloqueado;
        String sql="INSERT INTO inversor VALUES ('"+inversor.getNombre()+"','"+inversor.getCorreo()+"','"+inversor.getContrasena()+"','"+
                inversor.getTipoUsuario()+"','"+estado+"','"+inversor.getSaldo()+"','"+inversor.getInvertidoTotal()+"');";
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Ejecuta una actualización en la base de datos de la aplicacion
     * @author AnaOrCam
     * @param tipoUpdate hace referencia a la columna que se actualizará de la tabla
     * @param inversor se refiere al objeto administrador del cual se insertarán los datos
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean update(String tipoUpdate, Inversor inversor, DAOManager daoManager){
        String sql="";
        switch (tipoUpdate){
            case "nombre"-> sql="UPDATE inversor SET nombre='"+inversor.getNombre()+"';";
            case "correo" -> sql="UPDATE inversor SET correo='"+inversor.getCorreo()+"';";
            case "pass"-> sql="UPDATE inversor SET pass='"+inversor.getContrasena()+"';";
            case "saldo"-> sql="UPDATE inversor SET saldo="+inversor.getSaldo()+";";
            case "invertidoTotal"->sql="UPDATE inversor SET invertido_total="+inversor.getInvertidoTotal()+";";
            case "bloqueado"->{
                final String bloqueado="1";
                final String desbloqueado="0";
                String estado=inversor.isBloqueado()?bloqueado:desbloqueado;
                sql="UPDATE inversor SET bloqueado='"+estado+"';";
            }
        }
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Ejecuta un delete en la base de datos
     * @author AnaOrCam
     * @param inversor se refiere al objeto administrador que se borrará de la base de datos.
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return true si se hace el insert y false si no.
     */
    public boolean delete(Inversor inversor, DAOManager daoManager){
        String sql="DELETE FROM inversor WHERE correo='"+inversor.getCorreo()+"';";
        return daoManager.ejecutaSentencia(sql);
    }

    /**
     * Recupera un objeto Inversor desde la base de datos
     * @author AnaOrCam
     * @param correo se refiere al correo del objeto Inversor que se usará para buscar en la base de datos.
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return el objeto Inversor si se realiza la sentencia, null si no se realiza.
     */
    public Inversor read(String correo, DAOManager daoManager){
        String sql="SELECT * FROM inversor WHERE correo='"+correo+"';";
        try{
            Statement stmt=daoManager.getConnection().createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            if (rs.next()){
                Inversor inversor;
                if (rs.getString("bloqueado").equals("0")){
                    inversor=new Inversor(rs.getString("nombre"),rs.getString("correo"),rs.getString("pass"),
                            TipoUsuario.valueOf(rs.getString("tipo_usuario")),rs.getFloat("saldo"),rs.getFloat("invertido_total"),false);
                }else{
                    inversor=new Inversor(rs.getString("nombre"),rs.getString("correo"),rs.getString("pass"),
                            TipoUsuario.valueOf(rs.getString("tipo_usuario")),rs.getFloat("saldo"),rs.getFloat("invertido_total"),true);
                }
                return inversor;            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recupera una lista de Inversores desde la base de datos
     * @author AnaOrCam
     * @param daoManager se refiere al objeto DAOManager que permite que se ejecute la sentencia
     * @return devuelve la lista de Inversores.
     */
    public LinkedList<Inversor> readAll(DAOManager daoManager){
        String sql="SELECT * FROM inversor";
        LinkedList<Inversor> listaInversores=new LinkedList<>();
        try{
            Statement stmt=daoManager.getConnection().createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            if (rs.next()){
                Inversor inversor;
                if (rs.getString("bloqueado").equals("0")){
                    inversor=new Inversor(rs.getString("nombre"),rs.getString("correo"),rs.getString("pass"),
                            TipoUsuario.valueOf(rs.getString("tipo_usuario")),rs.getFloat("saldo"),rs.getFloat("invertido_total"),false);
                }else{
                    inversor=new Inversor(rs.getString("nombre"),rs.getString("correo"),rs.getString("pass"),
                            TipoUsuario.valueOf(rs.getString("tipo_usuario")),rs.getFloat("saldo"),rs.getFloat("invertido_total"),true);
                }
                listaInversores.add(inversor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaInversores;
    }
}

