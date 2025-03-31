import utilidades.FuncionesMenus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static utilidades.FuncionesMenus.*;
import static utilidades.FuncionesCorreos.*;
import static utilidades.FuncionesCadenas.*;
public class Main {
    public static void main(String[] args) {
        final String ANSI_GREEN= "\033[32m";
        final String ANSI_RED="\033[31m";
        final String ANSI_RESET= "\033[0m";
        final String ANSI_PURPLE= "\033[35m";
        final String ANSI_GREY= "\033[37m";

        Scanner s=new Scanner(System.in);
        GestionProyectos modeloProyectos= new GestionProyectos();
        VistaProyecto vistaProyectos=new VistaProyecto("\033[32m","\033[31m","\033[0m","\033[35m","\033[37m");
        ControladorProyectos controladorProyectos=new ControladorProyectos(modeloProyectos,vistaProyectos);
        GestionUsuarios modeloUsuarios=new GestionUsuarios();
        VistaUsuario vistaUsuario=new VistaUsuario("\033[32m","\033[31m","\033[0m","\033[35m");
        ControladorUsuario controladorUsuario=new ControladorUsuario(modeloUsuarios,vistaUsuario);
        int opcionInicial=0;
        DateTimeFormatter formatoES = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(ANSI_PURPLE+"Bienvenido a FernanStarter"+ANSI_RESET);
        do {
            menuInicial();
            //Iniciar,Crear,Cerrar
             opcionInicial=Integer.parseInt(s.nextLine());
            switch (opcionInicial){
                //Creacion
                case 1:{
                    String nombreAux="";
                    String correoAux="";
                    String contraseniaAux="";
                    String repeticionContrasena="";
                    eleccionUsuarioACrear();
                    int opcionGeneral=Integer.parseInt(s.nextLine());
                    switch (opcionGeneral){
                        //CREACION INVERSOR
                        case 1:{
                            boolean aux=false;
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil Inversor");
                                nombreAux = s.nextLine();
                            do {
                                do{
                                System.out.println("Introduzca su correo ");
                                correoAux = s.nextLine();
                                    aux=controladorUsuario.compruebaCorreoExistente(correoAux);
                                    if (aux){
                                        System.out.println("El nombre de correo ya existe");
                                    }
                                }while(aux);
                                if (!comprobacionCorreo(correoAux)){
                                    System.out.println("El formato del correo debe contener @");
                                }
                            }while(!comprobacionCorreo(correoAux));
                            do {
                                do {
                                    System.out.println("Introduzca la contraseña de usuario del nuevo perfil Inversor ");
                                    contraseniaAux = s.nextLine();
                                    System.out.println(fortalezaContrasena(contraseniaAux));
                                    if (fortalezaContrasena(contraseniaAux).equals("Robustez de la contraseña: Débil")){
                                        System.out.println("La contraseña debe tener al menos una longitud de 8 y contener mayúsculas y minúsculas.");
                                    }
                                }while (fortalezaContrasena(contraseniaAux).equals("Robustez de la contraseña: Débil"));
                                System.out.println("Repita la contraseña de usuario  ");
                                repeticionContrasena = s.nextLine();
                                if (!confirmarContrasena(contraseniaAux, repeticionContrasena)) {
                                    System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                }
                            } while (!confirmarContrasena(contraseniaAux, repeticionContrasena));
                            System.out.println("Introduzca el codigo de verificacion para la creacion del perfil que hemos enviado a su correo");
                            int autentificacion = generarAutentificacion();
                            String asunto = "Codigo de autentificacion";
                            String cuerpo = "Bienvenido a FernanStarter! Codigo de verificacion para crear tu nuevo usuario: " + autentificacion + "\n ";
                            enviarConGMail(correoAux, asunto, cuerpo);
                            int verificaion = Integer.parseInt(s.nextLine());
                            if (verificaion == autentificacion) {
                                System.out.println("Usuario creado con exito");
                                Inversor nuevo=new Inversor(nombreAux,correoAux,contraseniaAux,TipoUsuario.INVERSOR);
                                controladorUsuario.aniadirUsuario(nuevo);
                                 nombreAux="";
                                 correoAux="";
                                 contraseniaAux="";

                            } else {
                                System.out.println("El codigo no corresponde al enviado, creacion fallida");
                                nombreAux="";
                                correoAux="";
                                contraseniaAux="";
                            }
                            break;
                        }
                        //CREACION GESTOR
                        case 2:{
                            boolean aux =false;
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil Gestor");
                                nombreAux = s.nextLine();
                            do {
                                do{
                                    System.out.println("Introduzca su correo ");
                                    correoAux = s.nextLine();
                                    aux=controladorUsuario.compruebaCorreoExistente(correoAux);
                                    if (aux){
                                        System.out.println("El nombre de correo ya existe");
                                    }
                                }while(aux);
                                if (!comprobacionCorreo(correoAux)){
                                    System.out.println("El formato del correo debe contener @");
                                }
                            }while(!comprobacionCorreo(correoAux));
                            do {
                                do {
                                    System.out.println("Introduzca la contraseña de usuario del nuevo perfil Gestor ");
                                    contraseniaAux = s.nextLine();
                                    System.out.println(fortalezaContrasena(contraseniaAux));
                                    if (fortalezaContrasena(contraseniaAux).equals("Robustez de la contraseña: Débil")){
                                        System.out.println("La contraseña debe tener al menos una longitud de 8 y contener mayúsculas y minúsculas.");
                                    }
                                }while (fortalezaContrasena(contraseniaAux).equals("Robustez de la contraseña: Débil"));
                                System.out.println("Repita la contraseña de usuario  ");
                                repeticionContrasena = s.nextLine();
                                if (!confirmarContrasena(contraseniaAux, repeticionContrasena)) {
                                    System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                }
                            } while (!confirmarContrasena(contraseniaAux, repeticionContrasena));

                            System.out.println("Introduzca el codigo de verificacion para la creacion del perfil que hemos enviado a su correo");
                            int autentificacion = generarAutentificacion();
                            String asunto = "Codigo de autentificacion";
                            String cuerpo = "Bienvenido a FernanStarter! Codigo de verificacion para crear tu nuevo usuario: " + autentificacion + "\n ";
                            enviarConGMail(correoAux, asunto, cuerpo);
                            int verificaion = Integer.parseInt(s.nextLine());
                            if (verificaion == autentificacion) {
                                System.out.println("Usuario creado con exito");
                                Gestor nuevo=new Gestor(nombreAux,correoAux,contraseniaAux, TipoUsuario.GESTOR);
                                controladorUsuario.aniadirUsuario(nuevo);
                                nombreAux="";
                                correoAux="";
                                contraseniaAux="";
                            } else {
                                System.out.println("El codigo no corresponde al enviado, creacion fallida");
                                nombreAux="";
                                correoAux="";
                                contraseniaAux="";
                            }
                            break;
                        }
                        //CREACION ADMINSITRADOR
                        case 3:{
                            boolean aux=false;
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil Administrador");
                                nombreAux = s.nextLine();
                            do {
                                do{
                                    System.out.println("Introduzca su correo ");
                                    correoAux = s.nextLine();
                                    aux=controladorUsuario.compruebaCorreoExistente(correoAux);
                                    if (aux){
                                        System.out.println("El nombre de correo ya existe");
                                    }
                                }while(aux);
                                if (!comprobacionCorreo(correoAux)){
                                    System.out.println("El formato del correo debe contener @");
                                }
                            }while(!comprobacionCorreo(correoAux));
                            do {
                                do {
                                    System.out.println("Introduzca la contraseña de usuario del nuevo perfil Administrador ");
                                    contraseniaAux = s.nextLine();
                                    System.out.println(fortalezaContrasena(contraseniaAux));
                                    if (fortalezaContrasena(contraseniaAux).equals("Robustez de la contraseña: Débil")){
                                        System.out.println("La contraseña debe tener al menos una longitud de 8 y contener mayúsculas y minúsculas.");
                                    }
                                }while (fortalezaContrasena(contraseniaAux).equals("Robustez de la contraseña: Débil"));
                                System.out.println("Repita la contraseña de usuario  ");
                                 repeticionContrasena = s.nextLine();
                                if (!confirmarContrasena(contraseniaAux, repeticionContrasena)) {
                                    System.out.println("La contraseña repetida introducida es diferente. Inténtelo de nuevo");
                                }
                            } while (!confirmarContrasena(contraseniaAux, repeticionContrasena));
                            System.out.println("Introduzca el codigo de verificacion para la creacion del perfil que hemos enviado a su correo");
                            int autentificacion = generarAutentificacion();
                            String asunto = "Codigo de autentificacion";
                            String cuerpo = "Bienvenido a FernanStarter! Codigo de verificacion para crear tu nuevo usuario: " + autentificacion + "\n ";
                            enviarConGMail(correoAux, asunto, cuerpo);
                            int verificaion = Integer.parseInt(s.nextLine());
                            if (verificaion == autentificacion) {
                                System.out.println("Usuario creado con exito");
                                Administrador nuevo=new Administrador(nombreAux,correoAux,contraseniaAux, TipoUsuario.ADMINISTRADOR);
                                controladorUsuario.aniadirUsuario(nuevo);
                                nombreAux="";
                                correoAux="";
                                contraseniaAux="";
                            } else {
                                System.out.println("El codigo no corresponde al enviado, creacion fallida");
                                nombreAux="";
                                correoAux="";
                                contraseniaAux="";
                            }
                            break;
                        }
                    }
                    break;
                }
                //Iniciar Sesion
                case 2:{
                    int autentificacion=0;
                    int codigo=0;
                    String correoAux="";
                    String contraseniaAunx="";
                    System.out.println("Introduzca correo");
                    correoAux=s.nextLine();
                    System.out.println("Introduzca la contraseña asociada a su correo");
                    contraseniaAunx=s.nextLine();
                    if (controladorUsuario.compruebaCredenciales(correoAux,contraseniaAunx)){
                        System.out.println("Hemos enviado un código a tu correo. Introduce la autentificación");
                         autentificacion = generarAutentificacion();
                        String asunto = "Codigo de Verificacion";
                        String cuerpo = "Codigo de verificacion para el inicio de sesion : " + autentificacion + "\n Bienvenido a FernanStarter";
                        enviarConGMail(correoAux, asunto, cuerpo);
                         codigo = Integer.parseInt(s.nextLine());
                    }
                    if (controladorUsuario.compruebaCredenciales(correoAux,contraseniaAunx)&&codigo == autentificacion){
                        controladorUsuario.credencialesValidasNoValidas(correoAux,contraseniaAunx);
                        Usuario usuarioActual =controladorUsuario.getUsuarioIniciado(correoAux,contraseniaAunx);
                        TipoUsuario tipoIniciado=controladorUsuario.getUsuarioIniciado(correoAux,contraseniaAunx).getTipoUsuario();
                        int opcion;
                        switch (tipoIniciado){
                            case GESTOR :{
                                Gestor gestor=(Gestor) usuarioActual;
                                if (gestor.isBloqueado()){
                                    System.out.println("Este perfil esta bloqueado. Contacta con un administrador");
                                }else do {
                                    System.out.println("¿Qué quieres hacer?\n" +
                                            "1. Crear un nuevo proyecto\n" +
                                            "2. Vista detallada de mis proyectos\n" +
                                            "3. Modificar un proyecto\n" +
                                            "4. Borrar un proyecto\n" +
                                            "5. Acceder a mi configuracion\n" +
                                            "6. Salir");
                                    opcion=Integer.parseInt(s.nextLine());
                                    //Opciones Gestor
                                    switch (opcion){
                                        //Opcion Gestor Crear proyecto
                                        case 1:{
                                            String nombreNuevo;
                                            do {
                                                System.out.println("Introduce el nombre del proyecto");
                                                nombreNuevo=s.nextLine();
                                            }while (controladorProyectos.compruebaProyectoExiste(nombreNuevo));
                                            System.out.println("Introduce la fecha de apertura formato yyyy/MM/dd");
                                            LocalDate fechaInicio = LocalDate.parse(s.nextLine(), formatoES);
                                            System.out.println("Introduce la fecha de cierre formato yyyy/MM/dd");
                                            LocalDate fechaCierre = LocalDate.parse(s.nextLine(), formatoES);
                                            System.out.println("Introduce la descripcion del proyecto");
                                            String descripcion=s.nextLine();
                                            System.out.println("Introduce la cantidad total a invertir");
                                            int cantidadAInvertir=Integer.parseInt(s.nextLine());
                                            System.out.println("Elije la tematica del proyecto");
                                            controladorProyectos.muestratipos();
                                            TematicaProyecto tematicaProyecto=TematicaProyecto.valueOf(s.nextLine().toUpperCase());
                                            System.out.println("El numero inicial de recompensas");
                                            int numRecompensas=Integer.parseInt(s.nextLine());
                                            Proyecto nuevo =new Proyecto(numRecompensas,nombreNuevo,fechaInicio,fechaCierre,cantidadAInvertir,descripcion,tematicaProyecto);
                                            for (int i=0;i<numRecompensas;i++){
                                                System.out.println("Introduce el nombre de la recompensa "+(i+1));
                                                String nombreRecompensa=s.nextLine();
                                                System.out.println("Introduce una breve descripccion");
                                                String descripcionRecompensa=s.nextLine();
                                                System.out.println("Introduce el importe para conseguirla");
                                                float importe=Float.parseFloat(s.nextLine());
                                                Recompensa nueva=new Recompensa(nombreRecompensa,descripcionRecompensa,importe);
                                                controladorProyectos.insertarRecompensa(nueva,nuevo);
                                            }
                                            controladorProyectos.insertarProyecto(nuevo);
                                            controladorUsuario.gestorAnadirProyecto(gestor,nuevo);
                                            break;
                                        }
                                        case 2:{
                                            if (controladorUsuario.getProyectosCreadosPorGestorSinVista(gestor).size()>0){
                                                System.out.println("Estos son tus proyectos");
                                                controladorUsuario.getProyectosCreadosPorGestor(gestor);
                                                System.out.println("Escribe el nombre del  proyecto a visualizar (0 Para salir)");
                                                String opcionaux=s.nextLine();
                                                if (!opcionaux.equals("0")){
                                                    controladorUsuario.vistaDetalladaProyectoCreado(opcionaux,gestor);
                                                    if (controladorUsuario.buscaProyectoCreadoGestor(opcionaux,gestor)!=null) {
                                                        controladorProyectos.mostrarGraficoFinanciacion(controladorUsuario.buscaProyectoCreadoGestor(opcionaux, gestor));
                                                    }else{
                                                        System.out.println("El nombre introducido no corresponde a ningún proyecto.");
                                                    }
                                                }
                                            }else {
                                                System.out.println("No hay proyectos creados por este perfil");
                                            }

                                            break;
                                        }
                                        case 3:{
                                            if (controladorUsuario.getProyectosCreadosPorGestorSinVista(gestor).size()>0){
                                                System.out.println("Estos son tus proyectos");
                                                controladorUsuario.getProyectosCreadosPorGestor(gestor);
                                                System.out.println("Escribe el nombre del  proyecto a modificar(0 Para salir)");
                                                String opcionaux=s.nextLine();
                                                if (!opcionaux.equals("0")){
                                                    Proyecto auxiliarUsuarios= controladorUsuario.buscaProyectoCreadoGestor(opcionaux,gestor);
                                                    Proyecto auxiliarProyectos=controladorProyectos.buscarProyecto(opcionaux);
                                                    if (auxiliarUsuarios!=null){
                                                        System.out.println("Qué quieres modificar?\n" +
                                                                "1. Nombre\n" +
                                                                "2. Categoría\n" +
                                                                "3. Cantidad a financiar\n" +
                                                                "4. Cantidad financiada hasta el momento\n" +
                                                                "5. Fecha de apertura de inversiones\n" +
                                                                "6. Fecha de cierre de inversiones\n" +
                                                                "7. Añadir Recompensa" );
                                                        opcion=Integer.parseInt(s.nextLine());
                                                        switch (opcion){
                                                            case 1:{
                                                                System.out.println("Introduce el nuevo nombre");
                                                                String nombreNuevo=s.nextLine();
                                                                auxiliarUsuarios.setNombre(nombreNuevo);
                                                                auxiliarProyectos.setNombre(nombreNuevo);
                                                                break;
                                                            }
                                                            case 2:{
                                                                System.out.println("Elije la nueva tematica del proyecto");
                                                                controladorProyectos.muestratipos();
                                                                auxiliarUsuarios.setTematicaProyecto(TematicaProyecto.valueOf(s.nextLine()));
                                                                auxiliarProyectos.setTematicaProyecto(TematicaProyecto.valueOf(s.nextLine()));
                                                                break;
                                                            }
                                                            case 3:{
                                                                System.out.println("Elije la nueva cantidad a financiar");
                                                                int nuevaCantidad=Integer.parseInt(s.nextLine());
                                                                auxiliarUsuarios.setCantidadAInvertirTotal(nuevaCantidad);
                                                                auxiliarProyectos.setCantidadAInvertirTotal(nuevaCantidad);
                                                                break;
                                                            }case 4:{
                                                                System.out.println("Elije la nueva cantidad invertuda usuarioActual");
                                                                int nuevaCantidad=Integer.parseInt(s.nextLine());
                                                                auxiliarUsuarios.aniadirFinanciacion(nuevaCantidad);
                                                                auxiliarProyectos.aniadirFinanciacion(nuevaCantidad);
                                                                break;
                                                            }case 5:{
                                                                System.out.println("Fecha nueva de apertura");
                                                                LocalDate fechaInicionueva = LocalDate.parse(s.nextLine(), formatoES);
                                                                auxiliarUsuarios.setFechaApertura(fechaInicionueva);
                                                                auxiliarProyectos.setFechaApertura(fechaInicionueva);
                                                                break;
                                                            }case 6:{
                                                                System.out.println("Fecha cierre de apertura");
                                                                LocalDate fechaCierreNueva = LocalDate.parse(s.nextLine(), formatoES);
                                                                auxiliarUsuarios.setFechaApertura(fechaCierreNueva);
                                                                auxiliarProyectos.setFechaApertura(fechaCierreNueva);
                                                                break;
                                                            }case 7:{
                                                                System.out.println("Estas son las recompensas");
                                                                controladorUsuario.mostrarRecompensas(auxiliarUsuarios);
                                                                System.out.println("¿Desea añadir una recompensa?(Si/No)");
                                                                if (s.nextLine().equalsIgnoreCase("Si")){
                                                                    System.out.println("Introduce el nombre de la recompensa ");
                                                                    String nombreRecompensa=s.nextLine();
                                                                    System.out.println("Introduce una breve descripccion");
                                                                    String descripcionRecompensa=s.nextLine();
                                                                    System.out.println("Introduce el importe para conseguirla");
                                                                    float importe=Float.parseFloat(s.nextLine());
                                                                    Recompensa nueva=new Recompensa(nombreRecompensa,descripcionRecompensa,importe);
                                                                    controladorProyectos.insertarRecompensa(nueva,auxiliarProyectos);
                                                                    controladorUsuario.operacionSatisfactoria();
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    }else {
                                                        System.out.println("Proyecto no encontrado");
                                                    }
                                                }
                                            }else {
                                                System.out.println("No hay proyectos creados por este perfil");
                                            }
                                        break;
                                        }
                                        case 4:{
                                            System.out.println("Estos son tus proyectos");
                                            controladorUsuario.getProyectosCreadosPorGestor(gestor);
                                            System.out.println("Escribe el nombre del  proyecto para borrar (0 Para salir)");
                                            String opcionaux=s.nextLine();
                                            if (!opcionaux.equals("0")){
                                                Proyecto auxiliarUsuarios= controladorUsuario.buscaProyectoCreadoGestor(opcionaux,gestor);
                                                Proyecto auxiliarProyectos=controladorProyectos.buscarProyecto(opcionaux);
                                                controladorProyectos.borrarProyecto(auxiliarProyectos);
                                                controladorUsuario.borrarProyecto(gestor,auxiliarUsuarios);
                                            }
                                            break;
                                        }
                                        case 5:{
                                            System.out.println("Has accedido a la configuracion ");
                                            System.out.println("Elije opcion:\n" +
                                                    "1.Cambiar Nombre\n" +
                                                    "2.Cambiar Contraseña");
                                            opcion=Integer.parseInt(s.nextLine());
                                            switch (opcion){
                                                case 1:{
                                                    System.out.println("Introduce el nuevo nombre");
                                                    gestor.setNombre(s.nextLine());
                                                    controladorUsuario.operacionSatisfactoria();
                                                    System.out.println(gestor);
                                                    break;
                                                }
                                                case 2:{
                                                    System.out.println("Introduce la nueva contraseña");
                                                    gestor.setContrasena(s.nextLine());
                                                    controladorUsuario.operacionSatisfactoria();
                                                    break;
                                                }
                                                default:{
                                                    controladorUsuario.operacionFallida();
                                                }
                                            }
                                            break;
                                        }

                                    }
                                }while (opcion!=6);
                                break;
                            }
                            case INVERSOR:{
                                Inversor inversor=(Inversor) usuarioActual;
                                if (inversor.isBloqueado()){
                                    System.out.println("Este perfil esta bloqueado. Contacta con un administrador");
                                }else do {
                                    FuncionesMenus.menuInversor();
                                    opcion = Integer.parseInt(s.nextLine());
                                    switch (opcion) {
                                        case 1 -> {
                                            if (!controladorUsuario.mostrarInversiones(inversor)) System.out.println("No tienes ninguna inversión hasta la fecha.");
                                        }
                                        case 2 -> {
                                            System.out.println("------PROYECTOS------");
                                            if (controladorProyectos.mostrarProyectosConGrafico()){
                                                System.out.println("¿Quieres hacer una inversión? (si/no)");
                                                if (s.nextLine().equalsIgnoreCase("si")) {
                                                    System.out.println("Introduce el nombre del proyecto en el que quieres invertir:");
                                                    String nombre=s.nextLine();
                                                    if (controladorProyectos.buscarProyecto(nombre)!=null){
                                                        Proyecto proyectoAux=controladorProyectos.buscarProyecto(nombre);
                                                        System.out.println("¿Què cantidad quieres invertir?");
                                                        float cantidad=Float.parseFloat(s.nextLine());
                                                        if (controladorProyectos.siRecompensa(cantidad,proyectoAux)) {
                                                            System.out.println("¡Enhorabuena! Por tu inversión puedes elegir entre las siguientes recompensas: ");
                                                            controladorProyectos.mostrarRecompensasAElegir(cantidad, proyectoAux);
                                                            boolean recompensaValida = false;
                                                            String eleccion;
                                                            do {
                                                                System.out.println("Escribe el nombre de la recompensa que deseas elegir: ");
                                                                eleccion = s.nextLine();
                                                                if (controladorProyectos.buscarRecompensa(eleccion, proyectoAux) != null) {
                                                                    recompensaValida = true;
                                                                } else {
                                                                    System.out.println("El nombre introducido no corresponde a ninguna recompensa. Por favor introduzca una recompensa válida.");
                                                                }
                                                            } while (!recompensaValida);
                                                            Recompensa recompensaAux = controladorProyectos.buscarRecompensa(eleccion, proyectoAux);
                                                            Inversion inversionAux = new Inversion(nombre, cantidad, inversor, recompensaAux);

                                                            if (controladorUsuario.insertarInversion(inversionAux, inversor, cantidad)) {
                                                                controladorProyectos.aniadirFinanciacionAProyecto(cantidad, proyectoAux);
                                                            } else {
                                                                System.out.println("No se ha podido realizar la operación. Saldo insuficiente");
                                                            }
                                                        }else{
                                                            Inversion inversionAux = new Inversion(nombre, cantidad, inversor);
                                                            if (controladorUsuario.insertarInversion(inversionAux, inversor, cantidad)) {
                                                                controladorProyectos.aniadirFinanciacionAProyecto(cantidad, proyectoAux);
                                                            } else {
                                                                System.out.println("No se ha podido realizar la operación. Saldo insuficiente");
                                                            }
                                                        }
                                                    }else{
                                                        System.out.println("El nombre introducido no corresponde a ningún proyecto.");
                                                    }
                                                }
                                            }else{
                                                System.out.println("No hay proyectos disponibles.");
                                            }

                                        }
                                        case 3 -> {
                                            System.out.println("Bienvenido a tu cartera digital ¿Qúe quieres hacer?" +
                                                    "\n1. Mostrar saldo" +
                                                    "\n2. Ingresar saldo a mi cuenta" +
                                                    "\n3. Salir");
                                            int opcionCartera=Integer.parseInt(s.nextLine());
                                            switch (opcionCartera){
                                                case 1-> controladorUsuario.mostrarSaldoInversor(inversor);
                                                case 2-> {
                                                    System.out.println("¿Cuánto quieres ingresar?");
                                                    float cantidad=Float.parseFloat(s.nextLine());
                                                    controladorUsuario.ingresarSaldo(cantidad,inversor);
                                                }
                                                case 3-> System.out.println("Saliendo de cartera digital...");
                                                default -> System.out.println("Esa opción no se encuentra en el menú");
                                            }
                                        }
                                        case 4 -> {
                                            System.out.println("¿A quien quieres invitar? Introduce su email");
                                            String amigo = s.nextLine();
                                            if (controladorUsuario.invitarAmigo(amigo,inversor)){
                                                System.out.println("Tus amigos invitados hasta la fecha son los siguientes:");
                                                controladorUsuario.mostrarAmigos(inversor);
                                            }else{
                                                System.out.println("No se ha podido realizar la invitación. El formato introducido no es un correo electrónico.");
                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("Has accedido a la configuracion ");
                                            System.out.println("Elije opcion:\n" +
                                                    "1.Cambiar Nombre\n" +
                                                    "2.Cambiar Contraseña");
                                            opcion=Integer.parseInt(s.nextLine());
                                            switch (opcion){
                                                case 1:{
                                                    System.out.println("Introduce el nuevo nombre");
                                                    inversor.setNombre(s.nextLine());
                                                    controladorUsuario.operacionSatisfactoria();
                                                    System.out.println(inversor);
                                                    break;
                                                }
                                                case 2:{
                                                    System.out.println("Introduce la nueva contraseña");
                                                    inversor.setContrasena(s.nextLine());
                                                    controladorUsuario.operacionSatisfactoria();
                                                    break;
                                                }
                                                default:{
                                                    controladorUsuario.operacionFallida();
                                                }
                                            }
                                            break;
                                        }
                                        case 6 -> System.out.println("Cerrando sesión...") ;
                                        default -> System.out.println("Esa opción no se encuentra en el menú");
                                    }
                                }while (opcion!=6);

                                break;
                            }
                            case ADMINISTRADOR:{
                                Administrador admin=(Administrador) usuarioActual;
                                opcion=0;
                                do {
                                    menuAdministrador();
                                    opcion=Integer.parseInt(s.nextLine());
                                    switch (opcion){
                                        case 1:{
                                            menuBloqueo();
                                            opcion=Integer.parseInt(s.nextLine());
                                            switch (opcion){
                                                case 1:{
                                                    if (controladorUsuario.compruebaExistenUsuarios()){
                                                        controladorUsuario.muestraUsuarios(admin);
                                                        System.out.println("Escribe el correo del usuario que deseas bloquear");
                                                        Usuario aBloquear=controladorUsuario.getUsuario(s.nextLine());
                                                        if (aBloquear.getTipoUsuario()==(TipoUsuario.INVERSOR)){
                                                            Inversor inversor=(Inversor) aBloquear;
                                                            if (inversor.isBloqueado()){
                                                                System.out.println("Este usuario ya se encuentra bloqueado");
                                                            }else {
                                                                controladorUsuario.bloquearUsuario(inversor);
                                                                controladorUsuario.operacionSatisfactoria();
                                                            }
                                                        }else if (aBloquear.getTipoUsuario()==(TipoUsuario.GESTOR)){
                                                            Gestor gestor=(Gestor) aBloquear;
                                                            if (gestor.isBloqueado()){
                                                                System.out.println("Este usuario ya se encuentra bloqueado");
                                                            }else {
                                                                controladorUsuario.bloquearUsuario(gestor);
                                                                controladorUsuario.operacionSatisfactoria();
                                                            }
                                                        }else controladorUsuario.operacionFallida();
                                                    }else {
                                                        System.out.println("No hay usuarios creados");
                                                    }
                                                    break;
                                                }
                                                case 2:{
                                                    if (controladorUsuario.compruebaExistenUsuarios()){
                                                        controladorUsuario.muestraUsuarios(admin);
                                                        System.out.println("Escribe el correo del usuario que deseas desbloquear");
                                                        Usuario aDesBloquear=controladorUsuario.getUsuario(s.nextLine());
                                                        if (aDesBloquear.getTipoUsuario()==(TipoUsuario.INVERSOR)){
                                                            Inversor inversor=(Inversor) aDesBloquear;
                                                            if (!inversor.isBloqueado()){
                                                                System.out.println("Este usuario ya se encuentra desbloqueado");
                                                            }else {
                                                                controladorUsuario.desbloquearUsuario(inversor);
                                                                controladorUsuario.operacionSatisfactoria();
                                                            }
                                                        }else if (aDesBloquear.getTipoUsuario()==(TipoUsuario.GESTOR)){
                                                            Gestor gestor=(Gestor) aDesBloquear;
                                                            if (!gestor.isBloqueado()){
                                                                System.out.println("Este usuario ya se encuentra desbloqueado");
                                                            }else {
                                                                controladorUsuario.desbloquearUsuario(gestor);
                                                                controladorUsuario.operacionSatisfactoria();
                                                            }
                                                        }else controladorUsuario.operacionFallida();
                                                    }else {
                                                        System.out.println("No hay usuarios creados");
                                                    }

                                                    break;
                                                } case 3:{
                                                    System.out.println("Saliendo del menu de bloqueo/desbloqueo");
                                                    break;
                                                }
                                                default:{
                                                    controladorUsuario.operacionFallida();
                                                }
                                            }
                                            break;
                                        }
                                        case 2:{
                                            if (!controladorProyectos.mostrarProyectosConGrafico()){
                                                System.out.println("No hay proyectos disponibles");
                                            }
                                            break;
                                        }
                                        case  3:{
                                            System.out.println("Has accedido a la configuracion ");
                                            System.out.println("Elije opcion:\n" +
                                                    "1.Cambiar Nombre\n" +
                                                    "2.Cambiar Contraseña");
                                            opcion=Integer.parseInt(s.nextLine());
                                            switch (opcion){
                                                case 1:{
                                                    System.out.println("Introduce el nuevo nombre");
                                                    admin.setNombre(s.nextLine());
                                                    controladorUsuario.operacionSatisfactoria();
                                                    System.out.println(admin);
                                                    break;
                                                }
                                                case 2:{
                                                    System.out.println("Introduce la nueva contraseña");
                                                    admin.setContrasena(s.nextLine());
                                                    controladorUsuario.operacionSatisfactoria();
                                                    break;
                                                }
                                                default:{
                                                    controladorUsuario.operacionFallida();
                                                }
                                            }
                                            break;

                                        }
                                        case 4:{
                                            System.out.println("Cerrando Sesion...");
                                            break;
                                        }
                                        default:{
                                            controladorUsuario.operacionFallida();
                                            break;
                                        }
                                    }
                                }while(opcion!=4);


                                break;
                            }
                        }
                    }else if (controladorUsuario.getUsuario(correoAux)!=null){
                        System.out.println("Sus credenciales no son válidas");
                        if (controladorUsuario.getUsuario(correoAux).getTipoUsuario()==TipoUsuario.INVERSOR){
                            Inversor aux=(Inversor) controladorUsuario.getUsuario(correoAux);
                            aux.sumaIntentos();
                        }
                        if (controladorUsuario.getUsuario(correoAux).getTipoUsuario()==TipoUsuario.GESTOR){
                            Gestor aux=(Gestor) controladorUsuario.getUsuario(correoAux);
                            aux.sumaIntentos();
                        }
                    }else{
                        System.out.println("Sus credenciales no son válidas");
                    }
                    break;
                }
                case 3:{
                    System.out.println(ANSI_PURPLE+"Saliendo de FernanStarter"+ANSI_RESET);
                    break;
                }
            }
        }while (opcionInicial!=3);
        controladorUsuario.muestraUsuarios();

    }
}
