
public class ControladorProyectos {

    private GestionProyectos modelo=new GestionProyectos();
    private VistaProyecto vista =new VistaProyecto();

    public ControladorProyectos(GestionProyectos modelo,VistaProyecto vista){
        this.modelo=modelo;
        this.vista=vista;
    }
    public void mostrarProyectos(){
        vista.muestraListaProyectos(modelo.getProyectos(), modelo.getListaRecompensas());
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
}
