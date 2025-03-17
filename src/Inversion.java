public class Inversion {
    private Proyecto proyecto;
    private float cantidadInvertida;
    private Inversor inversor;
    public Inversion(Proyecto proyecto, float cantidadInvertida, Inversor inversor){
        this.proyecto=proyecto;
        this.cantidadInvertida=cantidadInvertida;
        this.inversor=inversor;
    }
    public void aumentaInversion(int cantidadAAumentar){
        cantidadInvertida+=cantidadAAumentar;
    }
}
