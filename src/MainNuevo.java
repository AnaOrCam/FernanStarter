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
                            boolean aux;
                            do {
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil Inversor");
                                nombreAux = s.nextLine();
                                aux=controladorUsuario.buscaUsuario(nombreAux);
                                if (aux)
                                    System.out.println("El nombre de usuario ya está en uso");

                            }while (aux);
                            do {
                                System.out.println("Introduzca su correo ");
                                correoAux = s.nextLine();
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
                                Inversor nuevo=new Inversor(nombreAux,correoAux,contraseniaAux);
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
                            boolean aux;
                            do {
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil Gestor");
                                nombreAux = s.nextLine();
                                aux=controladorUsuario.buscaUsuario(nombreAux);
                                if (aux)
                                    System.out.println("El nombre de usuario ya está en uso");

                            }while (aux);
                            do {
                                System.out.println("Introduzca su correo ");
                                correoAux = s.nextLine();
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
                                Inversor nuevo=new Inversor(nombreAux,correoAux,contraseniaAux);
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
                            boolean aux;
                            do {
                                System.out.println("Introduzca el nombre de usuario del nuevo perfil Administrador");
                                nombreAux = s.nextLine();
                                aux=controladorUsuario.buscaUsuario(nombreAux);
                                if (aux)
                                    System.out.println("El nombre de usuario ya está en uso");

                            }while (aux);
                            do {
                                System.out.println("Introduzca su correo ");
                                correoAux = s.nextLine();
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
                                Inversor nuevo=new Inversor(nombreAux,correoAux,contraseniaAux);
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
                case 2:{
                    String nombreAux="";
                    String contraseniaAunx="";
                    System.out.println("Introduzca nombre");
                    nombreAux=s.nextLine();

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
