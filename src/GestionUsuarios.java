import java.util.LinkedList;

public class GestionUsuarios {
    private LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

    public void aniadirUsuario(Usuario nuevo){
        usuarios.add(nuevo);
    }
    public LinkedList<Usuario> getUsuarios(){
        return  usuarios;
    }
    public boolean buscaUsuario(String nombre){
        for (Usuario buscar: usuarios){
            if (buscar.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    public boolean comprobarContrasenaMaestra(String contraseniaMaestraAComprobar){
        return Administrador.comprobarContrasenaMaestra(contraseniaMaestraAComprobar);
    }


}
