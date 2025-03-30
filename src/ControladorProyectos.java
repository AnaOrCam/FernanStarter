
public class ControladorProyectos {

    private GestionProyectos modelo;
    private VistaProyecto vista;

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
    public void insertarRecompensa(Recompensa recompensa, Proyecto proyecto){
        Proyecto aux=proyecto;
        aux.insertaRecompensa(recompensa);
    }
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
