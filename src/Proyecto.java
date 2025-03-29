import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class Proyecto implements Invertible{
    private String nombre;
    private LocalDate fechaApertura;
    private LocalDate fechaCierre;
    private int cantidadInvertidaActual;
    private int cantidadAInvertirTotal;
    private LinkedList<Recompensa> listaRecompensas;
    private String descripcion;
    private TematicaProyecto tematicaProyecto;

    public Proyecto(int numeroRecompensas,String nombre,LocalDate fechaApertura,LocalDate fechaCierre, int cantidadAInvertirTotal,String descripcion,TematicaProyecto tematicaProyecto){
        this.nombre=nombre;
        this.fechaApertura=fechaApertura;
        this.fechaCierre=fechaCierre;
        this.cantidadInvertidaActual=0;
        this.cantidadAInvertirTotal=cantidadAInvertirTotal;
        this.descripcion=descripcion;
        this.tematicaProyecto=tematicaProyecto;
        listaRecompensas=new LinkedList<>();
    }

    public int getCantidadInvertidaActual() {
        return cantidadInvertidaActual;
    }

    public TematicaProyecto getTematicaProyecto() {
        return tematicaProyecto;
    }

    public void setTematicaProyecto(TematicaProyecto tematicaProyecto) {
        this.tematicaProyecto = tematicaProyecto;
    }

    public void setCantidadInvertidaActual(int cantidadInvertidaActual) {
        this.cantidadInvertidaActual = cantidadInvertidaActual;
    }

    public int getCantidadAInvertirTotal() {
        return cantidadAInvertirTotal;
    }

    public void setCantidadAInvertirTotal(int cantidadAInvertirTotal) {
        this.cantidadAInvertirTotal = cantidadAInvertirTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public LinkedList<Recompensa> getListaRecompensas() {
        return listaRecompensas;
    }


    public void insertaRecompensa(Recompensa nueva){
        listaRecompensas.add(nueva);
    }

    public void eliminaRecompensa(Recompensa aEliminar) {
        for (Recompensa aux : listaRecompensas) {
            if (aux == aEliminar) {
                listaRecompensas.remove(aux);
            }
        }
    }
    public void aumentaInversion(int cantidadAAumentar){
        cantidadInvertidaActual+=cantidadAAumentar;
    }


    public String toString(){
        return "Proyecto "+nombre+"\nFecha de apertura: "+fechaApertura+" - "+"Fecha de cierre: "+fechaCierre+"\nDescripcion: "+descripcion;
    }
}
