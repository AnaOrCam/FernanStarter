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
    

}
