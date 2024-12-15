package utilidades;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Funciones {

    /**
     * Genera un gráfico de porcentaje de proyecto financiado.
     * @author AnaOrCam
     * @param porcentajefinanciado es el porcentaje financiado hasta el momento en el proyecto.
     * @return no devuelve nada.
     */
    public static void grafico (int porcentajefinanciado){
        final String ANSI_GREEN= "\033[32m";
        final String ANSI_GREY= "\033[37m";
        final String ANSI_RESET= "\033[0m";
        for (int i = 1; i <=8; i++) {
            System.out.printf("|");
            if (i>=3 && i<=5){
                for (int j = 0; j <=porcentajefinanciado; j++) {
                    System.out.printf(ANSI_GREEN+"█"+ANSI_RESET);
                }
                for (int j=porcentajefinanciado+1; j <=100 ; j++) {
                    System.out.printf(ANSI_GREY+"█"+ANSI_RESET);
                }
            }
            if (i==8){
                for (int j = 0; j < 100; j++) {
                    System.out.printf("_");
                }
            }
            System.out.println();
        }
    }

    /**
     * Muestra el menú principal del usuario Administrador.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void menuAdministrador (){
        System.out.println("Elije opción:\n" +
                "1. Panel de control\n" +
                "2. Proyectos\n" +
                "3. Configuración\n" +
                "4. Cerrar Sesión\n");
    }

    /**
     * Muestra el menú de bloqueo de usuarios del usuario Administrador.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void menuBloqueo (){
        System.out.println("Pulsa 1. Para bloquear");
        System.out.println("Pulsa 2. Para desbloquear");
        System.out.println("Pulsa 3. Para salir al menú principal de admin");
    }

    /**
     * Muestra el menú principal del usuario Gestor.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void menuGestor (){
        System.out.println("Elije opción:\n" +
                "1. Mis proyectos\n"+
                "2. Configuración\n" +
                "3. Cerrar Sesión\n");
    }

    /**
     * Muestra el menú principal de los usuarios Inversor1 e Inversor2.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void menuInversor (){
        System.out.println("Elije opción:\n" +
                "1. Mis inversiones\n" +
                "2. Proyectos\n" +
                "3. Cartera digital\n" +
                "4. Invita a un amigo\n" +
                "5. Configuración\n"+
                "6. Cerrar Sesión\n");
    }

    /**
     * Muestra el menú de configuración de los usuarios.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void menuConfiguracion (){
        System.out.println("Seleccione opción");
        System.out.println("1. Cambiar nombre de usuario");
        System.out.println("2. Cambiar contraseña de usuario");
        System.out.println("3. Salir");
    }

    /**
     * Muestra la visualización detallada del proyecto 1 a los usuarios.
     * @author AnaOrCam
     * @param proyecto1 nombre del proyecto 1.
     * @param categoria1 categoría del proyecto 1.
     * @param financiacionTotal1 financiación necesaria para llevar a cabo el proyecto 1.
     * @param financiado1 cantidad financiada hasta el momento en el proyecto 1.
     * @param fechaApertura1 fecha de apertura para inversiones del proyecto 1.
     * @param fechaCierre1 fecha de cierre para inversiones del proyecto 1.
     * @param recompensa1proy1 nombre de la primera recompensa ofrecida en el proyecto 1.
     * @param descripcion1proy1 descripción de la primera recompensa ofrecida en el proyecto 1.
     * @param precio1proy1 precio de la primera recompensa ofrecida en el proyecto 1.
     * @return no devuelve nada.
     */
    public static void visualizarProyecto1 (String proyecto1, String categoria1,int financiacionTotal1, int financiado1, String fechaApertura1, String fechaCierre1, String recompensa1proy1, String descripcion1proy1, int precio1proy1){
        System.out.println("Proyecto 1: " + proyecto1 + "\n" +
                "Nombre: " + proyecto1 + "\n" +
                "Categoría: " + categoria1 + "\n" +
                "Cantidad a financiar: " + financiacionTotal1 + "\n" +
                "Cantidad financiada hasta el momento: " + financiado1 + "\n" +
                "Fecha de apertura de inversiones: " + fechaApertura1 + "\n" +
                "Fecha de cierre de inversiones: " + fechaCierre1 + "\n" +
                "Recompensa 1: " + recompensa1proy1 + " por " + precio1proy1 + "€\n" +
                "\t\t" + descripcion1proy1);
    }

    /**
     * Muestra la visualización detallada del proyecto 2 a los usuarios.
     * @author AnaOrCam
     * @param proyecto2 nombre del proyecto 2.
     * @param categoria2 categoría del proyecto 2.
     * @param financiacionTotal2 financiación necesaria para llevar a cabo el proyecto 2.
     * @param financiado2 cantidad financiada hasta el momento en el proyecto 2.
     * @param fechaApertura2 fecha de apertura para inversiones del proyecto 2.
     * @param fechaCierre2 fecha de cierre para inversiones del proyecto 2.
     * @param recompensa1proy2 nombre de la primera recompensa ofrecida en el proyecto 2.
     * @param descripcion1proy2 descripción de la primera recompensa ofrecida en el proyecto 2.
     * @param precio1proy2 precio de la primera recompensa ofrecida en el proyecto 2.
     * @return no devuelve nada.
     */
    public static void visualizarProyecto2 (String proyecto2, String categoria2,int financiacionTotal2, int financiado2, String fechaApertura2, String fechaCierre2, String recompensa1proy2, String descripcion1proy2, int precio1proy2){
        System.out.println("Proyecto 2: " + proyecto2 + "\n" +
                "Nombre: " + proyecto2 + "\n" +
                "Categoría: " + categoria2 + "\n" +
                "Cantidad a financiar: " + financiacionTotal2 + "\n" +
                "Cantidad financiada hasta el momento: " + financiado2 + "\n" +
                "Fecha de apertura de inversiones: " + fechaApertura2 + "\n" +
                "Fecha de cierre de inversiones: " + fechaCierre2 + "\n" +
                "Recompensa 1: " + recompensa1proy2 + " por " + precio1proy2 + "€\n" +
                "\t\t" + descripcion1proy2);
    }

    /**
     * Muestra la visualización detallada del proyecto 3 a los usuarios.
     * @author AnaOrCam
     * @param proyecto3 nombre del proyecto 3.
     * @param categoria3 categoría del proyecto 3.
     * @param financiacionTotal3 financiación necesaria para llevar a cabo el proyecto 3.
     * @param financiado3 cantidad financiada hasta el momento en el proyecto 3.
     * @param fechaApertura3 fecha de apertura para inversiones del proyecto 3.
     * @param fechaCierre3 fecha de cierre para inversiones del proyecto 3.
     * @param recompensa1proy3 nombre de la primera recompensa ofrecida en el proyecto 3.
     * @param descripcion1proy3 descripción de la primera recompensa ofrecida en el proyecto 3.
     * @param precio1proy3 precio de la primera recompensa ofrecida en el proyecto 3.
     * @return no devuelve nada.
     */
    public static void visualizarProyecto3 (String proyecto3, String categoria3,int financiacionTotal3, int financiado3, String fechaApertura3, String fechaCierre3, String recompensa1proy3, String descripcion1proy3, int precio1proy3){
        System.out.println("Proyecto 3: " + proyecto3 + "\n" +
                "Nombre: " + proyecto3 + "\n" +
                "Categoría: " + categoria3 + "\n" +
                "Cantidad a financiar: " + financiacionTotal3 + "\n" +
                "Cantidad financiada hasta el momento: " + financiado3 + "\n" +
                "Fecha de apertura de inversiones: " + fechaApertura3 + "\n" +
                "Fecha de cierre de inversiones: " + fechaCierre3 + "\n" +
                "Recompensa 1: " + recompensa1proy3 + " por " + precio1proy3 + "€\n" +
                "\t\t" + descripcion1proy3);
    }

    /**
     * Muestra el menú de modificación de las características de un proyecto en el usuario Gestor.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void menuModificarProyecto (){
        System.out.println("Qué quieres modificar?\n" +
                "1. Nombre\n" +
                "2. Categoría\n" +
                "3. Cantidad a financiar\n" +
                "4. Cantidad financiada hasta el momento\n" +
                "5. Fecha de apertura de inversiones\n" +
                "6. Fecha de cierre de inversiones\n" +
                "7. Recompensas\n" +
                "8. Salir");
    }

    /**
     * Muestra el menú de configuración de los usuarios.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void menuEleccionRecompensa (){
        System.out.println("¿Qué recompensa quiere modificar?\n" +
                "1. Recompensa 1\n" +
                "2. Recompensa 2\n" +
                "3. Recompensa 3\n" +
                "4. Salir");
    }

    /**
     * Muestra el menú de modificación de la recompensa de un proyecto.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void modificarRecompensa (){
        System.out.println("¿Qué quiere modificar?\n" +
                "1. Objeto de la recompensa\n" +
                "2. Descripción\n" +
                "3. Precio\n" +
                "4. Salir");
    }
    public static void verProyecto(String proyecto1,String proyecto2, String proyecto3,String ANSI_GREEN, String ANSI_RESET){
        System.out.println("Has accedido a proyectos");
        System.out.println(ANSI_GREEN+"*****PROYECTOS*****"+ANSI_RESET);
        System.out.println("¿Qué proyecto quiere ver?\n" +
                "1. Proyecto 1: " + proyecto1 + "\n" +
                "2. Proyecto 2: " + proyecto2 + "\n" +
                "3. Proyecto 3: " + proyecto3 + "\n" +
                "4. Salir");
    }
    public static void borrarProyecto( String proyecto1,String proyecto2, String proyecto3){
        System.out.println("Elija un proyecto para borrar\n" +
                "1. Proyecto 1: " + proyecto1 + "\n" +
                "2. Proyecto 2: " + proyecto2 + "\n" +
                "3. Proyecto 3: " + proyecto3 + "\n" +
                "4. Salir");
    }

    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        String remitente = "";
        String clave = "";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setContent(cuerpo, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (Exception me) {
            me.printStackTrace();
        }
    }
}
