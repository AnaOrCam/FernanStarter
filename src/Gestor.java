public class Gestor extends Usuario implements Bloqueable{
    private int nProyectosCreados;
    private Proyecto [] proyectosCreados;
    private boolean bloqueado;
    private int idGestor;
    public Gestor(String nombre,String correo,String contrasena){
        super( nombre, correo, contrasena);
       idGestor=ids;
       ids++;
    }
}
