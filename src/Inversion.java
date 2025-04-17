import java.io.Serializable;

public class Inversion implements Invertible , Serializable {
    private String nombreProyecto;
    private float cantidadInvertida;
    private Inversor inversor;
    private Recompensa recompensaElegida;
    private static int contadorInversiones =0;
    private int idInversion;

    /**
     * Constructor para crear una inversion
     * @author AnaOrCam
     * @param inversor nombre del inversor que la crea
     * @param proyecto nombre del proyecto en el que se ha realizadp
     * @param  cantidadInvertida cantidad invertida en la inverison
     * @param recompensaElegida recompensa que ha elegido
     */
    public Inversion(String proyecto, float cantidadInvertida, Inversor inversor, Recompensa recompensaElegida){
        this.nombreProyecto =proyecto;
        this.cantidadInvertida=cantidadInvertida;
        this.inversor=inversor;
        this.recompensaElegida=recompensaElegida;
        idInversion= contadorInversiones++;

    }
    /**
     * Constructor para crear una inversion
     * @author AnaOrCam
     * @param inversor nombre del inversor que la crea
     * @param proyecto nombre del proyecto en el que se ha realizadp
     * @param  cantidadInvertida cantidad invertida en la inverison
     */
    public Inversion(String proyecto, float cantidadInvertida, Inversor inversor){
        this.nombreProyecto =proyecto;
        this.cantidadInvertida=cantidadInvertida;
        this.inversor=inversor;
        this.recompensaElegida=null;
        idInversion= contadorInversiones++;
    }
    /**
     * Devuelve la cantidad invertida en una inversion
     * @author AnaOrCam
     * @return  la cantidad
     */
    public float getCantidadInvertida() {
        return cantidadInvertida;
    }
    /**
     * Devuelve el nombre del proyecto
     * @author AnaOrCam
     * @return  devuelve el nombre del proyecto
     */
    public String getNombreProyecto() {
        return nombreProyecto;
    }
    /**
     * Devuelve la id de la inversion
     * @author AnaOrCam
     * @return  la id de la inversion
     */
    public int getIdInversion() {
        return idInversion;
    }
    /**
     * Aumenta la cantida invertida
     * @author AnaOrCam
     * @param cantidad la cantidad a aumentar
     */
    public void aumentaInversion(float cantidad){
        this.cantidadInvertida+=cantidad;
    }
    /**
     * Selecciona la Recompensa elegida
     * @author AnaOrCam
     * @param recompensaElegida  recompensa que se elige
     */
    public void setRecompensaElegida(Recompensa recompensaElegida) {
        this.recompensaElegida = recompensaElegida;
    }
    /**
     * Disminuye la inversion realizada
     * @author AnaOrCam
     * @param cantidad que va a ser disminuida
     */
    public void disminuyeInversion(float cantidad){
        this.cantidadInvertida-=cantidad;
    }
    /**
     * Devuelve la recompensa elegida en dicha inversion
     * @author AnaOrCam
     * @return  devuelve el la recompensa elegida
     */
    public Recompensa getRecompensaElegida() {
        return recompensaElegida;
    }

    public Inversor getInversor() {
        return inversor;
    }
    /**
     * Sobreescribe el metodo toString
     * @author AnaOrCam
     * @return  la cadena de con los datos de la inversion
     */
    public String toString(){
        if (recompensaElegida==null){
            return "Proyecto: "+nombreProyecto+" - ID de inversión: "+idInversion+"\nCantidad invertida: "+cantidadInvertida+"\nInversor: "+inversor;
        }else return "Proyecto: "+nombreProyecto+" - ID de inversión: "+idInversion+"\nCantidad invertida: "+cantidadInvertida+" - Recompensa elegida: "+recompensaElegida+"\nInversor: "+inversor;
    }
}
