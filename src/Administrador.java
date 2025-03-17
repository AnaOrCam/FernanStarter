public class Administrador extends Usuario{
    private int idAdministrador;
    public Administrador(String nombre,String correo,String contrasena){
        super( nombre, correo, contrasena);
        idAdministrador=ids;
        ids++;
    }
}
