package proyecto;

import controlador.DAOManager;
import usuario.Inversor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAOInversion {

    public boolean insert(Inversion inversion, DAOManager daoManager){
        String sql = "INSERT INTO inversion (idInversion, cantidadInvertida, correoInversor, idRecompensaElegida, nombreProyecto) VALUES (" +
                inversion.getIdInversion() + ", " +
                inversion.getCantidadInvertida() + ", '" +
                inversion.getInversor().getCorreo() + "', " +
                inversion.getRecompensaElegida().getId() + ", '" +
                inversion.getNombreProyecto() + "');";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean update(Inversion inversion, DAOManager daoManager,int idAActualizar) {
        String sql = "UPDATE inversion SET " +
                "cantidadInvertida = " + inversion.getCantidadInvertida() + ", " +
                "correoInversor = '" + inversion.getInversor().getCorreo() + "', " +
                "idRecompensaElegida = " + inversion.getRecompensaElegida().getId() + ", " +
                "nombreProyecto = '" + inversion.getNombreProyecto() + "' " +
                "WHERE idInversion = " + idAActualizar + ";";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean delete(Inversion inversion, DAOManager daoManager) {
        String sql = "DELETE FROM inversion WHERE idInversion = " + inversion.getIdInversion() + ";";
        return daoManager.ejecutaSentencia(sql);
    }
    public Inversion selectPorId(int  id, DAOManager daoManager ){
        String sql="SELECT * FROM inversion where idInversion= "+id+";";
        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()){
                Inversor aux=new Inversor(null,rs.getString("correoInversor"),null,null);
                Recompensa aux2 = new Recompensa(null,null,0);
                aux2.setId(rs.getInt("idRecompensaElegida"));
                Inversion inversion =new Inversion(rs.getString("proyecto"),
                        rs.getFloat("cantidadInvertida"),aux,aux2,rs.getInt("idInversion"));
                return inversion;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public LinkedList<Inversion> selectTodo(DAOManager daoManager) {
        LinkedList<Inversion> lista = new LinkedList<>();
        String sql = "SELECT * FROM inversion";

        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Inversor aux = new Inversor(null, rs.getString("correoInversor"), null, null);

                Recompensa aux2 = new Recompensa(null, null, 0);
                aux2.setId(rs.getInt("idRecompensaElegida"));

                Inversion inversion = new Inversion(
                        rs.getString("nombreProyecto"),
                        rs.getFloat("cantidadInvertida"),
                        aux,
                        aux2,
                        rs.getInt("idInversion")
                );

                lista.add(inversion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
