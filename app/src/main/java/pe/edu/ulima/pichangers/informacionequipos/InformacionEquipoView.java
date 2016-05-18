package pe.edu.ulima.pichangers.informacionequipos;

import pe.edu.ulima.pichangers.beans.Equipo;

/**
 * Created by kyos_ on 13/05/2016.
 */
public interface InformacionEquipoView {
    public void setPresenter(InformacionEquipoPresenter presenter);
    public void mostrarInfoEquipo(Equipo equipo);
}
