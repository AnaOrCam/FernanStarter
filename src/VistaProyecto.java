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
    public void vistaDetalladaProyecto(Proyecto proyecto){
        System.out.println(
                "Nombre: " + proyecto.getNombre() + "\n" +
                "Cantidad a financiar: " + proyecto.getCantidadAInvertirTotal() + "\n" +
                "Cantidad financiada hasta el momento: " + proyecto.getCantidadInvertidaActual() + "\n" +
                "Fecha de apertura de inversiones: " + proyecto.getFechaApertura() + "\n" +
                "Fecha de cierre de inversiones: " + proyecto.getFechaCierre()+"\n"+
                "Tematica "+ proyecto.getTematicaProyecto());
                for(int i=0;i<proyecto.getListaRecompensas().size();i++){
                    System.out.println("Recompensa "+i+" Nombre "+proyecto.getListaRecompensas().get(i).getNombre()+"\nDescripcion: "+proyecto.getListaRecompensas().get(i).getDescripcion()+" Importe"+proyecto.getListaRecompensas().get(i).getImporte());
                }
    }
    public void muestraTipos(){
        System.out.println("Tipos disponible: ");
        int i=1;
        for (TematicaProyecto tipo : TematicaProyecto.values()) {
            System.out.println("-" + tipo);
            i++;
        }

    }
}
