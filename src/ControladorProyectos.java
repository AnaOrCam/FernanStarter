import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class ControladorProyectos implements Serializable {

    private GestionProyectos modelo;
    private VistaProyecto vista;
    /**
     * Constructor del controlador de proyectos
     * @author davidrn06
     * @param modelo se refiere al modelo donde se almacenan los proyectos.
     * @param vista se refiere a la vista donde se mostrara lo relaccionado con los proyectos.
     */

    public ControladorProyectos(GestionProyectos modelo, VistaProyecto vista){
        this.modelo=modelo;
        this.vista=vista;
    }
    /**
     * Metodo que muestra proyectos
     * @author AnaOrCam
     * @return true si devuelve algo desde el modelo.
     */
    public boolean mostrarProyectos(){
        if (!modelo.getProyectos().isEmpty()) {
            vista.muestraListaProyectos(modelo.getProyectos());
            return true;
        }
        return false;
    }
    public void muestraProyectoUnicoConGrafico(Proyecto aux){
        vista.muestraProyectoConGrafica(aux);
    }

    /**
     * Getter de la lista de inversiones.
     * @author anaOrCam
     * @return devuelve la Linkedlist que contiene las inversiones realizadas.
     */
    public LinkedList<Inversion> getListaInversiones(Proyecto proyecto) {
        return modelo.getListaInversiones(proyecto);
    }

    /**
     * Metodo que devuelve la lista de proyectos
     * @author AnaOrCam
     * @return devuelve una Linkedlist con los proyectos existentes
     */
    public LinkedList<Proyecto> getListaProyectos(){
        return modelo.getProyectos();
    }

    /**
     * Metodo que ordena los proyectos según fecha de apertura, fecha de cierre, cantidad a financiar o importe financiado.
     * @author AnaOrCam
     * @param proyectos se refiere a la Linkedlist que contiene los proyectos.
     * @param tipoOrden se refiere al criterio de orden que se seguira basado en un numero entero.
     */
    public void ordenarProyectos(LinkedList<Proyecto> proyectos, int tipoOrden){
        //Tipo orden:
        // 1. Por cantidad invertida
        // 2. Por cantidad a financiar
        // 2. Por fecha de apertura
        // 3. Por fecha de cierre
        switch (tipoOrden){
            case 1->{
                LinkedList<Proyecto> listaOrdenada = new LinkedList<>(modelo.ordenarPorImporteFinanciado(proyectos));
                vista.muestraListaProyectos(listaOrdenada);
            }
            case 2->{
                LinkedList<Proyecto> listaOrdenada = new LinkedList<>(modelo.ordenarPorCantidadAFinanciar(proyectos));
                vista.muestraListaProyectos(listaOrdenada);
            }
            case 3->{
                LinkedList<Proyecto> listaOrdenada= new LinkedList<>(modelo.ordenarPorFechaApertura(proyectos));
                vista.muestraListaProyectos(listaOrdenada);
            }
            case 4->{
                LinkedList<Proyecto> listaOrdenada= new LinkedList<>(modelo.ordenarPorFechaCierre(proyectos));
                vista.muestraListaProyectos(listaOrdenada);
            }
            default -> vista.operacionFallida();
        }
    }

    /**
     * Ordena y muestra la lista de inversiones por el nombre del inversor.
     * @author anaOrCam
     * @param proyecto se refiere al proyecto que contiene la lista de inversiones.
     */
    public void ordenarYMostrarInversionesPorNombreInversor(Proyecto proyecto){
        vista.muestraInversiones(modelo.ordenarInversionesPorNombreInversor(proyecto));
    }

    /**
     * Ordena y muestra la lista de inversiones por el nombre del inversor.
     * @author anaOrCam
     * @param proyecto se refiere al proyecto que contiene la lista de inversiones.
     */
    public void mostrarInversiones(Proyecto proyecto){
        vista.muestraInversiones(modelo.getListaInversiones(proyecto));
    }

    /**
     * Metodo que muestra proyectos con grafico
     * @author AnaOrCam
     * @return true si devuelve algo desde el modelo.
     */
    public boolean mostrarProyectosConGrafico(){
        if (!modelo.getProyectos().isEmpty()) {
            vista.muestraListaProyectosConGrafica(modelo.getProyectos());
            return true;
        }
        return false;
    }
    /**
     * Metodo que inserta proyectos en el modelo
     * @author AnaOrCam
     * @param proyecto proyecto que va a ser insertado
     */
    public void insertarProyecto(Proyecto proyecto){
        modelo.insertarProyecto(proyecto);
        vista.proyectoInsertadoCorrectamente(proyecto);
    }

    /**
     * Inserta una inversión en la lista de inversiones
     * @author AnaOrCam
     * @param  proyecto proyecto al que pertenece la inversion
     * @param  inversion inversion que va a ser insertada
     */
    public void insertarInversion(Inversion inversion, Proyecto proyecto){
        modelo.insertarInversion(inversion,proyecto);
    }

    /**
     * Metodo que inserta recompensa en un proyecto
     * @author AnaOrCam
     * @param nombreProyecto nombre del proyecto en el que se va a insertar
     * @param  recompensa recompensa que va a ser insertada
     */
    public void insertarRecompensaPorNombre(Recompensa recompensa, String nombreProyecto){
        Proyecto aux=modelo.buscaProyecto(nombreProyecto);
        aux.insertaRecompensa(recompensa);
    }
    /**
     * Metodo para insertar recompensas en un proyecto
     * @author davidrn06
     * @param recompensa se refiere a la recompensa a insertar.
     * @param proyecto se refiere al proyecto en el que se insertara la recompensa.
     */
    public void insertarRecompensa(Recompensa recompensa, Proyecto proyecto){
        Proyecto aux=proyecto;
        aux.insertaRecompensa(recompensa);
    }
    /**
     * Metodo boolean que comprueva si un metodo existe
     * @author davidrn06
     * @param nombre se refiere al nombre del proyecto a comprobar.
     * @return devuelve true si el proyecto con ese nombre existe, de lo contrario false
     */
    public boolean compruebaProyectoExiste(String nombre){
        return modelo.compruebaProyectoExiste(nombre);
    }
    /**
     * Busca un proyecto segun su nombre y lo devuelve
     * @author davidrn06
     * @param nombre nombre del proyecto que va a ser buscado
     * @return devuelve el proyecto buscado
     */
    public Proyecto buscarProyecto(String nombre){
        return modelo.buscaProyecto(nombre);
    }
    /**
     * Muestra los tipos de proyecto disponibles
     * @author davidrn06
     */
    public void muestratipos(){
        vista.muestraTipos();
    }
    /**
     * Borra un proyecto pasado por parametro
     * @author davidrn06
     * @param aux proyecto que va a ser borrado
     */
    public void borrarProyecto(Proyecto aux){
        modelo.borrarProyecto(aux);
    }
    /**
     * Añade financiacion a un proyecto
     * @author AnaOrCam
     * @param cantidad cantidad a añadir
     * @param proyecto  proyecto en el que se va a añadir la financiacion
     */
    public void aniadirFinanciacionAProyecto(float cantidad, Proyecto proyecto){
         modelo.aniadirFinanciacionAProyecto(cantidad, proyecto);
    }

    /**
     * Comprueba que el importe que se pasa por parametro mas lo actualmente invertido en el proyecto supera el total a invertir.
     * @author AnaOrCam
     * @param cantidad se refiere cantidad a comprobar.
     * @return devuelve true si no supera la cantidad y false si por el contrario, la supera.
     */
    public boolean comprobarCantidadFinanciada(Proyecto proyecto, float cantidad){
        return modelo.comprobarCantidadFinanciada(proyecto,cantidad);
    }

    /**
     * Resta financiacion a un proyecto
     * @author AnaOrCam
     * @param cantidad cantidad a eliminar
     * @param proyecto  proyecto en el que se va a eliminar la financiacion
     */
    public void restarFinanciacionAProyecto(float cantidad, Proyecto proyecto){
        modelo.restarFinanciacionAProyecto(cantidad, proyecto);
    }
    /**
     * Muestra el grafico de financiacion de un proyecto
     * @author AnaOrCam
     * @param proyecto  proyecto del que se va a mostrar la financiacion
     */
    public void mostrarGraficoFinanciacion(Proyecto proyecto){
        vista.grafico(modelo.calcularPorcentajeFinanciado(proyecto));
    }
    /**
     * Muestra las recompensas que puede elegir
     * @author AnaOrCam
     * @param cantidad cantidad con la que se opta a las recompensas
     * @param proyecto  proyecto en el que se va a añdir la financiacion para obtener las recompensas
     */
    public void mostrarRecompensasAElegir(float cantidad, Proyecto proyecto){
        if (!modelo.listaDeRecompensasAElegir(cantidad, proyecto).isEmpty()){
            vista.mostrarRecompensasAElegir(proyecto.getListaDeRecompensasAElegir(cantidad,proyecto));
        }
    }
    /**
     * Devuelve si hay o no recompensas en un proyecto por una cantidad
     * @author AnaOrCam
     * @param cantidad cantidad con la que se busca la recompensas
     * @param proyecto  proyecto en el que se busca una recompensa
     * @return devuelve true si hay recompensas disponibles con esa cantidad
     */
    public boolean siRecompensa(float cantidad, Proyecto proyecto){
        if (!modelo.listaDeRecompensasAElegir(cantidad, proyecto).isEmpty()){
            return true;
        }
        return false;
    }
    /**
     * Busca recompensas por nombre en un proyecto
     * @author AnaOrCam
     * @param nombre nombre de la recompensa
     * @param proyecto proyecto en el que se busca la recompensa
     * @return devuelve la recompensa buscada
     */
    public Recompensa buscarRecompensa(String nombre, Proyecto proyecto){
        return modelo.buscarRecompensa(nombre, proyecto);
    }
}
