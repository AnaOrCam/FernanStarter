
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class VistaUsuario {
    private String textoVerde;
    private String textoRojo;
    private String resetColorTexto;
    private String textoMorado;

    /**
     * Constructor de la vista VistaProyecto.
     * @author AnaOrCam
     * @param verde se refiere al color verde en formato String.
     * @param rojo se refiere al color rojo en formato String.
     * @param reset se refiere al color de base del texto en formato String.
     * @param morado se refiere al color morado en formato String.
     * @return no devuelve nada.
     */
    public VistaUsuario(String verde, String rojo, String reset, String morado){
        this.textoVerde =verde;
        this.textoRojo =rojo;
        this.resetColorTexto =reset;
        this.textoMorado =morado;
    }

    /**
     * Muestra los distintos usuarios.
     * @author AnaOrcam
     * @param usuarios se refiere al HashMap que contiene la lista de usuarios.
     * @return no devuelve nada.
     */
    public void muestraUsuarios(HashMap<String,Usuario> usuarios){
        List<Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (Usuario mostrar:listaUsuarios){
            if (!mostrar.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
                System.out.println(mostrar);
                System.out.println("-------------------------------");
            }
        }
    }

    /**
     * Muestra un mensaje de operación satisfactoria.
     * @author AnaOrcam
     * @return no devuelve nada.
     */
    public void comprobacionCorrecta(){
        System.out.println(textoVerde +"La comprobación ha sido satisfactoria"+ resetColorTexto);
    }

    /**
     * Muestra un mensaje de operación fallida.
     * @author AnaOrcam
     * @return no devuelve nada.
     */
    public void comprobacionIncorrecta(){
        System.out.println(textoRojo +"Ha ocurrido un error. No se ha podido comprobar el usuario."+ resetColorTexto);
    }

    /**
     * Muestra un mensaje de operación satisfactoria.
     * @author AnaOrcam
     * @return no devuelve nada.
     */
    public void operacionSatisfactoria(){
        System.out.println(textoVerde +"La operación se ha realizado con éxito"+ resetColorTexto);
    }

    /**
     * Muestra un mensaje de operación fallida.
     * @author AnaOrcam
     * @return no devuelve nada.
     */
    public void operacionFallida(){
        System.out.println(textoRojo +"Ha ocurrido un error. La operación no se ha completado."+ resetColorTexto);
    }

    /**
     * Muestra un usuario.
     * @author AnaOrcam
     * @param usuario se refiere al usuario que se mostrará.
     * @return no devuelve nada.
     */
    public void muestraUsuario(Usuario usuario){
        System.out.println(usuario);
    }

    /**
     * Muestra un mensaje de operación satisfactoria.
     * @author davidrn06
     * @return no devuelve nada.
     */
    public void credencialesValidas(String correo){
        System.out.println("Las credenciales para su cuenta con correo "+correo+" son validas"+ textoVerde + resetColorTexto);
    }

    /**
     * Muestra un mensaje de operación fallida.
     * @author davidrn06
     * @return no devuelve nada.
     */
    public void credencialesNoValidas(){
        System.out.println(textoRojo +"Las credenciales no coinciden"+ resetColorTexto);
    }

    /**
     * Muestra los proyectos creados por un gestor.
     * @author davidrn06
     * @param proyectos se refiere a la LinkedList que contiene los proyectos.
     * @return no devuelve nada.
     */
    public void muestraProyectosGestor(LinkedList<Proyecto> proyectos){
        for (int i=0;i< proyectos.size();i++){
            System.out.println( (i+1)+"."+proyectos.get(i).getNombre());
        }
    }

    /**
     * Muestra los atributos de un proyecto.
     * @author davidrn06
     * @param proyecto se refiere un proyecto de tipo Proyecto.
     * @return no devuelve nada.
     */
    public void vistaDetalladaProyecto(Proyecto proyecto){
        System.out.println(
                "Nombre: " + proyecto.getNombre() + "\n" +
                        "Cantidad a financiar: " + proyecto.getCantidadAInvertirTotal() + "\n" +
                        "Cantidad financiada hasta el momento: " + proyecto.getCantidadInvertidaActual() + "\n" +
                        "Fecha de apertura de inversiones: " + proyecto.getFechaApertura() + "\n" +
                        "Fecha de cierre de inversiones: " + proyecto.getFechaCierre());
        for(int i=0;i<proyecto.getListaRecompensas().size();i++){
            System.out.println("Recompensa "+(i+1)+" Nombre "+proyecto.getListaRecompensas().get(i).getNombre()+"\nDescripcion: "+proyecto.getListaRecompensas().get(i).getDescripcion()+" Importe: "+proyecto.getListaRecompensas().get(i).getImporte());
        }
    }

    /**
     * Muestra los amigos invitados por un inversor.
     * @author AnaOrCam
     * @param amigosInvitados se refiere a la LinkedList que contiene los amigos invitados.
     * @return no devuelve nada.
     */
    public void mostrarAmigosInvitados(LinkedList amigosInvitados){
        for (Object e: amigosInvitados){
            System.out.println(e);
        }
    }

    /**
     * Muestra las inversiones de un inversor.
     * @author AnaOrCam
     * @param listaInversiones se refiere a la LinkedList que contiene las inversiones de un inversor.
     * @return no devuelve nada.
     */
    public void mostrarProyectosInvertidos(LinkedList listaInversiones){
        for (Object e: listaInversiones) {
            System.out.println(e);
        }
    }

    /**
     * Muestra la cantidad invertida en total por un inversor.
     * @author AnaOrCam
     * @param cantidad se refiere a la cantidad a mostrar.
     * @return no devuelve nada.
     */
    public void mostrarInvertidoTotal(float cantidad){
        System.out.println("Total invertido hasta la fecha: "+cantidad+"€");
    }

    /**
     * Muestra el saldo de un inversor.
     * @author AnaOrCam
     * @param saldo se refiere al saldo a mostrar.
     * @return no devuelve nada.
     */
    public void mostrarSaldo(float saldo){
        System.out.println("Saldo actual: "+saldo);
    }

    /**
     * Muestra las recompensas de un proyecto.
     * @author davidrn06
     * @param recompensas se refiere a la LinkedList que contiene las recompensas.
     * @return no devuelve nada.
     */
    public void muestraRecompensas(LinkedList<Recompensa>  recompensas){
        int i=1;
        for (Recompensa aux:recompensas){
            System.out.println(i+"."+aux);
            i++;
        }
    }

}
