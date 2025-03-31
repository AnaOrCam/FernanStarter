import java.util.LinkedList;

public class ControladorUsuario {
    private GestionUsuarios modelo;
    private VistaUsuario vista;


    public  ControladorUsuario(GestionUsuarios modelo,VistaUsuario vista){
        this.modelo=modelo;
        this.vista=vista;
    }
    public void aniadirUsuario(Usuario nuevo){
        modelo.aniadirUsuario(nuevo);
        vista.operacionSatisfactoria();
    }
    public void muestraUsuarios(){
        vista.muestraUsuarios(modelo.getUsuarios());
    }
    public void buscaUsuario(String correo){
       if (modelo.buscaUsuario(correo)!=null) vista.muestraUsuario(modelo.buscaUsuario(correo));
       else vista.comprobacionIncorrecta();
    }
    public Usuario getUsuario(String correo){
        return modelo.buscaUsuario(correo);
    }
    public void comprobarContrasenaMaestra(String contrasenaMaestraAComprobar){
        if (modelo.comprobarContrasenaMaestra(contrasenaMaestraAComprobar)) vista.comprobacionCorrecta();
        else vista.comprobacionIncorrecta();
    }
    public void bloquearUsuario(Usuario usuario){
        if (modelo.bloquearUsuario(usuario)){
            vista.operacionSatisfactoria();
        }else vista.operacionFallida();

    }
    public void desbloquearUsuario(Usuario usuario){
        if (modelo.desbloquearUsuario(usuario)){
            vista.operacionSatisfactoria();
        }else vista.operacionFallida();

    }
    public boolean compruebaCorreoExistente(String correo){
        return modelo.compruebaCorreoExistente(correo);
    }

    public boolean insertarInversion(Inversion inversion, Usuario usuario,float cantidad){
        if (modelo.insertarInversion(inversion,usuario,cantidad)){
            vista.operacionSatisfactoria();
            return true;
        }
        return false;
    }
    public boolean compruebaCredenciales(String correo,String contrasenia){
        return modelo.compruebaCredenciales(correo,contrasenia);
    }
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
    public Usuario getUsuarioIniciado(String correo,String contrasenia){
        return modelo.buscaUsuarioCorreoYContrasena(correo,contrasenia);
    }
    public void getProyectosCreadosPorGestor(Gestor aux){
       vista.muestraProyectosGestor(modelo.getProyectosCreadosPorGestor(aux));
    }
    public LinkedList<Proyecto> getProyectosCreadosPorGestorSinVista(Gestor aux){
        return modelo.getProyectosCreadosPorGestor(aux);
    }
    public void gestorAnadirProyecto(Gestor gestor, Proyecto proyecto){
        modelo.insertarProyectoCreadorPorGestor(gestor,proyecto);
    }
    public void vistaDetalladaProyectoCreado(String nombre, Gestor gestor){
        if (modelo.buscarProyectoCreadoPorGestor(nombre, gestor)!=null) vista.vistaDetalladaProyecto(modelo.buscarProyectoCreadoPorGestor(nombre,gestor));
        else vista.operacionFallida();
    }
    public Proyecto buscaProyectoCreadoGestor(String nombre,Gestor gestor){
       return modelo.buscarProyectoCreadoPorGestor(nombre,gestor);
    }
    public void borrarProyecto(Gestor gestor,Proyecto aux){
        modelo.borrarProyecto(gestor,aux);
        vista.operacionSatisfactoria();
    }
    public void ingresarSaldo(float saldo, Inversor inversor){
        modelo.ingresarSaldo(saldo,inversor);
        vista.operacionSatisfactoria();
    }
    public boolean invitarAmigo(String amigo, Inversor usuario){
        if (modelo.invitarAmigo(amigo,usuario)) {
            return true;
        }
        return false;
    }
    public void mostrarAmigos(Inversor usuario){
        vista.mostrarAmigosInvitados(usuario.getAmigosInvitados());
    }

    public boolean mostrarInversiones(Inversor inversor){
        if (!inversor.getProyectosInvertidos().isEmpty()){
            vista.mostrarProyecosInvertidos(inversor.getProyectosInvertidos());
            vista.mostrarInvertidoTotal(inversor.getInvertidoTotal());
            return true;
        }
        return false;
    }

    public boolean aumentarInversion(Inversor inversor, int idInversion, float cantidad){
        if (modelo.aumentarInversion(idInversion,cantidad,inversor)) {
            return true;
        }
        return false;
    }

    public void disminuirInversion(Inversor inversor, int idInversion, float cantidad){
        if (modelo.disminuirInversion(idInversion,cantidad,inversor)) vista.operacionSatisfactoria();
        else vista.operacionFallida();
    }

    public Recompensa getRecompensaDeInversion(Inversor inversor, int idInversion){
        return modelo.getRecompensaInversion(inversor, idInversion);
    }

    public boolean siExisteInversion(int idInversion, Inversor inversor){
        if (modelo.siExisteInversion(idInversion, inversor)) return true;
        return false;
    }

    public String getNombreProyecto (int idInversion, Inversor inversor){
        return modelo.getNombreProyecto(idInversion,inversor);
    }

    public float getCantidadInvertidaEnInversion(int idInversion, Inversor inversor){
        return modelo.getCantidadInvertidaEnInversion(idInversion,inversor);
    }

    public void setRecompensaElegida(int idInversion, Inversor inversor, Recompensa recompensa){
        modelo.setRecompensaElegidaEnInversion(idInversion,inversor,recompensa);
        vista.operacionSatisfactoria();
    }

    public void mostrarSaldoInversor(Inversor inversor){
        vista.mostrarSaldo(inversor.getSaldo());
    }
    public void mostrarRecompensas(Proyecto proyecto){
        vista.muestraRecompensas(modelo.getRecompensasProyecto(proyecto));
    }
    public void operacionFallida(){
        vista.operacionFallida();
    }
    public Recompensa buscaRecompensa(int numRecompensa,Proyecto proyectoDeRecompensa){
       return modelo.buscaRecompensa(numRecompensa,proyectoDeRecompensa);
    }
    public void operacionSatisfactoria(){
        vista.operacionSatisfactoria();
    }
    public void muestraUsuarios(Usuario usuario){
        if (usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
           vista.muestraUsuarios(modelo.usuarios());
        }else {
            vista.operacionFallida();
        }
    }
    public Boolean compruebaExistenUsuarios(){
        return modelo.compruebaExistenUsuario();
    }
}
