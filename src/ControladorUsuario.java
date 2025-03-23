public class ControladorUsuario {
    private GestionUsuarios modelo=new GestionUsuarios();
    private VistaUsuario vista =new VistaUsuario();
    public  ControladorUsuario(GestionUsuarios modelo,VistaUsuario vista){
        this.modelo=modelo;
        this.vista=vista;
    }
    public void aniadirUsuario(Usuario nuevo){
        modelo.aniadirUsuario( nuevo);
    }
    public void muestraUsuarios(){
        vista.muestraUsuarios(modelo.getUsuarios());
    }
    public boolean buscaUsuario(String nombre){
       return modelo.buscaUsuario(nombre);
    }
}
