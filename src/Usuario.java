public abstract class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombre, String correo, String contrasena, TipoUsuario tipoUsuario){
        this.nombre=nombre;
        this.correo=correo;
        this.contrasena=contrasena;
        this.tipoUsuario=tipoUsuario;
    }

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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public String toString(){
        return "Nombre: "+nombre+"\nCuenta tipo "+tipoUsuario+"\nCorreo: "+correo;
    }



}
