import java.util.LinkedList;

public class Gestor extends Usuario implements Bloqueable{
    private LinkedList<Proyecto> proyectosCreados = new LinkedList<Proyecto>();
    private boolean bloqueado;
    private int idGestor;
    public Gestor(String nombre, String correo, String contrasena){
        super( nombre, correo, contrasena);
        idGestor=ids;
        ids++;
    }
    public LinkedList<Proyecto> getProyectosCreados() {
        return proyectosCreados;
    }

    public void setProyectosCreados(LinkedList<Proyecto> proyectosCreados) {
        this.proyectosCreados = proyectosCreados;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public int getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
    }


}
