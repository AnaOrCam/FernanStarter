import java.util.HashMap;
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

}
