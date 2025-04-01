public class Administrador extends Usuario{
    private static String contrasenaMaestra="123dfg";
    /**
     * Constructor de la clase Administrador
     * @author AnaOrCam
     */

    public Administrador(String nombre,String correo,String contrasena, TipoUsuario tipoUsuario){
        super(nombre, correo, contrasena, tipoUsuario);
        ;
    }
    /**
     * Comprueba la contraseña maestra para crear admin(Aplicar en futuro)
     * @author AnaOrCam
     * @param contraseniaMaestra se refiere a la contraaseña pasada por parametro
     * @return true si es correcta.
     */
    public static boolean comprobarContrasenaMaestra(String contraseniaMaestra){
        if (contrasenaMaestra.equals(contraseniaMaestra))return true;
        return false;
    }
    /**
     * Metodo para obtener la contrasña maestra
     * @author AnaOrCam
     * @return devuelve la contraseña.
     */
    public static String getContrasenaMaestra(){
        return contrasenaMaestra;
    }
    /**
     * To String redefinifo
     * @author AnaOrCam
     * @return String del metodo redefinido.
     */
    public String toString(){
       return super.toString();
    }

}
