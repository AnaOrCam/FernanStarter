import java.util.LinkedList;

public class Inversor extends Usuario implements Bloqueable{
    private LinkedList<Inversion> proyectosInvertidos = new LinkedList<Inversion>();
    private int cantidadFinanciadaTotal;
    private boolean bloqueado;
    private  int idInversor;
    public Inversor(String nombre,String correo,String contrasena){
        super( nombre, correo, contrasena);
        idInversor=getIds();
        sumaid();
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

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public int getIdInversor() {
        return idInversor;
    }

    public void setIdInversor(int idInversor) {
        this.idInversor = idInversor;
    }
}
