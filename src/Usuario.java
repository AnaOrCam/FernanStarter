public abstract class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;
    public static int ids=0;
    public Usuario(String nombre,String correo,String contrasena){
        this.nombre=nombre;
        this.correo=correo;
        this.contrasena=contrasena;
    }
}
