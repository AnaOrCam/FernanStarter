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
        int eleccionadmin=0  ;
        int Adminconfiguracion=0;
        int opcion;
        String proyecto1="", proyecto2="", proyecto3="";
        String categoria1="", categoria2="", categoria3="";
        int financiacionTotal1=0, financiacionTotal2=0, financiacionTotal3=0;
        int financiado1=0, financiado2=0, financiado3=0;
        String fechaApertura1="", fechaApertura2="", fechaApertura3="";
        String fechaCierre1="", fechaCierre2="", fechaCierre3="";
        String recompensa1proy1="", recompensa2proy1="", recompensa3proy1="";
        String recompensa1proy2="", recompensa2proy2="", recompensa3proy2="";
        String recompensa1proy3="", recompensa2proy3="", recompensa3proy3="";
        String descripcion1proy1 ="", descripcion2proy1 ="", descripcion3proy1 ="";
        String descripcion1proy2 ="", descripcion2proy2 ="", descripcion3proy2 ="";
        String descripcion1proy3 ="", descripcion2proy3 ="", descripcion3proy3 ="";
        int precio1proy1 =0, precio2proy1 =0, precio3proy1 =0;
        int precio1proy2 =0, precio2proy2 =0, precio3proy2 =0;
        int precio1proy3 =0, precio2proy3 =0, precio3proy3 =0;
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
                if(usuario.equals(usuarioAdmin)) {
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
                                break;
                            }
                            case 2:{
                                System.out.println("Ha accedido a Proyectos");
                                System.out.println("Estos son los proyectos existentes:");
                                break;
                            }
                            case 3:{
                                System.out.println("Ha accedido a configuracion");


                                while(Adminconfiguracion!=3){
                                    System.out.println("Seleccione opcion");
                                    System.out.println("1. Cambiar nombre de usuario");
                                    System.out.println("2. Cambiar contraseña de usuario");
                                    System.out.println("3. Para salir del menu configuracion");
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
                                    }
                                }
                                System.out.println("Saliendo del menu de configurazion");



                                break;
                            }

                        }
                        if (opcion==4){
                            System.out.println("¡Hasta pronto!");
                        }
                    }while (opcion != 4);
                }
                if(usuario.equals(usuarioGestor)&& gestorbloqueado.equals(false) && contrasena.equals(contrasenaGestor)) {
                    do {
                        System.out.println("Elije opción:\n" +
                                "1. Mis proyectos\n"+
                                "2. Configuración\n" +
                                "3. Cerrar Sesión\n");
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
                                            if (proyecto1.equals("")){
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
                                                System.out.println("Escriba la recompensa 1 ofrecida por el promotor del proyecto");
                                                recompensa1proy1=s.nextLine();
                                                System.out.println("Incluye una breve descripción de la recompensa 1");
                                                descripcion1proy1 =s.nextLine();
                                                System.out.println("¿Qué precio tiene la recompensa 1?");
                                                precio1proy1 =Integer.parseInt(s.nextLine());
                                                System.out.println("Escriba la recompensa 2 ofrecida por el promotor del proyecto");
                                                recompensa2proy1=s.nextLine();
                                                System.out.println("Incluye una breve descripción de la recompensa 2");
                                                descripcion2proy1 =s.nextLine();
                                                System.out.println("¿Qué precio tiene la recompensa 2?");
                                                precio2proy1 =Integer.parseInt(s.nextLine());
                                                System.out.println("Escriba la recompensa 3 ofrecida por el promotor del proyecto");
                                                recompensa3proy1=s.nextLine();
                                                System.out.println("Incluye una breve descripción de la recompensa 3");
                                                descripcion3proy1 =s.nextLine();
                                                System.out.println("¿Qué precio tiene la recompensa 3?");
                                                precio3proy1 =Integer.parseInt(s.nextLine());
                                                System.out.println("Has añadido esta información en el proyecto 1:\n" +
                                                        "Nombre: "+proyecto1+"\n" +
                                                        "Categoría: "+categoria1+"\n" +
                                                        "Cantidad a financiar: "+financiacionTotal1+"\n" +
                                                        "Cantidad financiada hasta el momento: "+financiado1+"\n" +
                                                        "Fecha de apertura de inversiones: "+fechaApertura1+"\n" +
                                                        "Fecha de cierre de inversiones: "+fechaCierre1+"\n" +
                                                        "Recompensa 1: "+recompensa1proy1+" por "+precio1proy1+"€\n" +
                                                        "\t\t"+descripcion1proy1+"\n" +
                                                        "Recompensa 2: "+recompensa2proy1+" por "+precio2proy1+"€\n" +
                                                        "\t\t"+descripcion2proy1+"\n" +
                                                        "Recompensa 3: "+recompensa3proy1+" por "+precio3proy1+"€\n" +
                                                        "\t\t"+descripcion3proy1+"\n");
                                            } else if (proyecto2.equals("")) {
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
                                                System.out.println("Escriba la recompensa 1 ofrecida por el promotor del proyecto");
                                                recompensa1proy2=s.nextLine();
                                                System.out.println("Incluye una breve descripción de la recompensa 1");
                                                descripcion1proy2 =s.nextLine();
                                                System.out.println("¿Qué precio tiene la recompensa 1?");
                                                precio1proy2 =Integer.parseInt(s.nextLine());
                                                System.out.println("Escriba la recompensa 2 ofrecida por el promotor del proyecto");
                                                recompensa2proy2=s.nextLine();
                                                System.out.println("Incluye una breve descripción de la recompensa 2");
                                                descripcion2proy2 =s.nextLine();
                                                System.out.println("¿Qué precio tiene la recompensa 2?");
                                                precio2proy2 =Integer.parseInt(s.nextLine());
                                                System.out.println("Escriba la recompensa 3 ofrecida por el promotor del proyecto");
                                                recompensa3proy2=s.nextLine();
                                                System.out.println("Incluye una breve descripción de la recompensa 3");
                                                descripcion3proy2 =s.nextLine();
                                                System.out.println("¿Qué precio tiene la recompensa 3?");
                                                precio3proy2 =Integer.parseInt(s.nextLine());
                                                System.out.println("Has añadido esta información en el proyecto 2:\n" +
                                                        "Nombre: "+proyecto2+"\n" +
                                                        "Categoría: "+categoria2+"\n" +
                                                        "Cantidad a financiar: "+financiacionTotal2+"\n" +
                                                        "Cantidad financiada hasta el momento: "+financiado2+"\n" +
                                                        "Fecha de apertura de inversiones: "+fechaApertura2+"\n" +
                                                        "Fecha de cierre de inversiones: "+fechaCierre2+"\n" +
                                                        "Recompensa 1: "+recompensa1proy2+" por "+precio1proy2+"€\n" +
                                                        "\t\t"+descripcion1proy2+"\n" +
                                                        "Recompensa 2: "+recompensa2proy2+" por "+precio2proy2+"€\n" +
                                                        "\t\t"+descripcion2proy2+"\n" +
                                                        "Recompensa 3: "+recompensa3proy2+" por "+precio3proy2+"€\n" +
                                                        "\t\t"+descripcion3proy2+"\n");
                                            } else if (proyecto3.equals("")) {
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
                                                System.out.println("Escriba la recompensa 1 ofrecida por el promotor del proyecto");
                                                recompensa1proy3=s.nextLine();
                                                System.out.println("Incluye una breve descripción de la recompensa 1");
                                                descripcion1proy3 =s.nextLine();
                                                System.out.println("¿Qué precio tiene la recompensa 1?");
                                                precio1proy3 =Integer.parseInt(s.nextLine());
                                                System.out.println("Escriba la recompensa 2 ofrecida por el promotor del proyecto");
                                                recompensa2proy3=s.nextLine();
                                                System.out.println("Incluye una breve descripción de la recompensa 2");
                                                descripcion2proy3 =s.nextLine();
                                                System.out.println("¿Qué precio tiene la recompensa 2?");
                                                precio2proy3 =Integer.parseInt(s.nextLine());
                                                System.out.println("Escriba la recompensa 3 ofrecida por el promotor del proyecto");
                                                recompensa3proy3=s.nextLine();
                                                System.out.println("Incluye una breve descripción de la recompensa 3");
                                                descripcion3proy3 =s.nextLine();
                                                System.out.println("¿Qué precio tiene la recompensa 3?");
                                                precio3proy3 =Integer.parseInt(s.nextLine());
                                                System.out.println("Has añadido esta información en el proyecto 3:\n" +
                                                        "Nombre: "+proyecto3+"\n" +
                                                        "Categoría: "+categoria3+"\n" +
                                                        "Cantidad a financiar: "+financiacionTotal3+"\n" +
                                                        "Cantidad financiada hasta el momento: "+financiado3+"\n" +
                                                        "Fecha de apertura de inversiones: "+fechaApertura3+"\n" +
                                                        "Fecha de cierre de inversiones: "+fechaCierre3+"\n" +
                                                        "Recompensa 1: "+recompensa1proy3+" por "+precio1proy3+"€\n" +
                                                        "\t\t"+descripcion1proy3+"\n" +
                                                        "Recompensa 2: "+recompensa2proy3+" por "+precio2proy3+"€\n" +
                                                        "\t\t"+descripcion2proy3+"\n" +
                                                        "Recompensa 3: "+recompensa3proy3+" por "+precio3proy3+"€\n" +
                                                        "\t\t"+descripcion3proy3+"\n");
                                            }else{
                                                System.out.println("Ha alcanzado el límite de proyectos.");
                                            }
                                        }
                                        case 2 ->{
                                            System.out.println("¿Qué proyecto quiere ver?\n" +
                                                    "1. Proyecto 1: "+proyecto1+"\n" +
                                                    "2. Proyecto 2: "+proyecto2+"\n" +
                                                    "3. Proyecto 3: "+proyecto3+"\n" +
                                                    "4. Salir");
                                            opcion=Integer.parseInt(s.nextLine());
                                            if (opcion==1){
                                                if (!proyecto1.equals("")) {
                                                    System.out.println("Proyecto 1: "+proyecto1+"\n" +
                                                            "Nombre: "+proyecto1+"\n" +
                                                            "Categoría: "+categoria1+"\n" +
                                                            "Cantidad a financiar: "+financiacionTotal1+"\n" +
                                                            "Cantidad financiada hasta el momento: "+financiado1+"\n" +
                                                            "Fecha de apertura de inversiones: "+fechaApertura1+"\n" +
                                                            "Fecha de cierre de inversiones: "+fechaCierre1+"\n" +
                                                            "Recompensa 1: "+recompensa1proy1+" por "+precio1proy1+"€\n" +
                                                            "\t\t"+descripcion1proy1+"\n" +
                                                            "Recompensa 2: "+recompensa2proy1+" por "+precio2proy1+"€\n" +
                                                            "\t\t"+descripcion2proy1+"\n" +
                                                            "Recompensa 3: "+recompensa3proy1+" por "+precio3proy1+"€\n" +
                                                            "\t\t"+descripcion3proy1+"\n");
                                                }else{
                                                    System.out.println("No existe el proyecto 1");
                                                }
                                            }else if (opcion==2){
                                                if (!proyecto2.equals("")) {
                                                    System.out.println("Proyecto 2: "+ proyecto2+"\n" +
                                                            "Nombre: "+proyecto2+"\n" +
                                                            "Categoría: "+categoria2+"\n" +
                                                            "Cantidad a financiar: "+financiacionTotal2+"\n" +
                                                            "Cantidad financiada hasta el momento: "+financiado2+"\n" +
                                                            "Fecha de apertura de inversiones: "+fechaApertura2+"\n" +
                                                            "Fecha de cierre de inversiones: "+fechaCierre2+"\n" +
                                                            "Recompensa 1: "+recompensa1proy2+" por "+precio1proy2+"€\n" +
                                                            "\t\t"+descripcion1proy2+"\n" +
                                                            "Recompensa 2: "+recompensa2proy2+" por "+precio2proy2+"€\n" +
                                                            "\t\t"+descripcion2proy2+"\n" +
                                                            "Recompensa 3: "+recompensa3proy2+" por "+precio3proy2+"€\n" +
                                                            "\t\t"+descripcion3proy2+"\n");
                                                }else{
                                                    System.out.println("No existe el proyecto 2");
                                                }
                                            }else if (opcion==3){
                                                if (!proyecto3.equals("")) {
                                                    System.out.println("Proyecto 3: "+proyecto3+"\n" +
                                                            "Nombre: "+proyecto3+"\n" +
                                                            "Categoría: "+categoria3+"\n" +
                                                            "Cantidad a financiar: "+financiacionTotal3+"\n" +
                                                            "Cantidad financiada hasta el momento: "+financiado3+"\n" +
                                                            "Fecha de apertura de inversiones: "+fechaApertura3+"\n" +
                                                            "Fecha de cierre de inversiones: "+fechaCierre3+"\n" +
                                                            "Recompensa 1: "+recompensa1proy3+" por "+precio1proy3+"€\n" +
                                                            "\t\t"+descripcion1proy3+"\n" +
                                                            "Recompensa 2: "+recompensa2proy3+" por "+precio2proy3+"€\n" +
                                                            "\t\t"+descripcion2proy3+"\n" +
                                                            "Recompensa 3: "+recompensa3proy3+" por "+precio3proy3+"€\n" +
                                                            "\t\t"+descripcion3proy3+"\n");
                                                }else{
                                                    System.out.println("No existe el proyecto 3");
                                                }
                                            }else if (opcion==4){
                                                System.out.println("Ha salido de la vista detallada de proyectos");
                                            }else{
                                                System.out.println("Esa opción no se encuentra en el menú");
                                            }
                                        }
                                        case 3 ->{
                                            System.out.println("Elige un proyecto para modificar\n" +
                                                    "1. Proyecto 1: "+proyecto1+"\n" +
                                                    "2. Proyecto 2: "+proyecto2+"\n" +
                                                    "3. Proyecto 3: "+proyecto3+"\n" +
                                                    "4. Salir");
                                            opcion=Integer.parseInt(s.nextLine());
                                            if (opcion==1){
                                                if (!proyecto1.equals("")) {
                                                    System.out.println("Qué quieres modificar?\n" +
                                                            "1. Nombre\n" +
                                                            "2. Categoría\n" +
                                                            "3. Cantidad a financiar\n" +
                                                            "4. Cantidad financiada hasta el momento\n" +
                                                            "5. Fecha de apertura de inversiones\n" +
                                                            "6. Fecha de cierre de inversiones\n" +
                                                            "7. Recompensas\n" +
                                                            "8. Salir");
                                                    opcion=Integer.parseInt(s.nextLine());
                                                    switch (opcion){
                                                        case 1->{
                                                            System.out.println("Escribe el nuevo nombre del proyecto 1");
                                                            proyecto1=s.nextLine();
                                                        }
                                                        case 2->{
                                                            System.out.println("Escribe la nueva categoría del proyecto 1");
                                                            categoria1=s.nextLine();
                                                        }
                                                        case 3->{
                                                            System.out.println("Escribe la nueva cantidad a financiar");
                                                            financiacionTotal1=Integer.parseInt(s.nextLine());
                                                        }
                                                        case 4->{
                                                            System.out.println("Escribe la nueva cantidad financiada hasta el momento");
                                                            financiado1=Integer.parseInt(s.nextLine());
                                                        }
                                                        case 5->{
                                                            System.out.println("Escribe la nueva fecha de apertura de inversiones (Formato --/--/----)");
                                                            fechaApertura1=s.nextLine();
                                                        }
                                                        case 6->{
                                                            System.out.println("Escribe la nueva fecha de cierre de inversiones (Formato --/--/----)");
                                                            fechaCierre1=s.nextLine();
                                                        }
                                                        case 7->{
                                                            System.out.println("¿Qué recompensa quiere modificar?\n" +
                                                                    "1. Recompensa 1\n" +
                                                                    "2. Recompensa 2\n" +
                                                                    "3. Recompensa 3\n" +
                                                                    "4. Salir");
                                                            opcion=Integer.parseInt(s.nextLine());
                                                            switch (opcion){
                                                                case 1 -> {
                                                                    System.out.println("¿Qué quiere modificar de la recompensa 1?\n" +
                                                                            "1. Objeto de la recompensa\n" +
                                                                            "2. Descripción\n" +
                                                                            "3. Precio\n" +
                                                                            "4. Salir");
                                                                    opcion=Integer.parseInt(s.nextLine());
                                                                    if (opcion==1){
                                                                        System.out.println("Escribe la nueva recompensa ofrecida");
                                                                        recompensa1proy1=s.nextLine();
                                                                    } else if (opcion==2) {
                                                                        System.out.println("Escribe la nueva descripción");
                                                                        descripcion1proy1=s.nextLine();
                                                                    } else if (opcion==3) {
                                                                        System.out.println("Escribe el nuevo precio");
                                                                        precio1proy1=Integer.parseInt(s.nextLine());
                                                                    } else if (opcion==4) {
                                                                        System.out.println("Ha salido del menú modificar recompensa 1");
                                                                    }else{
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 2 -> {
                                                                    System.out.println("¿Qué quiere modificar de la recompensa 2?\n" +
                                                                            "1. Objeto de la recompensa\n" +
                                                                            "2. Descripción\n" +
                                                                            "3. Precio\n" +
                                                                            "4. Salir");
                                                                    opcion=Integer.parseInt(s.nextLine());
                                                                    if (opcion==1){
                                                                        System.out.println("Escribe la nueva recompensa ofrecida");
                                                                        recompensa2proy1=s.nextLine();
                                                                    } else if (opcion==2) {
                                                                        System.out.println("Escribe la nueva descripción");
                                                                        descripcion2proy1=s.nextLine();
                                                                    } else if (opcion==3) {
                                                                        System.out.println("Escribe el nuevo precio");
                                                                        precio2proy1=Integer.parseInt(s.nextLine());
                                                                    } else if (opcion==4) {
                                                                        System.out.println("Ha salido del menú modificar recompensa 2");
                                                                    }else{
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 3 -> {
                                                                    System.out.println("¿Qué quiere modificar de la recompensa 3?\n" +
                                                                            "1. Objeto de la recompensa\n" +
                                                                            "2. Descripción\n" +
                                                                            "3. Precio\n" +
                                                                            "4. Salir");
                                                                    opcion=Integer.parseInt(s.nextLine());
                                                                    if (opcion==1){
                                                                        System.out.println("Escribe la nueva recompensa ofrecida");
                                                                        recompensa3proy1=s.nextLine();
                                                                    } else if (opcion==2) {
                                                                        System.out.println("Escribe la nueva descripción");
                                                                        descripcion3proy1=s.nextLine();
                                                                    } else if (opcion==3) {
                                                                        System.out.println("Escribe el nuevo precio");
                                                                        precio3proy1=Integer.parseInt(s.nextLine());
                                                                    } else if (opcion==4) {
                                                                        System.out.println("Ha salido del menú modificar recompensa 3");
                                                                    }else{
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 4 -> {
                                                                    System.out.println("Ha salido de la modificación de las Recompensas");
                                                                }
                                                                default -> System.out.println("Esa opción no se encuentra en el menú");
                                                            }
                                                        }
                                                        case 8->{
                                                            System.out.println("Ha salido del menú Modificar Proyecto 1");
                                                        }
                                                        default -> System.out.println("Esa opción no se encuentra en el menú");
                                                    }
                                                }else{
                                                    System.out.println("No existe el proyecto 1");
                                                }
                                            }else if (opcion==2){
                                                if (!proyecto2.equals("")) {
                                                    System.out.println("Qué quieres modificar?\n" +
                                                            "1. Nombre\n" +
                                                            "2. Categoría\n" +
                                                            "3. Cantidad a financiar\n" +
                                                            "4. Cantidad financiada hasta el momento\n" +
                                                            "5. Fecha de apertura de inversiones\n" +
                                                            "6. Fecha de cierre de inversiones\n" +
                                                            "7. Recompensas\n" +
                                                            "8. Salir");
                                                    opcion=Integer.parseInt(s.nextLine());
                                                    switch (opcion){
                                                        case 1->{
                                                            System.out.println("Escribe el nuevo nombre del proyecto 2");
                                                            proyecto2=s.nextLine();
                                                        }
                                                        case 2->{
                                                            System.out.println("Escribe la nueva categoría del proyecto 2");
                                                            categoria2=s.nextLine();
                                                        }
                                                        case 3->{
                                                            System.out.println("Escribe la nueva cantidad a financiar");
                                                            financiacionTotal2=Integer.parseInt(s.nextLine());
                                                        }
                                                        case 4->{
                                                            System.out.println("Escribe la nueva cantidad financiada hasta el momento");
                                                            financiado2=Integer.parseInt(s.nextLine());
                                                        }
                                                        case 5->{
                                                            System.out.println("Escribe la nueva fecha de apertura de inversiones (Formato --/--/----)");
                                                            fechaApertura2=s.nextLine();
                                                        }
                                                        case 6->{
                                                            System.out.println("Escribe la nueva fecha de cierre de inversiones (Formato --/--/----)");
                                                            fechaCierre2=s.nextLine();
                                                        }
                                                        case 7->{
                                                            System.out.println("¿Qué recompensa quiere modificar?\n" +
                                                                    "1. Recompensa 1\n" +
                                                                    "2. Recompensa 2\n" +
                                                                    "3. Recompensa 3\n" +
                                                                    "4. Salir");
                                                            opcion=Integer.parseInt(s.nextLine());
                                                            switch (opcion){
                                                                case 1 -> {
                                                                    System.out.println("¿Qué quiere modificar de la recompensa 1?\n" +
                                                                            "1. Objeto de la recompensa\n" +
                                                                            "2. Descripción\n" +
                                                                            "3. Precio\n" +
                                                                            "4. Salir");
                                                                    opcion=Integer.parseInt(s.nextLine());
                                                                    if (opcion==1){
                                                                        System.out.println("Escribe la nueva recompensa ofrecida");
                                                                        recompensa1proy2=s.nextLine();
                                                                    } else if (opcion==2) {
                                                                        System.out.println("Escribe la nueva descripción");
                                                                        descripcion1proy2=s.nextLine();
                                                                    } else if (opcion==3) {
                                                                        System.out.println("Escribe el nuevo precio");
                                                                        precio1proy2=Integer.parseInt(s.nextLine());
                                                                    } else if (opcion==4) {
                                                                        System.out.println("Ha salido del menú modificar recompensa 1");
                                                                    }else{
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 2 -> {
                                                                    System.out.println("¿Qué quiere modificar de la recompensa 2?\n" +
                                                                            "1. Objeto de la recompensa\n" +
                                                                            "2. Descripción\n" +
                                                                            "3. Precio\n" +
                                                                            "4. Salir");
                                                                    opcion=Integer.parseInt(s.nextLine());
                                                                    if (opcion==1){
                                                                        System.out.println("Escribe la nueva recompensa ofrecida");
                                                                        recompensa2proy2=s.nextLine();
                                                                    } else if (opcion==2) {
                                                                        System.out.println("Escribe la nueva descripción");
                                                                        descripcion2proy2=s.nextLine();
                                                                    } else if (opcion==3) {
                                                                        System.out.println("Escribe el nuevo precio");
                                                                        precio2proy2=Integer.parseInt(s.nextLine());
                                                                    } else if (opcion==4) {
                                                                        System.out.println("Ha salido del menú modificar recompensa 2");
                                                                    }else{
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 3 -> {
                                                                    System.out.println("¿Qué quiere modificar de la recompensa 3?\n" +
                                                                            "1. Objeto de la recompensa\n" +
                                                                            "2. Descripción\n" +
                                                                            "3. Precio\n" +
                                                                            "4. Salir");
                                                                    opcion=Integer.parseInt(s.nextLine());
                                                                    if (opcion==1){
                                                                        System.out.println("Escribe la nueva recompensa ofrecida");
                                                                        recompensa3proy2=s.nextLine();
                                                                    } else if (opcion==2) {
                                                                        System.out.println("Escribe la nueva descripción");
                                                                        descripcion3proy2=s.nextLine();
                                                                    } else if (opcion==3) {
                                                                        System.out.println("Escribe el nuevo precio");
                                                                        precio3proy2=Integer.parseInt(s.nextLine());
                                                                    } else if (opcion==4) {
                                                                        System.out.println("Ha salido del menú modificar recompensa 3");
                                                                    }else{
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 4 -> {
                                                                    System.out.println("Ha salido de la modificación de las Recompensas");
                                                                }
                                                                default -> System.out.println("Esa opción no se encuentra en el menú");
                                                            }
                                                        }
                                                        case 8->{
                                                            System.out.println("Ha salido del menú Modificar Proyecto 2");
                                                        }
                                                        default -> System.out.println("Esa opción no se encuentra en el menú");
                                                    }
                                                }else{
                                                    System.out.println("No existe el proyecto 2");
                                                }
                                            }else if (opcion==3){
                                                if (!proyecto3.equals("")) {
                                                    System.out.println("Qué quieres modificar?\n" +
                                                            "1. Nombre\n" +
                                                            "2. Categoría\n" +
                                                            "3. Cantidad a financiar\n" +
                                                            "4. Cantidad financiada hasta el momento\n" +
                                                            "5. Fecha de apertura de inversiones\n" +
                                                            "6. Fecha de cierre de inversiones\n" +
                                                            "7. Recompensas\n" +
                                                            "8. Salir");
                                                    opcion=Integer.parseInt(s.nextLine());
                                                    switch (opcion){
                                                        case 1->{
                                                            System.out.println("Escribe el nuevo nombre del proyecto 3");
                                                            proyecto3=s.nextLine();
                                                        }
                                                        case 2->{
                                                            System.out.println("Escribe la nueva categoría del proyecto 3");
                                                            categoria3=s.nextLine();
                                                        }
                                                        case 3->{
                                                            System.out.println("Escribe la nueva cantidad a financiar");
                                                            financiacionTotal3=Integer.parseInt(s.nextLine());
                                                        }
                                                        case 4->{
                                                            System.out.println("Escribe la nueva cantidad financiada hasta el momento");
                                                            financiado3=Integer.parseInt(s.nextLine());
                                                        }
                                                        case 5->{
                                                            System.out.println("Escribe la nueva fecha de apertura de inversiones (Formato --/--/----)");
                                                            fechaApertura3=s.nextLine();
                                                        }
                                                        case 6->{
                                                            System.out.println("Escribe la nueva fecha de cierre de inversiones (Formato --/--/----)");
                                                            fechaCierre3=s.nextLine();
                                                        }
                                                        case 7->{
                                                            System.out.println("¿Qué recompensa quiere modificar?\n" +
                                                                    "1. Recompensa 1\n" +
                                                                    "2. Recompensa 2\n" +
                                                                    "3. Recompensa 3\n" +
                                                                    "4. Salir");
                                                            opcion=Integer.parseInt(s.nextLine());
                                                            switch (opcion){
                                                                case 1 -> {
                                                                    System.out.println("¿Qué quiere modificar de la recompensa 1?\n" +
                                                                            "1. Objeto de la recompensa\n" +
                                                                            "2. Descripción\n" +
                                                                            "3. Precio\n" +
                                                                            "4. Salir");
                                                                    opcion=Integer.parseInt(s.nextLine());
                                                                    if (opcion==1){
                                                                        System.out.println("Escribe la nueva recompensa ofrecida");
                                                                        recompensa1proy3=s.nextLine();
                                                                    } else if (opcion==2) {
                                                                        System.out.println("Escribe la nueva descripción");
                                                                        descripcion1proy3=s.nextLine();
                                                                    } else if (opcion==3) {
                                                                        System.out.println("Escribe el nuevo precio");
                                                                        precio1proy3=Integer.parseInt(s.nextLine());
                                                                    } else if (opcion==4) {
                                                                        System.out.println("Ha salido del menú modificar recompensa 1");
                                                                    }else{
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 2 -> {
                                                                    System.out.println("¿Qué quiere modificar de la recompensa 2?\n" +
                                                                            "1. Objeto de la recompensa\n" +
                                                                            "2. Descripción\n" +
                                                                            "3. Precio\n" +
                                                                            "4. Salir");
                                                                    opcion=Integer.parseInt(s.nextLine());
                                                                    if (opcion==1){
                                                                        System.out.println("Escribe la nueva recompensa ofrecida");
                                                                        recompensa2proy3=s.nextLine();
                                                                    } else if (opcion==2) {
                                                                        System.out.println("Escribe la nueva descripción");
                                                                        descripcion2proy3=s.nextLine();
                                                                    } else if (opcion==3) {
                                                                        System.out.println("Escribe el nuevo precio");
                                                                        precio2proy3=Integer.parseInt(s.nextLine());
                                                                    } else if (opcion==4) {
                                                                        System.out.println("Ha salido del menú modificar recompensa 2");
                                                                    }else{
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 3 -> {
                                                                    System.out.println("¿Qué quiere modificar de la recompensa 3?\n" +
                                                                            "1. Objeto de la recompensa\n" +
                                                                            "2. Descripción\n" +
                                                                            "3. Precio\n" +
                                                                            "4. Salir");
                                                                    opcion=Integer.parseInt(s.nextLine());
                                                                    if (opcion==1){
                                                                        System.out.println("Escribe la nueva recompensa ofrecida");
                                                                        recompensa3proy3=s.nextLine();
                                                                    } else if (opcion==2) {
                                                                        System.out.println("Escribe la nueva descripción");
                                                                        descripcion3proy3=s.nextLine();
                                                                    } else if (opcion==3) {
                                                                        System.out.println("Escribe el nuevo precio");
                                                                        precio3proy3=Integer.parseInt(s.nextLine());
                                                                    } else if (opcion==4) {
                                                                        System.out.println("Ha salido del menú modificar recompensa 3");
                                                                    }else{
                                                                        System.out.println("Esa opción no se encuentra en el menú");
                                                                    }
                                                                }
                                                                case 4 -> {
                                                                    System.out.println("Ha salido de la modificación de las Recompensas");
                                                                }
                                                                default -> System.out.println("Esa opción no se encuentra en el menú");
                                                            }
                                                        }
                                                        case 8->{
                                                            System.out.println("Ha salido del menú Modificar Proyecto 3");
                                                        }
                                                        default -> System.out.println("Esa opción no se encuentra en el menú");
                                                    }
                                                }else{
                                                    System.out.println("No existe el proyecto 3");
                                                }
                                            }else if (opcion==4){
                                                System.out.println("Ha salido del menú modificar proyecto");
                                            }else{
                                                System.out.println("Esa opción no se encuentra en el menú");
                                            }
                                        }
                                        case 4 ->{
                                            System.out.println("Elija un proyecto para borrar\n" +
                                                    "1. Proyecto 1: "+proyecto1+"\n" +
                                                    "2. Proyecto 2: "+proyecto2+"\n" +
                                                    "3. Proyecto 3: "+proyecto3+"\n" +
                                                    "4. Salir");
                                            opcion=Integer.parseInt(s.nextLine());
                                            if (opcion==1){
                                                if (!proyecto1.equals("")) {
                                                    proyecto1 = "";
                                                    System.out.println("Ha borrado el proyecto 1 satisfactoriamente.");
                                                }else{
                                                    System.out.println("No existe el proyecto 1");
                                                }
                                            }else if (opcion==2){
                                                if (!proyecto2.equals("")) {
                                                    proyecto2 = "";
                                                    System.out.println("Ha borrado el proyecto 2 satisfactoriamente.");
                                                }else{
                                                    System.out.println("No existe el proyecto 2");
                                                }
                                            }else if (opcion==3){
                                                if (!proyecto3.equals("")) {
                                                    proyecto3 = "";
                                                    System.out.println("Ha borrado el proyecto 3 satisfactoriamente.");
                                                }else{
                                                    System.out.println("No existe el proyecto 3");
                                                }
                                            }else if (opcion==4){
                                                System.out.println("Ha salido del menú borrar proyecto");
                                            }else{
                                                System.out.println("Esa opción no se encuentra en el menú");
                                            }

                                        }
                                        case 5 -> System.out.println("Pagina de proyectos cerrada");
                                        default -> System.out.println("Esa opción no existe en el menú");
                                    }
                                }while (opcion!=5);
                            }
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