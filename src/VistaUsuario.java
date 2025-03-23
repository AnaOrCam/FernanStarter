import java.util.LinkedList;

public class VistaUsuario {
    private final String ANSI_GREEN= "\033[32m";
    private final String ANSI_RED="\033[31m";
    private final String ANSI_RESET= "\033[0m";
    private final String ANSI_PURPLE= "\033[35m";
    public void muestraUsuarios(LinkedList<Usuario> usuarios){
        for (Usuario mostrar:usuarios){
            System.out.println(mostrar);
        }
    }
}
