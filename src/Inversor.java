import utilidades.FuncionesCadenas;

import java.util.LinkedList;

public class Inversor extends Usuario implements Bloqueable{
    private LinkedList<Inversion> proyectosInvertidos;
    private LinkedList<String> amigosInvitados;
    private float invertidoTotal;
    private float saldo;
    private boolean bloqueado;


    public Inversor(String nombre,String correo,String contrasena, TipoUsuario tipoUsuario){
        super( nombre, correo, contrasena, tipoUsuario);
        bloqueado=false;
        invertidoTotal =0;
        saldo=0;
        proyectosInvertidos=new LinkedList<>();
        amigosInvitados=new LinkedList<>();
    }

    public LinkedList<Inversion> getProyectosInvertidos() {
        return proyectosInvertidos;
    }

    public LinkedList<String> getAmigosInvitados() {
        return amigosInvitados;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getInvertidoTotal() {
        return invertidoTotal;
    }

    public void setInvertidoTotal(int invertidoTotal) {
        this.invertidoTotal = invertidoTotal;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public boolean invitarAmigo(String amigo){
        if (FuncionesCadenas.comprobacionCorreo(amigo)){
            amigosInvitados.add(amigo);
            return true;
        }
        return false;
    }

    public void ingresarSaldo(float saldo){
        this.saldo+=saldo;
    }

    public void bloquearUsuario() {
        this.bloqueado=true;
    }

    public void desbloquearUsuario(){
        this.bloqueado=false;
    }

    public boolean aniadirProyectoInvertido(Inversion inversion, float cantidad){
        if (cantidad<=saldo) {
            proyectosInvertidos.add(inversion);
            invertidoTotal += inversion.getCantidadInvertida();
            saldo-=cantidad;
            return true;
        }
        return false;
    }

}
