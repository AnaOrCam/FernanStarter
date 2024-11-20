import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String usuario="";
        String contrasena="";
        String usuarioAdmin="administrador";
        String usuarioGestor="gestor";
        String usuarioInversor1="inversor1";
        String usuarioInversor2="inversor2";
        String contrasenaAdmin="admin";
        String contrasenaGestor="gestor";
        String contrasenaInversor1="inversor1";
        String contrasenaInversor2="inversor2";
        int intentoGestor=3;
        int intentoInversor1=3;
        int intentoInversor2=3;
        Boolean bienvenido;
        int opcion=0;
        do{
            bienvenido=false;
            System.out.println("Introduce usuario y contraseña. Pulsa s para salir");
            usuario=s.nextLine().toLowerCase();
            contrasena=s.nextLine();
            if (!usuario.equals("s") && !contrasena.equals("s")) {
                if (usuario.equals(usuarioAdmin) && contrasena.equals(contrasenaAdmin) || usuario.equals(usuarioGestor) && contrasena.equals(contrasenaGestor) || usuario.equals(usuarioInversor1) && contrasena.equals(contrasenaInversor1) || usuario.equals(usuarioInversor2) && contrasena.equals(contrasenaInversor2)) {
                    System.out.println("Bienvenido");
                    bienvenido = true;
                } else {
                    System.out.println("Usuario o contraseña incorrectos");
                }
                if (usuario.equals("gestor") && !contrasena.equals(contrasenaGestor)) {
                    intentoGestor -= 1;
                    System.out.println("Te quedan " + intentoGestor + " intentos.");
                }
                if (usuario.equals("inversor1") && !contrasena.equals(contrasenaInversor1)) {
                    intentoInversor1 -= 1;
                    System.out.println("Te quedan " + intentoInversor1 + " intentos.");
                }
                if (usuario.equals("inversor2") && !contrasena.equals(contrasenaInversor2)) {
                    intentoInversor2 -= 1;
                    System.out.println("Te quedan " + intentoInversor2 + " intentos.");
                }
                if (usuario.equals("gestor") && intentoGestor == 0 || usuario.equals("inversor1") && intentoInversor1 == 0 || usuario.equals("inversor2") && intentoInversor2 == 0) {
                    System.out.println("Ha agotado los intentos de acceso a este perfil. Para restaurar contacte con el administrador.");
                }
            }else{
                System.out.println("¡Nos vemos pronto!");
            }
            if (bienvenido) {
                switch (usuario) {
                    case "administrador" -> {
                        do {
                            System.out.println("Elije opción:\n" +
                                    "1. Panel de control\n" +
                                    "2. Proyectos\n" +
                                    "3. Configuración\n" +
                                    "4. Cerrar Sesión\n");
                            opcion=Integer.parseInt(s.nextLine());
                            if (opcion==4){
                                System.out.println("¡Hasta pronto!");
                            }
                        }while (opcion != 4);
                    }
                    case "gestor" -> {
                        do {
                            System.out.println("Elije opción:\n" +
                                    "1. Mis proyectos\n"+
                                    "2. Configuración\n" +
                                    "3. Cerrar Sesión\n");
                            opcion=Integer.parseInt(s.nextLine());
                            if (opcion==3){
                                System.out.println("¡Hasta pronto!");
                            }
                        }while (opcion != 3);
                    }
                    case "inversor1" -> {
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
                    case "inversor2" -> {
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
            }
        }while(!usuario.equals("s") || !contrasena.equals("s"));
    }
}