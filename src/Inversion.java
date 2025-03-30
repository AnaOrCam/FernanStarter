public class Inversion {
    private String nombreProyecto;
    private float cantidadInvertida;
    private Inversor inversor;
    private Recompensa recompensaElegida;


    public Inversion(String proyecto, float cantidadInvertida, Inversor inversor, Recompensa recompensaElegida){
        this.nombreProyecto =proyecto;
        this.cantidadInvertida=cantidadInvertida;
        this.inversor=inversor;
        this.recompensaElegida=recompensaElegida;
    }
    public Inversion(String proyecto, float cantidadInvertida, Inversor inversor){
        this.nombreProyecto =proyecto;
        this.cantidadInvertida=cantidadInvertida;
        this.inversor=inversor;
        this.recompensaElegida=null;
    }

    public float getCantidadInvertida() {
        return cantidadInvertida;
    }

    public Recompensa getRecompensaElegida() {
        return recompensaElegida;
    }

    public Inversor getInversor() {
        return inversor;
    }
    public String toString(){
        if (recompensaElegida==null){
            return "Proyecto: "+nombreProyecto+"\nCantidad invertida: "+cantidadInvertida;
        }else return "Proyecto: "+nombreProyecto+"\nCantidad invertida: "+cantidadInvertida+" - Recompensa elegida: "+recompensaElegida;
    }
}
