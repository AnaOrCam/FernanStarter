
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
}
