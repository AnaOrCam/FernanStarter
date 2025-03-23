import java.util.Date;
import java.util.LinkedList;

public class Proyecto implements Invertible{
    private String nombre;
    private Date fechaApertura;
    private Date fechaCierre;
    private LinkedList<Recompensa> listaRecompensas = new LinkedList<Recompensa>();

    private int numRecompensas;


    public Proyecto(int numeroRecompensas,String nombre,Date fechaApertura,Date fechaCierre){
        this.nombre=nombre;
        this.fechaApertura=fechaApertura;
        this.fechaCierre=fechaCierre;
        numRecompensas=0;
    }

    public void insertaRecompensa(Recompensa nueva){
        listaRecompensas.add(nueva);
    }

    public void eliminaRecompensa(Recompensa aEliminar){
        for (Recompensa aux:listaRecompensas){
            if (aux==aEliminar){
                listaRecompensas.remove(aux);
            }
        }
    }
}
