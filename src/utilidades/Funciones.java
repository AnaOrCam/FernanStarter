package utilidades;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

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
     * Muestra la visualización detallada de un proyecto determinado a los usuarios.
     * @author AnaOrCam
     * @param proyecto nombre del proyecto.
     * @param categoria categoría del proyecto.
     * @param financiacionTotal financiación necesaria para llevar a cabo el proyecto.
     * @param financiado cantidad financiada hasta el momento en el proyecto.
     * @param fechaApertura fecha de apertura para inversiones del proyecto.
     * @param fechaCierre fecha de cierre para inversiones del proyecto.
     * @param recompensa1proy nombre de la primera recompensa ofrecida en el proyecto.
     * @param descripcion1proy descripción de la primera recompensa ofrecida en el proyecto.
     * @param precio1proy precio de la primera recompensa ofrecida en el proyecto.
     * @param recompensa2proy nombre de la segunda recompensa ofrecida en el proyecto.
     * @param descripcion2proy descripción de la segunda recompensa ofrecida en el proyecto.
     * @param precio2proy precio de la segunda recompensa ofrecida en el proyecto.
     * @param recompensa3proy nombre de la tercera recompensa ofrecida en el proyecto.
     * @param descripcion3proy descripción de la tercera recompensa ofrecida en el proyecto.
     * @param precio3proy precio de la tercera recompensa ofrecida en el proyecto.
     * @return no devuelve nada.
     */
    public static void visualizarProyecto (String proyecto, String categoria,int financiacionTotal, int financiado, String fechaApertura, String fechaCierre, String recompensa1proy, String descripcion1proy, int precio1proy, String recompensa2proy, String descripcion2proy, int precio2proy, String recompensa3proy, String descripcion3proy, int precio3proy){
        System.out.println("Proyecto 1: " + proyecto + "\n" +
                "Nombre: " + proyecto + "\n" +
                "Categoría: " + categoria + "\n" +
                "Cantidad a financiar: " + financiacionTotal + "\n" +
                "Cantidad financiada hasta el momento: " + financiado + "\n" +
                "Fecha de apertura de inversiones: " + fechaApertura + "\n" +
                "Fecha de cierre de inversiones: " + fechaCierre + "\n" +
                "Recompensa 1: " + recompensa1proy + " por " + precio1proy + "€\n" +
                "\t\t" + descripcion1proy);
        if (!recompensa2proy.equals("")) {
            System.out.println("Recompensa 2: " + recompensa2proy + " por " + precio2proy + "€\n" +
                    "\t\t" + descripcion2proy);
        }
        if (!recompensa3proy.equals("")) {
            System.out.println("Recompensa 3: " + recompensa3proy + " por " + precio3proy + "€\n" +
                    "\t\t" + descripcion3proy);
        }
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
     * Muestra para la eleccion de la recompensa.
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
    /**
     * Menu de visualizacion de los proyectos.
     * @author davidrn06
     * @param proyecto1 nombre del proyecto numero 1.
     * @param proyecto2 nombre del proyecto numero 2.
     * @param proyecto3 nombre del proyecto numero 3.
     * @param ANSI_GREEN asignacion de color verde.
     * @param ANSI_RESET asignacion de color predeterminado.
     * @return no devuelve ningun valor.
     */
    public static void verProyecto(String proyecto1,String proyecto2, String proyecto3,String ANSI_GREEN, String ANSI_RESET){
        System.out.println("Has accedido a proyectos");
        System.out.println(ANSI_GREEN+"*****PROYECTOS*****"+ANSI_RESET);
        System.out.println("¿Qué proyecto quiere ver?\n" +
                "1. Proyecto 1: " + proyecto1 + "\n" +
                "2. Proyecto 2: " + proyecto2 + "\n" +
                "3. Proyecto 3: " + proyecto3 + "\n" +
                "4. Salir");
    }
    /**
     * Menu de visualizacion de borrado de los proyectos.
     * @author davidrn06
     * @param proyecto1 nombre del proyecto numero 1.
     * @param proyecto2 nombre del proyecto numero 2.
     * @param proyecto3 nombre del proyecto numero 3.
     * @return no devuelve ningun valor.
     */
    public static void borrarProyecto( String proyecto1,String proyecto2, String proyecto3){
        System.out.println("Elija un proyecto para borrar\n" +
                "1. Proyecto 1: " + proyecto1 + "\n" +
                "2. Proyecto 2: " + proyecto2 + "\n" +
                "3. Proyecto 3: " + proyecto3 + "\n" +
                "4. Salir");
    }

    /**
     * Añade un nuevo amigo a la lista de amigos invitados y luego muestra la lista actualizada.
     * @author AnaOrCam
     * @param amigosInvitados es la cadena con los amigos invitados hasta el momento.
     * @return no devuelve nada.
     */
    public static String invitarAmigo (String amigosInvitados){
        Scanner s=new Scanner (System.in);
        System.out.println("¿A quien quieres invitar? Introduce su email");
        amigosInvitados=amigosInvitados.concat(s.nextLine()+"\n");
        System.out.println("Tus amigos invitados hasta la fecha son los siguientes:");
        System.out.println(amigosInvitados);
        return amigosInvitados;
    }

    /**
     * Permite visualizar el saldo actual e ingresar una cantidad a ese saldo.
     * @author AnaOrCam
     * @param saldo numero entero que indica el saldo del usuario.
     * @return devuelve un entero.
     */
    public static int gestionSaldoInversor (int saldo){
        Scanner s=new Scanner(System.in);
        System.out.println("¿Qué quieres hacer?\n 1.Mostrar mi saldo actual\n 2.Añadir saldo\n 3.Salir");
        int opcion=Integer.parseInt(s.nextLine());
        switch (opcion) {
            case 1 -> {
                System.out.println("Tu saldo actual es:");
                System.out.println(saldo + "€");
            }
            case 2 -> {
                System.out.println("Cuánto quieres añadir?");
                saldo+= Integer.parseInt(s.nextLine());
            }
            case 3 -> System.out.println("Saliendo de Cartera Digital");
            default -> System.out.println("Esa opción no se encuentra en el menú");
        }
        return saldo;
    }

    /**
     * Funcion para el envio del correo.
     * @author davidrn06
     * @param destinatario nombre del destinatario que recibe la autentificacion en dos factores.
     * @param asunto asunto correspondiente al correo enviado.
     * @param cuerpo cuerpo del correo enviado.
     * @return no devuelve ningun valor.
     */
    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        String remitente = "davidrosanebrera@gmail.com";
        String clave = "cnnu lpxh vvva enhn";

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
    /**
     * Menu para generar el codigo de autentificacion.
     * @author davidrn06
     * @return Devuelve el codigo de autentificacion generado para el acceso a los perfiles.
     */
    public static int generarAutentificacion(){
        double autentificacionInicial =Math.random();
        int  autentificacion =(int) (autentificacionInicial*8999+1000);
        return autentificacion;
    }
}
