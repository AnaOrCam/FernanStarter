import java.util.Scanner;
import static utilidades.Funciones.*;
import static utilidades.FuncionesCadenas.*;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        final String ANSI_GREEN= "\033[32m";
        final String ANSI_RED="\033[31m";
        final String ANSI_RESET= "\033[0m";
        final String ANSI_PURPLE= "\033[35m";
        String usuario="";
        String contrasena;
        String destinatarioAdmin="ana.oc.094@gmail.com";
        String usuarioAdmin="administrador";
        String contrasenaAdmin="admin";
        String [] nombreUsuarioGestor = {"gestor","","","","","","","","",""};
        String [] contrasenaUsuarioGestor = {"gestor","","","","","","","","",""};
        String [] correoUsuarioGestor = {"ana.oc.094@gmail.com","","","","","","","","",""};
        String [] nombreUsuarioInversor = {"inversor","","","","","","","","",""};
        String [] contrasenaUsuarioInversor = {"inversor","","","","","","","","",""};
        String [] correoUsuarioInversor = {"ana.oc.094@gmail.com","","","","","","","","",""};
        int [] intentoGestor= new int[10];
        int [] intentoInversor= new int[10];
        int [] intentoGestorCodigo= new int[10];
        int [] intentoInversorCodigo= new int[10];
        int [] saldoInversor= new int[10];
        String [] amigosInvitadosInversor= new String[10];
        boolean [] gestorbloqueado=new boolean [10];
        boolean [] inversorbloqueado=new boolean [10];
        String nombreUsuarioActual, contrasenaActual;
        String nuevoNombreUsuario, nuevaContrasena, repeticionContrasena;
        boolean usuarioCambiado;
        boolean contrasenaCambiada;
        boolean usuarioExiste=false;
        boolean bienvenido;
        boolean tipoUsuarioInversor;
        boolean tipoUsuarioGestor;
        boolean inversionAceptada;
        int admin_gestor=0;
        int admin_inversor1=0;
        int eleccionadmin=0;
        int Adminconfiguracion=0;
        int opcionConfiguracion;
        int opcion;
        String proyecto1="Próximamente", proyecto2="Próximamente", proyecto3="Próximamente";
        String categoria1="", categoria2="", categoria3="";
        int financiacionTotal1=0, financiacionTotal2=0, financiacionTotal3=0;
        int financiado1=0, financiado2=0, financiado3=0;
        int porcentajefinanciado1;
        int porcentajefinanciado2;
        int porcentajefinanciado3;
        String fechaApertura1="", fechaApertura2="", fechaApertura3="";
        String fechaCierre1="", fechaCierre2="", fechaCierre3="";
        int cantidadRecompensas1, cantidadRecompensas2, cantidadRecompensas3;
        String recompensa1proy1="", recompensa2proy1="", recompensa3proy1="";
        String recompensa1proy2="", recompensa2proy2="", recompensa3proy2="";
        String recompensa1proy3="", recompensa2proy3="", recompensa3proy3="";
        String descripcion1proy1 ="", descripcion2proy1 ="", descripcion3proy1 ="";
        String descripcion1proy2 ="", descripcion2proy2 ="", descripcion3proy2 ="";
        String descripcion1proy3 ="", descripcion2proy3 ="", descripcion3proy3 ="";
        int precio1proy1 =0, precio2proy1 =0, precio3proy1 =0;
        int precio1proy2 =0, precio2proy2 =0, precio3proy2 =0;
        int precio1proy3 =0, precio2proy3 =0, precio3proy3 =0;
        int opcionProyectoAdmin=0;
        int intentoInversion;
        int opcionInicial=0;
        int inversionProyecto1Inversor1=0, inversionProyecto2Inversor1=0, inversionProyecto3Inversor1=0;
        int inversionProyecto1Inversor2=0,inversionProyecto2Inversor2=0, inversionProyecto3Inversor2=0;
        int autentificacion;
        boolean creado=false;
        int respuesta=0;

        for (int i = 0; i < intentoGestor.length; i++) {
            intentoGestor[i]=3;
            intentoInversor[i]=3;
            intentoGestorCodigo[i]=3;
            intentoInversorCodigo[i]=3;
            inversorbloqueado[i]=false;
            gestorbloqueado[i]=false;
            saldoInversor[i]=0;
            amigosInvitadosInversor[i]="";
        }

        System.out.println(ANSI_PURPLE+"\n**[Bienvenido a FernanStarter]**\n"+ANSI_RESET);
        do{
            bienvenido=false;
            tipoUsuarioInversor=false;
            tipoUsuarioGestor=false;
            System.out.println("¿Que desea hacer?");
            System.out.println("1.Crear nuevo usuario");
            System.out.println("2.Iniciar Sesion");
            System.out.println("3.Salir");
            opcionInicial=Integer.parseInt(s.nextLine());
            if (opcionInicial==1){

                System.out.println("ACCESO A CREACION DE USUARIO");
                System.out.println("Que tipo de perfil desea crear");
                System.out.println("1.Inversor");
                System.out.println("2.Gestor");
                System.out.println("3.Salir");
                int eleccionCreacionPerfil = Integer.parseInt(s.nextLine());
                if (eleccionCreacionPerfil == 1) {
                    creado = false;
                    for (int i = 0; i < 10; i++) {
                        if (nombreUsuarioInversor[i].equals("") && creado == false) {
                            System.out.println("Introduzca el nombre de usuario del nuevo perfil inversor");
                            nombreUsuarioInversor[i] = s.nextLine();
                            do {
                                System.out.println("Introduzca la contraseña de usuario del nuevo perfil inversor");
                                contrasenaUsuarioInversor[i] = s.nextLine();
                                System.out.println(fortalezaContrasena(contrasenaUsuarioInversor[i]));
                                System.out.println("Repita la contraseña de usuario del nuevo perfil inversor");
                                repeticionContrasena = s.nextLine();
                                if (!confirmarContrasena(contrasenaUsuarioInversor[i], repeticionContrasena)) {
                                    System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                }
                            } while (!confirmarContrasena(contrasenaUsuarioInversor[i], repeticionContrasena));
                            System.out.println("Introduzca su correo ");
                            correoUsuarioInversor[i] = s.nextLine();
                            System.out.println("Introduzca el codigo de verificacion para la creacion del perfil que hemos enviado a su correo");
                            autentificacion = generarAutentificacion();
                            String asunto = "Codigo de autentificacion";
                            String cuerpo = "Codigo de verificacion para crear sesion : " + autentificacion + "\n ";
                            enviarConGMail(correoUsuarioInversor[i], asunto, cuerpo);
                            int verificaion = Integer.parseInt(s.nextLine());
                            if (verificaion == autentificacion) {
                                System.out.println("Usuario creado con exito");
                            } else {
                                System.out.println("El codigo no corresponde al enviado, creacion fallida");
                                nombreUsuarioInversor[i] = "";
                                contrasenaUsuarioInversor[i] = "";
                                correoUsuarioInversor[i] = "";
                            }
                            creado = true;

                        }
                    }
                } else if (eleccionCreacionPerfil == 2) {
                    creado = false;
                    for (int i = 0; i < 10; i++) {
                        if (nombreUsuarioGestor[i].equals("") && creado == false) {
                            System.out.println("Introduzca el nombre de usuario del nuevo perfil gestor");
                            nombreUsuarioGestor[i] = s.nextLine();
                            do {
                                System.out.println("Introduzca la contraseña de usuario del nuevo perfil gestor ");
                                contrasenaUsuarioGestor[i] = s.nextLine();
                                System.out.println(fortalezaContrasena(contrasenaUsuarioGestor[i]));
                                System.out.println("Repita la contraseña de usuario del nuevo perfil gestor ");
                                repeticionContrasena = s.nextLine();
                                if (!confirmarContrasena(contrasenaUsuarioGestor[i], repeticionContrasena)) {
                                    System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                }
                            } while (!confirmarContrasena(contrasenaUsuarioGestor[i], repeticionContrasena));
                            System.out.println("Introduzca su correo ");
                            correoUsuarioGestor[i] = s.nextLine();
                            creado = true;
                            System.out.println("Introduzca el codigo de verificacion para la creacion del perfil que hemos enviado a su correo");
                            autentificacion = generarAutentificacion();
                            String asunto = "Codigo de autentificacion";
                            String cuerpo = "Codigo de verificacion para crear sesion : " + autentificacion + "\n ";
                            enviarConGMail(correoUsuarioGestor[i], asunto, cuerpo);
                            int verificaion = Integer.parseInt(s.nextLine());
                            if (verificaion == autentificacion) {
                                System.out.println("Usuario creado con exito");
                            } else {
                                System.out.println("El codigo no corresponde al enviado, creacion fallida");
                                nombreUsuarioGestor[i] = "";
                                contrasenaUsuarioGestor[i] = "";
                                correoUsuarioGestor[i] = "";
                            }
                        }
                    }
                } else if (eleccionCreacionPerfil == 3) {
                    System.out.println("¡Hasta pronto!");
                }
            }else if (opcionInicial==2) {
                do {
                    System.out.println("Introduce usuario y contraseña. Pulsa s para salir");
                    usuario = s.nextLine();
                    contrasena = s.nextLine();
                    if (!usuario.equals("s") && !contrasena.equals("s")) {
                        if (usuario.equals(usuarioAdmin) && contrasena.equals(contrasenaAdmin)) {
                            System.out.println("Hemos enviado un código a tu correo. Introduce la autentificación");
                            autentificacion = generarAutentificacion();
                            String asunto = "Codigo de autentificacion";
                            String cuerpo = "Codigo de verificacion para el inicio de sesion : " + autentificacion + "\n Bienvenido a FernanStarter";
                            enviarConGMail(destinatarioAdmin, asunto, cuerpo);
                            int codigo = Integer.parseInt(s.nextLine());
                            if (codigo == autentificacion) {
                                System.out.println(ANSI_GREEN + "Bienvenido Administrador" + ANSI_RESET);
                                bienvenido = true;
                            } else {
                                System.out.println("Acceso denegado, clave de autentificacion erronea");
                            }
                        }
                        for (int i = 0; i < nombreUsuarioGestor.length; i++) {
                            if (usuario.equals(nombreUsuarioGestor[i]) && !gestorbloqueado[i]) {
                                usuarioExiste = true;
                                if (contrasena.equals(contrasenaUsuarioGestor[i])) {
                                    intentoGestor[i] = 3;
                                    System.out.println("Hemos enviado un código a tu correo. Introduce la autentificación");
                                    autentificacion = generarAutentificacion();
                                    String asunto = "Codigo de autentificacion";
                                    String cuerpo = "Codigo de verificacion para el inicio de sesion: " + autentificacion + "\n Bienvenido a FernanStarter";
                                    String destinatario = correoUsuarioGestor[i];
                                    enviarConGMail(destinatario, asunto, cuerpo);
                                    int codigo = Integer.parseInt(s.nextLine());
                                    if (codigo == autentificacion) {
                                        System.out.println(ANSI_GREEN + "Hola " + nombreUsuarioGestor[i] + ANSI_RESET);
                                        bienvenido = true;
                                        tipoUsuarioGestor = true;
                                        intentoGestorCodigo[i] = 3;
                                    } else {
                                        System.out.println("Acceso denegado, clave de autentificacion errónea");
                                        intentoGestorCodigo[i]--;
                                        System.out.println("Te quedan " + intentoGestorCodigo[i] + " intentos.");
                                    }
                                    if (intentoGestorCodigo[i] <= 0) {
                                        gestorbloqueado[i] = true;
                                        System.out.println("El usuario ha sido bloqueado. Contacte con el Administrador.");
                                    }
                                } else {
                                    System.out.println("Usuario o contraseña incorrectos");
                                    intentoGestor[i]--;
                                    System.out.println("Te quedan " + intentoGestor[i] + " intentos.");
                                    if (intentoGestor[i] <= 0) {
                                        gestorbloqueado[i] = true;
                                        System.out.println("El usuario ha sido bloqueado. Contacte con el Administrador.");
                                    }
                                }
                            } else if (gestorbloqueado[i]) {
                                System.out.println("El usuario está bloqueado. Por favor contacte con el administrador");
                            }
                        }
                        for (int i = 0; i < nombreUsuarioInversor.length; i++) {
                            if (usuario.equals(nombreUsuarioInversor[i]) && !inversorbloqueado[i]) {
                                usuarioExiste = true;
                                if (contrasena.equals(contrasenaUsuarioInversor[i])) {
                                    intentoInversor[i] = 3;
                                    System.out.println("Hemos enviado un código a tu correo. Introduce la autentificación");
                                    autentificacion = generarAutentificacion();
                                    String asunto = "Codigo de autentificacion";
                                    String cuerpo = "Codigo de verificacion para el inicio de sesion: " + autentificacion + "\n Bienvenido a FernanStarter";
                                    enviarConGMail(correoUsuarioInversor[i], asunto, cuerpo);
                                    int codigo = Integer.parseInt(s.nextLine());
                                    if (codigo == autentificacion) {
                                        System.out.println(ANSI_GREEN + "Hola " + nombreUsuarioInversor[i] + ANSI_RESET);
                                        bienvenido = true;
                                        tipoUsuarioInversor = true;
                                        intentoInversorCodigo[i] = 3;
                                    } else {
                                        System.out.println("Acceso denegado, clave de autentificacion erronea");
                                        intentoInversorCodigo[i]--;
                                        System.out.println("Te quedan " + intentoInversorCodigo[i] + " intentos.");
                                    }
                                    if (intentoInversorCodigo[i] <= 0) {
                                        inversorbloqueado[i] = true;
                                        System.out.println("El usuario ha sido bloqueado. Contacte con el Administrador.");
                                    }
                                } else {
                                    System.out.println("Usuario o contraseña incorrectos");
                                    intentoInversor[i]--;
                                    System.out.println("Te quedan " + intentoInversor[i] + " intentos.");
                                    if (intentoInversor[i] <= 0) {
                                        gestorbloqueado[i] = true;
                                        System.out.println("El usuario ha sido bloqueado. Contacte con el Administrador.");
                                    }
                                }

                            } else if (inversorbloqueado[i]) {
                                System.out.println("El usuario está bloqueado. Por favor contacte con el administrador");
                            }
                        }
                        if (!usuarioExiste && !usuario.equals(usuarioAdmin)) {
                            System.out.println("El usuario introducido no existe");
                        }
                    } else {
                        System.out.println("¡Nos vemos pronto!");
                    }
                }while (!usuario.equals("s") && !contrasena.equals("s"));
            } else if (opcionInicial==3) {
                System.out.println("Cerrando FernanStarter...");
            }else{
                System.out.println("Esa opción no se encuentra en el menú");
            }
            if (bienvenido) {
                if(usuario.equals(usuarioAdmin)) {
                    do {
                        menuAdministrador();
                        opcion=Integer.parseInt(s.nextLine());
                        switch (opcion){
                            case 1: {
                                System.out.println("Ha accedido a Panel de control");
                                System.out.println("¿A qué tipo de usuario quieres acceder?");
                                System.out.println("1. Gestor");
                                System.out.println("2. Inversor");
                                System.out.println("3. Salir");
                                eleccionadmin=Integer.parseInt(s.nextLine());
                                switch (eleccionadmin){
                                    case 1:{
                                        for (int i = 0; i < nombreUsuarioGestor.length; i++) {
                                            if (!nombreUsuarioGestor[i].equals("")){
                                                System.out.print("El estado de "+ nombreUsuarioGestor[i]+ " es ");
                                                if(gestorbloqueado.equals(false)){
                                                    System.out.println(ANSI_GREEN+"desbloqueado"+ANSI_RESET);
                                                }else {
                                                    System.out.println(ANSI_RED+"bloqueado"+ANSI_RESET);
                                                }
                                            }
                                            menuBloqueo();
                                            admin_gestor=Integer.parseInt(s.nextLine());
                                            switch (admin_gestor){
                                                case 1:{
                                                    if(gestorbloqueado.equals(true)){
                                                        System.out.println("Este usuario ya esta bloqueado");
                                                    }else {
                                                        System.out.println("Usuario bloqueado satisfactoriamente");
                                                        gestorbloqueado[i]=true;
                                                    }
                                                    break;
                                                }
                                                case 2:{
                                                    if(gestorbloqueado.equals(false)){
                                                        System.out.println("Este usuario ya esta desbloqueado");
                                                    }else {
                                                        System.out.println("Usuario desbloqueado satisfactoriamente");
                                                        gestorbloqueado[i]=false;
                                                        intentoGestorCodigo[i]=3;
                                                        intentoGestor[i]=3;
                                                    }
                                                    break;
                                                }
                                                case 3:{
                                                    System.out.println("Saliendo al menú principal de "+ usuarioAdmin);
                                                    break;
                                                }
                                                default:
                                                    System.out.println("Opción no valida , saliendo al menu principal de "+usuarioAdmin);
                                            }
                                        }
                                        break;
                                    }
                                    case 2: {
                                        for (int i = 0; i < nombreUsuarioGestor.length; i++) {
                                            if (!nombreUsuarioGestor[i].equals("")) {
                                                System.out.print("El estado de " + nombreUsuarioInversor[i] + " es ");
                                                if (!inversorbloqueado[i]) {
                                                    System.out.println(ANSI_GREEN + "desbloqueado" + ANSI_RESET);
                                                } else {
                                                    System.out.println(ANSI_RED + "bloqueado" + ANSI_RESET);
                                                }
                                            }
                                            menuBloqueo();
                                            admin_inversor1 = Integer.parseInt(s.nextLine());
                                            switch (admin_inversor1) {
                                                case 1: {
                                                    if (inversorbloqueado[i]) {
                                                        System.out.println("Este usuario ya esta bloqueado");
                                                    } else {
                                                        System.out.println("Usuario bloqueado satisfactoriamente");
                                                        inversorbloqueado[i] = true;
                                                    }
                                                    break;
                                                }
                                                case 2: {
                                                    if (!inversorbloqueado[i]) {
                                                        System.out.println("Este usuario ya esta desbloqueado");
                                                    } else {
                                                        System.out.println("Usuario desbloqueado satisfactoriamente");
                                                        inversorbloqueado[i] = false;
                                                        intentoInversorCodigo[i] = 3;
                                                        intentoInversor[i] = 3;
                                                    }
                                                    break;
                                                }
                                                case 3: {
                                                    System.out.println("Saliendo al menú principal de " + usuarioAdmin);
                                                    break;
                                                }
                                                default:
                                                    System.out.println("Opción no valida , saliendo al menu principal de " + usuarioAdmin);
                                            }
                                            break;
                                        }
                                    }
                                    case 3:{
                                        System.out.println("Saliendo del panel de control");
                                        break;
                                    }
                                    default:
                                        System.out.println("Opcion no valida , saliendo de panel de control");
                                }
                                break;
                            }
                            case 2:{
                                verProyecto(proyecto1,proyecto2,proyecto3,ANSI_GREEN,ANSI_RESET);
                                opcionProyectoAdmin = Integer.parseInt(s.nextLine());
                                switch (opcionProyectoAdmin) {
                                    case 1 -> {
                                        if (!proyecto1.equals("Próximamente")) {
                                            visualizarProyecto(proyecto1, categoria1, financiacionTotal1, financiado1, fechaApertura1, fechaCierre1, recompensa1proy1,descripcion1proy1,precio1proy1, recompensa2proy1, descripcion2proy1, precio2proy1, recompensa3proy1, descripcion3proy1, precio3proy1);
                                            porcentajefinanciado1=financiado1*100/financiacionTotal1;
                                            System.out.println("Actualmente se ha financiado un "+porcentajefinanciado1+"%");
                                            grafico(porcentajefinanciado1);
                                        } else {
                                            System.out.println("No existe el proyecto 1");
                                        }
                                    }
                                    case 2 -> {
                                        if (!proyecto2.equals("Próximamente")) {
                                            visualizarProyecto(proyecto2,categoria2,financiacionTotal2,financiado2,fechaApertura2,fechaCierre2,recompensa1proy2,descripcion1proy2,precio1proy2, recompensa2proy2, descripcion2proy2, precio2proy2, recompensa3proy2, descripcion3proy2, precio3proy2);
                                            porcentajefinanciado2=financiado2*100/financiacionTotal2;
                                            System.out.println("Actualmente se ha financiado un "+porcentajefinanciado2+"%");
                                            grafico(porcentajefinanciado2);

                                        } else {
                                            System.out.println("No existe el proyecto 2");
                                        }
                                    }
                                    case 3 -> {
                                        if (!proyecto3.equals("Próximamente")) {
                                            visualizarProyecto(proyecto3,categoria3,financiacionTotal3,financiado3,fechaApertura3,fechaCierre3,recompensa1proy3,descripcion1proy3,precio1proy3, recompensa2proy3, descripcion2proy3, precio2proy3, recompensa3proy3, descripcion3proy3, precio3proy3);
                                            porcentajefinanciado3=financiado3*100/financiacionTotal3;
                                            System.out.println("Actualmente se ha financiado un "+porcentajefinanciado3+"%");
                                            grafico(porcentajefinanciado3);

                                        } else {
                                            System.out.println("No existe el proyecto 3");
                                        }
                                    }
                                    case 4 -> System.out.println("¡Hasta pronto!");
                                    default -> System.out.println("Esa opcion no se encuentra en el menú");
                                }
                                break;
                            }
                            case 3:{
                                System.out.println("Ha accedido a configuración");

                                do{
                                    menuConfiguracion();
                                    Adminconfiguracion=Integer.parseInt(s.nextLine());
                                    switch (Adminconfiguracion){
                                        case 1:{
                                            System.out.println("Introduzca el nuevo nombre de usuario");
                                            usuarioAdmin=s.nextLine();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Introduzca la nueva contraseña de usuario");
                                            contrasenaAdmin=s.nextLine();
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("Saliendo de configuración");
                                            break;
                                        }
                                    }
                                }while(Adminconfiguracion!=3);
                                break;
                            }
                        }
                        if (opcion==4){
                            System.out.println("¡Hasta pronto!");
                        }
                    }while (opcion != 4);
                }
                if(tipoUsuarioGestor) {
                    do {
                        menuGestor();
                        opcion=Integer.parseInt(s.nextLine());
                        switch (opcion){
                            case 1-> {
                                do {
                                    System.out.println("¿Qué quieres hacer?\n" +
                                            "1. Crear un nuevo proyecto\n" +
                                            "2. Vista detallada de mis proyectos\n" +
                                            "3. Modificar un proyecto\n" +
                                            "4. Borrar un proyecto\n" +
                                            "5. Salir");
                                    opcion = Integer.parseInt(s.nextLine());
                                    switch (opcion) {
                                        case 1 ->{
                                            if (proyecto1.equals("Próximamente")){
                                                System.out.println("Introduzca el nombre del proyecto");
                                                proyecto1=s.nextLine();
                                                System.out.println("Introduzca la categoría del proyecto (arte, tecnología, cine, música, juegos, comida, moda…)");
                                                categoria1=s.nextLine();
                                                System.out.println("¿Cual es la cantidad necesaria para financiar este proyecto?");
                                                financiacionTotal1=Integer.parseInt(s.nextLine());
                                                System.out.println("¿Cual es la cantidad financiada hasta el momento?");
                                                financiado1=Integer.parseInt(s.nextLine());
                                                System.out.println("Escriba la fecha de apertura para poder recibir inversiones (formato --/--/----)");
                                                fechaApertura1=s.nextLine();
                                                System.out.println("Escriba la fecha de cierre de inversiones (formato --/--/----)");
                                                fechaCierre1=s.nextLine();
                                                do {
                                                    System.out.println("¿Cuántas recompensas quieres añadir (máximo 3)?");
                                                    cantidadRecompensas1 = Integer.parseInt(s.nextLine());
                                                    if (cantidadRecompensas1<1 || cantidadRecompensas1>3){
                                                        System.out.println("Error, la cantidad de recompensas debe ser de al menos 1 y como máximo de 3");
                                                    }
                                                }while (cantidadRecompensas1<1 || cantidadRecompensas1>3);
                                                for (int i = 1; i <= cantidadRecompensas1; i++) {
                                                    System.out.println("Escriba la recompensa "+i+" ofrecida por el promotor del proyecto");
                                                    if (i==1){
                                                        recompensa1proy1=s.nextLine();
                                                    } else if (i==2) {
                                                        recompensa2proy1=s.nextLine();
                                                    } else if (i==3) {
                                                        recompensa3proy1=s.nextLine();
                                                    }
                                                    System.out.println("Incluye una breve descripción de la recompensa "+i);
                                                    if (i==1){
                                                        descripcion1proy1 =s.nextLine();
                                                    } else if (i==2) {
                                                        descripcion2proy1 =s.nextLine();
                                                    } else if (i==3) {
                                                        descripcion3proy1=s.nextLine();
                                                    }
                                                    System.out.println("¿Qué precio tiene la recompensa "+i+"?");
                                                    if (i==1){
                                                        precio1proy1 =Integer.parseInt(s.nextLine());
                                                    } else if (i==2) {
                                                        precio2proy1 =Integer.parseInt(s.nextLine());
                                                    } else if (i==3) {
                                                        precio3proy1 =Integer.parseInt(s.nextLine());
                                                    }
                                                }
                                                System.out.println("Has añadido esta información en el proyecto 1:");
                                                visualizarProyecto(proyecto1, categoria1, financiacionTotal1, financiado1, fechaApertura1, fechaCierre1, recompensa1proy1,descripcion1proy1,precio1proy1, recompensa2proy1, descripcion2proy1, precio2proy1, recompensa3proy1, descripcion3proy1, precio3proy1);
                                            } else if (proyecto2.equals("Próximamente")) {
                                                System.out.println("Introduzca el nombre del proyecto");
                                                proyecto2=s.nextLine();
                                                System.out.println("Introduzca la categoría del proyecto (arte, tecnología, cine, música, juegos, comida, moda…)");
                                                categoria2=s.nextLine();
                                                System.out.println("¿Cual es la cantidad necesaria para financiar este proyecto?");
                                                financiacionTotal2=Integer.parseInt(s.nextLine());
                                                System.out.println("¿Cual es la cantidad financiada hasta el momento?");
                                                financiado2=Integer.parseInt(s.nextLine());
                                                System.out.println("Escriba la fecha de apertura para poder recibir inversiones (formato --/--/----)");
                                                fechaApertura2=s.nextLine();
                                                System.out.println("Escriba la fecha de cierre de inversiones (formato --/--/----)");
                                                fechaCierre2=s.nextLine();
                                                do {
                                                    System.out.println("¿Cuántas recompensas quieres añadir (máximo 3)?");
                                                    cantidadRecompensas2 = Integer.parseInt(s.nextLine());
                                                    if (cantidadRecompensas2<1 || cantidadRecompensas2>3){
                                                        System.out.println("Error, la cantidad de recompensas debe ser de al menos 1 y como máximo de 3");
                                                    }
                                                }while (cantidadRecompensas2<1 || cantidadRecompensas2>3);
                                                for (int i = 1; i <= cantidadRecompensas2; i++) {
                                                    System.out.println("Escriba la recompensa "+i+" ofrecida por el promotor del proyecto");
                                                    if (i==1){
                                                        recompensa1proy2=s.nextLine();
                                                    } else if (i==2) {
                                                        recompensa2proy2=s.nextLine();
                                                    } else if (i==3) {
                                                        recompensa3proy2=s.nextLine();
                                                    }
                                                    System.out.println("Incluye una breve descripción de la recompensa "+i);
                                                    if (i==1){
                                                        descripcion1proy2 =s.nextLine();
                                                    } else if (i==2) {
                                                        descripcion2proy2 =s.nextLine();
                                                    } else if (i==3) {
                                                        descripcion3proy2=s.nextLine();
                                                    }
                                                    System.out.println("¿Qué precio tiene la recompensa "+i+"?");
                                                    if (i==1){
                                                        precio1proy2 =Integer.parseInt(s.nextLine());
                                                    } else if (i==2) {
                                                        precio2proy2 =Integer.parseInt(s.nextLine());
                                                    } else if (i==3) {
                                                        precio3proy2 =Integer.parseInt(s.nextLine());
                                                    }
                                                }
                                                System.out.println("Has añadido esta información en el proyecto 2:");
                                                visualizarProyecto(proyecto2,categoria2,financiacionTotal2,financiado2,fechaApertura2,fechaCierre2,recompensa1proy2,descripcion1proy2,precio1proy2, recompensa2proy2, descripcion2proy2, precio2proy2, recompensa3proy2, descripcion3proy2, precio3proy2);
                                            } else if (proyecto3.equals("Próximamente")) {
                                                System.out.println("Introduzca el nombre del proyecto");
                                                proyecto3=s.nextLine();
                                                System.out.println("Introduzca la categoría del proyecto (arte, tecnología, cine, música, juegos, comida, moda…)");
                                                categoria3=s.nextLine();
                                                System.out.println("¿Cual es la cantidad necesaria para financiar este proyecto?");
                                                financiacionTotal3=Integer.parseInt(s.nextLine());
                                                System.out.println("¿Cual es la cantidad financiada hasta el momento?");
                                                financiado3=Integer.parseInt(s.nextLine());
                                                System.out.println("Escriba la fecha de apertura para poder recibir inversiones (formato --/--/----)");
                                                fechaApertura3=s.nextLine();
                                                System.out.println("Escriba la fecha de cierre de inversiones (formato --/--/----)");
                                                fechaCierre3=s.nextLine();
                                                do {
                                                    System.out.println("¿Cuántas recompensas quieres añadir? (máximo 3)");
                                                    cantidadRecompensas3 = Integer.parseInt(s.nextLine());
                                                    if (cantidadRecompensas3<1 || cantidadRecompensas3>3){
                                                        System.out.println("Error, la cantidad de recompensas debe ser de al menos 1 y como máximo de 3");
                                                    }
                                                }while (cantidadRecompensas3<1 || cantidadRecompensas3>3);
                                                for (int i = 1; i <= cantidadRecompensas3; i++) {
                                                    System.out.println("Escriba la recompensa "+i+" ofrecida por el promotor del proyecto");
                                                    if (i==1){
                                                        recompensa1proy3=s.nextLine();
                                                    } else if (i==2) {
                                                        recompensa2proy3=s.nextLine();
                                                    } else if (i==3) {
                                                        recompensa3proy3=s.nextLine();
                                                    }
                                                    System.out.println("Incluye una breve descripción de la recompensa "+i);
                                                    if (i==1){
                                                        descripcion1proy3 =s.nextLine();
                                                    } else if (i==2) {
                                                        descripcion2proy3 =s.nextLine();
                                                    } else if (i==3) {
                                                        descripcion3proy3=s.nextLine();
                                                    }
                                                    System.out.println("¿Qué precio tiene la recompensa "+i+"?");
                                                    if (i==1){
                                                        precio1proy3 =Integer.parseInt(s.nextLine());
                                                    } else if (i==2) {
                                                        precio2proy3 =Integer.parseInt(s.nextLine());
                                                    } else if (i==3) {
                                                        precio3proy3 =Integer.parseInt(s.nextLine());
                                                    }
                                                }
                                                System.out.println("Has añadido esta información en el proyecto 3:");
                                                visualizarProyecto(proyecto3,categoria3,financiacionTotal3,financiado3,fechaApertura3,fechaCierre3,recompensa1proy3,descripcion1proy3,precio1proy3, recompensa2proy3, descripcion2proy3, precio2proy3, recompensa3proy3, descripcion3proy3, precio3proy3);
                                            }else{
                                                System.out.println("Ha alcanzado el límite de proyectos.");
                                            }
                                        }
                                        case 2 ->{
                                            do {
                                                verProyecto(proyecto1,proyecto2,proyecto3,ANSI_GREEN,ANSI_RESET);
                                                opcion = Integer.parseInt(s.nextLine());
                                                if (opcion == 1) {
                                                    if (!proyecto1.equals("Próximamente")) {
                                                        visualizarProyecto(proyecto1, categoria1, financiacionTotal1, financiado1, fechaApertura1, fechaCierre1, recompensa1proy1,descripcion1proy1,precio1proy1, recompensa2proy1, descripcion2proy1, precio2proy1, recompensa3proy1, descripcion3proy1, precio3proy1);
                                                        porcentajefinanciado1=financiado1*100/financiacionTotal1;
                                                        System.out.println("Actualmente se ha financiado un "+porcentajefinanciado1+"%");
                                                        grafico(porcentajefinanciado1);
                                                    } else {
                                                        System.out.println("No existe el proyecto 1");
                                                    }
                                                } else if (opcion == 2) {
                                                    if (!proyecto2.equals("Próximamente")) {
                                                        visualizarProyecto(proyecto2,categoria2,financiacionTotal2,financiado2,fechaApertura2,fechaCierre2,recompensa1proy2,descripcion1proy2,precio1proy2, recompensa2proy2, descripcion2proy2, precio2proy2, recompensa3proy2, descripcion3proy2, precio3proy2);
                                                        porcentajefinanciado2=financiado2*100/financiacionTotal2;
                                                        System.out.println("Actualmente se ha financiado un "+porcentajefinanciado2+"%");
                                                        grafico(porcentajefinanciado2);
                                                    } else {
                                                        System.out.println("No existe el proyecto 2");
                                                    }
                                                } else if (opcion == 3) {
                                                    if (!proyecto3.equals("Próximamente")) {
                                                        visualizarProyecto(proyecto3,categoria3,financiacionTotal3,financiado3,fechaApertura3,fechaCierre3,recompensa1proy3,descripcion1proy3,precio1proy3, recompensa2proy3, descripcion2proy3, precio2proy3, recompensa3proy3, descripcion3proy3, precio3proy3);
                                                        porcentajefinanciado3=financiado3*100/financiacionTotal3;
                                                        System.out.println("Actualmente se ha financiado un "+porcentajefinanciado3+"%");
                                                        grafico(porcentajefinanciado3);
                                                    } else {
                                                        System.out.println("No existe el proyecto 3");
                                                    }
                                                } else if (opcion == 4) {
                                                    System.out.println("Ha salido de la vista detallada de proyectos");
                                                } else {
                                                    System.out.println("Esa opción no se encuentra en el menú");
                                                }
                                            }while (opcion!=4);
                                        }
                                        case 3 ->{
                                            do {
                                                System.out.println("Elige un proyecto para modificar\n" +
                                                        "1. Proyecto 1: " + proyecto1 + "\n" +
                                                        "2. Proyecto 2: " + proyecto2 + "\n" +
                                                        "3. Proyecto 3: " + proyecto3 + "\n" +
                                                        "4. Salir");
                                                opcion = Integer.parseInt(s.nextLine());
                                                    if (opcion == 1) {
                                                        if (!proyecto1.equals("Próximamente")) {
                                                            menuModificarProyecto();
                                                            opcion = Integer.parseInt(s.nextLine());
                                                            switch (opcion) {
                                                                case 1 -> {
                                                                    System.out.println("Escribe el nuevo nombre del proyecto 1");
                                                                    proyecto1 = s.nextLine();
                                                                }
                                                                case 2 -> {
                                                                    System.out.println("Escribe la nueva categoría del proyecto 1");
                                                                    categoria1 = s.nextLine();
                                                                }
                                                                case 3 -> {
                                                                    System.out.println("Escribe la nueva cantidad a financiar");
                                                                    financiacionTotal1 = Integer.parseInt(s.nextLine());
                                                                }
                                                                case 4 -> {
                                                                    System.out.println("Escribe la nueva cantidad financiada hasta el momento");
                                                                    financiado1 = Integer.parseInt(s.nextLine());
                                                                }
                                                                case 5 -> {
                                                                    System.out.println("Escribe la nueva fecha de apertura de inversiones (Formato --/--/----)");
                                                                    fechaApertura1 = s.nextLine();
                                                                }
                                                                case 6 -> {
                                                                    System.out.println("Escribe la nueva fecha de cierre de inversiones (Formato --/--/----)");
                                                                    fechaCierre1 = s.nextLine();
                                                                }
                                                                case 7 -> {
                                                                    menuEleccionRecompensa();
                                                                    opcion = Integer.parseInt(s.nextLine());
                                                                    switch (opcion) {
                                                                        case 1 -> {
                                                                            modificarRecompensa();
                                                                            opcion = Integer.parseInt(s.nextLine());
                                                                            if (opcion == 1) {
                                                                                System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                recompensa1proy1 = s.nextLine();
                                                                            } else if (opcion == 2) {
                                                                                System.out.println("Escribe la nueva descripción");
                                                                                descripcion1proy1 = s.nextLine();
                                                                            } else if (opcion == 3) {
                                                                                System.out.println("Escribe el nuevo precio");
                                                                                precio1proy1 = Integer.parseInt(s.nextLine());
                                                                            } else if (opcion == 4) {
                                                                                System.out.println("Ha salido del menú modificar recompensa 1");
                                                                            } else {
                                                                                System.out.println("Esa opción no se encuentra en el menú");
                                                                            }
                                                                        }
                                                                        case 2 -> {
                                                                            if (!recompensa2proy1.equals("")) {
                                                                                modificarRecompensa();
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                if (opcion == 1) {
                                                                                    System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                    recompensa2proy1 = s.nextLine();
                                                                                } else if (opcion == 2) {
                                                                                    System.out.println("Escribe la nueva descripción");
                                                                                    descripcion2proy1 = s.nextLine();
                                                                                } else if (opcion == 3) {
                                                                                    System.out.println("Escribe el nuevo precio");
                                                                                    precio2proy1 = Integer.parseInt(s.nextLine());
                                                                                } else if (opcion == 4) {
                                                                                    System.out.println("Ha salido del menú modificar recompensa 2");
                                                                                } else {
                                                                                    System.out.println("Esa opción no se encuentra en el menú");
                                                                                }
                                                                            } else {
                                                                                System.out.println("No existe esta recompensa todavía");
                                                                            }
                                                                        }
                                                                        case 3 -> {
                                                                            if (!recompensa3proy1.equals("")) {
                                                                                modificarRecompensa();
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                if (opcion == 1) {
                                                                                    System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                    recompensa3proy1 = s.nextLine();
                                                                                } else if (opcion == 2) {
                                                                                    System.out.println("Escribe la nueva descripción");
                                                                                    descripcion3proy1 = s.nextLine();
                                                                                } else if (opcion == 3) {
                                                                                    System.out.println("Escribe el nuevo precio");
                                                                                    precio3proy1 = Integer.parseInt(s.nextLine());
                                                                                } else if (opcion == 4) {
                                                                                    System.out.println("Ha salido del menú modificar recompensa 3");
                                                                                } else {
                                                                                    System.out.println("Esa opción no se encuentra en el menú");
                                                                                }
                                                                            } else {
                                                                                System.out.println("No existe esta recompensa todavía");
                                                                            }
                                                                        }
                                                                        case 4 -> {
                                                                            System.out.println("Ha salido de la modificación de las Recompensas");
                                                                        }
                                                                        default ->
                                                                                System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 8 -> {
                                                                    System.out.println("Ha salido del menú Modificar Proyecto 1");
                                                                }
                                                                default ->
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                            }
                                                        } else {
                                                            System.out.println("No existe el proyecto 1");
                                                        }
                                                    } else if (opcion == 2) {
                                                        if (!proyecto2.equals("Próximamente")) {
                                                            menuModificarProyecto();
                                                            opcion = Integer.parseInt(s.nextLine());
                                                            switch (opcion) {
                                                                case 1 -> {
                                                                    System.out.println("Escribe el nuevo nombre del proyecto 2");
                                                                    proyecto2 = s.nextLine();
                                                                }
                                                                case 2 -> {
                                                                    System.out.println("Escribe la nueva categoría del proyecto 2");
                                                                    categoria2 = s.nextLine();
                                                                }
                                                                case 3 -> {
                                                                    System.out.println("Escribe la nueva cantidad a financiar");
                                                                    financiacionTotal2 = Integer.parseInt(s.nextLine());
                                                                }
                                                                case 4 -> {
                                                                    System.out.println("Escribe la nueva cantidad financiada hasta el momento");
                                                                    financiado2 = Integer.parseInt(s.nextLine());
                                                                }
                                                                case 5 -> {
                                                                    System.out.println("Escribe la nueva fecha de apertura de inversiones (Formato --/--/----)");
                                                                    fechaApertura2 = s.nextLine();
                                                                }
                                                                case 6 -> {
                                                                    System.out.println("Escribe la nueva fecha de cierre de inversiones (Formato --/--/----)");
                                                                    fechaCierre2 = s.nextLine();
                                                                }
                                                                case 7 -> {
                                                                    menuEleccionRecompensa();
                                                                    opcion = Integer.parseInt(s.nextLine());
                                                                    switch (opcion) {
                                                                        case 1 -> {
                                                                            modificarRecompensa();
                                                                            opcion = Integer.parseInt(s.nextLine());
                                                                            if (opcion == 1) {
                                                                                System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                recompensa1proy2 = s.nextLine();
                                                                            } else if (opcion == 2) {
                                                                                System.out.println("Escribe la nueva descripción");
                                                                                descripcion1proy2 = s.nextLine();
                                                                            } else if (opcion == 3) {
                                                                                System.out.println("Escribe el nuevo precio");
                                                                                precio1proy2 = Integer.parseInt(s.nextLine());
                                                                            } else if (opcion == 4) {
                                                                                System.out.println("Ha salido del menú modificar recompensa 1");
                                                                            } else {
                                                                                System.out.println("Esa opción no se encuentra en el menú");
                                                                            }
                                                                        }
                                                                        case 2 -> {
                                                                            if (!recompensa2proy2.equals("")) {
                                                                                modificarRecompensa();
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                if (opcion == 1) {
                                                                                    System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                    recompensa2proy2 = s.nextLine();
                                                                                } else if (opcion == 2) {
                                                                                    System.out.println("Escribe la nueva descripción");
                                                                                    descripcion2proy2 = s.nextLine();
                                                                                } else if (opcion == 3) {
                                                                                    System.out.println("Escribe el nuevo precio");
                                                                                    precio2proy2 = Integer.parseInt(s.nextLine());
                                                                                } else if (opcion == 4) {
                                                                                    System.out.println("Ha salido del menú modificar recompensa 2");
                                                                                } else {
                                                                                    System.out.println("Esa opción no se encuentra en el menú");
                                                                                }
                                                                            } else {
                                                                                System.out.println("No existe esta recompensa todavía");
                                                                            }
                                                                        }
                                                                        case 3 -> {
                                                                            if (!recompensa3proy2.equals("")) {
                                                                                modificarRecompensa();
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                if (opcion == 1) {
                                                                                    System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                    recompensa3proy2 = s.nextLine();
                                                                                } else if (opcion == 2) {
                                                                                    System.out.println("Escribe la nueva descripción");
                                                                                    descripcion3proy2 = s.nextLine();
                                                                                } else if (opcion == 3) {
                                                                                    System.out.println("Escribe el nuevo precio");
                                                                                    precio3proy2 = Integer.parseInt(s.nextLine());
                                                                                } else if (opcion == 4) {
                                                                                    System.out.println("Ha salido del menú modificar recompensa 3");
                                                                                } else {
                                                                                    System.out.println("Esa opción no se encuentra en el menú");
                                                                                }
                                                                            } else {
                                                                                System.out.println("No existe esta recompensa todavía");
                                                                            }
                                                                        }
                                                                        case 4 -> {
                                                                            System.out.println("Ha salido de la modificación de las Recompensas");
                                                                        }
                                                                        default ->
                                                                                System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 8 -> {
                                                                    System.out.println("Ha salido del menú Modificar Proyecto 2");
                                                                }
                                                                default ->
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                            }
                                                        } else {
                                                            System.out.println("No existe el proyecto 2");
                                                        }
                                                    } else if (opcion == 3) {
                                                        if (!proyecto3.equals("Próximamente")) {
                                                            menuModificarProyecto();
                                                            opcion = Integer.parseInt(s.nextLine());
                                                            switch (opcion) {
                                                                case 1 -> {
                                                                    System.out.println("Escribe el nuevo nombre del proyecto 3");
                                                                    proyecto3 = s.nextLine();
                                                                }
                                                                case 2 -> {
                                                                    System.out.println("Escribe la nueva categoría del proyecto 3");
                                                                    categoria3 = s.nextLine();
                                                                }
                                                                case 3 -> {
                                                                    System.out.println("Escribe la nueva cantidad a financiar");
                                                                    financiacionTotal3 = Integer.parseInt(s.nextLine());
                                                                }
                                                                case 4 -> {
                                                                    System.out.println("Escribe la nueva cantidad financiada hasta el momento");
                                                                    financiado3 = Integer.parseInt(s.nextLine());
                                                                }
                                                                case 5 -> {
                                                                    System.out.println("Escribe la nueva fecha de apertura de inversiones (Formato --/--/----)");
                                                                    fechaApertura3 = s.nextLine();
                                                                }
                                                                case 6 -> {
                                                                    System.out.println("Escribe la nueva fecha de cierre de inversiones (Formato --/--/----)");
                                                                    fechaCierre3 = s.nextLine();
                                                                }
                                                                case 7 -> {
                                                                    menuEleccionRecompensa();
                                                                    opcion = Integer.parseInt(s.nextLine());
                                                                    switch (opcion) {
                                                                        case 1 -> {
                                                                            modificarRecompensa();
                                                                            opcion = Integer.parseInt(s.nextLine());
                                                                            if (opcion == 1) {
                                                                                System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                recompensa1proy3 = s.nextLine();
                                                                            } else if (opcion == 2) {
                                                                                System.out.println("Escribe la nueva descripción");
                                                                                descripcion1proy3 = s.nextLine();
                                                                            } else if (opcion == 3) {
                                                                                System.out.println("Escribe el nuevo precio");
                                                                                precio1proy3 = Integer.parseInt(s.nextLine());
                                                                            } else if (opcion == 4) {
                                                                                System.out.println("Ha salido del menú modificar recompensa 1");
                                                                            } else {
                                                                                System.out.println("Esa opción no se encuentra en el menú");
                                                                            }
                                                                        }
                                                                        case 2 -> {
                                                                            if (!recompensa2proy3.equals("")) {
                                                                                modificarRecompensa();
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                if (opcion == 1) {
                                                                                    System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                    recompensa2proy3 = s.nextLine();
                                                                                } else if (opcion == 2) {
                                                                                    System.out.println("Escribe la nueva descripción");
                                                                                    descripcion2proy3 = s.nextLine();
                                                                                } else if (opcion == 3) {
                                                                                    System.out.println("Escribe el nuevo precio");
                                                                                    precio2proy3 = Integer.parseInt(s.nextLine());
                                                                                } else if (opcion == 4) {
                                                                                    System.out.println("Ha salido del menú modificar recompensa 2");
                                                                                } else {
                                                                                    System.out.println("Esa opción no se encuentra en el menú");
                                                                                }
                                                                            } else {
                                                                                System.out.println("No existe esta recompensa todavía");
                                                                            }
                                                                        }
                                                                        case 3 -> {
                                                                            if (!recompensa3proy3.equals("")) {
                                                                                modificarRecompensa();
                                                                                opcion = Integer.parseInt(s.nextLine());
                                                                                if (opcion == 1) {
                                                                                    System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                    recompensa3proy3 = s.nextLine();
                                                                                } else if (opcion == 2) {
                                                                                    System.out.println("Escribe la nueva descripción");
                                                                                    descripcion3proy3 = s.nextLine();
                                                                                } else if (opcion == 3) {
                                                                                    System.out.println("Escribe el nuevo precio");
                                                                                    precio3proy3 = Integer.parseInt(s.nextLine());
                                                                                } else if (opcion == 4) {
                                                                                    System.out.println("Ha salido del menú modificar recompensa 3");
                                                                                } else {
                                                                                    System.out.println("Esa opción no se encuentra en el menú");
                                                                                }
                                                                            } else {
                                                                                System.out.println("No existe esta recompensa todavía");
                                                                            }
                                                                        }
                                                                        case 4 -> {
                                                                            System.out.println("Ha salido de la modificación de las Recompensas");
                                                                        }
                                                                        default ->
                                                                                System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 8 -> {
                                                                    System.out.println("Ha salido del menú Modificar Proyecto 3");
                                                                }
                                                                default ->
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                            }
                                                        } else {
                                                            System.out.println("No existe el proyecto 3");
                                                        }
                                                    } else if (opcion == 4) {
                                                        System.out.println("Ha salido del menú modificar proyecto");
                                                    } else {
                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                    }

                                            }while (opcion!=4);
                                        }
                                        case 4 ->{
                                            do {
                                                borrarProyecto(proyecto1,proyecto2,proyecto3);
                                                opcion = Integer.parseInt(s.nextLine());
                                                if (opcion == 1) {
                                                    if (!proyecto1.equals("Próximamente")) {
                                                        proyecto1 = "Próximamente";
                                                        System.out.println("Ha borrado el proyecto 1 satisfactoriamente.");
                                                    } else {
                                                        System.out.println("No existe el proyecto 1");
                                                    }
                                                } else if (opcion == 2) {
                                                    if (!proyecto2.equals("Próximamente")) {
                                                        proyecto2 = "Próximamente";
                                                        System.out.println("Ha borrado el proyecto 2 satisfactoriamente.");
                                                    } else {
                                                        System.out.println("No existe el proyecto 2");
                                                    }
                                                } else if (opcion == 3) {
                                                    if (!proyecto3.equals("Próximamente")) {
                                                        proyecto3 = "Próximamente";
                                                        System.out.println("Ha borrado el proyecto 3 satisfactoriamente.");
                                                    } else {
                                                        System.out.println("No existe el proyecto 3");
                                                    }
                                                } else if (opcion == 4) {
                                                    System.out.println("Ha salido del menú borrar proyecto");
                                                } else {
                                                    System.out.println("Esa opción no se encuentra en el menú");
                                                }
                                            }while (opcion!=4);
                                        }
                                        case 5 -> System.out.println("Pagina de proyectos cerrada");
                                        default -> System.out.println("Esa opción no existe en el menú");
                                    }
                                }while (opcion!=5);
                            }
                            case 2 -> {
                                System.out.println("Ha accedido a configuración");

                                do{
                                    menuConfiguracion();
                                    opcionConfiguracion=Integer.parseInt(s.nextLine());
                                    switch (opcionConfiguracion){
                                        case 1:{
                                            System.out.println("Introduzca el nombre de usuario actual");
                                            nombreUsuarioActual=s.nextLine();
                                            System.out.println("Introduzca el nuevo nombre de usuario");
                                            nuevoNombreUsuario=s.nextLine();
                                            usuarioCambiado=false;
                                            for (int i = 0; i < nombreUsuarioGestor.length; i++) {
                                                if (nombreUsuarioActual.equals(nombreUsuarioGestor[i])){
                                                    nombreUsuarioGestor[i]=nuevoNombreUsuario;
                                                    usuarioCambiado=true;
                                                }
                                            }
                                            if (usuarioCambiado){
                                                System.out.println(ANSI_GREEN+"Nombre de usuario actualizado satisfactoriamente"+ANSI_RESET);
                                            }else{
                                                System.out.println(ANSI_RED+"El nombre de usuario actual introducido es erróneo"+ANSI_RESET);
                                            }
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Introduzca la contraseña actual");
                                            contrasenaActual=s.nextLine();
                                            do {
                                                System.out.println("Introduzca la nueva contraseña");
                                                nuevaContrasena=s.nextLine();
                                                System.out.println(fortalezaContrasena(nuevaContrasena));
                                                System.out.println("Vuelve a escribir la nueva contraseña");
                                                repeticionContrasena = s.nextLine();
                                                if (!confirmarContrasena(nuevaContrasena, repeticionContrasena)) {
                                                    System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                                }
                                            }while(!confirmarContrasena(nuevaContrasena, repeticionContrasena));
                                            contrasenaCambiada=false;
                                            for (int i = 0; i < contrasenaUsuarioGestor.length; i++) {
                                                if (contrasenaActual.equals(contrasenaUsuarioGestor[i])){
                                                    contrasenaUsuarioGestor[i]=nuevaContrasena;
                                                    contrasenaCambiada=true;
                                                }
                                            }
                                            if (contrasenaCambiada){
                                                System.out.println(ANSI_GREEN+"Contraseña actualizada satisfactoriamente");
                                            }else{
                                                System.out.println(ANSI_RED+"La contraseña actual introducida es errónea");
                                            }
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("Saliendo de configuración");
                                            break;
                                        }
                                    }
                                }while(opcionConfiguracion!=3);
                            }
                            case 3-> System.out.println("¡Hasta pronto!");
                            default -> System.out.println("Esa opción no se encuentra en el menú");
                        }

                    }while (opcion != 3);
                }
                if(tipoUsuarioInversor) {
                    do {
                        menuInversor();
                        opcion=Integer.parseInt(s.nextLine());
                        switch (opcion){
                            case 1:{
                                System.out.println("Usted ha accedido a Mis inversiones");
                                if(inversionProyecto1Inversor1>0) {
                                    System.out.println("Usted ha contribuido con " + inversionProyecto1Inversor1 + " € en el proyecto *****" + proyecto1 + "*****");
                                    System.out.println("La categoria de *****" + proyecto1 + "***** es " + categoria1);
                                    if (precio1proy1 != 0 && inversionProyecto1Inversor1 >= precio1proy1) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 1 del proyecto "+proyecto1+": " + recompensa1proy1+ANSI_RESET);
                                    }
                                    if (precio2proy1 != 0 && inversionProyecto1Inversor1 >= precio2proy1){
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 2 del proyecto "+proyecto1+": " + recompensa2proy1+ANSI_RESET);
                                    }
                                    if (precio3proy1!=0 && inversionProyecto1Inversor1>precio3proy1) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 3 del proyecto "+proyecto1+": " + recompensa3proy1+ANSI_RESET);
                                    }
                                }
                                if(inversionProyecto2Inversor1>0){
                                    System.out.println("Usted ha contribuido con "+ inversionProyecto2Inversor1+" € en el proyecto *****"+ proyecto2+"*****");
                                    System.out.println("La categoria de *****"+proyecto2+"***** es "+categoria2);
                                    if (precio1proy2 != 0 && inversionProyecto2Inversor1 >= precio1proy2) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 1 del proyecto "+proyecto2+": "+ recompensa1proy2+ANSI_RESET);
                                    }
                                    if (precio2proy2 != 0 && inversionProyecto2Inversor1 >= precio2proy2){
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 2 del proyecto "+proyecto2+": "+ recompensa2proy2+ANSI_RESET);
                                    }
                                    if (precio3proy2!=0 && inversionProyecto2Inversor1>precio3proy2) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 3 del proyecto "+proyecto2+": "+ recompensa3proy2+ANSI_RESET);
                                    }
                                }
                                if(inversionProyecto3Inversor1>0){
                                    System.out.println("Usted ha contribuido con "+ inversionProyecto3Inversor1+" € en el proyecto *****"+ proyecto3+"*****");
                                    System.out.println("La categoria de *****"+proyecto3+"***** es "+categoria3);
                                    if (precio1proy3 != 0 && inversionProyecto3Inversor1 >= precio1proy3) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 1 del proyecto "+proyecto3+": "+ recompensa1proy3+ANSI_RESET);
                                    }
                                    if (precio2proy3 != 0 && inversionProyecto3Inversor1 >= precio2proy3){
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 2 del proyecto "+proyecto3+": "+ recompensa2proy3+ANSI_RESET);
                                    }
                                    if (precio3proy3!=0 && inversionProyecto3Inversor1>=precio3proy3) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 3 del proyecto "+proyecto3+": "+ recompensa3proy3+ANSI_RESET);
                                    }
                                }
                                if (inversionProyecto3Inversor1==0&&inversionProyecto2Inversor1==0&&inversionProyecto1Inversor1==0){
                                    System.out.println(ANSI_RED+"Aún no has realizado ninguna inversion"+ANSI_RESET);
                                }
                                break;
                            }
                            case 2:{
                                verProyecto(proyecto1,proyecto2,proyecto3,ANSI_GREEN,ANSI_RESET);

                                opcion = Integer.parseInt(s.nextLine());
                                switch (opcion) {
                                    case 1-> {
                                        if (!proyecto1.equals("Próximamente")) {
                                            visualizarProyecto(proyecto1, categoria1, financiacionTotal1, financiado1, fechaApertura1, fechaCierre1, recompensa1proy1,descripcion1proy1,precio1proy1, recompensa2proy1, descripcion2proy1, precio2proy1, recompensa3proy1, descripcion3proy1, precio3proy1);
                                            porcentajefinanciado1=financiado1*100/financiacionTotal1;
                                            System.out.println("Actualmente se ha financiado un "+porcentajefinanciado1+"%");
                                            grafico(porcentajefinanciado1);
                                            System.out.println("\n Quieres invertir en el proyecto: "+proyecto1+"? (si/no)");
                                            if (s.nextLine().equalsIgnoreCase("SI")) {
                                                System.out.println("Por favor introduzca usuario y contraseña para validar la operación");
                                                usuario=s.nextLine();
                                                contrasena=s.nextLine();
                                                validarOperacion(usuario, contrasena, nombreUsuarioInversor,contrasenaUsuarioInversor);
                                                System.out.println("¿Cuánto desea invertir?");
                                                intentoInversion=Integer.parseInt(s.nextLine());
                                                inversionAceptada=false;
                                                for (int i = 0; i < saldoInversor.length; i++) {
                                                    if (intentoInversion<=saldoInversor[i] && intentoInversion>0){
                                                        inversionAceptada=true;
                                                        System.out.println(ANSI_GREEN+"Operacion realizada con exito"+ANSI_RESET);
                                                        inversionProyecto2Inversor1+=intentoInversion;
                                                        saldoInversor[i]-=intentoInversion;
                                                        financiado1+=intentoInversion;
                                                    }
                                                }
                                                if (!inversionAceptada){
                                                    System.out.println(ANSI_RED+"Operación Denegada"+ANSI_RESET);
                                                }
                                            }else{
                                                System.out.println("Volviendo al menú principal");
                                            }
                                        } else {
                                            System.out.println("No existe el proyecto 1");
                                        }
                                    }
                                    case 2-> {
                                        if (!proyecto2.equals("Próximamente")) {
                                            visualizarProyecto(proyecto2,categoria2,financiacionTotal2,financiado2,fechaApertura2,fechaCierre2,recompensa1proy2,descripcion1proy2,precio1proy2, recompensa2proy2, descripcion2proy2, precio2proy2, recompensa3proy2, descripcion3proy2, precio3proy2);
                                            porcentajefinanciado2=financiado2*100/financiacionTotal2;
                                            System.out.println("Actualmente se ha financiado un "+porcentajefinanciado2+"%");
                                            grafico(porcentajefinanciado2);
                                            System.out.println("\n Quieres invertir en el proyecto: "+proyecto2+"? (si/no)");
                                            if (s.nextLine().equalsIgnoreCase("SI")) {
                                                System.out.println("Por favor introduzca usuario y contraseña para validar la operación");
                                                usuario=s.nextLine();
                                                contrasena=s.nextLine();
                                                validarOperacion(usuario, contrasena, nombreUsuarioInversor,contrasenaUsuarioInversor);
                                                System.out.println("¿Cuánto desea invertir?");
                                                intentoInversion=Integer.parseInt(s.nextLine());
                                                inversionAceptada=false;
                                                for (int i = 0; i < saldoInversor.length; i++) {
                                                    if (intentoInversion<=saldoInversor[i] && intentoInversion>0){
                                                        inversionAceptada=true;
                                                        System.out.println(ANSI_GREEN+"Operacion realizada con exito"+ANSI_RESET);
                                                        inversionProyecto2Inversor1+=intentoInversion;
                                                        saldoInversor[i]-=intentoInversion;
                                                        financiado2+=intentoInversion;
                                                    }
                                                }
                                                if (!inversionAceptada){
                                                    System.out.println(ANSI_RED+"Operación Denegada"+ANSI_RESET);
                                                }
                                            }else{
                                                System.out.println("Volviendo al menú principal");
                                            }
                                        } else {
                                            System.out.println("No existe el proyecto 2");
                                        }
                                    }
                                    case 3-> {
                                        if (!proyecto3.equals("Próximamente")) {
                                            visualizarProyecto(proyecto3,categoria3,financiacionTotal3,financiado3,fechaApertura3,fechaCierre3,recompensa1proy3,descripcion1proy3,precio1proy3, recompensa2proy3, descripcion2proy3, precio2proy3, recompensa3proy3, descripcion3proy3, precio3proy3);
                                            porcentajefinanciado3=financiado3*100/financiacionTotal3;
                                            System.out.println("Actualmente se ha financiado un "+porcentajefinanciado3+"%");
                                            grafico(porcentajefinanciado3);
                                            System.out.println("\n Quieres invertir en el proyecto: "+proyecto3+"? (si/no)");
                                            if (s.nextLine().equalsIgnoreCase("SI")) {
                                                System.out.println("Por favor introduzca usuario y contraseña para validar la operación");
                                                usuario=s.nextLine();
                                                contrasena=s.nextLine();
                                                validarOperacion(usuario, contrasena, nombreUsuarioInversor,contrasenaUsuarioInversor);
                                                System.out.println("¿Cuánto desea invertir?");
                                                intentoInversion=Integer.parseInt(s.nextLine());
                                                inversionAceptada=false;
                                                for (int i = 0; i < saldoInversor.length; i++) {
                                                    if (intentoInversion<=saldoInversor[i] && intentoInversion>0){
                                                        inversionAceptada=true;
                                                        System.out.println(ANSI_GREEN+"Operacion realizada con exito"+ANSI_RESET);
                                                        inversionProyecto2Inversor1+=intentoInversion;
                                                        saldoInversor[i]-=intentoInversion;
                                                        financiado3+=intentoInversion;
                                                    }
                                                }
                                                if (!inversionAceptada){
                                                    System.out.println(ANSI_RED+"Operación Denegada"+ANSI_RESET);
                                                }
                                            }else{
                                                System.out.println("Volviendo al menú principal");
                                            }
                                        } else {
                                            System.out.println("No existe el proyecto 3");
                                        }
                                    }
                                    case 4-> System.out.println("¡Hasta pronto!");
                                    default -> System.out.println("Esa opción no se encuentra en el menú");
                                }
                                break;
                            }
                            case 3:{
                                do{
                                    gestionSaldoInversor(nombreUsuarioInversor,contrasenaUsuarioInversor,saldoInversor);
                                }while (opcion!=3);
                                break;
                            }
                            case 4:{
                                invitarAmigo(amigosInvitadosInversor, nombreUsuarioInversor, correoUsuarioInversor);
                                break;
                            }
                            case 5:{
                                System.out.println("Ha accedido a configuración");

                                do{
                                    menuConfiguracion();
                                    opcion=Integer.parseInt(s.nextLine());
                                    switch (opcion){
                                        case 1:{
                                            System.out.println("Introduzca el nombre de usuario actual");
                                            nombreUsuarioActual=s.nextLine();
                                            System.out.println("Introduzca el nuevo nombre de usuario");
                                            nuevoNombreUsuario=s.nextLine();
                                            usuarioCambiado=false;
                                            for (int i = 0; i < nombreUsuarioInversor.length; i++) {
                                                if (nombreUsuarioActual.equals(nombreUsuarioInversor[i])){
                                                    nombreUsuarioInversor[i]=nuevoNombreUsuario;
                                                    usuarioCambiado=true;
                                                }
                                            }
                                            if (usuarioCambiado){
                                                System.out.println(ANSI_GREEN+"Nombre de usuario actualizado satisfactoriamente"+ANSI_RESET);
                                            }else{
                                                System.out.println(ANSI_RED+"El nombre de usuario actual introducido es erróneo"+ANSI_RESET);
                                            }
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Introduzca la contraseña actual");
                                            contrasenaActual=s.nextLine();
                                            do {
                                                System.out.println("Introduzca la nueva contraseña");
                                                nuevaContrasena=s.nextLine();
                                                System.out.println(fortalezaContrasena(nuevaContrasena));
                                                System.out.println("Vuelve a escribir la nueva contraseña");
                                                repeticionContrasena = s.nextLine();
                                                if (!confirmarContrasena(nuevaContrasena, repeticionContrasena)) {
                                                    System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                                }
                                            }while(!confirmarContrasena(nuevaContrasena, repeticionContrasena));
                                            contrasenaCambiada=false;
                                            for (int i = 0; i < contrasenaUsuarioInversor.length; i++) {
                                                if (contrasenaActual.equals(contrasenaUsuarioInversor[i])){
                                                    contrasenaUsuarioInversor[i]=nuevaContrasena;
                                                    contrasenaCambiada=true;
                                                }
                                            }
                                            if (contrasenaCambiada){
                                                System.out.println(ANSI_GREEN+"Contraseña actualizada satisfactoriamente");
                                            }else{
                                                System.out.println(ANSI_RED+"La contraseña actual introducida es errónea");
                                            }
                                            break;
                                        }
                                        case 3:{
                                            System.out.println("Saliendo de configuración");
                                            break;
                                        }
                                    }
                                }while(opcion!=3);
                                break;
                            }

                        }
                        if (opcion==6){
                            System.out.println("¡Hasta pronto!");
                        }
                    }while (opcion != 6);
                }
            }
        }while(opcionInicial!=3);
    }
}