import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static utilidades.Funciones.*;
import static utilidades.FuncionesCorreos.*;
import static utilidades.FuncionesCadenas.*;
public class MainNuevo {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        GestionProyectos modeloProyectos= new GestionProyectos();
        VistaProyecto vistaProyectos=new VistaProyecto();
        ControladorProyectos controladorProyectos=new ControladorProyectos(modeloProyectos,vistaProyectos);
        GestionUsuarios modeloUsuarios=new GestionUsuarios();
        VistaUsuario vistaUsuario=new VistaUsuario();
        ControladorUsuario controladorUsuario=new ControladorUsuario(modeloUsuarios,vistaUsuario);
        int opcionInicial=0;
        DateTimeFormatter formatoES = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("Bienvenido a FernanStarter");
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
                              //  do{
                                System.out.println("Introduzca su correo ");
                                correoAux = s.nextLine();
                                    aux=controladorUsuario.compruebaCorreoExistente(correoAux);
                                    if (aux){
                                        System.out.println("El nombre de correo ya existe");
                                    }
                                //}while(aux);
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
                              //  do{
                                    System.out.println("Introduzca su correo ");
                                    correoAux = s.nextLine();
                                    aux=controladorUsuario.compruebaCorreoExistente(correoAux);
                                    if (aux){
                                        System.out.println("El nombre de correo ya existe");
                                    }
                              //  }while(aux);
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
                               // do{
                                    System.out.println("Introduzca su correo ");
                                    correoAux = s.nextLine();
                                    aux=controladorUsuario.compruebaCorreoExistente(correoAux);
                                    if (aux){
                                        System.out.println("El nombre de correo ya existe");
                                    }
                                //}while(aux);
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
                    String correoAux="";
                    String contraseniaAunx="";
                    System.out.println("Introduzca correo");
                    correoAux=s.nextLine();
                    System.out.println("Introduzca la contraseña asociada a su correo");
                    contraseniaAunx=s.nextLine();
                    controladorUsuario.compruebaCredenciales(correoAux,contraseniaAunx);
                    if (controladorUsuario.compruebaCredenciales(correoAux,contraseniaAunx)){
                        controladorUsuario.credencialesValidasNoValidas(correoAux,contraseniaAunx);
                        Usuario aux=controladorUsuario.getUsuarioIniciado(correoAux,contraseniaAunx);
                        TipoUsuario tipoIniciado=controladorUsuario.getUsuarioIniciado(correoAux,contraseniaAunx).getTipoUsuario();
                        int opcion;
                        switch (tipoIniciado){
                            case GESTOR :{

                                Gestor gestor=(Gestor) aux;
                                do {
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
                                            TematicaProyecto tematicaProyecto=TematicaProyecto.valueOf(s.nextLine());
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
                                            System.out.println("Estos son tus proyectos");
                                            controladorUsuario.getProyectosCreadosPorGestor(gestor);
                                            System.out.println("Escribe el nombre del  proyecto a visualizar(0 Para salir)");
                                            String opcionaux=s.nextLine();
                                            if (opcionaux!="0"){
                                                controladorUsuario.vistaDetalladaProyecto(opcionaux,gestor);
                                            }
                                            //todo mostrar  grafica de financiacion

                                            break;
                                        }
                                        case 3:{
                                            System.out.println("Estos son tus proyectos");
                                            controladorUsuario.getProyectosCreadosPorGestor(gestor);
                                            System.out.println("Escribe el nombre del  proyecto a modificar(0 Para salir)");
                                            String opcionaux=s.nextLine();
                                            if (opcionaux!="0"){
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
                                                           "7. Recompensas" );
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
                                                            System.out.println("Elije la nueva cantidad invertuda actual");
                                                            int nuevaCantidad=Integer.parseInt(s.nextLine());
                                                            auxiliarUsuarios.setCantidadInvertidaActual(nuevaCantidad);
                                                            auxiliarProyectos.setCantidadInvertidaActual(nuevaCantidad);
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
                                                            //todo
                                                        }
                                                    }
                                               }else {
                                                   System.out.println("Proyecto no encontrado");
                                               }
                                            }
                                        break;
                                        }
                                        case 4:{
                                            System.out.println("Estos son tus proyectos");
                                            controladorUsuario.getProyectosCreadosPorGestor(gestor);
                                            System.out.println("Escribe el nombre del  proyecto para borrar (0 Para salir)");
                                            String opcionaux=s.nextLine();
                                            if (opcionaux!="0"){
                                                Proyecto auxiliarUsuarios= controladorUsuario.buscaProyectoCreadoGestor(opcionaux,gestor);
                                                Proyecto auxiliarProyectos=controladorProyectos.buscarProyecto(opcionaux);
                                                controladorProyectos.borrarProyecto(auxiliarProyectos);
                                                controladorUsuario.borrarProyecto(gestor,auxiliarUsuarios);
                                            }
                                            break;
                                        }

                                    }
                                }while (opcion!=6);
                                break;
                            }
                            case INVERSOR:{
                                Inversor inversor=(Inversor) aux;


                                break;
                            }
                            case ADMINISTRADOR:{
                                Administrador admin=(Administrador) aux;

                                break;
                            }
                        }
                    }else System.out.println("Sus credenciales no son validas");
                    break;
                }
                case 3:{
                    System.out.println("Saliendo de FernanStarter");
                    break;
                }
            }
        }while (opcionInicial!=3);
        controladorUsuario.muestraUsuarios();
    }
}
