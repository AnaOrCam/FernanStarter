import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class VistaProyecto implements Serializable {
    private String textoVerde;
    private String textoRojo;
    private String resetColorTexto;
    private String textoMorado;
    private String textoGris;

    /**
     * Constructor de la vista VistaProyecto.
     * @author AnaOrCam
     * @param verde se refiere al color verde en formato String.
     * @param rojo se refiere al color rojo en formato String.
     * @param reset se refiere al color de base del texto en formato String.
     * @param morado se refiere al color morado en formato String.
     * @param gris se refiere al color gris en formato String.
     * @return no devuelve nada.
     */
    public VistaProyecto(String verde, String rojo, String reset, String morado, String gris){
        this.textoVerde =verde;
        this.textoRojo =rojo;
        this.resetColorTexto =reset;
        this.textoMorado =morado;
        this.textoGris=gris;
    }
    /**
     * Muestra mensaje de operacion fallida
     * @author AnaOrCam
     */
    public void operacionFallida(){
        System.out.println(textoRojo+"Error. La operación no ha podido realizarse"+resetColorTexto);
    }

    /**
     * Muestra la lista de proyectos.
     * @author AnaOrcam
     * @param listaProyectos se refiere a la LinkedList que contiene la lista de proyectos.
     * @return no devuelve nada.
     */
    public void muestraListaProyectos(LinkedList listaProyectos){
        for (int i = 0; i < listaProyectos.size(); i++) {
            System.out.println(listaProyectos.get(i));
            muestraRecompensas((Proyecto)listaProyectos.get(i));
            System.out.println("----------------------------------");
        }
    }

    /**
     * Muestra la lista de proyectos con la gráfica.
     * @author AnaOrcam
     * @param listaProyectos se refiere a la LinkedList que contiene la lista de proyectos.
     * @return no devuelve nada.
     */
    public void muestraListaProyectosConGrafica(LinkedList<Proyecto> listaProyectos){
        for (int i = 0; i < listaProyectos.size(); i++) {
            System.out.println(listaProyectos.get(i));
            System.out.println("Recompensas:");
            muestraRecompensas(listaProyectos.get(i));
            grafico(listaProyectos.get(i).calcularPorcentajeFinanciado(listaProyectos.get(i)));
        }
    }
    /**
     * Muestra la lista de proyectos con la gráfica.
     * @author davidrn06
     * @param aux se refiere a la LinkedList que contiene la lista de proyectos.
     */
    public void muestraProyectoConGrafica(Proyecto aux){
            System.out.println(aux);
            if (!aux.getListaRecompensas().isEmpty()){
                System.out.println("Recompensas:");
                muestraRecompensas(aux);
            }
            grafico(aux.calcularPorcentajeFinanciado(aux));
    }

    /**
     * Muestra la lista de recompensas.
     * @author AnaOrcam
     * @param proyecto se refiere al proyecto que contiene la lista de recompensas.
     * @return no devuelve nada.
     */
    private void muestraRecompensas(Proyecto proyecto){
        LinkedList<Recompensa>listaRecompensas=proyecto.getListaRecompensas();
        for (Object e: listaRecompensas){
            System.out.println(e);
        }
    }

    /**
     * Muestra la lista de inversiones.
     * @author AnaOrcam
     * @param listaInversiones se refiere a la lista de inversiones que contiene un proyecto.
     * @return no devuelve nada.
     */
    public void muestraInversiones(List<Inversion> listaInversiones){
        listaInversiones.forEach(System.out::println);
    }

    /**
     * Muestra un mensaje de operación correcta y muestra el objeto.
     * @author AnaOrcam
     * @param proyecto se refiere al proyecto a mostrar.
     * @return no devuelve nada.
     */
    public void proyectoInsertadoCorrectamente(Proyecto proyecto){
        System.out.println(textoVerde +"Proyecto añadido correctamente"+ resetColorTexto);
        muestraProyecto(proyecto);
    }

    /**
     * Muestra el objeto proyecto.
     * @author AnaOrcam
     * @param proyecto se refiere al proyecto a mostrar.
     * @return no devuelve nada.
     */
    public void muestraProyecto(Proyecto proyecto){
        System.out.println(proyecto);
    }

    /**
     * Muestra los tipos de proyecto disponibles.
     * @author davidrn06
     * @return no devuelve nada.
     */
    public void muestraTipos(){
        System.out.println("Tipos disponibles: ");
        int i=1;
        for (TematicaProyecto tipo : TematicaProyecto.values()) {
            System.out.println("-" + tipo);
            i++;
        }
    }

    /**
     * Muestra las recompensas que se pueden elegir al hacer una inversión.
     * @author AnaOrCam
     * @param listaRecompensas se refiere a la LinkedList que contiene la lista de recompensas.
     * @return no devuelve nada.
     */
    public void mostrarRecompensasAElegir(LinkedList listaRecompensas){
        for (Object e: listaRecompensas){
            System.out.println(e);
        }
    }

    /**
     * Genera un gráfico de porcentaje de proyecto financiado.
     * @author AnaOrCam
     * @param porcentajeFinanciado es el porcentaje financiado hasta el momento en el proyecto.
     * @return no devuelve nada.
     */
    public void grafico (int porcentajeFinanciado){
        for (int i = 1; i <=8; i++) {
            System.out.printf("|");
            if (i>=3 && i<=5){
                for (int j = 0; j <= porcentajeFinanciado; j++) {
                    System.out.printf(textoVerde+"█"+resetColorTexto);
                }
                for (int j = porcentajeFinanciado +1; j <=100 ; j++) {
                    System.out.printf(textoGris+"█"+resetColorTexto);
                }
            }
            if (i==8){
                for (int j = 0; j < 100; j++) {
                    System.out.printf("_");
                }
            }
            System.out.println();
        }
    }
}
