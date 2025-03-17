
public class Recompensa {
    private String nombre;
    private String descripcion;
    private float importe;
    private static int idRecompensa=0;
    int id;

   public Recompensa(String nombre, String descripcion , float importe){
       this.nombre=nombre;
       this.descripcion=descripcion;
       this.importe=importe;
       id=++idRecompensa;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public static void setIdRecompensa(int idRecompensa) {
        Recompensa.idRecompensa = idRecompensa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recompensa(){

   }
   public int getIdRecompensa(){
       return id;
   }
}
