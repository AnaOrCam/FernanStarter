import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GestionUsuarios implements Serializable {
    private HashMap<String,Usuario> usuarios = new HashMap<>();
    /**
     * Añade un usuario nuevo a la lista
     * @author AnaOrCam
     * @param nuevo usuario nuevo
     */
    public void aniadirUsuario(Usuario nuevo){
        usuarios.put(nuevo.getCorreo(), nuevo);
    }

    public void eliminarUsuario(Usuario usuario){
        usuarios.remove(usuario.getCorreo(), usuario);
    }

    /**
     * Devuelve el diccionario de usuarios
     * @author AnaOrCam
     * @return devuelve el diccionario de usuarios
     */
    public HashMap<String,Usuario> getUsuarios(){
        return usuarios;
    }
    /**
     * Busca un usuario por su correo
     * @author AnaOrCam
     * @param correo busca un correo por su usuario
     * @return devuelve el usuario, encontrado si es que existe
     */
    public Usuario buscaUsuario(String correo){
        List <Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCorreo().equals(correo)) return listaUsuarios.get(i);
        }
        return null;
    }

    public boolean comprobarContrasenaMaestra(String contraseniaMaestraAComprobar){
        return Administrador.comprobarContrasenaMaestra(contraseniaMaestraAComprobar);
    }
    /**
     * Comprueba si un correo existe
     * @author davidrn06
     * @param correo nombre del correo que se quiere comprobar
     * @return devuelve true si lo encuentra
     */
    public boolean compruebaCorreoExistente(String correo){
        List <Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCorreo().equals(correo)) return true;
        }
        return false;
    }
    /**
     * Bloquea un usuario
     * @author davidrn06
     * @param usuario usuario a bloquear
     * @return devuelve true si lo ha podido bloquear
     */
    public boolean bloquearUsuario(Usuario usuario){
            if (usuario.getTipoUsuario()==TipoUsuario.INVERSOR){
                Inversor aux=(Inversor) usuario;
                if (!aux.isBloqueado()){
                    aux.bloquearUsuario();
                    return true;
                }else {
                    return false;
                }
            }
            if (usuario.getTipoUsuario()==TipoUsuario.GESTOR){
                Gestor aux=(Gestor) usuario;
                if (!aux.isBloqueado()){
                    aux.bloquearUsuario();
                    return true;
                }else {
                    return false;
                }
            }
            return   false;
    }
    /**
     * Desbloquea un usuario
     * @author davidrn06
     * @param usuario usuario a Desbloquear
     * @return devuelve true si lo ha podido Desbloquear
     */
    public boolean desbloquearUsuario(Usuario usuario){
        if (usuario.getTipoUsuario()==TipoUsuario.INVERSOR){
            Inversor aux=(Inversor) usuario;
            if (aux.isBloqueado()){
                aux.desbloquearUsuario();
                return true;
            }else {
                return false;
            }
        }
        if (usuario.getTipoUsuario()==TipoUsuario.GESTOR){
            Gestor aux=(Gestor) usuario;
            if (aux.isBloqueado()){
                aux.desbloquearUsuario();
                return true;
            }else {
                return false;
            }
        }
        return   false;
    }
    /**
     * Ingresa saldo a un inversor
     * @author AnaOrCam
     * @param saldo saldo que se va a ingresar
     * @param inversor que va a hacer el ingreso
     */
    public void ingresarSaldo(float saldo, Inversor inversor){
        inversor.ingresarSaldo(saldo);
    }
    /**
     * Inserta una Inversion a un inversor
     * @author AnaOrCam
     * @param usuario usuario que va a insertar
     * @param cantidad cantidad de la inversion
     * @param inversion inversion que se va a insertar
     * @return devuelve true si se ha podido insertar
     */
    public boolean insertarInversion(Inversion inversion, Usuario usuario, float cantidad){
        if (usuario.getTipoUsuario()==TipoUsuario.INVERSOR){
            Inversor aux=(Inversor) usuario;
            if (cantidad<=aux.getSaldo()) {
                aux.aniadirProyectoInvertido(inversion,cantidad);
                return true;
            }
        }
        return false;
    }
    /**
     * Devuelve la recompensa elegida en una inversion
     * @author AnaOrCam
     * @param inversor inversor que ha hecho la inversion
     * @param idInversion id de la inversion de la que se busca la recompensa
     * @return devuelve la recompensa encontrada
     */
    public Recompensa getRecompensaInversion(Inversor inversor, int idInversion){
        return inversor.buscarInversionPorId(idInversion).getRecompensaElegida();
    }
    /**
     * Comprueba si existe una inversion
     * @author AnaOrCam
     * @param idInversion id de la inversion a buscar
     * @param inversor del que se comprueba la inversion
     * @return devuelve true si se encuentra la inversion
     */
    public boolean siExisteInversion (int idInversion, Inversor inversor){
        if (inversor.buscarInversionPorId(idInversion)!=null) return true;
        return false;
    }
    /**
     * Devuelve el nombre del proyecto del que se ha hecho una inversion
     * @author AnaOrCam
     * @param idInversion id de la inversion realizada
     * @param inversor inversor que ha realizado la inversion
     * @return devuelve el nombre del proyecto en el que se ha realizado la inversion
     */
    public String getNombreProyecto (int idInversion, Inversor inversor){
        if (inversor.buscarInversionPorId(idInversion)!=null) return inversor.buscarInversionPorId(idInversion).getNombreProyecto();
        return "";
    }
    /**
     * La cantidad que se ha invertido en una sola inversion
     * @author AnaOrCam
     * @param idInversion id de la inversion realizada
     * @param inversor inversor que ha realizado la inversion
     * @return La cantidad incertida
     */
    public float getCantidadInvertidaEnInversion(int idInversion, Inversor inversor){
        return inversor.getCantidadInvertidaEnInversion(idInversion);
    }
    /**
     * Aplica la recompensa elgida en una inversion
     * @author AnaOrCam
     * @param idInversion id de la inversion realizada
     * @param inversor inversor que ha realizado la inversion
     * @param recompensa recompensa elegida
     */
    public void setRecompensaElegidaEnInversion(int idInversion, Inversor inversor,Recompensa recompensa){
         inversor.setRecompensaElegida(idInversion,recompensa);
    }
    /**
     * Aumenta la inversion
     * @author AnaOrCam
     * @param idInversion id de la inversion realizada
     * @param inversor inversor que ha realizado la inversion
     * @param cantidad cantidad para aumentar
     * @return true si se a podido realizar la inversion
     */
    public boolean aumentarInversion(int idInversion, float cantidad, Inversor inversor){
        if (inversor.aumentarInversion(idInversion,cantidad)) return true;
        return false;
    }
    /**
     * Disminuye la inversion
     * @author AnaOrCam
     * @param idInversion id de la inversion realizada
     * @param inversor inversor que ha realizado la inversion
     * @param cantidad cantidad a disminuir
     * @return devuelve true si se puede disminuir
     */
    public boolean disminuirInversion(int idInversion, float cantidad, Inversor inversor){
        if (inversor.disminuirInversion(idInversion,cantidad)) return true;
        return false;
    }
    /**
     * Comprueba que las credenciales coinciden
     * @author davidrn06
     * @param correo correo de referencia
     * @param contrasena asignada al correo
     * @return devuelve true si son correctas las credenciales
     */
    public boolean compruebaCredenciales(String correo,String contrasena){
        List <Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCorreo().equals(correo)&&listaUsuarios.get(i).getContrasena().equals(contrasena)) return true;
        }
        return false;
    }
    public boolean compruebaCredenciales2(String correo,String contrasena){
        if (usuarios.containsKey(correo)){
            Usuario aux=usuarios.get(correo);
            return aux.getContrasena().equals(contrasena);
        }
        return false;
    }
    /**
     * Busca un usuario segun su correo y contraseña
     * @author davidrn06
     * @param correo correo asignado
     * @param contrasena contraseña asignada
     * @return el usuario el cual coinciden sus credenciales
     */
    public Usuario buscaUsuarioCorreoYContrasena(String correo,String contrasena){
        List <Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCorreo().equals(correo)&&listaUsuarios.get(i).getContrasena().equals(contrasena)) return listaUsuarios.get(i);
        }
        return null;
    }
    /**
     * Devuelve una lista de proyectos creados por un inversor
     * @author davidrn06
     * @param aux gestor del que se buscan los proyectos
     * @return devuelve la lista de proyectos
     */
    public LinkedList<Proyecto> getProyectosCreadosPorGestor(Gestor aux){
        return aux.getProyectosCreados();
    }
    /**
     * Inserta proyectos en la lista de un gestor
     * @author davidrn06
     * @param gestor gestor en el que se inserta el proyecto
     * @param proyecto proyecto que va a ser insertado
     */
    public void insertarProyectoCreadorPorGestor(Gestor gestor,Proyecto proyecto){
        gestor.anadirProyecto(proyecto);
    }
    /**
     * Busca el proyecto creado por un gestor segun su nombre
     * @author davidrn06
     * @param nombre nombre del proyecto vreado
     * @param  gestor gestor que ha creado el proyecto
     * @return el proyecto encontrado
     */
    public Proyecto buscarProyectoCreadoPorGestor(String nombre,Gestor gestor){
        for (int i=0;i<gestor.getProyectosCreados().size();i++){
            if (gestor.getProyectosCreados().get(i).getNombre().equals(nombre)) {
                return gestor.getProyectosCreados().get(i);
            }
        }
        return null;
    }
    /**
     * Invita a un amigo segun su correo
     * @author AnaOrCam
     * @param amigo correo del amigo invitado
     * @param inversor inversor que invita al amigo
     * @return devuelve true si se ha podido invitar
     */
    public boolean invitarAmigo(String amigo, Inversor inversor){
        if (inversor.invitarAmigo(amigo)) return true;
        return false;
    }
    /**
     * Devuelve las recompensas de un proyecto
     * @author davidrn06
     * @param aux proyecto del que se busca la lista de recompensas
     * @return devuelve la lista de recompensas
     */
    public LinkedList<Recompensa> getRecompensasProyecto(Proyecto aux){
        return aux.getListaRecompensas();
    }
    /**
     * Borra un proyecto creado por un gestor
     * @author davidrn06
     * @param gestor gestor del que se busca el proyecto a borrar
     * @param aux proyecto que se desea borrar
     */
    public void borrarProyecto(Gestor gestor,Proyecto aux){
        gestor.getProyectosCreados().remove(aux);
    }

    public LinkedList<Recompensa>  getRecompensasProyectoGestor(Proyecto proyecto){
        return proyecto.getListaRecompensas();
    }
    /**
     * Busca una recompensa en un proyecto
     * @author davidrn06
     * @param numRecompensa es el numero de la recompensa dentro del proyecto
     * @param proyectoDeRecompensa proyecto en el que se encuentra la recompensa
     * @return la recompensa encontrada
     */
    public Recompensa buscaRecompensa(int numRecompensa,Proyecto proyectoDeRecompensa){
        LinkedList<Recompensa>  recompensas=proyectoDeRecompensa.getListaRecompensas();
        return recompensas.get(numRecompensa);
    }
    /**
     * Devuelve el diccionario de usuarios
     * @author davidrn06
     * @return  el diccionario de usuarios
     */
    public HashMap<String,Usuario> usuarios(){
        return usuarios;
    }
    /**
     * Comprueba si existe algun usuario de tipo inversor o gestor
     * @author davidrn06
     * @return true si existe alguno
     */
    public boolean compruebaExistenUsuario(){
        List <Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getTipoUsuario()==TipoUsuario.INVERSOR||listaUsuarios.get(i).getTipoUsuario()==TipoUsuario.GESTOR){
                return true;
            }
        }
        return false;
    }
}
