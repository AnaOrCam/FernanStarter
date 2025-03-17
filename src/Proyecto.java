import java.util.Date;

public class Proyecto implements Invertible{
    private String nombre;
    private Date fechaApertura;
    private Date fechaCierre;
    private Recompensa [] arrayRecompensas;
    private int numRecompensas;


    public Proyecto(int numeroRecompensas,String nombre,Date fechaApertura,Date fechaCierre){
        this.nombre=nombre;
        this.fechaApertura=fechaApertura;
        this.fechaCierre=fechaCierre;
        arrayRecompensas=new Recompensa[numeroRecompensas];
        numRecompensas=0;
    }

    public void insertaRecompensa(Recompensa nueva){
        arrayRecompensas[numRecompensas++]=nueva;
    }

    public void eliminaRecompensa(Recompensa aEliminar){
        for (int i=0;i<numRecompensas;i++){
            if (arrayRecompensas[i].getIdRecompensa()==aEliminar.getIdRecompensa()){
                arrayRecompensas[i]=null;
            }
        }
    }
}
