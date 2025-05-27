package proyecto;

import controlador.DAOManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

public class DAOProyecto {
    public boolean insert(Proyecto proyecto, DAOManager daoManager, String correoGestor) {
        String sql = "INSERT INTO proyecto (nombre, fechaApertura, fechaCierre, cantidadInvertidaActual, cantidadAInvertirTotal, descripcion, tematicaProyecto, correoGestor) VALUES ('" +
                proyecto.getNombre() + "', '" +
                proyecto.getFechaApertura() + "', '" +
                proyecto.getFechaCierre() + "', " +
                proyecto.getCantidadInvertidaActual() + ", " +
                proyecto.getCantidadAInvertirTotal() + ", '" +
                proyecto.getDescripcion() + "', '" +
                proyecto.getTematicaProyecto() + "', '" +
                correoGestor + "');";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean update(Proyecto proyecto, DAOManager daoManager,String nombre) {
        String sql = "UPDATE proyecto SET " +
                "fechaApertura = '" + proyecto.getFechaApertura() + "', " +
                "fechaCierre = '" + proyecto.getFechaCierre() + "', " +
                "cantidadInvertidaActual = " + proyecto.getCantidadInvertidaActual() + ", " +
                "cantidadAInvertirTotal = " + proyecto.getCantidadAInvertirTotal() + ", " +
                "descripcion = '" + proyecto.getDescripcion() + "', " +
                "tematicaProyecto = '" + proyecto.getTematicaProyecto() + "' " +
                "WHERE nombre = '" + nombre + "';";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean updateNombre( DAOManager daoManager,String nombre,String nombreNuevo) {
        String sql = "UPDATE proyecto SET " +
                "nombre='"+nombreNuevo+"' where nombre='"+nombre+"' ;";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean updateTematica( DAOManager daoManager,String nombreProyecto,String nuevatematica) {
        String sql = "UPDATE proyecto SET " +
                "tematicaProyecto='"+nuevatematica+"' where nombre='"+nombreProyecto+"'; ";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean updateCantidadAFinanciar( DAOManager daoManager,String nombreProyecto,int cantidad) {
        String sql = "UPDATE proyecto SET " +
                "cantidadAInvertirTotal="+cantidad+" where nombre='"+nombreProyecto+"' ;";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean updateCantidadInvertida( DAOManager daoManager,String nombreProyecto,int cantidad) {
        String sql = "UPDATE proyecto SET " +
                "cantidadInvertidaActual="+cantidad+" where nombre='"+nombreProyecto+"' ;";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean updateFechaApertura(DAOManager daoManager, String nombreProyecto, LocalDate nueva) {
        String sql = "UPDATE proyecto SET " +
                "fechaApertura='"+nueva+"' where nombre='"+nombreProyecto+"' ;";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean updateFechaCierre(DAOManager daoManager, String nombreProyecto, LocalDate nueva) {
        String sql = "UPDATE proyecto SET " +
                "fechaCierre='"+nueva+"' where nombre='"+nombreProyecto+"' ;";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean delete(DAOManager daoManager, String nombre) {
        String sql = "DELETE FROM proyecto WHERE nombre = '" + nombre + "';";
        return daoManager.ejecutaSentencia(sql);
    }
    public Proyecto select(int id, DAOManager daoManager) {
        String sql = "SELECT * FROM proyecto WHERE id = " + id + ";";

        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Proyecto proyecto = new Proyecto();
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setFechaApertura(rs.getDate("fechaApertura").toLocalDate());
                proyecto.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
                proyecto.setCantidadInvertidaActual(rs.getInt("cantidadInvertidaActual"));
                proyecto.setCantidadAInvertirTotal(rs.getInt("cantidadAInvertirTotal"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setTematicaProyecto(TematicaProyecto.valueOf(rs.getString("tematicaProyecto")));

                return proyecto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    public LinkedList<Proyecto> selectTodo(DAOManager daoManager) {
        LinkedList<Proyecto> lista = new LinkedList<>();
        String sql = "SELECT * FROM proyecto;";

        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Proyecto proyecto = new Proyecto();
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setFechaApertura(rs.getDate("fechaApertura").toLocalDate());
                proyecto.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
                proyecto.setCantidadInvertidaActual(rs.getInt("cantidadInvertidaActual"));
                proyecto.setCantidadAInvertirTotal(rs.getInt("cantidadAInvertirTotal"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setTematicaProyecto(TematicaProyecto.valueOf(rs.getString("tematicaProyecto")));

                lista.add(proyecto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
