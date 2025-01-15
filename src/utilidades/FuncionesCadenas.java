package utilidades;

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
        } else if (contrasena.length()>=5 && contieneMinusculas && contieneMayusculas && (contrasena.contains("@") || contrasena.contains(".") || contrasena.contains("_") || contrasena.contains("-") || contrasena.contains("*"))) {
            fortaleza="Robustez de la contraseña: Media";
        }
        return fortaleza;
    }

    /**
     * Comprueba que la contraseña corresponde al usuario.
     * @author AnaOrCam
     * @param usuario se refiere al nombre de usuario dado por el usuario.
     * @param contrasena se refiere a la contraseña dada por el usuario.
     * @param usuarios se refiere a la lista de usuarios donde se encuentra el nombre de usuario del usuario.
     * @param contrasenas se refiere a la lista de contraseñas donde se encuentra la contraseña del usuario.
     * @return devuelve true si el usuario existe y la contraseña corresponde al usuario y false en el caso contrario.
     */
    public static boolean validarOperacion (String usuario, String contrasena, String[]usuarios, String []contrasenas){
        boolean usuarioValidado=false;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuario.equals(usuarios[i]) && contrasena.equals(contrasenas[i])){
                usuarioValidado=true;
            }
        }
        return usuarioValidado;
    }
    /**
     * Comprueba que la contraseña corresponde al usuario.
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
     * Comprueba que la contraseña corresponde al usuario.
     * @author davidrn06
     * @param fecha se refiere a la fecha del proyecto.
     * @return devuelve true si el formato de la fecha es correcto.
     */
    public static boolean comprobacionFechas(String fecha){
        boolean fechaCorrecta;
        if (fecha.length()==10){
            if (fecha.charAt(2)=='/'&&fecha.charAt(5)=='/'){
                fechaCorrecta=true;
            }else {
                fechaCorrecta=false;
            }
        }else {
            fechaCorrecta=false;
        }
        return fechaCorrecta;
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
