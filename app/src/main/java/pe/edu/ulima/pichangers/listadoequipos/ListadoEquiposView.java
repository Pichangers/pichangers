package pe.edu.ulima.pichangers.listadoequipos;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipo;

/**
 * Created by w3204 on 11/05/2016.
 */
public interface ListadoEquiposView {
    public void setPresenter(ListadoEquiposPresenter presenter);
    public void mostrarListadoEquipos(List<Equipo> equipos);
}
