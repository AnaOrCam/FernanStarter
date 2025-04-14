import java.util.LinkedList;

public class ControladorUsuario {
    private GestionUsuarios modelo;
    private VistaUsuario vista;

    /**
     * Constructor del controlador de usuarios
     * @author davidrn06
     * @param modelo modelo pasado por parametro
     * @param vista  vista pasada por parametro
     */
    public  ControladorUsuario(GestionUsuarios modelo,VistaUsuario vista){
        this.modelo=modelo;
        this.vista=vista;
    }
    /**
     * Añade un usuario pasado por parametro
     * @author davidrn06
     * @param nuevo usuario nuevo a añadir
     */
    public void aniadirUsuario(Usuario nuevo){
        modelo.aniadirUsuario(nuevo);
        vista.operacionSatisfactoria();
    }

    public boolean eliminarUsuario(Usuario usuario, String contrasena){
        if (modelo.compruebaCredenciales2(usuario.getCorreo(),contrasena)) {
            modelo.eliminarUsuario(usuario);
            vista.operacionSatisfactoria();
            return true;
        }
        vista.comprobacionIncorrecta();
        return false;
    }

    /**
     * Muestra usuarios en la vista pasados desde el modelo
     * @author davidrn06
     */
    public void muestraUsuarios(){
        vista.muestraUsuarios(modelo.getUsuarios());
    }
    /**
     * Busca usuarios por su correo
     * @author AnaOrCam
     * @param correo correo del usuario
     */
    public void buscaUsuario(String correo){
       if (modelo.buscaUsuario(correo)!=null) vista.muestraUsuario(modelo.buscaUsuario(correo));
       else vista.comprobacionIncorrecta();
    }
    /**
     * Devuelve un usuario
     * @author davidrn06
     * @param correo correo del usuario
     * @return delvuelve el usuario buscado
     */
    public Usuario getUsuario(String correo){
        return modelo.buscaUsuario(correo);
    }
    public void comprobarContrasenaMaestra(String contrasenaMaestraAComprobar){
        if (modelo.comprobarContrasenaMaestra(contrasenaMaestraAComprobar)) vista.comprobacionCorrecta();
        else vista.comprobacionIncorrecta();
    }
    /**
     * Bloquea un usuario
     * @author davidrn06
     * @param usuario usuario a bloquear
     */
    public void bloquearUsuario(Usuario usuario){
        if (modelo.bloquearUsuario(usuario)){
            vista.operacionSatisfactoria();
        }else vista.operacionFallida();

    }
    /**
     * Desbloquea un usuario
     * @author davidrn06
     * @param usuario usuario a desbloquear
     */
    public void desbloquearUsuario(Usuario usuario){
        if (modelo.desbloquearUsuario(usuario)){
            vista.operacionSatisfactoria();
        }else vista.operacionFallida();

    }
    /**
     * Comprueba si un correo ya esta en uso
     * @author davidrn06
     * @param correo correo a comprobar
     * @return true si existe
     */
    public boolean compruebaCorreoExistente(String correo){
        return modelo.compruebaCorreoExistente(correo);
    }
    /**
     * Inserta inversiones
     * @author AnaOrCam
     * @param inversion objeto inversion a insertar
     * @param usuario  usuario que realiza la inversion
     * @param cantidad cantidad que se invierte
     * @return true si se inserta
     */
    public boolean insertarInversion(Inversion inversion, Usuario usuario,float cantidad){
        if (modelo.insertarInversion(inversion,usuario,cantidad)){
            vista.operacionSatisfactoria();
            return true;
        }
        return false;
    }
    /**
     * Comprueba que las credenciales sean validas
     * @author davidrn06
     * @param correo correo a comprobar
     * @param contrasenia  contraseña a comprobar
     * @return true si son correctas
     */
    public boolean compruebaCredenciales(String correo,String contrasenia){
        return modelo.compruebaCredenciales(correo,contrasenia);
    }
    /**
     * Muestra si las credenciales sean validas
     * @author davidrn06
     * @param correo correo a comprobar
     * @param contrasenia  contraseña a comprobar
     */
    public void credencialesValidasNoValidas(String correo,String contrasenia){
        if (compruebaCredenciales(correo,contrasenia)){
            if (modelo.buscaUsuario(correo).getTipoUsuario()==TipoUsuario.INVERSOR){
                Inversor aux= (Inversor) modelo.buscaUsuario(correo);
                if (!aux.isBloqueado()){
                    vista.credencialesValidas(correo);
                }
            }
            if (modelo.buscaUsuario(correo).getTipoUsuario()==TipoUsuario.GESTOR){
                Gestor aux= (Gestor) modelo.buscaUsuario(correo);
                if (!aux.isBloqueado()){
                    vista.credencialesValidas(correo);
                }
            }
            if (modelo.buscaUsuario(correo).getTipoUsuario()==TipoUsuario.ADMINISTRADOR){
                vista.credencialesValidas(correo);
            }
        } else vista.credencialesNoValidas();
    }
    /**
     * Devuelve el usuario iniciado
     * @author davidrn06
     * @param correo correo a comprobar
     * @param contrasenia  contraseña a comprobar
     * @return el usuario iniciado
     */
    public Usuario getUsuarioIniciado(String correo,String contrasenia){
        return modelo.buscaUsuarioCorreoYContrasena(correo,contrasenia);
    }
    /**
     * Muestra los proyectos que ha creado un gestor
     * @author davidrn06
     * @param aux gestor del que se muestran los proyectos
     */
    public void getProyectosCreadosPorGestor(Gestor aux){
       vista.muestraProyectosGestor(modelo.getProyectosCreadosPorGestor(aux));
    }
    /**
     * Devuelve los proyectos creados por un gestor
     * @author davidrn06
     * @param aux gestor del que se muestran los proeyctos
     * @return la lista de proyectos
     */
    public LinkedList<Proyecto> getProyectosCreadosPorGestorSinVista(Gestor aux){
        return modelo.getProyectosCreadosPorGestor(aux);
    }
    /**
     * Añade proyectos a la lista de un gestor
     * @author davidrn06
     * @param gestor gestor al que se le añaden
     * @param proyecto  proyecto añadido
     */
    public void gestorAnadirProyecto(Gestor gestor, Proyecto proyecto){
        modelo.insertarProyectoCreadorPorGestor(gestor,proyecto);
    }
    /**
     * Muestra la vista detallada de un proeycto
     * @author AnaOrCam
     * @param nombre nombre del proyecto
     * @param gestor  gestor que lo ha creado
     */
    public void vistaDetalladaProyectoCreado(String nombre, Gestor gestor){
        if (modelo.buscarProyectoCreadoPorGestor(nombre, gestor)!=null) vista.vistaDetalladaProyecto(modelo.buscarProyectoCreadoPorGestor(nombre,gestor));
        else vista.operacionFallida();
    }
    /**
     * Busca un proyecto creado por un gestor y lo devuelve
     * @author davidrn06
     * @param nombre nombre del proyecto
     * @param gestor  gestor que lo crea
     * @return el proyecto encontrado
     */
    public Proyecto buscaProyectoCreadoGestor(String nombre,Gestor gestor){
       return modelo.buscarProyectoCreadoPorGestor(nombre,gestor);
    }
    /**
     * Borra un proyecto de un gestor
     * @author davidrn06
     * @param gestor gestor que lo ha creado
     * @param aux  proyecto a  borrar
     */
    public void borrarProyecto(Gestor gestor,Proyecto aux){
        modelo.borrarProyecto(gestor,aux);
        vista.operacionSatisfactoria();
    }
    /**
     * Ingresa saldo a un Inversor
     * @author AnaOrCam
     * @param saldo cantidad a ingresar
     * @param inversor  quien lo ingresa
     */
    public void ingresarSaldo(float saldo, Inversor inversor){
        modelo.ingresarSaldo(saldo,inversor);
        vista.operacionSatisfactoria();
    }
    /**
     * Invita a un amigo
     * @author AnaOrCam
     * @param amigo correo del amigo a invitar
     * @param usuario  usuario que lo invita
     * @return true si lo invita
     */
    public boolean invitarAmigo(String amigo, Inversor usuario){
        if (modelo.invitarAmigo(amigo,usuario)) {
            return true;
        }
        return false;
    }
    /**
     * Muestra los amigos invitados de un inversor
     * @author AnaOrCam
     * @param usuario usuario del que se muestran los amigos
     */
    public void mostrarAmigos(Inversor usuario){
        vista.mostrarAmigosInvitados(usuario.getAmigosInvitados());
    }
    /**
     * Muestra las inversiones realizadas por un inversor
     * @author AnaOrCam
     * @param inversor inversor del que se muestran
     * @return true si hay alguna inversion
     */
    public boolean mostrarInversiones(Inversor inversor){
        if (!inversor.getProyectosInvertidos().isEmpty()){
            vista.mostrarProyectosInvertidos(inversor.getProyectosInvertidos());
            vista.mostrarInvertidoTotal(inversor.getInvertidoTotal());
            return true;
        }
        return false;
    }

    public boolean mostrarInversionesOrdenadas(Inversor inversor){
        if (!inversor.getProyectosInvertidos().isEmpty()){
            LinkedList<Inversion>listaOrdenadaInversiones=new LinkedList<>(inversor.ordenarPorCantidadInvertida());
            vista.mostrarProyectosInvertidos(listaOrdenadaInversiones);
            vista.mostrarInvertidoTotal(inversor.getInvertidoTotal());
            return true;
        }
        return false;
    }

    /**
     * Aumenta inversiones
     * @author AnaOrCam
     * @param inversor usuario del que se aumenta la inversion
     * @param cantidad  cantidad a aumentar
     * @param idInversion id de la inversion en la que se aumenta
     * @return true si se puede aumentar
     */
    public boolean aumentarInversion(Inversor inversor, int idInversion, float cantidad){
        if (modelo.aumentarInversion(idInversion,cantidad,inversor)) {
            return true;
        }
        return false;
    }
    /**
     * Disminuye inversiones
     * @author AnaOrCam
     * @param inversor usuario del que se disminuir la inversion
     * @param cantidad  cantidad a disminuir
     * @param idInversion id de la inversion en la que se disminuye
     */

    public void disminuirInversion(Inversor inversor, int idInversion, float cantidad){
        if (modelo.disminuirInversion(idInversion,cantidad,inversor)) vista.operacionSatisfactoria();
        else vista.operacionFallida();
    }

    public Recompensa getRecompensaDeInversion(Inversor inversor, int idInversion){
        return modelo.getRecompensaInversion(inversor, idInversion);
    }
    /**
     * Comprueba si una inversion existe
     * @author AnaOrCam
     * @param inversor usuario del que se busca la inversion
     * @param idInversion id de la inversion que se busca
     * @return true si se encuentra
     */
    public boolean siExisteInversion(int idInversion, Inversor inversor){
        if (modelo.siExisteInversion(idInversion, inversor)) return true;
        return false;
    }
    /**
     * Busca el nombre del proyecto de una inversion
     * @author AnaOrCam
     * @param inversor usuario del que se busca
     * @param idInversion id de la inversion en la que busca
     * @return el nombre si se encuentra
     */
    public String getNombreProyecto (int idInversion, Inversor inversor){
        return modelo.getNombreProyecto(idInversion,inversor);
    }
    /**
     * Devuelve la cantidad invertida en una sola inversion
     * @author AnaOrCam
     * @param inversor usuario del que se busca
     * @param idInversion id de la inversion en la que se busca
     * @return la cantidad invertida
     */
    public float getCantidadInvertidaEnInversion(int idInversion, Inversor inversor){
        return modelo.getCantidadInvertidaEnInversion(idInversion,inversor);
    }
    /**
     * Elije la recompensa
     * @author AnaOrCam
     * @param inversor usuario que elige la recompensa
     * @param recompensa  recompensa elgida
     * @param idInversion id de la inversion en la que se elige
     */
    public void setRecompensaElegida(int idInversion, Inversor inversor, Recompensa recompensa){
        modelo.setRecompensaElegidaEnInversion(idInversion,inversor,recompensa);
        vista.operacionSatisfactoria();
    }
    /**
     * Muestra el saldo de un inversor
     * @author AnaOrCam
     * @param inversor inversor del que se muestra
     */
    public void mostrarSaldoInversor(Inversor inversor){
        vista.mostrarSaldo(inversor.getSaldo());
    }
    /**
     * Muestra las recompensas de un proyecto
     * @author davidrn06
     * @param proyecto del que se muestran las recompensas
     */
    public void mostrarRecompensas(Proyecto proyecto){
        vista.muestraRecompensas(modelo.getRecompensasProyecto(proyecto));
    }
    /**
     * Muestra que la operacion ha sido fallida
     * @author davidrn06
     */
    public void operacionFallida(){
        vista.operacionFallida();
    }
    public Recompensa buscaRecompensa(int numRecompensa,Proyecto proyectoDeRecompensa){
       return modelo.buscaRecompensa(numRecompensa,proyectoDeRecompensa);
    }
    /**
     * Muestra que la operacion a sido satisfactoria
     * @author davidrn06
     */
    public void operacionSatisfactoria(){
        vista.operacionSatisfactoria();
    }
    /**
     * Muestra los usuarios si el usuario que llama a la funcion es un administrador
     * @param usuario usuario que llama a la funcion
     * @author davidrn06
     */
    public void muestraUsuarios(Usuario usuario){
        if (usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
           vista.muestraUsuarios(modelo.usuarios());
        }else {
            vista.operacionFallida();
        }
    }
    /**
     * Comprueba si algun usuario existe
     * @author davidrn06
     * @return true si existe
     */
    public Boolean compruebaExistenUsuarios(){
        return modelo.compruebaExistenUsuario();
    }
}
