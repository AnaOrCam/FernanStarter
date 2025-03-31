public class Inversion implements Invertible{
    private String nombreProyecto;
    private float cantidadInvertida;
    private Inversor inversor;
    private Recompensa recompensaElegida;
    private static int contadorInversiones =0;
    private int idInversion;


    public Inversion(String proyecto, float cantidadInvertida, Inversor inversor, Recompensa recompensaElegida){
        this.nombreProyecto =proyecto;
        this.cantidadInvertida=cantidadInvertida;
        this.inversor=inversor;
        this.recompensaElegida=recompensaElegida;
        idInversion= contadorInversiones++;

    }
    public Inversion(String proyecto, float cantidadInvertida, Inversor inversor){
        this.nombreProyecto =proyecto;
        this.cantidadInvertida=cantidadInvertida;
        this.inversor=inversor;
        this.recompensaElegida=null;
        idInversion= contadorInversiones++;
    }

    public float getCantidadInvertida() {
        return cantidadInvertida;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public int getIdInversion() {
        return idInversion;
    }

    public void aumentaInversion(float cantidad){
        this.cantidadInvertida+=cantidad;
    }

    public void setRecompensaElegida(Recompensa recompensaElegida) {
        this.recompensaElegida = recompensaElegida;
    }

    public void disminuyeInversion(float cantidad){
        this.cantidadInvertida-=cantidad;
    }

    public Recompensa getRecompensaElegida() {
        return recompensaElegida;
    }

    public Inversor getInversor() {
        return inversor;
    }
    public String toString(){
        if (recompensaElegida==null){
            return "Proyecto: "+nombreProyecto+" - ID de inversión: "+idInversion+"\nCantidad invertida: "+cantidadInvertida;
        }else return "Proyecto: "+nombreProyecto+" - ID de inversión: "+idInversion+"\nCantidad invertida: "+cantidadInvertida+" - Recompensa elegida: "+recompensaElegida;
    }
}
