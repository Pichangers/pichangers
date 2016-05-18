package pe.edu.ulima.pichangers.beans;

import java.io.Serializable;

/**
 * Created by w3204 on 11/05/2016.
 */
public class Equipo implements Serializable{

    private int id;
    private String nombre;
    private String urlFoto;
    private int partidosGanados;
    private int partidosPerdidos;

    public Equipo(){}

    public Equipo(int id, String nombre, String urlImagen, int partidosGanados, int partidosPerdidos) {
        this.id = id;
        this.nombre = nombre;
        this.urlFoto = urlImagen;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlFoto;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlFoto = urlImagen;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }
}
