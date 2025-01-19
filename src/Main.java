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
        String destinatarioAdmin="davidrosanebrera@gmail.com";
        String usuarioAdmin="administrador";
        String contrasenaAdmin="admin";
        String [] nombreUsuarioGestor = {"gestor","","","","","","","","",""};
        String [] contrasenaUsuarioGestor = {"gestor","","","","","","","","",""};
        String [] correoUsuarioGestor = {"davidrosanebrera@gmail.com","","","","","","","","",""};
        String [] nombreUsuarioInversor = {"inversor","","","","","","","","",""};
        String [] contrasenaUsuarioInversor = {"inversor","","","","","","","","",""};
        String [] correoUsuarioInversor = {"davidrosanebrera@gmail.com","","","","","","","","",""};
        String [] proyecto = {"Aloha","","","","","","","","","","","","","","","","","","",""};
        String [] categoria = {"Cine","","","","","","","","","","","","","","","","","","",""};
        int [] financiacionTotal = {500,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] financiado = {200,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String [] fechaApertura = {"12/12/1212","","","","","","","","","","","","","","","","","","",""};
        String [] fechaCierre = {"12/12/1212","","","","","","","","","","","","","","","","","","",""};
        int [] cantidadRecompensas= {3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String [] recompensa1proy = {"gafas","","","","","","","","","","","","","","","","","","",""};
        String [] recompensa2proy = {"trineo","","","","","","","","","","","","","","","","","","",""};
        String [] recompensa3proy = {"televisor","","","","","","","","","","","","","","","","","","",""};
        String [] descripcion1proy = {"qer","","","","","","","","","","","","","","","","","","",""};
        String [] descripcion2proy = {" qwer","","","","","","","","","","","","","","","","","","",""};
        String [] descripcion3proy = {"qwert","","","","","","","","","","","","","","","","","","",""};
        int [] precio1proy = {20,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] precio2proy = {50,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] precio3proy = {250,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [] porcentajefinanciado = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int [][] inversorProyectoInversion = new int[10][20];
        int []contadorInversiones= new int [10];
        int [] intentoGestor= new int[10];
        int [] intentoInversor= new int[10];
        int [] intentoGestorCodigo= new int[10];
        int [] intentoInversorCodigo= new int[10];
        int [] saldoInversor= new int[10];
        String [] amigosInvitadosInversor= new String[10];
        boolean [] gestorbloqueado=new boolean [10];
        boolean [] inversorbloqueado=new boolean [10];
        String usuarioActual="";
        String contrasenaActual;
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
        int numeroProyecto;
        int intentoInversion;
        int opcionInicial=0;
        int numeroUsuario;
        int autentificacion;
        int contadorProyectos=0;
        String nombreUsuario;
        boolean creado=false;
        boolean loginHecho=false;

        for (int i = 0; i < intentoGestor.length; i++) {
            intentoGestor[i]=3;
            intentoInversor[i]=3;
            intentoGestorCodigo[i]=3;
            intentoInversorCodigo[i]=3;
            inversorbloqueado[i]=false;
            gestorbloqueado[i]=false;
            saldoInversor[i]=0;
            amigosInvitadosInversor[i]="";
            contadorInversiones[i]=0;
        }

        System.out.println(ANSI_PURPLE+"\n**[Bienvenido a FernanStarter]**\n"+ANSI_RESET);
        do{
            bienvenido=false;
            tipoUsuarioInversor=false;
            tipoUsuarioGestor=false;
            loginHecho=false;
            System.out.println("¿Que desea hacer?");
            System.out.println("1.Crear nuevo usuario");
            System.out.println("2.Iniciar Sesion");
            System.out.println("3.Salir");
            opcionInicial=Integer.parseInt(s.nextLine());
            if (opcionInicial==1){

                System.out.println(ANSI_PURPLE+"---ACCESO A CREACION DE USUARIO---"+ANSI_RESET);
                System.out.println("Que tipo de perfil desea crear");
                System.out.println("1.Inversor");
                System.out.println("2.Gestor");
                System.out.println("3.Salir");
                int eleccionCreacionPerfil = Integer.parseInt(s.nextLine());
                if (eleccionCreacionPerfil == 1) {
                    creado = false;
                    for (int i = 0; i < 10; i++) {
                        if (nombreUsuarioInversor[i].equals("") && creado == false) {
                            boolean aux;
                            do {
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil inversor");
                                nombreUsuario = s.nextLine();
                                aux=usuarioNoExiste(nombreUsuario, nombreUsuarioInversor);
                                if (!aux)
                                    System.out.println("El nombre de usuario ya está en uso");

                            }while (!aux);
                                nombreUsuarioInversor[i]=nombreUsuario;
                            do {
                                do {
                                    System.out.println("Introduzca la contraseña de usuario del nuevo perfil inversor");
                                    contrasenaUsuarioInversor[i] = s.nextLine();
                                    System.out.println(fortalezaContrasena(contrasenaUsuarioInversor[i]));
                                    if (fortalezaContrasena(contrasenaUsuarioInversor[i]).equals("Robustez de la contraseña: Débil")){
                                        System.out.println("La fortaleza de la contraseña no puede ser debil, para una mayor seguridad en sus datos.");
                                    }
                                }while(fortalezaContrasena(contrasenaUsuarioInversor[i]).equals("Robustez de la contraseña: Débil"));
                                System.out.println("Repita la contraseña de usuario del nuevo perfil inversor");
                                repeticionContrasena = s.nextLine();
                                if (!confirmarContrasena(contrasenaUsuarioInversor[i], repeticionContrasena)) {
                                    System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                }
                            } while (!confirmarContrasena(contrasenaUsuarioInversor[i], repeticionContrasena));
                            do {
                                System.out.println("Introduzca su correo ");
                                correoUsuarioInversor[i] = s.nextLine();
                                if (!comprobacionCorreo(correoUsuarioInversor[i])){
                                    System.out.println("El formato del correo debe contener @");
                                }
                            }while(!comprobacionCorreo(correoUsuarioInversor[i]));
                            System.out.println("Introduzca el codigo de verificacion para la creacion del perfil que hemos enviado a su correo");
                            autentificacion = generarAutentificacion();
                            String asunto = "Codigo de autentificacion";
                            String cuerpo = "Bienvenido a FernanStarter! Codigo de verificacion para crear tu nuevo usuario: " + autentificacion + "\n ";
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
                            boolean aux;
                            do {
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil gestor");
                                nombreUsuario = s.nextLine();
                                aux=usuarioNoExiste(nombreUsuario, nombreUsuarioGestor);
                                if (!aux)
                                    System.out.println("El nombre de usuario ya está en uso");

                            }while (!aux);
                            nombreUsuarioGestor[i]=nombreUsuario;
                            do {
                                do {
                                    System.out.println("Introduzca la contraseña de usuario del nuevo perfil gestor ");
                                    contrasenaUsuarioGestor[i] = s.nextLine();
                                    System.out.println(fortalezaContrasena(contrasenaUsuarioGestor[i]));
                                    if (fortalezaContrasena(contrasenaUsuarioGestor[i]).equals("Robustez de la contraseña: Débil")){
                                        System.out.println("La contraseña debe tener al menos una longitud de 8 y contener mayúsculas y minúsculas.");
                                    }
                                }while (fortalezaContrasena(contrasenaUsuarioGestor[i]).equals("Robustez de la contraseña: Débil"));
                                System.out.println("Repita la contraseña de usuario del nuevo perfil gestor ");
                                repeticionContrasena = s.nextLine();
                                if (!confirmarContrasena(contrasenaUsuarioGestor[i], repeticionContrasena)) {
                                    System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                }
                            } while (!confirmarContrasena(contrasenaUsuarioGestor[i], repeticionContrasena));
                            do {
                                System.out.println("Introduzca su correo ");
                                correoUsuarioGestor[i] = s.nextLine();
                                if (!comprobacionCorreo(correoUsuarioGestor[i])){
                                    System.out.println("Error. Debe introducir un correo electronico");
                                }
                            }while(!comprobacionCorreo(correoUsuarioGestor[i]));
                            creado = true;
                            System.out.println("Introduzca el codigo de verificacion para la creacion del perfil que hemos enviado a su correo");
                            autentificacion = generarAutentificacion();
                            String asunto = "Codigo de autentificacion";
                            String cuerpo = "Bienvenido a FernanStarter! Codigo de verificacion para crear tu nuevo usuario: " + autentificacion + "\n ";
                            enviarConGMail(correoUsuarioGestor[i], asunto, cuerpo);
                            int verificaion = Integer.parseInt(s.nextLine());
                            if (verificaion == autentificacion) {
                                System.out.println(ANSI_GREEN+"Usuario creado con exito"+ANSI_RESET);
                            } else {
                                System.out.println(ANSI_RED+"El codigo no corresponde al enviado, creacion fallida"+ANSI_RESET);
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
                                loginHecho=true;
                                usuarioActual="Administrador";
                            } else {
                                System.out.println(ANSI_RED+"Acceso denegado, clave de autentificacion erronea"+ANSI_RESET);
                            }
                        }
                        for (int i = 0; i < nombreUsuarioGestor.length; i++) {
                            if (usuario.equals(nombreUsuarioGestor[i])) {
                                usuarioExiste = true;
                                if (contrasena.equals(contrasenaUsuarioGestor[i]) && !gestorbloqueado[i]) {
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
                                        loginHecho=true;
                                        intentoGestorCodigo[i] = 3;
                                        usuarioActual=nombreUsuarioGestor[i];
                                    } else {
                                        System.out.println(ANSI_RED+"Acceso denegado, clave de autentificacion errónea"+ANSI_RESET);
                                        intentoGestorCodigo[i]--;
                                        System.out.println("Te quedan " + intentoGestorCodigo[i] + " intentos.");
                                    }
                                    if (intentoGestorCodigo[i] <= 0) {
                                        gestorbloqueado[i] = true;
                                        System.out.println(ANSI_RED+"El usuario ha sido bloqueado. Contacte con el Administrador."+ANSI_RESET);
                                    }
                                } else {
                                    System.out.println("Usuario o contraseña incorrectos");
                                    intentoGestor[i]--;
                                    System.out.println("Te quedan " + intentoGestor[i] + " intentos.");
                                    if (intentoGestor[i] <= 0) {
                                        gestorbloqueado[i] = true;
                                        System.out.println(ANSI_RED+"El usuario ha sido bloqueado. Contacte con el Administrador."+ANSI_RESET);
                                    }
                                }
                            } else if (usuario.equals(nombreUsuarioGestor[i]) && gestorbloqueado[i]) {
                                System.out.println("El usuario está bloqueado. Por favor contacte con el administrador");
                            }
                        }
                        for (int i = 0; i < nombreUsuarioInversor.length; i++) {
                            if (usuario.equals(nombreUsuarioInversor[i])) {
                                usuarioExiste = true;
                                if (contrasena.equals(contrasenaUsuarioInversor[i]) && !inversorbloqueado[i]) {
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
                                        loginHecho=true;
                                        intentoInversorCodigo[i] = 3;
                                        usuarioActual=nombreUsuarioInversor[i];
                                    } else {
                                        System.out.println(ANSI_RED+"Acceso denegado, clave de autentificacion erronea"+ANSI_RESET);
                                        intentoInversorCodigo[i]--;
                                        System.out.println("Te quedan " + intentoInversorCodigo[i] + " intentos.");
                                    }
                                    if (intentoInversorCodigo[i] <= 0) {
                                        inversorbloqueado[i] = true;
                                        System.out.println(ANSI_RED+"El usuario ha sido bloqueado. Contacte con el Administrador."+ANSI_RESET);
                                    }
                                } else {
                                    System.out.println("Usuario o contraseña incorrectos");
                                    intentoInversor[i]--;
                                    System.out.println("Te quedan " + intentoInversor[i] + " intentos.");
                                    if (intentoInversor[i] <= 0) {
                                        gestorbloqueado[i] = true;
                                        System.out.println(ANSI_RED+"El usuario ha sido bloqueado. Contacte con el Administrador."+ANSI_RESET);
                                    }
                                }

                            } else if (usuario.equals(nombreUsuarioInversor[i]) && inversorbloqueado[i]) {
                                System.out.println("El usuario está bloqueado. Por favor contacte con el administrador");
                            }
                        }
                        if (!usuarioExiste && !usuario.equals(usuarioAdmin)) {
                            System.out.println("El usuario introducido no existe");
                        }
                    } else {
                        System.out.println("¡Nos vemos pronto!");
                        loginHecho=true;
                    }
                }while (!usuario.equals("s") && !contrasena.equals("s") && !bienvenido);

            } else if (opcionInicial==3) {
                System.out.println(ANSI_PURPLE+"Cerrando FernanStarter..."+ANSI_RESET);
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
                                                if (!nombreUsuarioGestor[i].isEmpty()){
                                                    System.out.print(i+1+":"+ nombreUsuarioGestor[i]+ " está ");
                                                    if(!gestorbloqueado[i]){
                                                        System.out.println(ANSI_GREEN+"desbloqueado"+ANSI_RESET);
                                                    }else {
                                                        System.out.println(ANSI_RED+"bloqueado"+ANSI_RESET);
                                                    }
                                                }
                                            }

                                            menuBloqueo();
                                            admin_gestor=Integer.parseInt(s.nextLine());
                                            switch (admin_gestor){
                                                case 1:{
                                                    System.out.println("Escribe el número del usuario que quieres bloquear");
                                                    numeroUsuario=Integer.parseInt(s.nextLine());
                                                    if(gestorbloqueado[numeroUsuario-1]){
                                                        System.out.println("Este usuario ya esta bloqueado");
                                                    }else {
                                                        System.out.println(ANSI_GREEN+"Usuario bloqueado satisfactoriamente"+ANSI_RESET);
                                                        gestorbloqueado[numeroUsuario-1]=true;
                                                    }
                                                    break;
                                                }
                                                case 2:{
                                                    System.out.println("Escribe el número del usuario que quieres desbloquear");
                                                    numeroUsuario=Integer.parseInt(s.nextLine());
                                                    if(!gestorbloqueado[numeroUsuario-1]){
                                                        System.out.println("Este usuario ya esta desbloqueado");
                                                    }else {
                                                        System.out.println(ANSI_GREEN+"Usuario desbloqueado satisfactoriamente"+ANSI_RESET);
                                                        gestorbloqueado[numeroUsuario-1]=false;
                                                        intentoGestorCodigo[numeroUsuario-1]=3;
                                                        intentoGestor[numeroUsuario-1]=3;
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
                                        break;
                                    }
                                    case 2: {
                                        for (int i = 0; i < nombreUsuarioGestor.length; i++) {
                                            if (!nombreUsuarioInversor[i].isEmpty()) {
                                                System.out.print(i+1+":"+ nombreUsuarioInversor[i] + " está ");
                                                if (!inversorbloqueado[i]) {
                                                    System.out.println(ANSI_GREEN + "desbloqueado" + ANSI_RESET);
                                                } else {
                                                    System.out.println(ANSI_RED + "bloqueado" + ANSI_RESET);
                                                }
                                            }
                                        }
                                        menuBloqueo();
                                        admin_inversor1 = Integer.parseInt(s.nextLine());
                                        switch (admin_inversor1) {
                                            case 1: {
                                                System.out.println("Escribe el número del usuario que quieres bloquear");
                                                numeroUsuario=Integer.parseInt(s.nextLine());
                                                if (inversorbloqueado[numeroUsuario-1]) {
                                                    System.out.println("Este usuario ya esta bloqueado");
                                                } else {
                                                    System.out.println(ANSI_GREEN+"Usuario bloqueado satisfactoriamente"+ANSI_RESET);
                                                    inversorbloqueado[numeroUsuario-1] = true;
                                                }
                                                break;
                                            }
                                            case 2: {
                                                System.out.println("Escribe el número del usuario que quieres desbloquear");
                                                numeroUsuario=Integer.parseInt(s.nextLine());
                                                if (!inversorbloqueado[numeroUsuario-1]) {
                                                    System.out.println("Este usuario ya esta desbloqueado");
                                                } else {
                                                    System.out.println(ANSI_GREEN+"Usuario desbloqueado satisfactoriamente"+ANSI_RESET);
                                                    inversorbloqueado[numeroUsuario-1] = false;
                                                    intentoInversorCodigo[numeroUsuario-1] = 3;
                                                    intentoInversor[numeroUsuario-1] = 3;
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
                                System.out.println("Has accedido a proyectos");
                                System.out.println("¿Qué quieres hacer?");
                                System.out.println("1. Visualizar proyecto");
                                System.out.println("2. Salir");
                                opcion = Integer.parseInt(s.nextLine());
                                switch (opcion) {
                                    case 1 -> {
                                        System.out.println(ANSI_GREEN + "*****PROYECTOS*****" + ANSI_RESET);
                                        for (int k = 0; k < proyecto.length; k++) {
                                            if (!proyecto[k].isEmpty()) {
                                                System.out.println(k + 1 + ". Proyecto " + k + " : " + proyecto[k]);
                                            }
                                        }
                                        System.out.println("Escribe el número del proyecto que desees visualizar");
                                        numeroProyecto = Integer.parseInt(s.nextLine());
                                        if (!proyecto[numeroProyecto - 1].isEmpty()) {
                                            visualizarProyecto(proyecto[numeroProyecto - 1], categoria[numeroProyecto - 1], financiacionTotal[numeroProyecto - 1], financiado[numeroProyecto - 1], fechaApertura[numeroProyecto - 1], fechaCierre[numeroProyecto - 1], recompensa1proy[numeroProyecto - 1], descripcion1proy[numeroProyecto - 1], precio1proy[numeroProyecto - 1], recompensa2proy[numeroProyecto - 1], descripcion2proy[numeroProyecto - 1], precio2proy[numeroProyecto - 1], recompensa3proy[numeroProyecto - 1], descripcion3proy[numeroProyecto - 1], precio3proy[numeroProyecto - 1]);
                                            porcentajefinanciado[numeroProyecto - 1] = financiado[numeroProyecto - 1] * 100 / financiacionTotal[numeroProyecto - 1];
                                            System.out.println("Actualmente se ha financiado un " + porcentajefinanciado[numeroProyecto - 1] + "%");
                                            grafico(porcentajefinanciado[numeroProyecto - 1]);
                                        }
                                    }
                                    case 2 -> System.out.println("¡Hasta pronto!");
                                    default -> System.out.println("Esa opción no se encuentra en el menú");
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
                                            do {
                                                System.out.println("Introduzca la nueva contraseña de usuario");
                                                contrasenaAdmin=s.nextLine();
                                                System.out.println(fortalezaContrasena(contrasenaAdmin));
                                                if (fortalezaContrasena(contrasenaAdmin).equals("Robustez de la contraseña: Débil")){
                                                    System.out.println("La fortaleza de la contraseña no puede ser debil, para una mayor seguridad en sus datos.");
                                                }
                                            }while (fortalezaContrasena(contrasenaAdmin).equals("Robustez de la contraseña: Débil"));
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
                                            for (int k=0;k<proyecto.length;k++){
                                                if (proyecto[k].isEmpty()){
                                                    do {
                                                        System.out.println("Introduzca el nombre del proyecto");
                                                        proyecto[k]=s.nextLine();
                                                        if (!comprobacionMaximosMinimosTitulos(proyecto[k])){
                                                            System.out.println("La longitud del titulo debe estar comprendida entre 4 y 15 caracteres");
                                                        }
                                                    }while(!comprobacionMaximosMinimosTitulos(proyecto[k]));

                                                    System.out.println("Introduzca la categoría del proyecto (arte, tecnología, cine, música, juegos, comida, moda…)");
                                                    categoria[k]=s.nextLine();
                                                    System.out.println("¿Cual es la cantidad necesaria para financiar este proyecto?");
                                                    financiacionTotal[k]=Integer.parseInt(s.nextLine());
                                                    System.out.println("¿Cual es la cantidad financiada hasta el momento?");
                                                    financiado[k]=Integer.parseInt(s.nextLine());
                                                    do {
                                                        System.out.println("Escriba la fecha de apertura para poder recibir inversiones (formato --/--/----)");
                                                        fechaApertura[k]=s.nextLine();
                                                        if (!comprobacionFechas(fechaApertura[k])){
                                                            System.out.println("El formato debe de ser --/--/----");
                                                        }
                                                    }while (!comprobacionFechas(fechaApertura[k]));
                                                    do {
                                                        System.out.println("Escriba la fecha de cierre de inversiones (formato --/--/----)");
                                                        fechaCierre[k]=s.nextLine();
                                                        if (!comprobacionFechas(fechaCierre[k])){
                                                            System.out.println("El formato debe de ser --/--/----");
                                                        }
                                                    }while (!comprobacionFechas(fechaCierre[k]));
                                                    do {
                                                        System.out.println("¿Cuántas recompensas quieres añadir (máximo 3)?");
                                                        cantidadRecompensas[k] = Integer.parseInt(s.nextLine());
                                                        if (cantidadRecompensas[k]<1 || cantidadRecompensas[k]>3){
                                                            System.out.println("Error, la cantidad de recompensas debe ser de al menos 1 y como máximo de 3");
                                                        }
                                                    }while (cantidadRecompensas[k]<1 || cantidadRecompensas[k]>3);
                                                    for (int j = 1; j <= cantidadRecompensas[k]; j++) {
                                                        System.out.println("Escriba la recompensa "+j+" ofrecida por el promotor del proyecto");
                                                        if (j==1){
                                                            recompensa1proy[k]=s.nextLine();
                                                        } else if (j==2) {
                                                            recompensa2proy[k]=s.nextLine();
                                                        } else if (j==3) {
                                                            recompensa3proy[k]=s.nextLine();
                                                        }
                                                        System.out.println("Incluye una breve descripción de la recompensa "+j);
                                                        if (j==1){
                                                            descripcion1proy[k] =s.nextLine();
                                                        } else if (j==2) {
                                                            descripcion2proy[k] =s.nextLine();
                                                        } else if (j==3) {
                                                            descripcion3proy[k]=s.nextLine();
                                                        }
                                                        System.out.println("¿Qué precio tiene la recompensa "+j+"?");
                                                        if (j==1){
                                                            precio1proy[k] =Integer.parseInt(s.nextLine());
                                                        } else if (j==2) {
                                                            precio2proy[k] =Integer.parseInt(s.nextLine());
                                                        } else if (j==3) {
                                                            precio3proy[k] =Integer.parseInt(s.nextLine());
                                                        }
                                                    }
                                                    System.out.println("Has añadido esta información en el proyecto :" +proyecto[k]);
                                                    visualizarProyecto(proyecto[k], categoria[k], financiacionTotal[k], financiado[k], fechaApertura[k], fechaCierre[k], recompensa1proy[k],descripcion1proy[k],precio1proy[k], recompensa2proy[k], descripcion2proy[k], precio2proy[k], recompensa3proy[k], descripcion3proy[k], precio3proy[k]);
                                                }
                                            }
                                        }
                                        case 2 ->{
                                            System.out.println("Has accedido a proyectos");
                                            System.out.println("¿Qué quieres hacer?");
                                            System.out.println("1. Visualizar proyecto");
                                            System.out.println("2. Salir");
                                            opcion = Integer.parseInt(s.nextLine());
                                            switch (opcion) {
                                                case 1 -> {
                                                    contadorProyectos=0;
                                                    System.out.println(ANSI_GREEN + "*****PROYECTOS*****" + ANSI_RESET);
                                                    for (int k = 0; k < proyecto.length; k++) {
                                                        if (!proyecto[k].isEmpty()) {
                                                            System.out.println(k + 1 + ". Proyecto: " + proyecto[k]);
                                                            contadorProyectos++;
                                                        }
                                                    }
                                                    if (contadorProyectos>0) {
                                                        System.out.println("Escribe el número del proyecto que desees visualizar");
                                                        numeroProyecto = Integer.parseInt(s.nextLine());
                                                        if (!proyecto[numeroProyecto - 1].isEmpty()) {
                                                            visualizarProyecto(proyecto[numeroProyecto - 1], categoria[numeroProyecto - 1], financiacionTotal[numeroProyecto - 1], financiado[numeroProyecto - 1], fechaApertura[numeroProyecto - 1], fechaCierre[numeroProyecto - 1], recompensa1proy[numeroProyecto - 1], descripcion1proy[numeroProyecto - 1], precio1proy[numeroProyecto - 1], recompensa2proy[numeroProyecto - 1], descripcion2proy[numeroProyecto - 1], precio2proy[numeroProyecto - 1], recompensa3proy[numeroProyecto - 1], descripcion3proy[numeroProyecto - 1], precio3proy[numeroProyecto - 1]);
                                                            porcentajefinanciado[numeroProyecto - 1] = financiado[numeroProyecto - 1] * 100 / financiacionTotal[numeroProyecto - 1];
                                                            System.out.println("Actualmente se ha financiado un " + porcentajefinanciado[numeroProyecto - 1] + "%");
                                                            grafico(porcentajefinanciado[numeroProyecto - 1]);
                                                        }
                                                    }else{
                                                        System.out.println("No hay proyectos actualmente");
                                                    }
                                                }
                                                case 2 -> System.out.println("¡Hasta pronto!");
                                                default -> System.out.println("Esa opción no se encuentra en el menú");
                                            }
                                        }
                                        case 3 ->{
                                            do {
                                                System.out.println("Elige un proyecto para modificar");
                                                contadorProyectos=0;
                                                for(int k=0;k<proyecto.length;k++){
                                                    if (!proyecto[k].isEmpty()) {
                                                        System.out.println(k+1 + ". Proyecto: " + proyecto[k]);
                                                        contadorProyectos++;
                                                    }
                                                }
                                                if (contadorProyectos==0){
                                                    System.out.println("No hay ningún proyecto creado actualmente");
                                                }else {
                                                    System.out.println("0. Salir");
                                                    System.out.println("Elige un proyecto para modificar");
                                                    opcion = Integer.parseInt(s.nextLine());
                                                    int aux = opcion;
                                                    if (opcion == 0) {
                                                        System.out.println("Ha salido del menú modificar proyecto");
                                                    } else {
                                                        menuModificarProyecto();
                                                        opcion = Integer.parseInt(s.nextLine());
                                                        switch (opcion) {
                                                            case 1 -> {
                                                                do {
                                                                    System.out.println("Escribe el nuevo nombre del proyecto " + aux);
                                                                    proyecto[aux-1] = s.nextLine();
                                                                    if (!comprobacionMaximosMinimosTitulos(proyecto[aux-1])){
                                                                        System.out.println("La longitud del titulo debe estar comprendida entre 4 y 15 caracteres");
                                                                    }
                                                                }while(!comprobacionMaximosMinimosTitulos(proyecto[aux-1]));
                                                            }
                                                            case 2 -> {
                                                                System.out.println("Escribe la nueva categoría del proyecto " + aux);
                                                                categoria[aux-1] = s.nextLine();
                                                            }
                                                            case 3 -> {
                                                                System.out.println("Escribe la nueva cantidad a financiar");
                                                                financiacionTotal[aux-1] = Integer.parseInt(s.nextLine());
                                                            }
                                                            case 4 -> {
                                                                System.out.println("Escribe la nueva cantidad financiada hasta el momento");
                                                                financiado[aux-1] = Integer.parseInt(s.nextLine());
                                                            }
                                                            case 5 -> {
                                                                do {
                                                                    System.out.println("Escribe la nueva fecha de apertura de inversiones (Formato --/--/----)");
                                                                    fechaApertura[aux-1] = s.nextLine();
                                                                    if (!comprobacionFechas(fechaApertura[aux-1])){
                                                                        System.out.println("El formato debe de ser --/--/----");
                                                                    }
                                                                }while (!comprobacionFechas(fechaApertura[aux-1]));
                                                            }
                                                            case 6 -> {
                                                                do {
                                                                    System.out.println("Escribe la nueva fecha de cierre de inversiones (Formato --/--/----)");
                                                                    fechaCierre[aux-1] = s.nextLine();
                                                                    if (!comprobacionFechas(fechaCierre[aux])){
                                                                        System.out.println("El formato debe de ser --/--/----");
                                                                    }
                                                                }while (!comprobacionFechas(fechaCierre[aux-1]));
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
                                                                            recompensa1proy[aux-1] = s.nextLine();
                                                                        } else if (opcion == 2) {
                                                                            System.out.println("Escribe la nueva descripción");
                                                                            descripcion1proy[aux-1] = s.nextLine();
                                                                        } else if (opcion == 3) {
                                                                            System.out.println("Escribe el nuevo precio");
                                                                            precio1proy[aux-1] = Integer.parseInt(s.nextLine());
                                                                        } else if (opcion == 4) {
                                                                            System.out.println("Ha salido del menú modificar recompensa 1");
                                                                        } else {
                                                                            System.out.println("Esa opción no se encuentra en el menú");
                                                                        }
                                                                    }
                                                                    case 2 -> {
                                                                        if (!recompensa2proy[aux-1].equals("")) {
                                                                            modificarRecompensa();
                                                                            opcion = Integer.parseInt(s.nextLine());
                                                                            if (opcion == 1) {
                                                                                System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                recompensa2proy[aux-1] = s.nextLine();
                                                                            } else if (opcion == 2) {
                                                                                System.out.println("Escribe la nueva descripción");
                                                                                descripcion2proy[aux-1] = s.nextLine();
                                                                            } else if (opcion == 3) {
                                                                                System.out.println("Escribe el nuevo precio");
                                                                                precio2proy[aux-1] = Integer.parseInt(s.nextLine());
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
                                                                        if (!recompensa3proy[aux-1].equals("")) {
                                                                            modificarRecompensa();
                                                                            opcion = Integer.parseInt(s.nextLine());
                                                                            if (opcion == 1) {
                                                                                System.out.println("Escribe la nueva recompensa ofrecida");
                                                                                recompensa3proy[aux-1] = s.nextLine();
                                                                            } else if (opcion == 2) {
                                                                                System.out.println("Escribe la nueva descripción");
                                                                                descripcion3proy[aux-1] = s.nextLine();
                                                                            } else if (opcion == 3) {
                                                                                System.out.println("Escribe el nuevo precio");
                                                                                precio3proy[aux-1] = Integer.parseInt(s.nextLine());
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
                                                                System.out.println("Ha salido del menú Modificar Proyecto " + aux);
                                                            }
                                                            default ->
                                                                    System.out.println("Esa opción no se encuentra en el menú");
                                                        }
                                                    }
                                                }
                                            }while (opcion!=0 && contadorProyectos!=0);
                                        }
                                        case 4 ->{
                                            do {
                                                System.out.println("Elige un proyecto para borrar");
                                                contadorProyectos=0;
                                                for(int k=0;k<proyecto.length;k++){
                                                    if (!proyecto[k].isEmpty()) {
                                                        System.out.println(k+1 + ". Proyecto: " + proyecto[k]);
                                                        contadorProyectos++;
                                                    }
                                                }
                                                if (contadorProyectos==0){
                                                    System.out.println("No hay ningún proyecto creado actualmente");
                                                }else {
                                                    System.out.println("0. Salir");
                                                    opcion = Integer.parseInt(s.nextLine());
                                                    if (opcion == 0) {
                                                        System.out.println("Ha salido del menú borrar proyecto");
                                                    } else if (!proyecto[opcion-1].isEmpty()) {
                                                        proyecto[opcion-1] ="";
                                                        System.out.println("Ha borrado el proyecto " + opcion + " satisfactoriamente.");
                                                    } else {
                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                    }
                                                }
                                            }while (opcion!=0 && contadorProyectos!=0);
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
                                            System.out.println("Introduce tu nombre de usuario");
                                            usuario=s.nextLine();
                                            System.out.println("Introduzca la contraseña actual");
                                            contrasenaActual=s.nextLine();
                                            if (validarOperacion(usuarioActual,usuario, contrasenaActual, nombreUsuarioGestor,contrasenaUsuarioGestor)) {
                                                System.out.println("Introduzca el nuevo nombre de usuario");
                                                nuevoNombreUsuario = s.nextLine();
                                                usuarioCambiado = false;
                                                for (int i = 0; i < nombreUsuarioGestor.length; i++) {
                                                    if (usuario.equals(nombreUsuarioGestor[i])) {
                                                        nombreUsuarioGestor[i] = nuevoNombreUsuario;
                                                        usuarioCambiado = true;
                                                    }
                                                }
                                                if (usuarioCambiado){
                                                    usuarioActual=nuevoNombreUsuario;
                                                    System.out.println(ANSI_GREEN+"Nombre de usuario actualizado satisfactoriamente"+ANSI_RESET);
                                                }
                                            }else{
                                                System.out.println(ANSI_RED+"El nombre de usuario o contraseña introducido es erróneo"+ANSI_RESET);
                                            }
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Introduce tu nombre de usuario");
                                            usuario=s.nextLine();
                                            System.out.println("Introduzca la contraseña actual");
                                            contrasenaActual=s.nextLine();
                                            if (validarOperacion(usuarioActual,usuario, contrasenaActual, nombreUsuarioGestor,nombreUsuarioGestor)) {
                                                do {
                                                    do {
                                                        System.out.println("Introduzca la nueva contraseña");
                                                        nuevaContrasena = s.nextLine();
                                                        System.out.println(fortalezaContrasena(nuevaContrasena));
                                                        if (fortalezaContrasena(nuevaContrasena).equals("Robustez de la contraseña: Débil")){
                                                            System.out.println("La contraseña debe tener al menos una longitud de 8 y contener mayúsculas y minúsculas.");
                                                        }
                                                    }while (fortalezaContrasena(nuevaContrasena).equals("Robustez de la contraseña: Débil"));
                                                    System.out.println("Vuelve a escribir la nueva contraseña");
                                                    repeticionContrasena = s.nextLine();
                                                    if (!confirmarContrasena(nuevaContrasena, repeticionContrasena)) {
                                                        System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                                    }
                                                } while (!confirmarContrasena(nuevaContrasena, repeticionContrasena));
                                                contrasenaCambiada = false;
                                                for (int i = 0; i < contrasenaUsuarioGestor.length; i++) {
                                                    if (contrasenaActual.equals(contrasenaUsuarioGestor[i])) {
                                                        contrasenaUsuarioGestor[i] = nuevaContrasena;
                                                        contrasenaCambiada = true;
                                                    }
                                                }
                                                if (contrasenaCambiada) {
                                                    System.out.println(ANSI_GREEN + "Contraseña actualizada satisfactoriamente" + ANSI_RESET);
                                                }
                                            } else {
                                                System.out.println(ANSI_RED + "El usuario o contraseña introducidos son erróneos" + ANSI_RESET);
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
                                for (int i = 0; i < nombreUsuarioInversor.length; i++) {
                                    if (usuarioActual.equals(nombreUsuarioInversor[i])){
                                        for (int j = 0; j < proyecto.length; j++) {
                                            if(inversorProyectoInversion[i][j]>0) {
                                                System.out.println("Usted ha contribuido con " + inversorProyectoInversion[i][j] + " € en el proyecto *****" + proyecto[j] + "*****");
                                                System.out.println("La categoria de *****" + proyecto[j] + "***** es " + categoria[j]);
                                                if (precio1proy[j]!=0 && inversorProyectoInversion[i][j] >= precio1proy[j]) {
                                                    System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 1 del proyecto "+proyecto[j]+": " + recompensa1proy[j]+ANSI_RESET);
                                                }
                                                if (precio2proy[j]!=0 && inversorProyectoInversion[i][j] >= precio2proy[j]){
                                                    System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 2 del proyecto "+proyecto[j]+": " + recompensa2proy[j]+ANSI_RESET);
                                                }
                                                if (precio3proy[j]!=0 && inversorProyectoInversion[i][j]>precio3proy[j]) {
                                                    System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 3 del proyecto "+proyecto[j]+": " + recompensa3proy[j]+ANSI_RESET);
                                                }
                                                contadorInversiones[i]++;
                                            }
                                        }
                                        if (contadorInversiones[i]==0){
                                            System.out.println("Aún no has realizado ninguna inversión.");
                                        }
                                    }
                                }
                                break;
                            }
                            case 2:{
                                System.out.println("Has accedido a proyectos");
                                System.out.println("¿Qué quieres hacer?");
                                System.out.println("1. Visualizar proyecto");
                                System.out.println("2. Salir");
                                opcion = Integer.parseInt(s.nextLine());
                                switch (opcion) {
                                    case 1-> {
                                        System.out.println(ANSI_GREEN+"*****PROYECTOS*****"+ANSI_RESET);
                                        for (int k=0;k<proyecto.length;k++){
                                            if (!proyecto[k].isEmpty()) {
                                                System.out.println(k+1 + ". Proyecto: " + proyecto[k]);
                                            }
                                        }
                                        System.out.println("Escribe el número del proyecto que desees visualizar");
                                        numeroProyecto=Integer.parseInt(s.nextLine());
                                        if (!proyecto[numeroProyecto-1].isEmpty()) {
                                            visualizarProyecto(proyecto[numeroProyecto-1], categoria[numeroProyecto-1], financiacionTotal[numeroProyecto-1], financiado[numeroProyecto-1], fechaApertura[numeroProyecto-1], fechaCierre[numeroProyecto-1], recompensa1proy[numeroProyecto-1],descripcion1proy[numeroProyecto-1],precio1proy[numeroProyecto-1], recompensa2proy[numeroProyecto-1], descripcion2proy[numeroProyecto-1], precio2proy[numeroProyecto-1], recompensa3proy[numeroProyecto-1], descripcion3proy[numeroProyecto-1], precio3proy[numeroProyecto-1]);
                                            porcentajefinanciado[numeroProyecto-1]=financiado[numeroProyecto-1]*100/financiacionTotal[numeroProyecto-1];
                                            System.out.println("Actualmente se ha financiado un "+porcentajefinanciado[numeroProyecto-1]+"%");
                                            grafico(porcentajefinanciado[numeroProyecto-1]);
                                            System.out.println("\n Quieres invertir en el proyecto: "+proyecto[numeroProyecto-1]+"? (si/no)");
                                            if (s.nextLine().equalsIgnoreCase("SI")) {
                                                System.out.println("Por favor introduzca usuario y contraseña para validar la operación");
                                                usuario = s.nextLine();
                                                contrasena = s.nextLine();
                                                if (validarOperacion(usuarioActual, usuario, contrasena, nombreUsuarioInversor, contrasenaUsuarioInversor)) {
                                                    System.out.println("¿Cuánto desea invertir?");
                                                    intentoInversion = Integer.parseInt(s.nextLine());
                                                    inversionAceptada = false;
                                                    for (int i = 0; i < saldoInversor.length; i++) {
                                                        if (usuario.equals(nombreUsuarioInversor[i])) {
                                                            if (intentoInversion <= saldoInversor[i] && intentoInversion > 0 && intentoInversion + financiado[numeroProyecto - 1] <= financiacionTotal[numeroProyecto - 1]) {
                                                                inversionAceptada = true;
                                                                System.out.println(ANSI_GREEN + "Operacion realizada con exito" + ANSI_RESET);
                                                                inversorProyectoInversion[i][numeroProyecto - 1] += intentoInversion;
                                                                saldoInversor[i] -= intentoInversion;
                                                                financiado[numeroProyecto - 1] += intentoInversion;
                                                            } else if (intentoInversion + financiado[numeroProyecto - 1] > financiacionTotal[numeroProyecto - 1]) {
                                                                System.out.println("El importe supera la cantidad que se puede financiar del proyecto");
                                                            }
                                                        }
                                                    }
                                                    if (!inversionAceptada) {
                                                        System.out.println(ANSI_RED + "Operación Denegada" + ANSI_RESET);
                                                    }
                                                } else {
                                                    System.out.println("La validación ha fallado. El usuario o contraseña introducido no es correcto.");
                                                }
                                            }else{
                                                System.out.println("Volviendo al menú principal...");
                                            }
                                        } else {
                                            System.out.println("No existe ese proyecto");
                                        }
                                    }
                                    case 2-> System.out.println("¡Hasta pronto!");
                                    default -> System.out.println("Esa opción no se encuentra en el menú");
                                }
                                break;
                            }
                            case 3:{
                                do{
                                    gestionSaldoInversor(usuarioActual,nombreUsuarioInversor,contrasenaUsuarioInversor,saldoInversor);
                                }while (opcion!=3);
                                break;
                            }
                            case 4:{
                                amigosInvitadosInversor=invitarAmigo(usuarioActual,amigosInvitadosInversor,nombreUsuarioInversor);
                                break;
                            }
                            case 5:{
                                System.out.println("Ha accedido a configuración");

                                do{
                                    menuConfiguracion();
                                    opcion=Integer.parseInt(s.nextLine());
                                    switch (opcion){
                                        case 1:{
                                            System.out.println("Introduce tu nombre de usuario");
                                            usuario=s.nextLine();
                                            System.out.println("Introduzca la contraseña actual");
                                            contrasenaActual=s.nextLine();
                                            if (validarOperacion(usuarioActual,usuario, contrasenaActual, nombreUsuarioInversor,contrasenaUsuarioInversor)) {
                                                System.out.println("Introduzca el nuevo nombre de usuario");
                                                nuevoNombreUsuario = s.nextLine();
                                                usuarioCambiado = false;
                                                for (int i = 0; i < nombreUsuarioInversor.length; i++) {
                                                    if (usuario.equals(nombreUsuarioInversor[i])) {
                                                        nombreUsuarioInversor[i] = nuevoNombreUsuario;
                                                        usuarioCambiado = true;
                                                    }
                                                }
                                                if (usuarioCambiado){
                                                    usuarioActual=nuevoNombreUsuario;
                                                    System.out.println(ANSI_GREEN+"Nombre de usuario actualizado satisfactoriamente"+ANSI_RESET);
                                                }
                                            }else{
                                                System.out.println(ANSI_RED+"El nombre de usuario o contraseña introducido es erróneo"+ANSI_RESET);
                                            }
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Introduce tu nombre de usuario");
                                            usuario=s.nextLine();
                                            System.out.println("Introduzca la contraseña actual");
                                            contrasenaActual=s.nextLine();
                                            if (validarOperacion(usuarioActual,usuario, contrasenaActual, nombreUsuarioInversor,contrasenaUsuarioInversor)) {
                                                do {
                                                    do {
                                                        System.out.println("Introduzca la nueva contraseña");
                                                        nuevaContrasena = s.nextLine();
                                                        System.out.println(fortalezaContrasena(nuevaContrasena));
                                                        if (fortalezaContrasena(nuevaContrasena).equals("Robustez de la contraseña: Débil")){
                                                            System.out.println("La contraseña debe tener al menos una longitud de 8 y contener mayúsculas y minúsculas.");
                                                        }
                                                    }while(fortalezaContrasena(nuevaContrasena).equals("Robustez de la contraseña: Débil"));
                                                    System.out.println("Vuelve a escribir la nueva contraseña");
                                                    repeticionContrasena = s.nextLine();
                                                    if (!confirmarContrasena(nuevaContrasena, repeticionContrasena)) {
                                                        System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                                    }
                                                } while (!confirmarContrasena(nuevaContrasena, repeticionContrasena));
                                                contrasenaCambiada = false;
                                                for (int i = 0; i < contrasenaUsuarioInversor.length; i++) {
                                                    if (contrasenaActual.equals(contrasenaUsuarioInversor[i])) {
                                                        contrasenaUsuarioInversor[i] = nuevaContrasena;
                                                        contrasenaCambiada = true;
                                                    }
                                                }
                                                if (contrasenaCambiada) {
                                                    System.out.println(ANSI_GREEN + "Contraseña actualizada satisfactoriamente" + ANSI_RESET);
                                                }
                                            } else {
                                                System.out.println(ANSI_RED + "El usuario o contraseña introducidos son erróneos" + ANSI_RESET);
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