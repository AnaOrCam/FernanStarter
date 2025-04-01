
public class Recompensa {
    private String nombre;
    private String descripcion;
    private float importe;
    private static int idRecompensa=0;
    int id;

    /**
     * Constructor del objeto Recompensa.
     * @author davidrn06
     * @param nombre se refiere al atributo nombre de la recompensa en formato String.
     * @param descripcion se refiere a la descripción de la recompensa en formato TipoUsuario.
     * @param importe se refiere al importe de la recompensa de tipo float.
     * @return no devuelve nada.
     */
   public Recompensa(String nombre, String descripcion , float importe){
       this.nombre=nombre;
       this.descripcion=descripcion;
       this.importe=importe;
       id=++idRecompensa;
   }

    /**
     * Getter del nombre de la recompensa.
     * @author davidrn06
     * @return devuelve el nombre de tipo String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el atributo nombre.
     * @author davidrn06
     * @param nombre se refiere al atributo nombre nuevo que sustituirá al anterior de tipo String.
     * @return no devuelve nada.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la descripcion de la recompensa.
     * @author davidrn06
     * @return devuelve la recompensa de tipo String.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Getter del importe de la recompensa.
     * @author davidrn06
     * @return devuelve el importe de tipo float.
     */
    public float getImporte() {
        return importe;
    }

    /**
     * Getter del id de la recompensa.
     * @author davidrn06
     * @return devuelve el id de tipo int.
     */
    public int getId() {
        return id;
    }

    /**
     * Modifica el atributo id.
     * @author davidrn06
     * @param id se refiere al atributo id nuevo que sustituirá al anterior de tipo int.
     * @return no devuelve nada.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Redefine la función toString para mostrar el objeto Recompensa.
     * @author AnaOrCam
     * @return devuelve el String definido.
     */
   public String toString(){
       return nombre+"\nDescripción de la recompensa: "+descripcion+"\nImporte: "+importe;
   }

}
