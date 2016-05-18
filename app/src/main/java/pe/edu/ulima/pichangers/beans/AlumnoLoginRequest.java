package pe.edu.ulima.pichangers.beans;

import java.io.Serializable;

/**
 * Created by W3214 on 18/05/2016.
 */
public class AlumnoLoginRequest implements Serializable{
    private String usuario;
    private String password;
    public AlumnoLoginRequest(){}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
