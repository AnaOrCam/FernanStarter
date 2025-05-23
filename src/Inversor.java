import utilidades.FuncionesCadenas;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Inversor extends Usuario implements Bloqueable, Serializable {
    private LinkedList<Inversion> proyectosInvertidos;
    private LinkedList<String> amigosInvitados;
    private float invertidoTotal;
    private float saldo;
    private boolean bloqueado;
    private int intentos;

    /**
     * Constructor del objeto Inversor.
     * @author AnaOrCam
     * @param nombre se refiere al atributo nombre del objeto en formato String.
     * @param correo se refiere al atributo correo del objeto en formato String.
     * @param contrasena se refiere al atributo contrasena del objeto en formato String.
     * @param tipoUsuario se refiere al atributo tipoUsuario del objeto en formato TipoUsuario.
     * @return no devuelve nada.
     */
    public Inversor(String nombre,String correo,String contrasena, TipoUsuario tipoUsuario){
        super( nombre, correo, contrasena, tipoUsuario);
        bloqueado=false;
        invertidoTotal =0;
        saldo=0;
        proyectosInvertidos=new LinkedList<>();
        amigosInvitados=new LinkedList<>();
        intentos=0;
    }

    /**
     * Getter de la lista proyectosInvertidos.
     * @author davidrn06
     * @return devuelve la lista proyectosInvertidos en LinkedList.
     */
    public LinkedList<Inversion> getProyectosInvertidos() {
        return proyectosInvertidos;
    }
    /**
     * Devuelve la lista de proyectos invertidos en formato CSV
     * @author AnaOrCam
     * @return lista resultante
     */
    public LinkedList<String> getProyectosInvertidosResumenCSV() {
        LinkedList<String> resumenInversiones=new LinkedList<>();
        for (int i = 0; i < proyectosInvertidos.size() ; i++) {
            if (proyectosInvertidos.get(i).getRecompensaElegida() != null) {
                resumenInversiones.add(proyectosInvertidos.get(i).getNombreProyecto() + ";" + proyectosInvertidos.get(i).getIdInversion() + ";" + proyectosInvertidos.get(i).getCantidadInvertida() + ";" + proyectosInvertidos.get(i).getRecompensaElegida().getNombre());
            }else{
                resumenInversiones.add(proyectosInvertidos.get(i).getNombreProyecto() + ";" + proyectosInvertidos.get(i).getIdInversion() + ";" + proyectosInvertidos.get(i).getCantidadInvertida());
            }
        }
        return resumenInversiones;
    }
    /**
     * Ordena una lista de proyectos segun la cantidad invertida de un inversor
     * @author AnaOrCam
     * @return lista resultante
     */
    public List<Inversion> ordenarPorCantidadInvertida(){
        List<Inversion> listaOrdenada=proyectosInvertidos.stream().toList();
        return listaOrdenada
                .stream()
                .sorted((o1,o2) ->Integer.compare((int) o1.getCantidadInvertida(), (int)o2.getCantidadInvertida()))
                .toList();

    }

    /**
     * Getter de la lista amigosInvitados.
     * @author AnaOrCam
     * @return devuelve la lista amigosInvitados en LinkedList.
     */
    public LinkedList<String> getAmigosInvitados() {
        return amigosInvitados;
    }

    /**
     * Getter del atributo saldo.
     * @author AnaOrCam
     * @return devuelve el saldo en tipo float.
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Getter del atributo invertidoTotal.
     * @author AnaOrCam
     * @return devuelve el atributo invertidoTotal en tipo float.
     */
    public float getInvertidoTotal() {
        return invertidoTotal;
    }

    /**
     * Getter del boolean bloqueado.
     * @author davidrn06
     * @return true si el usuario está bloqueado y false si no lo está.
     */
    public boolean isBloqueado() {
        return bloqueado;
    }

    /**
     * Añade amigos a la lista amigosInvitados.
     * @author AnaOrCam
     * @param amigo se refiere al correo introducido en formato String.
     * @return devuelve true si se ha introducido y false si no lo ha hecho.
     */
    public boolean invitarAmigo(String amigo){
        if (FuncionesCadenas.comprobacionCorreo(amigo)){
            amigosInvitados.add(amigo);
            return true;
        }
        return false;
    }

    /**
     * Suma saldo al atributo saldo.
     * @author AnaOrCam
     * @param saldo se refiere al saldo que se quiere ingresar en formato float.
     * @return no devuelve nada.
     */
    public void ingresarSaldo(float saldo){
        this.saldo+=saldo;
    }

    /**
     * Bloquea al usuario.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public void bloquearUsuario() {
        this.bloqueado=true;
    }

    /**
     * Desbloquea al usuario.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public void desbloquearUsuario(){
        this.bloqueado=false;
    }

    /**
     * Añade una nueva inversión a la lista proyectosInvertidos, suma la inversión al atributo totalInvertido y la resta a saldo.
     * @author AnaOrCam
     * @param inversion se refiere al objeto Inversion que se añadirá a la lista.
     * @param cantidad se refiere a la cantidad a sumar y sustraer en los atributos totalInvertido y saldo en tipo float.
     * @return devuelve true si la cantidad es menor o igual al saldo y se ha podido realizar la operación y false si no ha podido hacerse.
     */
    public boolean aniadirProyectoInvertido(Inversion inversion, float cantidad){
        if (cantidad<=saldo) {
            proyectosInvertidos.add(inversion);
            invertidoTotal += inversion.getCantidadInvertida();
            saldo-=cantidad;
            return true;
        }
        return false;
    }

    /**
     * Busca una Inversión por su id.
     * @author AnaOrCam
     * @param idInversion se refiere al atributo id de Inversion.
     * @return devuelve el objeto Inversion si lo ha encontrado y null si no lo ha encontrado.
     */
    public Inversion buscarInversionPorId(int idInversion){
        for (int i = 0; i < proyectosInvertidos.size(); i++) {
            if (proyectosInvertidos.get(i).getIdInversion()== idInversion) return proyectosInvertidos.get(i);
        }
        return null;
    }

    /**
     * Modifica la recompensa elegida.
     * @author AnaOrCam
     * @param idInversion se refiere al atributo id de Inversion.
     * @param recompensa se refiere al objeto recompensa que sustituirá a la anterior.
     * @return no devuelve nada.
     */
    public void setRecompensaElegida(int idInversion, Recompensa recompensa){
        if (buscarInversionPorId(idInversion)!=null){
            Inversion inversionAModificar= buscarInversionPorId(idInversion);
            inversionAModificar.setRecompensaElegida(recompensa);
        }
    }

    /**
     * Suma una cantidad a una inversión ya realizada.
     * @author AnaOrCam
     * @param idInversion se refiere al atributo id de Inversion.
     * @param cantidad se refiere a la cantidad que se sumará a la inversión.
     */
    public void aumentarInversion(int idInversion, float cantidad){
            Inversion inversionAModificar= buscarInversionPorId(idInversion);
            inversionAModificar.aumentaInversion(cantidad);
            invertidoTotal+=cantidad;
    }

    /**
     * Comprueba que el saldo es mayor a la inversion que se desea hacer y que el id de la inversion no apunta a un objeto nulo.
     * @author AnaOrCam
     * @param idInversion se refiere al atributo id de Inversion.
     * @param cantidad se refiere a la cantidad que se desea invertir.
     * @return devuelve true si el objeto con la id existe y si el saldo es mayor o igual a la cantidad a invertir y false en el canso contrario.
     */
    public boolean comprobarInversionYSaldo(int idInversion,float cantidad){
        if (buscarInversionPorId(idInversion)!=null) {
            if (saldo >= cantidad) {
                return true;
            }
        }
        return false;
    }

    /**
     * Resta una cantidad a una inversión ya realizada.
     * @author AnaOrCam
     * @param idInversion se refiere al atributo id de Inversion.
     * @param cantidad se refiere a la cantidad que se restará a la inversión.
     * @return devuelve true si se ha encontrado el objeto Inversion y esta no tiene una recompensa asignada, si la cantidad a sustraer es menor que la cantidad invertida y ha podido realizarse la operación y false en caso contrario.
     */
    public boolean disminuirInversion(int idInversion, float cantidad){
        if (buscarInversionPorId(idInversion)!=null){
            Inversion inversionAModificar= buscarInversionPorId(idInversion);
            if (inversionAModificar.getRecompensaElegida()==null && inversionAModificar.getCantidadInvertida()>cantidad) {
                inversionAModificar.disminuyeInversion(cantidad);
                saldo += cantidad;
                invertidoTotal-=cantidad;
                return true;
            }
        }
        return false;
    }

    /**
     * Getter del atributo cantidadInvertida de un inversión en función de su id.
     * @author AnaOrCam
     * @param idInversion se refiere al atributo id de Inversion.
     * @return devuelve la cantidad invertida.
     */
    public float getCantidadInvertidaEnInversion(int idInversion){
        float cantidadInvertida=0;
        for (int i = 0; i < proyectosInvertidos.size(); i++) {
            cantidadInvertida=proyectosInvertidos.get(i).getCantidadInvertida();
        }
        return cantidadInvertida;
    }

    /**
     * Suma intentos al atributo intentos y bloquea al usuario cuando éste llega a 3.
     * @author davidrn06
     * @return no devuelve nada.
     */
    public void sumaIntentos(){
        intentos++;
        if (intentos==3){
            bloquearUsuario();
        }
    }

}
