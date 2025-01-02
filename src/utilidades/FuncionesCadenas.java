package utilidades;

public class FuncionesCadenas {

    /**
     * Comprueba al crearse un nuevo usuario que la contraseña y la contraseña repetida son iguales.
     * @author AnaOrCam
     * @param contrasena se refiere a la contraseña elegida por el usuario.
     * @param repetirContrasena hace referencia a la contraseña repetida que ha elegido el usuario.
     * @return devuelve true si contrasena y repetirContrasena son iguales y false si son diferentes.
     */
    static Boolean confirmarContrasena (String contrasena, String repetirContrasena){
        boolean mismaContrasena=false;
        if (contrasena.equals(repetirContrasena)){
            mismaContrasena=true;
        }
        return mismaContrasena;
    }

    /**
     * Comprueba la robustez de una contraseña al crearse un nuevo usuario.
     * @author AnaOrCam
     * @param contrasena se refiere a la contraseña elegida por el usuario.
     * @return devuelve la cadena describiendo la fortaleza de la conytraseña.
     */
    static String fortalezaContrasena (String contrasena){
        String fortaleza="Robustez de la contraseña: Débil";
        String LETRAS_MAYUSCULAS="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String LETRAS_MINUSCULAS="abcdefghijklmñopqrstuvwxyz";
        boolean contieneMayusculas=false;
        boolean contieneMinusculas=false;
        for (int i = 0; i < contrasena.length(); i++) {
            for (int j = 0; j < LETRAS_MAYUSCULAS.length(); j++) {
                if (contrasena.charAt(i)==LETRAS_MAYUSCULAS.charAt(j)){
                    contieneMayusculas=true;
                }
                if (contrasena.charAt(i)==LETRAS_MINUSCULAS.charAt(j)){
                    contieneMinusculas=true;
                }
            }
        }
        if (contrasena.length()>=8 && contieneMinusculas && contieneMayusculas && (contrasena.contains("@") || contrasena.contains(".") || contrasena.contains("_") || contrasena.contains("-") || contrasena.contains("*"))){
            fortaleza="Robustez de la contraseña: Fuerte";
        } else if (contrasena.length()>=8 && (contrasena.contains("@") || contrasena.contains(".") || contrasena.contains("_") || contrasena.contains("-") || contrasena.contains("*"))) {
            fortaleza="Robustez de la contraseña: Media";
        }
        return fortaleza;
    }

}
