import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class VistaUsuario {
    private final String ANSI_GREEN= "\033[32m";
    private final String ANSI_RED="\033[31m";
    private final String ANSI_RESET= "\033[0m";
    private final String ANSI_PURPLE= "\033[35m";

    public void muestraUsuarios(HashMap<String,Usuario> usuarios){
        List<Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (Usuario mostrar:listaUsuarios){
            System.out.println(mostrar);
        }
    }
    public void comprobacionCorrecta(){
        System.out.println(ANSI_GREEN+"La comprobación ha sido satisfactoria"+ANSI_RESET);
    }
    public void comprobacionIncorrecta(){
        System.out.println(ANSI_RED+"Ha ocurrido un error. No se ha podido comprobar el usuario."+ANSI_RESET);
    }
    public void operacionSatisfactoria(){
        System.out.println(ANSI_GREEN+"La operación se ha realizado con éxito"+ANSI_RESET);
    }
    public void operacionFallida(){
        System.out.println(ANSI_RED+"Ha ocurrido un error. La operación no se ha completado."+ANSI_RESET);
    }
    public void muestraUsuario(Usuario usuario){
        System.out.println(usuario);
    }
    public void credencialesValidas(String correo){
        System.out.println("Las credenciales para su cuenta con correo "+correo+" son validas"+ANSI_GREEN+" \n Iniciando Sesion..."+ANSI_RESET );
    }
    public void credencialesNoValidas(){
        System.out.println(ANSI_RED+"Las credenciales no coinciden"+ANSI_RESET);
    }
    public void muestraProyectosGestor(LinkedList<Proyecto> proyectos){
        for (int i=0;i< proyectos.size();i++){
            System.out.println( (i+1)+"."+proyectos.get(i).getNombre());
        }
    }
    public void vistaDetalladaProyecto(Proyecto proyecto){
        System.out.println(
                "Nombre: " + proyecto.getNombre() + "\n" +
                        "Cantidad a financiar: " + proyecto.getCantidadAInvertirTotal() + "\n" +
                        "Cantidad financiada hasta el momento: " + proyecto.getCantidadInvertidaActual() + "\n" +
                        "Fecha de apertura de inversiones: " + proyecto.getFechaApertura() + "\n" +
                        "Fecha de cierre de inversiones: " + proyecto.getFechaCierre());
        for(int i=0;i<proyecto.getListaRecompensas().size();i++){
            System.out.println("Recompensa "+i+" Nombre "+proyecto.getListaRecompensas().get(i).getNombre()+"\nDescripcion: "+proyecto.getListaRecompensas().get(i).getDescripcion()+" Importe: "+proyecto.getListaRecompensas().get(i).getImporte());
        }

    }

}
