import java.util.LinkedList;

public class ControladorUsuario {
    private GestionUsuarios modelo=new GestionUsuarios();
    private VistaUsuario vista =new VistaUsuario();
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

    public void insertarInversion(Inversion inversion, Usuario usuario){
        if (modelo.insertarInversion(inversion,usuario)) vista.operacionSatisfactoria();
        else vista.operacionFallida();
    }
    public boolean compruebaCredenciales(String correo,String contrasenia){
        return modelo.compruebaCredenciales(correo,contrasenia);
    }
    public void credencialesValidasNoValidas(String correo,String contrasenia){
        if (compruebaCredenciales(correo,contrasenia))vista.credencialesValidas(correo);
        else vista.credencialesNoValidas();
    }
    public Usuario getUsuarioIniciado(String correo,String contrasenia){
        return modelo.buscaUsuarioCorreoYContrasena(correo,contrasenia);
    }
    public void getProyectosCreadosPorGestor(Gestor aux){
       vista.muestraProyectosGestor(modelo.getProyectosCreadosPorGestor(aux));
    }
    public void gestorAnadirProyecto(Gestor gestor, Proyecto proyecto){
        modelo.insertarProyectoCreadorPorGestor(gestor,proyecto);
    }
    public void vistaDetalladaProyecto(String nombre,Gestor gestor){
        vista.vistaDetalladaProyecto(modelo.buscarProyectoCreadoPorGestor(nombre,gestor));
    }
    public Proyecto buscaProyectoCreadoGestor(String nombre,Gestor gestor){
       return modelo.buscarProyectoCreadoPorGestor(nombre,gestor);
    }
    public void borrarProyecto(Gestor gestor,Proyecto aux){
        modelo.borrarProyecto(gestor,aux);
        vista.operacionSatisfactoria();
    }



}
