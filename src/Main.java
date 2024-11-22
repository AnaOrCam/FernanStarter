import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String usuario;
        String contrasena;
        String usuarioAdmin="administrador", usuarioGestor="gestor", usuarioInversor1="inversor1", usuarioInversor2="inversor2";
        String contrasenaAdmin="admin", contrasenaGestor="gestor", contrasenaInversor1="inversor1", contrasenaInversor2="inversor2";
        int intentoGestor=3, intentoInversor1=3, intentoInversor2=3;
        Boolean bienvenido;
        Boolean gestorbloqueado=false, inversor1bloqueado=false, inversor2bloqueado=false;
        int admin_gestor=0;
        int admin_inversor1=0;
        int admin_inversor2=0;
        int eleccionadmin=0;
        int opcion;
        do{
            bienvenido=false;
            System.out.println("Introduce usuario y contraseña. Pulsa s para salir");
            usuario=s.nextLine().toLowerCase();
            contrasena=s.nextLine();
            if (!usuario.equals("s") && !contrasena.equals("s")) {
                if (usuario.equals(usuarioAdmin) && contrasena.equals(contrasenaAdmin) ) {
                    System.out.println("Bienvenido Administrador");
                    bienvenido = true;
                }
                if (usuario.equals(usuarioGestor)&&contrasena.equals(contrasenaGestor)&&gestorbloqueado.equals(false)) {
                    System.out.println("Bienvenido Gestor");
                    bienvenido = true;
                } else if ((usuario.equals(usuarioGestor)&&gestorbloqueado.equals(true))) {
                    System.out.println("Acceso denegado  el perfil *Gestor* ha sido bloqueado ");
                }
                if (usuario.equals(usuarioInversor1)&&contrasena.equals(contrasenaInversor1)&&inversor1bloqueado.equals(false)) {
                    System.out.println("Bienvenido inversor1");
                    bienvenido = true;
                } else if ((usuario.equals(usuarioInversor1)&&inversor1bloqueado.equals(true))) {
                    System.out.println("Acceso denegado  el perfil *inversor1* ha sido bloqueado ");
                }
                if (usuario.equals(usuarioInversor2)&&contrasena.equals(contrasenaInversor2)&&inversor2bloqueado.equals(false)) {
                    System.out.println("Bienvenido inversor2");
                    bienvenido = true;
                } else if ((usuario.equals(usuarioInversor2)&&inversor2bloqueado.equals(true))) {
                    System.out.println("Acceso denegado  el perfil *Gestor* ha sido bloqueado ");
                }
                if (!usuario.equals(usuarioGestor)&&!usuario.equals(usuarioInversor1)&&!usuario.equals(usuarioInversor2)&&!usuario.equals(usuarioAdmin)){
                 if(gestorbloqueado.equals(true)){
                     System.out.println("No es posible el intento de acceso al perfil *Gestor*, esta bloqueado");
                 } else if (inversor1bloqueado.equals(true)) {
                     System.out.println("No es posible el intento de acceso al perfil *Inversor1*, esta bloqueado");
                 }else if (inversor2bloqueado.equals(true)) {
                     System.out.println("No es posible el intento de acceso al perfil *Inversor2*, esta bloqueado");
                 }else{
                     System.out.println("Usuario o contraseña incorrectos");

                 }
                }
                if((usuario.equals(usuarioGestor)&&!contrasena.equals(contrasenaGestor))||(usuario.equals(usuarioInversor1)&&!contrasena.equals(contrasenaInversor1))||(usuario.equals(usuarioInversor1)&&!contrasena.equals(contrasenaInversor2))||(usuario.equals(usuarioAdmin)&&!contrasena.equals(contrasenaAdmin))){
                    if(gestorbloqueado.equals(true)){
                        System.out.println("No es posible el intento de acceso al perfil *Gestor*, esta bloqueado");
                    } else if (inversor1bloqueado.equals(true)) {
                        System.out.println("No es posible el intento de acceso al perfil *Inversor1*, esta bloqueado");
                    }else if (inversor2bloqueado.equals(true)) {
                        System.out.println("No es posible el intento de acceso al perfil *Inversor2*, esta bloqueado");
                    }else{
                        System.out.println("Usuario o contraseña incorrectos");

                    }
                }
                /// ///////////////////////////////////////
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
                    System.out.println("Te quedan " + intentoGestor + " intentos.");
                }
                if (usuario.equals(usuarioInversor1) && !contrasena.equals(contrasenaInversor1)&& inversor1bloqueado.equals(false)) {
                    intentoInversor1 -= 1;
                    System.out.println("Te quedan " + intentoInversor1 + " intentos.");
                }
                if (usuario.equals(usuarioInversor2) && !contrasena.equals(contrasenaInversor2)&& inversor2bloqueado.equals(false)) {
                    intentoInversor2 -= 1;
                    System.out.println("Te quedan " + intentoInversor2 + " intentos.");
                }
                if (usuario.equals(usuarioGestor) && intentoGestor == 0 ) {
                    System.out.println("Ha agotado los intentos de acceso a el perfil Gestor. Para restaurar contacte con el administrador.");
                    gestorbloqueado=true;
                }
                if (usuario.equals(usuarioInversor1)&&(intentoInversor1==0)){
                    System.out.println("Ha agotado los intentos de acceso a el perfil Inversor1. Para restaurar contacte con el administrador.");
                    inversor1bloqueado=true;
                }
                if (usuario.equals(usuarioInversor2)&&(intentoInversor2==0)){
                    System.out.println("Ha agotado los intentos de acceso a el perfil Inversor2. Para restaurar contacte con el administrador.");
                    inversor2bloqueado=true;
                }
            }else{
                System.out.println("¡Nos vemos pronto!");
            }
            if (bienvenido) {
                    if(usuario.equals("administrador")) {
                        do {
                            System.out.println("Elije opción:\n" +
                                    "1. Panel de control\n" +
                                    "2. Proyectos\n" +
                                    "3. Configuración\n" +
                                    "4. Cerrar Sesión\n");
                            opcion=Integer.parseInt(s.nextLine());
                            switch (opcion){
                                case 1: {
                                    System.out.println("Ha accedido a Panel de control");
                                    System.out.println("Introduzca de que usuario quiere conocer su estado:");
                                    System.out.println("1."+usuarioGestor);
                                    System.out.println("2."+usuarioInversor1);
                                    System.out.println("3."+usuarioInversor2);
                                    eleccionadmin=Integer.parseInt(s.nextLine());
                                    switch (eleccionadmin){
                                        case 1:{
                                            System.out.print("El estado de "+ usuarioGestor+ " es ");
                                            if(gestorbloqueado.equals(false)){
                                                System.out.println("desbloqueado");
                                            }else {
                                                System.out.println("bloqueado");
                                            }
                                            System.out.println("Pulsa 1. Para bloquear");
                                            System.out.println("Pulsa 2. Para desbloquear");
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
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                                case 2: {
                                    System.out.print("El estado de "+ usuarioInversor1+ " es ");
                                    if(inversor1bloqueado.equals(false)){
                                        System.out.println("desbloqueado");
                                    }else {
                                        System.out.println("bloqueado");
                                    }
                                    System.out.println("Pulsa 1. Para bloquear");
                                    System.out.println("Pulsa 2. Para desbloquear");
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
                                            }
                                            break;
                                        }
                                    }
                                    break;

                                }
                                case 3: {
                                    System.out.print("El estado de "+ usuarioInversor2+ " es ");
                                    if(inversor2bloqueado.equals(false)){
                                        System.out.println("desbloqueado");
                                    }else {
                                        System.out.println("bloqueado");
                                    }
                                    System.out.println("Pulsa 1. Para bloquear");
                                    System.out.println("Pulsa 2. Para desbloquear");
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
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (opcion==4){
                                System.out.println("¡Hasta pronto!");
                            }
                        }while (opcion != 4);
                    }
                    if(usuario.equals(usuarioGestor)&& gestorbloqueado.equals(false)&&contrasena.equals(contrasenaGestor)) {
                        do {
                            System.out.println("Elije opción:\n" +
                                    "1. Mis proyectos\n"+
                                    "2. Configuración\n" +
                                    "3. Cerrar Sesión\n");
                            opcion=Integer.parseInt(s.nextLine());
                            switch (opcion){
                                case 1-> {}
                                case 2 -> {
                                    System.out.println("¿Qué quieres cambiar?\n 1.Nombre de usuario\n 2.Contraseña");
                                    int opcionConfiguracionGestor = Integer.parseInt(s.nextLine());
                                    if (opcionConfiguracionGestor == 1) {
                                        System.out.println("Introduzca el nuevo nombre de usuario. Pulsa INTRO para guardar los cambios.");
                                        usuarioGestor = s.nextLine();
                                    } else if (opcionConfiguracionGestor == 2) {
                                        System.out.println("Introduzca la nueva contraseña. Pulsa INTRO para guardar los cambios.");
                                        contrasenaGestor = s.nextLine();
                                    } else {
                                        System.out.println("Error esa opcion no se encuentra en el menú");
                                    }
                                }
                                case 3-> System.out.println("¡Hasta pronto!");
                                default -> System.out.println("Esa opción no se encuentra en el menú");
                            }

                        }while (opcion != 3);
                    }
                    if(usuario.equals(usuarioInversor1)&&inversor1bloqueado.equals(false)) {
                        do {
                            System.out.println("Elije opción:\n" +
                                    "1. Mis inversiones\n" +
                                    "2. Proyectos\n" +
                                    "3. Cartera digital\n" +
                                    "4. Invita a un amigo\n" +
                                    "5. Configuración\n"+
                                    "6. Cerrar Sesión\n");
                            opcion=Integer.parseInt(s.nextLine());
                            if (opcion==6){
                                System.out.println("¡Hasta pronto!");
                            }
                        }while (opcion != 6);
                    }
                    if (usuario.equals(usuarioInversor2)&&inversor2bloqueado.equals(false)){
                        do {
                            System.out.println("Elije opción:\n" +
                                    "1. Mis inversiones\n" +
                                    "2. Proyectos\n" +
                                    "3. Cartera digital\n" +
                                    "4. Invita a un amigo\n" +
                                    "5. Configuración\n"+
                                    "6. Cerrar Sesión\n");
                            opcion=Integer.parseInt(s.nextLine());
                            if (opcion==6){
                                System.out.println("¡Hasta pronto!");
                            }
                        }while (opcion != 6);
                    }

            }
        }while(!usuario.equals("s") || !contrasena.equals("s"));
    }
}