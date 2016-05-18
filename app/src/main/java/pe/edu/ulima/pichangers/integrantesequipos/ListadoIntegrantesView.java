package pe.edu.ulima.pichangers.integrantesequipos;

import java.util.List;

import pe.edu.ulima.pichangers.beans.Alumno;

/**
 * Created by W3214 on 18/05/2016.
 */
public interface ListadoIntegrantesView {
    public void setPresenter(ListadoIntegrantesPresenter presenter);
    public void mostrarListadoAlumnos(List<Alumno> alumnos);
    public void agregarIntegrante();
    public void errorAgregarIntegrante();
}
