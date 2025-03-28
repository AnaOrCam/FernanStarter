import java.util.LinkedList;

public class GestionProyectos {
    private LinkedList<Proyecto> proyectos;

    public GestionProyectos(){
        proyectos=new LinkedList<>();
    }

    public LinkedList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void insertarProyecto(Proyecto proyecto){
        proyectos.add(proyecto);
    }

    public LinkedList<Recompensa> getListaRecompensas(){
        for (int i = 0; i < proyectos.size(); i++) {
            return proyectos.get(i).getListaRecompensas();
        }
        return null;
    }
}
