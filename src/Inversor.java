import java.util.LinkedList;

public class Inversor extends Usuario implements Bloqueable{
    private LinkedList<Inversion> proyectosInvertidos;
    private int cantidadFinanciadaTotal;
    private boolean bloqueado;
    private  int idInversor;
    public Inversor(String nombre,String correo,String contrasena, TipoUsuario tipoUsuario){
        super( nombre, correo, contrasena, tipoUsuario);
        idInversor=getIds();
        sumaid();
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


    public int getIdInversor() {
        return idInversor;
    }

    public void setIdInversor(int idInversor) {
        this.idInversor = idInversor;
    }
    public void bloquearUsuario() {
        this.bloqueado=true;
    }

    public void desbloquearUsuario(){
        this.bloqueado=false;
    }

}
