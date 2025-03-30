
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class VistaUsuario {
    private String textoVerde;
    private String textoRojo;
    private String resetColorTexto;
    private String textoMorado;

    public VistaUsuario(String verde, String rojo, String reset, String morado){
        this.textoVerde =verde;
        this.textoRojo =rojo;
        this.resetColorTexto =reset;
        this.textoMorado =morado;
    }

    public void muestraUsuarios(HashMap<String,Usuario> usuarios){
        List<Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (Usuario mostrar:listaUsuarios){
            System.out.println(mostrar);
        }
    }
    public void comprobacionCorrecta(){
        System.out.println(textoVerde +"La comprobación ha sido satisfactoria"+ resetColorTexto);
    }
    public void comprobacionIncorrecta(){
        System.out.println(textoRojo +"Ha ocurrido un error. No se ha podido comprobar el usuario."+ resetColorTexto);
    }
    public void operacionSatisfactoria(){
        System.out.println(textoVerde +"La operación se ha realizado con éxito"+ resetColorTexto);
    }
    public void operacionFallida(){
        System.out.println(textoRojo +"Ha ocurrido un error. La operación no se ha completado."+ resetColorTexto);
    }
    public void muestraUsuario(Usuario usuario){
        System.out.println(usuario);
    }
    public void credencialesValidas(String correo){
        System.out.println("Las credenciales para su cuenta con correo "+correo+" son validas"+ textoVerde +" \n Iniciando Sesion..."+ resetColorTexto);
    }
    public void credencialesNoValidas(){
        System.out.println(textoRojo +"Las credenciales no coinciden"+ resetColorTexto);
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

    public void mostrarAmigosInvitados(LinkedList amigosInvitados){
        for (Object e: amigosInvitados){
            System.out.println(e);
        }
    }

    public void mostrarProyecosInvertidos(LinkedList listaInversiones){
        for (Object e: listaInversiones) {
            System.out.println(e);
        }
    }
    public void mostrarInvertidoTotal(float cantidad){
        System.out.println("Total invertido hasta la fecha: "+cantidad+"€");
    }

    public void mostrarSaldo(float saldo){
        System.out.println("Saldo actual: "+saldo);
    }

}
