
public class ControladorProyectos {

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
    public boolean mostrarProyectos(){
        if (!modelo.getProyectos().isEmpty()) {
            vista.muestraListaProyectos(modelo.getProyectos(), modelo.getListaRecompensas());
            return true;
        }
        return false;
    }
    public boolean mostrarProyectosConGrafico(){
        if (!modelo.getProyectos().isEmpty()) {
            vista.muestraListaProyectosConGrafica(modelo.getProyectos(), modelo.getListaRecompensas());
            return true;
        }
        return false;
    }
    public void insertarProyecto(Proyecto proyecto){
        modelo.insertarProyecto(proyecto);
        vista.proyectoInsertadoCorrectamente(proyecto);
    }
    public void insertarRecompensa(Recompensa recompensa, String nombreProyecto){
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
    public Proyecto buscarProyecto(String nombre){
        return modelo.buscaProyecto(nombre);
    }
    public void muestratipos(){
        vista.muestraTipos();
    }
    public void borrarProyecto(Proyecto aux){
        modelo.borrarProyecto(aux);
    }

    public void aniadirFinanciacionAProyecto(float cantidad, Proyecto proyecto){
        modelo.aniadirFinanciacionAProyecto(cantidad, proyecto);
    }

    public void mostrarGraficoFinanciacion(Proyecto proyecto){
        vista.grafico(modelo.calcularPorcentajeFinanciado(proyecto));
    }
    public void mostrarRecompensasAElegir(float cantidad, Proyecto proyecto){
        if (!modelo.listaDeRecompensasAElegir(cantidad, proyecto).isEmpty()){
            vista.mostrarRecompensasAElegir(proyecto.getListaDeRecompensasAElegir(cantidad,proyecto));
        }
    }
    public boolean siRecompensa(float cantidad, Proyecto proyecto){
        if (!modelo.listaDeRecompensasAElegir(cantidad, proyecto).isEmpty()){
            return true;
        }
        return false;
    }
    public Recompensa buscarRecompensa(String nombre, Proyecto proyecto){
        return modelo.buscarRecompensa(nombre, proyecto);
    }
}
