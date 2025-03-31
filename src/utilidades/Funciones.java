package utilidades;
import java.util.Scanner;
import static utilidades.FuncionesCadenas.*;

public class Funciones {

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
        System.out.println("¿Qué quieres hacer?");
        System.out.println("Pulsa 1. Bloquear un usuario");
        System.out.println("Pulsa 2. Desbloquear un usuario");
        System.out.println("Pulsa 3. Salir");
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

    public static void menuInicial(){
        System.out.println("Indica que desea realizar");
        System.out.println("1.Crear un usuario");
        System.out.println("2.Iniciar Sesion");
        System.out.println("3.Cerrar el programa");
    }
    public static void eleccionUsuarioACrear(){
        System.out.println("Que tipo de usuario desea crear");
        System.out.println("1.Inversor");
        System.out.println("2.Gestor");
        System.out.println("3.Administrador");
    }
}
