package proyecto;

import controlador.DAOManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DAORecompensa {
    public boolean insert(Recompensa recompensa, DAOManager daoManager) {
        String sql = "INSERT INTO recompensa (id, nombre, descripcion, importe) VALUES (" +
                recompensa.getId() + ", '" +
                recompensa.getNombre() + "', '" +
                recompensa.getDescripcion() + "', " +
                recompensa.getImporte() + ");";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean update(Recompensa recompensa, DAOManager daoManager) {
        String sql = "UPDATE recompensa SET " +
                "nombre = '" + recompensa.getNombre() + "', " +
                "descripcion = '" + recompensa.getDescripcion() + "', " +
                "importe = " + recompensa.getImporte() + " " +
                "WHERE id = " + recompensa.getId() + ";";

        return daoManager.ejecutaSentencia(sql);
    }
    public boolean delete(DAOManager daoManager, int id) {
        String sql = "DELETE FROM recompensa WHERE id = " + id + ";";
        return daoManager.ejecutaSentencia(sql);
    }
    public Recompensa select(int id, DAOManager daoManager) {
        String sql = "SELECT * FROM recompensa WHERE id = " + id + ";";

        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float importe = rs.getFloat("importe");

                Recompensa recompensa = new Recompensa(nombre, descripcion, importe);
                recompensa.setId(rs.getInt("id"));

                return recompensa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public LinkedList<Recompensa> selectTodo(DAOManager daoManager) {
        LinkedList<Recompensa> lista = new LinkedList<>();
        String sql = "SELECT * FROM recompensa;";

        try {
            Statement stmt = daoManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                float importe = rs.getFloat("importe");

                Recompensa recompensa = new Recompensa(nombre, descripcion, importe);
                recompensa.setId(rs.getInt("id"));

                lista.add(recompensa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
