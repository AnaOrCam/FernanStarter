import java.util.Date;
import java.util.LinkedList;

public class Proyecto implements Invertible{
    private String nombre;
    private Date fechaApertura;
    private Date fechaCierre;
    private int cantidadInvertidaActual;
    private int cantidadAInvertirTotal;
    private LinkedList<Recompensa> listaRecompensas;


    public Proyecto(int numeroRecompensas,String nombre,Date fechaApertura,Date fechaCierre, int cantidadAInvertirTotal){
        this.nombre=nombre;
        this.fechaApertura=fechaApertura;
        this.fechaCierre=fechaCierre;
        this.cantidadInvertidaActual=0;
        this.cantidadAInvertirTotal=cantidadAInvertirTotal;
        listaRecompensas=new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
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
        return "Proyecto "+nombre+"\nFecha de apertura: "+fechaApertura+" - "+"Fecha de cierre: "+fechaCierre;
    }
}
