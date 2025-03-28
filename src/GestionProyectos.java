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
    public Proyecto buscaProyecto(String nombre){
        for(Proyecto e: proyectos){
            if (e.getNombre().equalsIgnoreCase(nombre)) return e;
        }
        return null;
    }

    public LinkedList<Recompensa> getListaRecompensas(){
        for (int i = 0; i < proyectos.size(); i++) {
            return proyectos.get(i).getListaRecompensas();
        }
        return null;
    }
}
