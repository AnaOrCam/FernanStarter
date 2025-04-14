import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GestionProyectos {
    private LinkedList<Proyecto> proyectos;


    /**
     * Constructor de gestion de proyecto
     * @author AnaOrCam
     */
    public GestionProyectos(){
        proyectos=new LinkedList<>();
    }
    /**
     * Devuelve la lista de proyectos
     * @author AnaOrCam
     * @return lista de proyectos
     */
    public LinkedList<Proyecto> getProyectos() {
        return proyectos;
    }
    /**
     * Inserta un proyecto en la lista de proyectos
     * @author AnaOrCam
     * @param  proyecto proyecto que va a ser insertado
     */
    public void insertarProyecto(Proyecto proyecto){
        proyectos.add(proyecto);
    }
    /**
     * Busca un proyecto por su nombre
     * @author AnaOrCam
     * @param nombre nombre del proyecto que se quiere buscar
     * @return devuelve el proyecto encontrado/null si no lo encuentra
     */
    public Proyecto buscaProyecto(String nombre){
        for(Proyecto e: proyectos){
            if (e.getNombre().equalsIgnoreCase(nombre)) return e;
        }
        return null;
    }

    public List<Proyecto> ordenarPorImporteFinanciado(LinkedList<Proyecto> proyectos){
        List<Proyecto> listaProyectos=proyectos.stream().toList();
        return listaProyectos
                .stream()
                .sorted((o1,o2) -> o1.getCantidadInvertidaActual()-o2.getCantidadInvertidaActual())
                .toList();
    }

    public List<Proyecto> ordenarPorCantidadAFinanciar(LinkedList<Proyecto> proyectos){
        List<Proyecto> listaProyectos=proyectos.stream().toList();
        return listaProyectos
                .stream()
                .sorted((o1,o2) -> o1.getCantidadAInvertirTotal()-o2.getCantidadAInvertirTotal())
                .toList();
    }

    public List<Proyecto> ordenarPorFechaApertura(LinkedList<Proyecto> proyectos){
        List<Proyecto> listaProyectos=proyectos.stream().toList();
        return listaProyectos
                .stream()
                .sorted((o1,o2) -> o1.getFechaApertura().compareTo(o2.getFechaApertura()))
                .toList();
    }

    public List<Proyecto> ordenarPorFechaCierre(LinkedList<Proyecto> proyectos){
        List<Proyecto> listaProyectos=proyectos.stream().toList();
        return listaProyectos
                .stream()
                .sorted((o1,o2) -> o1.getFechaCierre().compareTo(o2.getFechaCierre()))
                .toList();
    }

    /**
     * Añade financiaciona un proyecto
     * @author AnaOrCam
     * @param cantidad cantidad que se va a añadir
     * @param proyecto proyecto en el que se va a añadir
     * @return devuelve true si se añade
     */
    public boolean aniadirFinanciacionAProyecto(float cantidad, Proyecto proyecto){
        return (proyecto.aniadirFinanciacion(cantidad));
    }
    /**
     * Resta financiacion a un proyecto
     * @author AnaOrCam
     * @param cantidad cantidad a restar
     * @param proyecto proyecto en el que se va a restar
     */
    public void restarFinanciacionAProyecto(float cantidad, Proyecto proyecto){
        proyecto.restarFinanciacion(cantidad);
    }
    /**
     * Calcula el porcentaje financiado actual
     * @author AnaOrCam
     * @param proyecto proyecto del que se desea calcular
     * @return el numero del porcentaje
     */
    public int calcularPorcentajeFinanciado(Proyecto proyecto){
        return proyecto.calcularPorcentajeFinanciado(proyecto);
    }
    /**
     * Devuelve la lista de recompensas
     * @author AnaOrCam
     * @return devuelve una lista
     */
    public LinkedList<Recompensa> getListaRecompensas(){
        for (int i = 0; i < proyectos.size(); i++) {
            return proyectos.get(i).getListaRecompensas();
        }
        return null;
    }
    /**
     * Devuelve la lista de recompensas que puedes elegir
     * @author AnaOrCam
     * @param cantidad cantidad por la que se elige
     * @param  proyecto del que se eligen las recompensas
     * @return devuelve la lista de recompensas
     */
    public LinkedList<Recompensa> listaDeRecompensasAElegir(float cantidad, Proyecto proyecto){
        return proyecto.getListaDeRecompensasAElegir(cantidad,proyecto);
    }
    /**
     * Busca las recompensas de un proyecto
     * @author AnaOrCam
     * @param nombre nombre de la recompensa a buscar
     * @param proyecto proyecto del que se buscan las recompensas
     * @return devuelve la recompensa una vez encontrada
     */
    public Recompensa buscarRecompensa(String nombre, Proyecto proyecto){
        return proyecto.buscarRecompensa(nombre);
    }
    /**
     * Comprueba si existe un proyecto por su nombre
     * @author davidrn06
     * @param nombre nombre del proyecto que se quiere comprobar
     * @return true si existe
     */
    public boolean compruebaProyectoExiste(String nombre){
        for (int i = 0; i < proyectos.size(); i++) {
            if (proyectos.get(i).getNombre().equals(nombre))return true;
        }
        return false;
    }
    /**
     * Borra un proyecto
     * @author davidrn06
     * @param aux nombre que se va a borrar
     */
    public void borrarProyecto(Proyecto aux){
        proyectos.remove(aux);
    }
}
