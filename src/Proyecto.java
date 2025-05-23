import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static utilidades.FuncionesFechas.*;
public class Proyecto implements Serializable {
    private String nombre;
    private LocalDate fechaApertura;
    private LocalDate fechaCierre;
    private int cantidadInvertidaActual;
    private int cantidadAInvertirTotal;
    private LinkedList<Recompensa> listaRecompensas;
    private LinkedList<Inversion> listaInversiones;
    private String descripcion;
    private TematicaProyecto tematicaProyecto;

    /**
     * Constructor del objeto Proyecto.
     * @author davidrn06
     * @param numeroRecompensas se refiere al numero de recompensas.
     * @param nombre se refiere al atributo nombre del proyecto en formato String.
     * @param fechaApertura se refiere al atributo fecha de apertura en formato LocalDate.
     * @param fechaCierre se refiere al atributo fecha de cierre en formato LocalDate.
     * @param cantidadAInvertirTotal se refiere al atributo cantidadAInvertirTotal del objeto en tipo int.
     * @param descripcion se refiere a la descripción del proyecto en formato TipoUsuario.
     * @param tematicaProyecto se refiere al atributo tematicaProyecto del objeto en formato TematicaProyecto.
     */
    public Proyecto(int numeroRecompensas,String nombre,LocalDate fechaApertura,LocalDate fechaCierre, int cantidadAInvertirTotal,String descripcion,TematicaProyecto tematicaProyecto){
        this.nombre=nombre;
        this.fechaApertura=fechaApertura;
        this.fechaCierre=fechaCierre;
        this.cantidadInvertidaActual=0;
        this.cantidadAInvertirTotal=cantidadAInvertirTotal;
        this.descripcion=descripcion;
        this.tematicaProyecto=tematicaProyecto;
        listaRecompensas=new LinkedList<>();
        listaInversiones=new LinkedList<>();
    }

    /**
     * Getter de la cantidadInvertidaActual.
     * @author davidrn06
     * @return devuelve el atributo cantidadInvertidaActual de tipo int.
     */
    public int getCantidadInvertidaActual() {
        return cantidadInvertidaActual;
    }

    /**
     * Getter del atributo tematicaProyecto.
     * @author davidrn06
     * @return devuelve el atributo tematicaProyecto de tipo TematicaProyecto.
     */
    public TematicaProyecto getTematicaProyecto() {
        return tematicaProyecto;
    }

    /**
     * Modifica el atributo tematicaProyecto.
     * @author davidrn06
     * @param tematicaProyecto se refiere al atributo tematicaProyecto que sustituirá an antiguo de tipo TematicaProyecto.
     */
    public void setTematicaProyecto(TematicaProyecto tematicaProyecto) {
        this.tematicaProyecto = tematicaProyecto;
    }

    /**
     * Comprueba que el importe que se pasa por parametro mas lo actualmente invertido en el proyecto supera el total a invertir.
     * @author AnaOrCam
     * @param cantidad se refiere cantidad a comprobar.
     * @return devuelve true si no supera la cantidad y false si por el contrario, la supera.
     */
    public boolean comprobacionImporteFinanciacion(float cantidad){
        if (cantidadInvertidaActual+cantidad<=cantidadAInvertirTotal) return true;
        return false;
    }
    /**
     * Añade financiación al importe total a invertir del proyecto.
     * @author AnaOrCam
     * @param cantidad se refiere cantidad a añadir a la financiación del proyecto de tipo float.
     */
    public void aniadirFinanciacion(float cantidad) {
        this.cantidadInvertidaActual += cantidad;
    }

    /**
     * Getter de la lista de inversiones.
     * @author anaOrCam
     * @return devuelve la Linkedlist que contiene las inversiones realizadas.
     */
    public LinkedList<Inversion> getListaInversiones() {
        return listaInversiones;
    }

    /**
     * Ordena la lista de inversiones por el nombre del inversor.
     * @author anaOrCam
     * @return devuelve la lista ordenada en formato List.
     */
    public List<Inversion> ordenarInversionesPorNombreInversor(){
        List<Inversion> listaOrdenada=listaInversiones.stream().toList();
        listaOrdenada
                .stream()
                .sorted((o1,o2)->o1.getInversor().getNombre().compareTo(o2.getInversor().getNombre()))
                .toList();
        return listaOrdenada;
    }

    /**
     * Añade una inversion a la lista de inversiones.
     * @author AnaOrCam
     * @param inversion se refiere al objeto inversion que se añadirá a la lista.
     */
    public void insertarInversion(Inversion inversion){
        listaInversiones.add(inversion);
    }

    /**
     * Resta financiación a un proyecto.
     * @author davidrn06
     * @param cantidad se refiere al atributo cantidad a restar a la financiación del proyecto de tipo float.
     */
    public void restarFinanciacion(float cantidad) {
        this.cantidadInvertidaActual-=cantidad;
    }

    /**
     * Getter de la cantidadAInvertirTotal.
     * @author davidrn06
     * @return devuelve la cantidad total a invertir en tipo int.
     */
    public int getCantidadAInvertirTotal() {
        return cantidadAInvertirTotal;
    }

    /**
     * Modifica el atributo cantidadAInvertirTotal.
     * @author davidrn06
     * @param cantidadAInvertirTotal se refiere al atributo cantidadAInvertirTotal nuevo que sustituirá al anterior de tipo int.
     */
    public void setCantidadAInvertirTotal(int cantidadAInvertirTotal) {
        this.cantidadAInvertirTotal = cantidadAInvertirTotal;
    }

    /**
     * Getter del nombre del proyecto.
     * @author AnaOrCam
     * @return devuelve el nombre de tipo String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el atributo nombre.
     * @author AnaOrCam
     * @param nombre se refiere al atributo nombre nuevo que sustituirá al anterior de tipo String.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la fecha de apertura del proyecto.
     * @author AnaOrCam
     * @return devuelve la fecha de apertura de tipo LocalDate.
     */
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Modifica el atributo fechaApertura.
     * @author AnaOrCam
     * @param fechaApertura se refiere al atributo fechaApertura nuevo que sustituirá al anterior de tipo LocalDate.
     */
    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Getter de la fecha de apertura del proyecto.
     * @author AnaOrCam
     * @return devuelve la fecha de cierre de tipo LocalDate.
     */
    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    /**
     * Getter de la lista de recompensas del proyecto.
     * @author AnaOrCam
     * @return la linkedList de recompensas.
     */
    public LinkedList<Recompensa> getListaRecompensas() {
        return listaRecompensas;
    }

    /**
     * Añade recompensas a la lista de recompensas del proyecto.
     * @author davidrn06
     * @param nueva se refiere a la nueva recompensa que se incluira en la lista de recompensas.
     */
    public void insertaRecompensa(Recompensa nueva){
        listaRecompensas.add(nueva);
    }

    /**
     * Crea una lista de posibles recompensas a elegir.
     * @author AnaOrCam
     * @param cantidad se refiere a la cantidad invertida en el proyecto de tipo float.
     * @param proyecto se refiere al proyecto del que se extraerán las recompensas.
     * @return devuelve la LinkedList que contiene las recompensas a elegir por parte del usuario.
     */
    public LinkedList<Recompensa> getListaDeRecompensasAElegir(float cantidad, Proyecto proyecto){
        LinkedList<Recompensa> listaRecompensasAElegir=new LinkedList<>();
        for (int i = 0; i < listaRecompensas.size(); i++) {
            if (cantidad>=listaRecompensas.get(i).getImporte()) listaRecompensasAElegir.add(listaRecompensas.get(i));
        }
        return listaRecompensasAElegir;
    }

    /**
     * Busca una recompensa a partir del nombre.
     * @author AnaOrCam
     * @param nombre se refiere al nombre de la recompensa por la cual se buscará.
     * @return devuelve el objeto recompensa si se encuentra a partir del nombre o null si no se encuentra.
     */
    public Recompensa buscarRecompensa (String nombre){
        for (int i = 0; i < listaRecompensas.size(); i++) {
            if (listaRecompensas.get(i).getNombre().equalsIgnoreCase(nombre)) return listaRecompensas.get(i);
        }
        return null;
    }

    /**
     * Calcula el porcentaje financiado d eun proyecto.
     * @author AnaOrCam
     * @param proyecto se refiere al proyecto del que se calculará el porcentaje financiado.
     * @return devuelve el entero porcentajeFinanciado.
     */
    public int calcularPorcentajeFinanciado(Proyecto proyecto){
        final int PORCENTAJE_FINANCIACION_TOTAL=100;
        int porcentajeFinanciadoActual= cantidadInvertidaActual*PORCENTAJE_FINANCIACION_TOTAL/cantidadAInvertirTotal;
        return porcentajeFinanciadoActual;
    }

    /**
     * Redefine la función toString para mostrar el objeto Proyecto.
     * @author AnaOrCam
     * @return devuelve el String definido.
     */
    public String toString(){
        String fechaAperturaString=parsearLocalDateAString(fechaApertura);
        String fechaCierreString =parsearLocalDateAString(fechaCierre);
        return "Proyecto "+nombre+"\nFecha de apertura: "+ fechaAperturaString +" - "+"Fecha de cierre: "+ fechaCierreString+
                "\nDescripcion: "+descripcion+"\nCantidad invertida: "+cantidadInvertidaActual+
                "\nCategoria: "+tematicaProyecto+
                "\nFinanciación total del proyecto: "+cantidadAInvertirTotal+
                "\nTiempo restante: " + (getTiempoRestanteParaInvertir(LocalDate.now(),fechaCierre)>0?tiempoRestanteParaInvertir(LocalDate.now(),fechaCierre):"no queda tiempo");
    }

    /**
     * Compara los nombres de dos proyectos para comprobar si son iguales.
     * @author davidrn06
     * @param proyecto se refiere al proyecto que se comparará.
     * @return devuelve true si es igual o false si no es igual.
     */
    public boolean equals(Proyecto proyecto){
        return  this.nombre.equals(proyecto.nombre) ;
    }

}
