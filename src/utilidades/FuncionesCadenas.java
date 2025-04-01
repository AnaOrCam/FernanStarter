package utilidades;

import java.time.LocalDate;

public class FuncionesCadenas {

    /**
     * Comprueba al crearse un nuevo usuario que la contraseña y la contraseña repetida son iguales.
     * @author AnaOrCam
     * @param contrasena se refiere a la contraseña elegida por el usuario.
     * @param repetirContrasena hace referencia a la contraseña repetida que ha elegido el usuario.
     * @return devuelve true si contrasena y repetirContrasena son iguales y false si son diferentes.
     */
    public static Boolean confirmarContrasena (String contrasena, String repetirContrasena){
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
    public static String fortalezaContrasena (String contrasena){
        String fortaleza="Robustez de la contraseña: Débil";
        final String LETRAS_MAYUSCULAS="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        final String LETRAS_MINUSCULAS="abcdefghijklmnñopqrstuvwxyz";
        final String NUMEROS="0123456789";
        boolean contieneMayusculas=false;
        boolean contieneMinusculas=false;
        boolean contieneNumeros=false;
        for (int i = 0; i < contrasena.length(); i++) {
            for (int j = 0; j < LETRAS_MAYUSCULAS.length(); j++) {
                if (contrasena.charAt(i)==LETRAS_MAYUSCULAS.charAt(j)){
                    contieneMayusculas=true;
                }
                if (contrasena.charAt(i)==LETRAS_MINUSCULAS.charAt(j)){
                    contieneMinusculas=true;
                }
            }
            for (int j = 0; j < NUMEROS.length(); j++) {
                if (contrasena.charAt(i)==NUMEROS.charAt(j)){
                    contieneNumeros=true;
                }
            }
        }
        if (contrasena.length()>=8 && contieneNumeros && contieneMinusculas && contieneMayusculas && (contrasena.contains("@") || contrasena.contains(".") || contrasena.contains("_") || contrasena.contains("-") || contrasena.contains("*"))){
            fortaleza="Robustez de la contraseña: Fuerte";
        } else if (contrasena.length()>=8 && contieneMinusculas && contieneMayusculas) {
            fortaleza="Robustez de la contraseña: Media";
        }
        return fortaleza;
    }

    /**
     * Comprueba que el título del proyecto tiene una longitud entre 4 y 14 caracteres.
     * @author davidrn06
     * @param titulo se refiere al titulo del proyecto.
     * @return devuelve true la longitud es correcta.
     */
    public static boolean comprobacionMaximosMinimosTitulos(String titulo){
        boolean tituloCorrecto;
        if (titulo.length()<15&&titulo.length()>3){
            tituloCorrecto=true;
        }else {
            tituloCorrecto=false;
        }
        return tituloCorrecto;
    }

    /**
     * Comprueba que el correo contenga @.
     * @author davidrn06
     * @param correo se refiere al correo del usuario.
     * @return devuelve true si el formato del correo es correcto.
     */
    public static boolean comprobacionCorreo(String correo){
        boolean correoCorrecto;
        if (correo.contains("@")){
            correoCorrecto=true;
        }else {
            correoCorrecto=false;
        }
        return correoCorrecto;
    }
}
