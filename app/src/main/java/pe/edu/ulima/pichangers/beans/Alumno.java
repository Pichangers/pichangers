package pe.edu.ulima.pichangers.beans;

/**
 * Created by W3214 on 18/05/2016.
 */
public class Alumno {
    private Long id;
    private String nombre;
    private String codigo;
    private String equipo;

    public Alumno(){}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
