public abstract class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;
    private TipoUsuario tipoUsuario;

    /**
     * Constructor del objeto Usuario.
     * @author AnaOrCam
     * @param nombre se refiere al atributo nombre en formato String.
     * @param correo se refiere al correo del usuario de tipo String.
     * @param contrasena se refiere al atributo contrasena de tipo String.
     * @param tipoUsuario se refiere al tipo de usuario de tipo TipoUsuario.
     * @return no devuelve nada.
     */
    public Usuario(String nombre, String correo, String contrasena, TipoUsuario tipoUsuario){
        this.nombre=nombre;
        this.correo=correo;
        this.contrasena=contrasena;
        this.tipoUsuario=tipoUsuario;
    }

    /**
     * Getter del nombre del usuario.
     * @author davidrn06
     * @return devuelve el nombre de tipo String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el atributo nombre.
     * @author davidrn06
     * @param nombre se refiere al atributo nombre nuevo que sustituirá al anterior de tipo String.
     * @return no devuelve nada.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del correo del usuario.
     * @author davidrn06
     * @return devuelve el correo de tipo String.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Modifica el atributo correo.
     * @author davidrn06
     * @param correo se refiere al atributo correo nuevo que sustituirá al anterior de tipo String.
     * @return no devuelve nada.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Getter de la contraseña del usuario.
     * @author davidrn06
     * @return devuelve el atributo contrasena de tipo String.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Modifica el atributo contrasena.
     * @author davidrn06
     * @param contrasena se refiere al atributo contrasena nuevo que sustituirá al anterior de tipo String.
     * @return no devuelve nada.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Getter del tipo de usuario del usuario.
     * @author AnaOrcam
     * @return devuelve el atributo tipoUsuario de tipo TipoUsuario.
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Redefine la función toString para mostrar el objeto Usuario.
     * @author AnaOrCam
     * @return devuelve el String definido.
     */
    public String toString(){
        return "Nombre: "+nombre+"\nCuenta tipo "+tipoUsuario+"\nCorreo: "+correo;
    }



}
