import java.util.Scanner;
import static utilidades.Funciones.*;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        final String ANSI_GREEN= "\033[32m";
        final String ANSI_RED="\033[31m";
        final String ANSI_RESET= "\033[0m";
        final String ANSI_PURPLE= "\033[35m";
        String usuario;
        String contrasena;
        String destinatarioAdmin="ana.oc.094@gmail.com", destinatarioGestor="ana.oc.094@gmail.com", destinatarioInversor1="ana.oc.094@gmail.com", destinatarioInversor2="ana.oc.094@gmail.com";
        String usuarioAdmin="administrador", usuarioGestor="gestor", usuarioInversor1="inversor1", usuarioInversor2="inversor2";
        String contrasenaAdmin="admin", contrasenaGestor="gestor", contrasenaInversor1="inversor1", contrasenaInversor2="inversor2";
        int intentoGestor=3, intentoInversor1=3, intentoInversor2=3;
        int intentoGestorCodigo=3, intentoInversor1Codigo=3, intentoInversor2Codigo=3;
        Boolean bienvenido;
        Boolean gestorbloqueado=false, inversor1bloqueado=false, inversor2bloqueado=false;
        int admin_gestor=0;
        int admin_inversor1=0;
        int admin_inversor2=0;
        int eleccionadmin=0  ;
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
        int saldoInversor1=0, saldoInversor2=0;
        int intentoInversion;
        int opcionInicial=0;
        int inversionProyecto1Inversor1=0, inversionProyecto2Inversor1=0, inversionProyecto3Inversor1=0;
        int inversionProyecto1Inversor2=0,inversionProyecto2Inversor2=0, inversionProyecto3Inversor2=0;
        String amigosInvitadosInversor1="", amigosInvitadosInversor2="";
        int autentificacion;
        boolean creado=false;
        int respuesta=0;

        String [] nombreUsuarioInversor = new String[10];
        String [] contrasenaUsuarioInversor = new String[10];
        String [] correoUsuarioInversor = new String[10];


        String [] nombreUsuarioGestor = new String[10];
        String [] contrasenaUsuarioGestor = new String[10];
        String [] correoUsuarioGestor = new String[10];


        System.out.println(ANSI_PURPLE+"\n**[Bienvenido a FernanStarter]**\n"+ANSI_RESET);
        for (int x=0;x<10;x++){
            nombreUsuarioGestor[x]="";
            nombreUsuarioInversor[x]="";
            contrasenaUsuarioGestor[x]="";
            contrasenaUsuarioInversor[x]="";
        }
        do{
            bienvenido=false;
            System.out.println("Que desea hacer");
            System.out.println("1.Crear nuevo usuario");
            System.out.println("2.Iniciar Sesion");
            opcionInicial=Integer.parseInt(s.nextLine());
            if (opcionInicial==1){
                do {
                    System.out.println("ACCESO A CREACION DE USUARIO");
                    System.out.println("Que tipo de perfil desea crear");
                    System.out.println("1.Inversor");
                    System.out.println("2.Gestor");
                    int creacionPerfil=Integer.parseInt(s.nextLine());
                    if (creacionPerfil==1){
                        creado=false;
                        for (int i=0;i<10;i++){
                            if (nombreUsuarioInversor[i].equals("")&&creado==false){
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil inversor");
                                nombreUsuarioInversor[i]=s.nextLine();
                                System.out.println("Introduzca la contraseña de usuario del nuevo perfil inversor ");
                                contrasenaUsuarioInversor[i]=s.nextLine();
                                System.out.println("Introduzca su correo ");
                                correoUsuarioInversor[i]=s.nextLine();
                                System.out.println("Introduzca el codigo de verificacion para la creacion del perfil que hemos enviado a su correo");
                                autentificacion=generarAutentificacion();
                                String asunto = "Codigo de autentificacion";
                                String cuerpo = "Codigo de verificacion para crear sesion : "+ autentificacion+"\n ";
                                enviarConGMail(correoUsuarioInversor[i], asunto, cuerpo);
                                    int verificaion=Integer.parseInt(s.nextLine());
                                    if (verificaion==autentificacion){
                                        System.out.println("Usuario creado con exito");
                                    }else {
                                        System.out.println("El codigo no corresponde al enviado, creacion fallida");
                                        nombreUsuarioInversor[i]="";
                                        contrasenaUsuarioInversor[i]="";
                                        correoUsuarioInversor[i]="";
                                    }
                                creado=true;

                            }
                        }
                    }else if (creacionPerfil==2){
                        creado=false;
                        for (int i=0;i<10;i++){
                            if (nombreUsuarioGestor[i].equals("")&&creado==false){
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil gestor");
                                nombreUsuarioGestor[i]=s.nextLine();
                                System.out.println("Introduzca la contraseña de usuario del nuevo perfil gestor ");
                                contrasenaUsuarioGestor[i]=s.nextLine();
                                System.out.println("Introduzca su correo ");
                                correoUsuarioGestor[i]=s.nextLine();
                                creado=true;
                                System.out.println("Introduzca el codigo de verificacion para la creacion del perfil que hemos enviado a su correo");
                                autentificacion=generarAutentificacion();
                                String asunto = "Codigo de autentificacion";
                                String cuerpo = "Codigo de verificacion para crear sesion : "+ autentificacion+"\n ";
                                enviarConGMail(correoUsuarioGestor[i], asunto, cuerpo);
                                int verificaion=Integer.parseInt(s.nextLine());
                                if (verificaion==autentificacion){
                                    System.out.println("Usuario creado con exito");
                                }else {
                                    System.out.println("El codigo no corresponde al enviado, creacion fallida");
                                    nombreUsuarioGestor[i]="";
                                    contrasenaUsuarioGestor[i]="";
                                    correoUsuarioGestor[i]="";
                                }
                            }
                        }
                    }
                    System.out.println("¿Desea crear otro usuario?");
                    System.out.println("1.Si");
                    System.out.println("2.No");
                    respuesta = Integer.parseInt(s.nextLine());
                }while(respuesta==1);
            }


            System.out.println("Introduce usuario y contraseña. Pulsa s para salir");
            usuario=s.nextLine();
            contrasena=s.nextLine();
            if (!usuario.equals("s") && !contrasena.equals("s")) {
                if (usuario.equals(usuarioAdmin) && contrasena.equals(contrasenaAdmin) ) {
                    System.out.println("Hemos enviado un código a tu correo. Introduce la autentificación");
                    autentificacion=generarAutentificacion();
                    String asunto = "Codigo de autentificacion";
                    String cuerpo = "Codigo de verificacion para el inicio de sesion : "+ autentificacion+"\n Bienvenido a FernanStarter";
                    enviarConGMail(destinatarioAdmin, asunto, cuerpo);
                    int codigo=Integer.parseInt(s.nextLine());
                    if (codigo == autentificacion) {
                        System.out.println(ANSI_GREEN+"Bienvenido Administrador"+ANSI_RESET);
                        bienvenido = true;
                    }else {
                        System.out.println("Acceso denegado, clave de autentificacion erronea");
                    }
                }
                if (usuario.equals(usuarioGestor)&&contrasena.equals(contrasenaGestor)&&gestorbloqueado.equals(false)) {
                    System.out.println("Hemos enviado un código a tu correo. Introduce autentificacion");
                    autentificacion=generarAutentificacion();
                    String asunto = "Codigo de autentificacion";
                    String cuerpo = "Codigo de verificacion para el inicio de sesion : "+ autentificacion+"\n Bienvenido a FernanStarter";
                    enviarConGMail(destinatarioGestor, asunto, cuerpo);
                    int codigo=Integer.parseInt(s.nextLine());
                    if (codigo == autentificacion) {
                        System.out.println(ANSI_GREEN+"Bienvenido Gestor"+ANSI_RESET);
                        bienvenido = true;
                        intentoGestorCodigo=3;
                    }else {
                        intentoGestorCodigo--;
                        System.out.println("Acceso denegado, clave de autentificacion erronea. Te quedan "+intentoGestorCodigo+" intentos.");
                    }
                } else if ((usuario.equals(usuarioGestor)&&gestorbloqueado.equals(true))) {
                    System.out.println(ANSI_RED+"Acceso denegado. El perfil *Gestor* ha sido bloqueado"+ANSI_RESET);
                }
                if (usuario.equals(usuarioInversor1)&&contrasena.equals(contrasenaInversor1)&&inversor1bloqueado.equals(false)) {
                    System.out.println("Hemos enviado un código a tu correo. Introduce autentificacion");
                    autentificacion=generarAutentificacion();
                    String asunto = "Codigo de autentificacion";
                    String cuerpo = "Codigo de verificacion para el inicio de sesion : "+ autentificacion+"\n Bienvenido a FernanStarter";
                    enviarConGMail(destinatarioInversor1, asunto, cuerpo);
                    int codigo=Integer.parseInt(s.nextLine());
                    if (codigo == autentificacion) {
                        System.out.println(ANSI_GREEN+"Bienvenido Inversor1"+ANSI_RESET);
                        bienvenido = true;
                        intentoInversor1Codigo=3;
                    }else {
                        intentoInversor1Codigo--;
                        System.out.println("Acceso denegado, clave de autentificacion erronea. Te quedan "+intentoInversor1Codigo+" intentos.");
                    }

                } else if ((usuario.equals(usuarioInversor1)&&inversor1bloqueado.equals(true))) {
                    System.out.println(ANSI_RED+"Acceso denegado. El perfil *inversor1* ha sido bloqueado "+ANSI_RESET);
                }
                if (usuario.equals(usuarioInversor2)&&contrasena.equals(contrasenaInversor2)&&inversor2bloqueado.equals(false)) {
                    System.out.println("Hemos enviado un código a tu correo. Introduce autentificacion");
                    autentificacion=generarAutentificacion();
                    String asunto = "Codigo de autentificacion";
                    String cuerpo = "Codigo de verificacion para el inicio de sesion : "+ autentificacion+"\n Bienvenido a FernanStarter";
                    enviarConGMail(destinatarioInversor2, asunto, cuerpo);
                    int codigo=Integer.parseInt(s.nextLine());
                    if (codigo == autentificacion) {
                        System.out.println(ANSI_GREEN+"Bienvenido Inversor2"+ANSI_RESET);
                        bienvenido = true;
                        intentoInversor2Codigo=3;
                    }else {
                        intentoInversor2Codigo--;
                        System.out.println("Acceso denegado, clave de autentificacion errónea. Te quedan "+intentoInversor2Codigo+" intentos.");

                    }
                } else if ((usuario.equals(usuarioInversor2)&&inversor2bloqueado.equals(true))) {
                    System.out.println(ANSI_RED+"Acceso denegado. El perfil *Gestor* ha sido bloqueado "+ANSI_RESET);
                }
                if (!usuario.equals(usuarioAdmin) && !usuario.equals(usuarioGestor) && !usuario.equals(usuarioInversor1) && !usuario.equals(usuarioInversor2)){
                    System.out.println("Usuario o contraseña incorrectos");
                } else if (usuario.equals(usuarioAdmin) && !contrasena.equals(contrasenaAdmin)) {
                    System.out.println("Usuario o contraseña incorrectos");
                }
                if (usuario.equals(usuarioGestor) && contrasena.equals(contrasenaGestor)){
                    intentoGestor=3;
                }
                if (usuario.equals(usuarioInversor1) && contrasena.equals(contrasenaInversor1)){
                    intentoInversor1=3;
                }
                if (usuario.equals(usuarioInversor2) && contrasena.equals(contrasenaInversor2)){
                    intentoInversor2=3;
                }
                if (usuario.equals(usuarioGestor) && !contrasena.equals(contrasenaGestor)&& gestorbloqueado.equals(false)) {
                    intentoGestor -= 1;
                    System.out.println("Usuario o contraseña incorrectos");
                    System.out.println("Te quedan " + intentoGestor + " intentos.");
                }
                if (usuario.equals(usuarioInversor1) && !contrasena.equals(contrasenaInversor1)&& inversor1bloqueado.equals(false)) {
                    intentoInversor1 -= 1;
                    System.out.println("Usuario o contraseña incorrectos");
                    System.out.println("Te quedan " + intentoInversor1 + " intentos.");
                }
                if (usuario.equals(usuarioInversor2) && !contrasena.equals(contrasenaInversor2)&& inversor2bloqueado.equals(false)) {
                    intentoInversor2 -= 1;
                    System.out.println("Usuario o contraseña incorrectos");
                    System.out.println("Te quedan " + intentoInversor2 + " intentos.");
                }
                if (usuario.equals(usuarioGestor) && (intentoGestor == 0 || intentoGestorCodigo==0)) {
                    System.out.println("Ha agotado los intentos de acceso a el perfil Gestor. Para restaurar contacte con el administrador.");
                    gestorbloqueado=true;
                }
                if (usuario.equals(usuarioInversor1)&&(intentoInversor1==0 || intentoInversor1Codigo==0)){
                    System.out.println("Ha agotado los intentos de acceso a el perfil Inversor1. Para restaurar contacte con el administrador.");
                    inversor1bloqueado=true;
                }
                if (usuario.equals(usuarioInversor2)&&(intentoInversor2==0 || intentoInversor2Codigo==0)){
                    System.out.println("Ha agotado los intentos de acceso a el perfil Inversor2. Para restaurar contacte con el administrador.");
                    inversor2bloqueado=true;
                }
            }else{
                System.out.println("¡Nos vemos pronto!");
            }
            if (bienvenido) {
                if(usuario.equals(usuarioAdmin)) {
                    do {
                        menuAdministrador();
                        opcion=Integer.parseInt(s.nextLine());
                        switch (opcion){
                            case 1: {
                                System.out.println("Ha accedido a Panel de control");
                                System.out.println("Introduzca de que usuario quiere conocer su estado:");
                                System.out.println("1."+usuarioGestor);
                                System.out.println("2."+usuarioInversor1);
                                System.out.println("3."+usuarioInversor2);
                                System.out.println("4. Salir");
                                eleccionadmin=Integer.parseInt(s.nextLine());
                                switch (eleccionadmin){
                                    case 1:{
                                        System.out.print("El estado de "+ usuarioGestor+ " es ");
                                        if(gestorbloqueado.equals(false)){
                                            System.out.println(ANSI_GREEN+"desbloqueado"+ANSI_RESET);
                                        }else {
                                            System.out.println(ANSI_RED+"bloqueado"+ANSI_RESET);
                                        }
                                        menuBloqueo();
                                        admin_gestor=Integer.parseInt(s.nextLine());
                                        switch (admin_gestor){
                                            case 1:{
                                                if(gestorbloqueado.equals(true)){
                                                    System.out.println("Este usuario ya esta bloqueado");
                                                }else {
                                                    System.out.println("Usuario bloqueado satisfactoriamente");
                                                    gestorbloqueado=true;
                                                }
                                                break;
                                            }
                                            case 2:{
                                                if(gestorbloqueado.equals(false)){
                                                    System.out.println("Este usuario ya esta desbloqueado");
                                                }else {
                                                    System.out.println("Usuario desbloqueado satisfactoriamente");
                                                    gestorbloqueado=false;
                                                    intentoGestorCodigo=3;
                                                    intentoGestor=3;
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
                                        System.out.print("El estado de "+ usuarioInversor1+ " es ");
                                        if(inversor1bloqueado.equals(false)){
                                            System.out.println(ANSI_GREEN+"desbloqueado"+ANSI_RESET);
                                        }else {
                                            System.out.println(ANSI_RED+"bloqueado"+ANSI_RESET);
                                        }
                                        menuBloqueo();
                                        admin_inversor1=Integer.parseInt(s.nextLine());
                                        switch (admin_inversor1){
                                            case 1:{
                                                if(inversor1bloqueado.equals(true)){
                                                    System.out.println("Este usuario ya esta bloqueado");
                                                }else {
                                                    System.out.println("Usuario bloqueado satisfactoriamente");
                                                    inversor1bloqueado=true;
                                                }
                                                break;
                                            }
                                            case 2:{
                                                if(inversor1bloqueado.equals(false)){
                                                    System.out.println("Este usuario ya esta desbloqueado");
                                                }else {
                                                    System.out.println("Usuario desbloqueado satisfactoriamente");
                                                    inversor1bloqueado=false;
                                                    intentoInversor1Codigo=3;
                                                    intentoInversor1=3;
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
                                    case 3: {
                                        System.out.print("El estado de "+ usuarioInversor2+ " es ");
                                        if(inversor2bloqueado.equals(false)){
                                            System.out.println(ANSI_GREEN+"desbloqueado"+ANSI_RESET);
                                        }else {
                                            System.out.println(ANSI_RED+"bloqueado"+ANSI_RESET);
                                        }
                                        menuBloqueo();
                                        admin_inversor2=Integer.parseInt(s.nextLine());
                                        switch (admin_inversor2){
                                            case 1:{
                                                if(inversor2bloqueado.equals(true)){
                                                    System.out.println("Este usuario ya esta bloqueado");
                                                }else {
                                                    System.out.println("Usuario bloqueado satisfactoriamente");
                                                    inversor2bloqueado=true;
                                                }
                                                break;
                                            }
                                            case 2:{
                                                if(inversor2bloqueado.equals(false)){
                                                    System.out.println("Este usuario ya esta desbloqueado");
                                                }else {
                                                    System.out.println("Usuario desbloqueado satisfactoriamente");
                                                    inversor2bloqueado=false;
                                                    intentoInversor2Codigo=3;
                                                    intentoInversor2=3;
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
                                    case 4:{
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
                if(usuario.equals(usuarioGestor)) {
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
                                            System.out.println("Introduzca el nuevo nombre de usuario");
                                            usuarioGestor=s.nextLine();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Introduzca la nueva contraseña de usuario");
                                            contrasenaGestor=s.nextLine();
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
                if(usuario.equals(usuarioInversor1)) {
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
                                                System.out.println("¿Cuánto desea invertir?");
                                                intentoInversion=Integer.parseInt(s.nextLine());
                                                if (intentoInversion<=saldoInversor1 && intentoInversion>0){
                                                    System.out.println(ANSI_GREEN+"Operación realizada con exito"+ANSI_RESET);
                                                    inversionProyecto1Inversor1+=intentoInversion;
                                                    saldoInversor1-=intentoInversion;
                                                    financiado1+=intentoInversion;
                                                }else {
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
                                                System.out.println("¿Cuánto desea invertir?");
                                                intentoInversion=Integer.parseInt(s.nextLine());
                                                if (intentoInversion<=saldoInversor1 && intentoInversion>0){
                                                    System.out.println(ANSI_GREEN+"Operacion realizada con exito"+ANSI_RESET);
                                                    inversionProyecto2Inversor1+=intentoInversion;
                                                    saldoInversor1-=intentoInversion;
                                                    financiado2+=intentoInversion;
                                                }else {
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
                                                System.out.println("¿Cuánto desea invertir?");
                                                intentoInversion=Integer.parseInt(s.nextLine());
                                                if (intentoInversion<=saldoInversor1&&intentoInversion>0){
                                                    System.out.println(ANSI_GREEN+"Operación realizada con exito"+ANSI_RESET);
                                                    inversionProyecto3Inversor1+=intentoInversion;
                                                    saldoInversor1-=intentoInversion;
                                                    financiado3+=intentoInversion;
                                                }else {
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
                                    saldoInversor1=gestionSaldoInversor(saldoInversor1);
                                }while (opcion!=3);
                                break;
                            }
                            case 4:{
                                amigosInvitadosInversor1=invitarAmigo(amigosInvitadosInversor1);
                                break;
                            }
                            case 5:{
                                System.out.println("Ha accedido a configuración");

                                do{
                                    menuConfiguracion();
                                    opcion=Integer.parseInt(s.nextLine());
                                    switch (opcion){
                                        case 1:{
                                            System.out.println("Introduzca el nuevo nombre de usuario");
                                            usuarioInversor1=s.nextLine();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Introduzca la nueva contraseña de usuario");
                                            contrasenaInversor1=s.nextLine();
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
                if (usuario.equals(usuarioInversor2)){
                    do {
                        menuInversor();
                        opcion=Integer.parseInt(s.nextLine());
                        switch (opcion){
                            case 1:{
                                System.out.println("Usted ha accedido a Mis inversiones");
                                if(inversionProyecto1Inversor2>0){
                                    System.out.println("Usted ha contribuido con "+ inversionProyecto1Inversor2+" € en el proyecto *****"+ proyecto1+"*****");
                                    System.out.println("La categoria de *****"+proyecto1+"***** es "+categoria1);
                                    if (precio1proy1 != 0 && inversionProyecto1Inversor2 >= precio1proy1) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 1 del proyecto "+proyecto1+": "+ recompensa1proy1+ANSI_RESET);
                                    }
                                    if (precio2proy1 != 0 && inversionProyecto1Inversor2 >= precio2proy1){
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 2 del proyecto "+proyecto1+": "+ recompensa2proy1+ANSI_RESET);
                                    }
                                    if (precio3proy1!=0 && inversionProyecto1Inversor2>=precio3proy1) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 3 del proyecto "+proyecto1+": "+ recompensa3proy1+ANSI_RESET);
                                    }
                                }
                                if(inversionProyecto2Inversor2>0){
                                    System.out.println("Usted ha contribuido con "+ inversionProyecto2Inversor2+" € en el proyecto *****"+ proyecto2+"*****");
                                    System.out.println("La categoria de *****"+proyecto2+"***** es "+categoria2);
                                    if (precio1proy2 != 0 && inversionProyecto1Inversor2 >= precio1proy1) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 1 del proyecto "+proyecto2+": "+ recompensa1proy2+ANSI_RESET);
                                    }
                                    if (precio2proy2 != 0 && inversionProyecto1Inversor2 >= precio2proy1){
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 2 del proyecto "+proyecto2+": "+ recompensa2proy2+ANSI_RESET);
                                    }
                                    if (precio3proy2!=0 && inversionProyecto1Inversor2>=precio3proy1) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 3 del proyecto "+proyecto2+": "+ recompensa3proy2+ANSI_RESET);
                                    }
                                }
                                if(inversionProyecto3Inversor2>0){
                                    System.out.println("Usted ha contribuido con "+ inversionProyecto3Inversor2+" € en el proyecto *****"+ proyecto3+"*****");
                                    System.out.println("La categoria de *****"+proyecto3+"***** es "+categoria3);
                                    if (precio1proy3 != 0 && inversionProyecto1Inversor2 > precio1proy3) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 1 del proyecto "+proyecto3+": "+ recompensa1proy3+ANSI_RESET);
                                    }
                                    if (precio2proy3 != 0 && inversionProyecto1Inversor2 > precio2proy3){
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 2 del proyecto "+proyecto3+": "+ recompensa2proy3+ANSI_RESET);
                                    }
                                    if (precio3proy3!=0 && inversionProyecto1Inversor2>precio3proy3) {
                                        System.out.println(ANSI_GREEN+"Ha conseguido la recompensa 3 del proyecto "+proyecto3+": "+ recompensa3proy3+ANSI_RESET);
                                    }
                                }
                                if (inversionProyecto3Inversor2==0&&inversionProyecto2Inversor2==0&&inversionProyecto1Inversor2==0){
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
                                                    System.out.println("¿Cuánto desea invertir?");
                                                    intentoInversion=Integer.parseInt(s.nextLine());
                                                    if (intentoInversion<=saldoInversor2 && intentoInversion>0){
                                                        inversionProyecto1Inversor2+=intentoInversion;
                                                        System.out.println(ANSI_GREEN+"Operación realizada con exito"+ANSI_RESET);
                                                        saldoInversor2-=intentoInversion;
                                                        financiado1+=intentoInversion;
                                                    }else {
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
                                                System.out.println("¿Cuánto desea invertir?");
                                                intentoInversion=Integer.parseInt(s.nextLine());
                                                if (intentoInversion<=saldoInversor2 && intentoInversion>0){
                                                    inversionProyecto2Inversor2+=intentoInversion;
                                                    System.out.println(ANSI_GREEN+"Operación realizada con exito"+ANSI_RESET);
                                                    saldoInversor2-=intentoInversion;
                                                    financiado2+=intentoInversion;
                                                }else {
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
                                                System.out.println("¿Cuánto desea invertir?");
                                                intentoInversion=Integer.parseInt(s.nextLine());
                                                if (intentoInversion<=saldoInversor2 && intentoInversion>0){
                                                    System.out.println(ANSI_GREEN+"Operación realizada con exito"+ANSI_RESET);
                                                    inversionProyecto3Inversor2+=intentoInversion;
                                                    saldoInversor2-=intentoInversion;
                                                    financiado3+=intentoInversion;
                                                }else {
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
                                    saldoInversor2=gestionSaldoInversor(saldoInversor2);
                                }while (opcion!=3);
                                break;
                            }
                            case 4:{
                                amigosInvitadosInversor2=invitarAmigo(amigosInvitadosInversor2);
                                break;
                            }
                            case 5:{
                                System.out.println("Ha accedido a configuracion");

                                do{
                                    menuConfiguracion();
                                    opcion=Integer.parseInt(s.nextLine());
                                    switch (opcion){
                                        case 1:{
                                            System.out.println("Introduzca el nuevo nombre de usuario");
                                            usuarioInversor2=s.nextLine();
                                            break;
                                        }
                                        case 2:{
                                            System.out.println("Introduzca la nueva contraseña de usuario");
                                            contrasenaInversor2=s.nextLine();
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
        }while(!usuario.equals("s") && !contrasena.equals("s"));
    }
}