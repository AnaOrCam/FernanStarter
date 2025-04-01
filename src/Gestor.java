import java.util.LinkedList;

public class Gestor extends Usuario implements Bloqueable{
    private LinkedList<Proyecto> proyectosCreados;
    private boolean bloqueado;
    private int intentos;
    /**
     * Constructor para crear un usuario de tipo gestor
     * @author AnaOrCam
     * @param nombre nombre del gestor
     * @param correo correo del gestor
     * @param  contrasena contraseña de correo
     * @param tipoUsuario tipo de usuario gestor
     */
    public Gestor(String nombre, String correo, String contrasena, TipoUsuario tipoUsuario){
        super( nombre, correo, contrasena, tipoUsuario);

        bloqueado=false;
        proyectosCreados=new LinkedList<>();
        intentos=0;
    }
    /**
     * Devuelve los proyectos creados por el gestor invocante
     * @author davidrn06
     * @return la lista de proyectos
     */
    public LinkedList<Proyecto> getProyectosCreados() {
        return proyectosCreados;
    }

    public void setProyectosCreados(LinkedList<Proyecto> proyectosCreados) {
        this.proyectosCreados = proyectosCreados;
    }
    /**
     * Devuelve sin un gestor esta bloqueadp
     * @author davidrn06
     * @return true si el usuario esta bloqueado
     */
    public boolean isBloqueado() {
        return bloqueado;
    }
    @Override
    /**
     * Bloquea un usuario
     * @author AnaOrCam
     */
    public void bloquearUsuario() {
        this.bloqueado=true;
    }
    /**
     * Desbloquea un usuario
     * @author AnaOrCam
     */
    public void desbloquearUsuario(){
        this.bloqueado=false;
    }
    /**
     * Sobreescribe el metodo toString del gestor teniendo en cuenta el de la clase padre Usuario
     * @author AnaOrCam
     */
    public String toString(){
        return super.toString();
    }
    /**
     * Añade un proyecto a la lista de proyectos creados por el gestor
     * @param proyecto proyecto que se va a añadir
     * @author davidrn06
     */
    public void  anadirProyecto(Proyecto proyecto){
        proyectosCreados.add(proyecto);
    }
    /**
     * Suma intentos a un usuario
     * @author davidrn06
     */
    public void sumaIntentos(){
        intentos++;
        if (intentos==3){
            bloquearUsuario();
        }
    }

}
