import java.util.LinkedList;

public class Inversor extends Usuario implements Bloqueable{
    private LinkedList<Inversion> proyectosInvertidos;
    private int cantidadFinanciadaTotal;
    private boolean bloqueado;
    public Inversor(String nombre,String correo,String contrasena, TipoUsuario tipoUsuario){
        super( nombre, correo, contrasena, tipoUsuario);
        bloqueado=false;
        proyectosInvertidos=new LinkedList<>();
    }

    public LinkedList<Inversion> getProyectosInvertidos() {
        return proyectosInvertidos;
    }

    public void setProyectosInvertidos(LinkedList<Inversion> proyectosInvertidos) {
        this.proyectosInvertidos = proyectosInvertidos;
    }

    public int getCantidadFinanciadaTotal() {
        return cantidadFinanciadaTotal;
    }

    public void setCantidadFinanciadaTotal(int cantidadFinanciadaTotal) {
        this.cantidadFinanciadaTotal = cantidadFinanciadaTotal;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }



    public void bloquearUsuario() {
        this.bloqueado=true;
    }

    public void desbloquearUsuario(){
        this.bloqueado=false;
    }

}
