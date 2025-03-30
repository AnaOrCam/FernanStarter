import java.util.LinkedList;

public class VistaProyecto {
    private String textoVerde;
    private String textoRojo;
    private String resetColorTexto;
    private String textoMorado;
    private String textoGris;

    public VistaProyecto(String verde, String rojo, String reset, String morado, String gris){
        this.textoVerde =verde;
        this.textoRojo =rojo;
        this.resetColorTexto =reset;
        this.textoMorado =morado;
        this.textoGris=gris;
    }
    public void muestraListaProyectos(LinkedList listaProyectos, LinkedList listaRecompensas){
        for (int i = 0; i < listaProyectos.size(); i++) {
            System.out.println(listaProyectos.get(i));
            muestraRecompensas(listaRecompensas);
        }
    }
    public void muestraListaProyectosConGrafica(LinkedList<Proyecto> listaProyectos, LinkedList listaRecompensas){
        for (int i = 0; i < listaProyectos.size(); i++) {
            System.out.println(listaProyectos.get(i));
            muestraRecompensas(listaRecompensas);
            grafico(listaProyectos.get(i).calcularPorcentajeFinanciado(listaProyectos.get(i)));
        }
    }

    private void muestraRecompensas(LinkedList listaRecompensas){
        for (Object e: listaRecompensas){
            System.out.println(e);
        }
    }

    public void proyectoInsertadoCorrectamente(Proyecto proyecto){
        System.out.println(textoVerde +"Proyecto añadido correctamente"+ resetColorTexto);
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
