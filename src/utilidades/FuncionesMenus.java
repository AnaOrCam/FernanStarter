package utilidades;

public class FuncionesMenus {

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
                "4. Configuración del programa\n"+
                "5. Enviar resumen de inversiones\n"+
                "6. Cerrar Sesión\n");
    }

    /**
     * Muestra el menú de bloqueo de usuarios del usuario Administrador.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void menuBloqueo (){
        System.out.println("¿Qué quieres hacer?");
        System.out.println("Pulsa 1. Bloquear un usuario");
        System.out.println("Pulsa 2. Desbloquear un usuario");
        System.out.println("Pulsa 3. Salir");
    }

    public static void menuOrdenProyectos(){
        System.out.println("¿Cómo quieres ordenar los proyectos?\n" +
                "1. Por cantidad invertida\n" +
                "2. Por cantidad a financiar\n"+
                "3. Por fecha de apertura\n" +
                "4. Por fecha de cierre\n" +
                "5. Salir");
    }

    /**
     * Muestra el menú principal de los usuarios Inversor.
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
     * Muestra el menú inicial de la aplicación.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void menuInicial(){
        System.out.println("Indica que desea realizar");
        System.out.println("1.Crear un usuario");
        System.out.println("2.Iniciar Sesion");
        System.out.println("3.Modo Invitado");
        System.out.println("4.Cerrar el programa");
    }

    /**
     * Muestra el menú de elección del tipo de usuario a crear.
     * @author AnaOrCam
     * @return no devuelve nada.
     */
    public static void eleccionUsuarioACrear(){
        System.out.println("Que tipo de usuario desea crear");
        System.out.println("1.Inversor");
        System.out.println("2.Gestor");
        System.out.println("3.Administrador");
    }

}
