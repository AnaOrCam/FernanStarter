package proyecto;

import controlador.DAOManager;
import usuario.Inversor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAOInversion {

    public boolean insert(Inversion inversion, DAOManager daoManager){
        String sql;
        if (inversion.getRecompensaElegida() != null) {
            sql = "INSERT INTO inversion (id, cantidad, correo, id_recompensa, nombre_proyecto) VALUES (" +
                    inversion.getIdInversion() + ", " +
                    inversion.getCantidadInvertida() + ", '" +
                    inversion.getInversor().getCorreo() + "', " +
                    inversion.getRecompensaElegida().getId() + ", '" +
                    inversion.getNombreProyecto() + "');";
        } else {
            sql = "INSERT INTO inversion (id, cantidad, correo, nombre_proyecto) VALUES (" +
                    inversion.getIdInversion() + ", " +
                    inversion.getCantidadInvertida() + ", '" +
                    inversion.getInversor().getCorreo() + "', '" +
                    inversion.getNombreProyecto() + "');";
        }
        return daoManager.ejecutaSentencia(sql);
    }
    public boolean update(Inversion inversion, DAOManager daoManager,int idAActualizar) {
        String sql = "UPDATE inversion SET " +
                "cantidad = " + inversion.getCantidadInvertida() + ", " +
                "correo = '" + inversion.getInversor().getCorreo() + "', " +
                "id = " + inversion.getRecompensaElegida().getId() + ", " +
                "nombre_proyecto = '" + inversion.getNombreProyecto() + "' " +
                "WHERE id = " + idAActualizar + ";";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean updateSaldoInversion( DAOManager daoManager,int idAActualizar,Float cantidadAumentada) {
        String sql = "UPDATE inversion SET " +
                "cantidad = cantidad+" +cantidadAumentada+"where id="+idAActualizar+";";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean delete(Inversion inversion, DAOManager daoManager) {
        String sql = "DELETE FROM inversion WHERE id = " + inversion.getIdInversion() + ";";
        return daoManager.ejecutaSentencia(sql);
    }
    public Inversion selectPorId(int  id, DAOManager daoManager ){
        String sql="SELECT * FROM inversion where idInversion= "+id+";";
        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()){
                Inversor aux=new Inversor(null,rs.getString("correo"),null,null);
                Recompensa aux2 = new Recompensa(null,null,0);
                aux2.setId(rs.getInt("id"));
                Inversion inversion =new Inversion(rs.getString("nombre_proyecto"),
                        rs.getFloat("cantidad"),aux,aux2,rs.getInt("id"));
                return inversion;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public LinkedList<Inversion> selectPorProyecto(DAOManager daoManager,String nombreProyecto) {
        LinkedList<Inversion> lista = new LinkedList<>();
        String sql = "SELECT * FROM inversion where nombre_proyecto='"+nombreProyecto+"';";

        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id=rs.getInt("id");
                float cantidad = rs.getFloat("cantidad");
                String nombre_proyecto= rs.getString("nombre_proyecto");
                Inversor aux=new Inversor(null,rs.getString("correo"),null,null);
                Recompensa aux2 = new Recompensa(null,null,0);
                aux2.setId(rs.getInt("id_recompensa"));
                Inversion inversion = new Inversion(nombre_proyecto, cantidad, aux,aux2,id);
                lista.add(inversion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
