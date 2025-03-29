import java.util.LinkedList;

public class Gestor extends Usuario implements Bloqueable{
    private LinkedList<Proyecto> proyectosCreados;
    private boolean bloqueado;
    public Gestor(String nombre, String correo, String contrasena, TipoUsuario tipoUsuario){
        super( nombre, correo, contrasena, tipoUsuario);

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
    public void  anadirProyecto(Proyecto proyecto){
        proyectosCreados.add(proyecto);
    }

}
