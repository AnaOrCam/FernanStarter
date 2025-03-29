import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GestionUsuarios {
    private HashMap<String,Usuario> usuarios = new HashMap<>();

    public void aniadirUsuario(Usuario nuevo){
        usuarios.put(nuevo.getCorreo(), nuevo);
    }
    public HashMap<String,Usuario> getUsuarios(){
        return usuarios;
    }

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
    public boolean compruebaCorreoExistente(String correo){
        List <Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCorreo().equals(correo)) return true;
        }
        return false;
    }
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
    public boolean insertarInversion(Inversion inversion, Usuario usuario){
        if (usuario.getTipoUsuario()==TipoUsuario.INVERSOR){
            Inversor aux=(Inversor) usuario;
            aux.insertarProyectoInvertido(inversion);
            return true;
        }
        return false;
    }
    public boolean compruebaCredenciales(String correo,String contrasena){
        List <Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCorreo().equals(correo)&&listaUsuarios.get(i).getContrasena().equals(contrasena)) return true;
        }
        return false;
    }
    public Usuario buscaUsuarioCorreoYContrasena(String correo,String contrasena){
        List <Usuario> listaUsuarios=List.copyOf(usuarios.values());
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getCorreo().equals(correo)&&listaUsuarios.get(i).getContrasena().equals(contrasena)) return listaUsuarios.get(i);
        }
        return null;
    }
    public LinkedList<Proyecto> getProyectosCreadosPorGestor(Gestor aux){
        return aux.getProyectosCreados();
    }
    public void insertarProyectoCreadorPorGestor(Gestor gestor,Proyecto proyecto){
        gestor.anadirProyecto(proyecto);
    }
    public Proyecto buscarProyectoCreadoPorGestor(String nombre,Gestor gestor){
        for (int i=0;i<gestor.getProyectosCreados().size();i++){
            if (gestor.getProyectosCreados().get(i).getNombre().equals(nombre)) {
                return gestor.getProyectosCreados().get(i);
            }
        }
        return null;
    }
    public LinkedList<Recompensa> getRecompensasProyecto(Proyecto aux){
        return aux.getListaRecompensas();
    }
    public void borrarProyecto(Gestor gestor,Proyecto aux){
        gestor.getProyectosCreados().remove(aux);
    }
}
