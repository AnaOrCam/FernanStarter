import java.util.LinkedList;

public class Gestor extends Usuario implements Bloqueable{
    private LinkedList<Proyecto> proyectosCreados;
    private boolean bloqueado;
    private int idGestor;
    public Gestor(String nombre, String correo, String contrasena, TipoUsuario tipoUsuario){
        super( nombre, correo, contrasena, tipoUsuario);
        idGestor=getIds();
        sumaid();
        bloqueado=false;
        proyectosCreados=new LinkedList<>();
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

    public int getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(int idGestor) {
        this.idGestor = idGestor;
    }

    @Override
    public void bloquearUsuario() {
        this.bloqueado=true;
    }

    public void desbloquearUsuario(){
        this.bloqueado=false;
    }

    public String toString(){
        return super.toString();
    }

}
