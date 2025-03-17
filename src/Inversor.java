public class Inversor extends Usuario implements Bloqueable{
    private int nProyectosInvertidos;
    private Inversion[] proyectosInvertidos;
    private int cantidadFinanciadaTotal;
    private boolean bloqueado;
    private  int idInversor;
    public Inversor(String nombre,String correo,String contrasena){
        super( nombre, correo, contrasena);
        idInversor=ids;

    }
}
