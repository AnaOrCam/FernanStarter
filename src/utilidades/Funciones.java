package utilidades;

public class Funciones {
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
    public static void menuAdministrador (){
        System.out.println("Elije opción:\n" +
                "1. Panel de control\n" +
                "2. Proyectos\n" +
                "3. Configuración\n" +
                "4. Cerrar Sesión\n");
    }

    public static void menuBloqueo (){
        System.out.println("Pulsa 1. Para bloquear");
        System.out.println("Pulsa 2. Para desbloquear");
        System.out.println("Pulsa 3. Para salir al menú principal de admin");
    }

    public static void menuGestor (){
        System.out.println("Elije opción:\n" +
                "1. Mis proyectos\n"+
                "2. Configuración\n" +
                "3. Cerrar Sesión\n");
    }
    public static void menuInversor (){
        System.out.println("Elije opción:\n" +
                "1. Mis inversiones\n" +
                "2. Proyectos\n" +
                "3. Cartera digital\n" +
                "4. Invita a un amigo\n" +
                "5. Configuración\n"+
                "6. Cerrar Sesión\n");
    }

    public static void menuConfiguracion (){
        System.out.println("Seleccione opción");
        System.out.println("1. Cambiar nombre de usuario");
        System.out.println("2. Cambiar contraseña de usuario");
        System.out.println("3. Salir");
    }

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

    public static void menuEleccionRecompensa (){
        System.out.println("¿Qué recompensa quiere modificar?\n" +
                "1. Recompensa 1\n" +
                "2. Recompensa 2\n" +
                "3. Recompensa 3\n" +
                "4. Salir");
    }
    public static void modificarRecompensa (){
        System.out.println("¿Qué quiere modificar?\n" +
                "1. Objeto de la recompensa\n" +
                "2. Descripción\n" +
                "3. Precio\n" +
                "4. Salir");
    }
}
