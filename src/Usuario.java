public abstract class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;
    public static int ids=0;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuario(String nombre, String correo, String contrasena){
        this.nombre=nombre;
        this.correo=correo;
        this.contrasena=contrasena;
    }
    public static String getContraseniaMaestra(String contrasenia){
        return "awdw";
    }
}
