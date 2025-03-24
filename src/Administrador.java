public class Administrador extends Usuario{
    private int idAdministrador;
    private static String contrasenaMaestra="123dfg";

    public Administrador(String nombre,String correo,String contrasena){
        super( nombre, correo, contrasena);
        idAdministrador=getIds();
        sumaid();
    }
    public static boolean comprobarContrasenaMaestra(String contraseniaMaestra){
        if (contrasenaMaestra.equals(contraseniaMaestra))return true;
        return false;
    }
    public static String getContrasenaMaestra(){
        return contrasenaMaestra;
    }
}
