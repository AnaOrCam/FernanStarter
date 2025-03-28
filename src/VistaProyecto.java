import java.util.LinkedList;

public class VistaProyecto {
    private final String ANSI_GREEN= "\033[32m";
    private final String ANSI_RED="\033[31m";
    private final String ANSI_RESET= "\033[0m";
    private final String ANSI_PURPLE= "\033[35m";

    public void muestraListaProyectos(LinkedList listaProyectos, LinkedList listaRecompensas){
        for (int i = 0; i < listaProyectos.size(); i++) {
            System.out.println(listaProyectos.get(i));
            muestraRecompensas(listaRecompensas);
        }
    }

    private void muestraRecompensas(LinkedList listaRecompensas){
        for (Object e: listaRecompensas){
            System.out.println(e);
        }
    }

    public void proyectoInsertadoCorrectamente(Proyecto proyecto){
        System.out.println(ANSI_GREEN+"Proyecto añadido correctamente"+ANSI_RESET);
        muestraProyecto(proyecto);
    }
    public void muestraProyecto(Proyecto proyecto){
        System.out.println(proyecto);
    }
}
