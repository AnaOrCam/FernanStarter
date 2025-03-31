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

    public void aniadirFinanciacionAProyecto(float cantidad, Proyecto proyecto){
        proyecto.aniadirFinanciacion(cantidad);
    }
    public void restarFinanciacionAProyecto(float cantidad, Proyecto proyecto){
        proyecto.restarFinanciacion(cantidad);
    }

    public int calcularPorcentajeFinanciado(Proyecto proyecto){
        return proyecto.calcularPorcentajeFinanciado(proyecto);
    }

    public LinkedList<Recompensa> getListaRecompensas(){
        for (int i = 0; i < proyectos.size(); i++) {
            return proyectos.get(i).getListaRecompensas();
        }
        return null;
    }

    public LinkedList<Recompensa> listaDeRecompensasAElegir(float cantidad, Proyecto proyecto){
        return proyecto.getListaDeRecompensasAElegir(cantidad,proyecto);
    }
    public Recompensa buscarRecompensa(String nombre, Proyecto proyecto){
        return proyecto.buscarRecompensa(nombre);
    }

    public boolean compruebaProyectoExiste(String nombre){
        for (int i = 0; i < proyectos.size(); i++) {
            if (proyectos.get(i).getNombre().equals(nombre))return true;
        }
        return false;
    }
    public void borrarProyecto(Proyecto aux){
        proyectos.remove(aux);
    }
}
