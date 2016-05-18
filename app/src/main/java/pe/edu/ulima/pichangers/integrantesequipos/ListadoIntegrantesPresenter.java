package pe.edu.ulima.pichangers.integrantesequipos;

import pe.edu.ulima.pichangers.beans.AgregarIntegranteRequest;

/**
 * Created by W3214 on 18/05/2016.
 */
public interface ListadoIntegrantesPresenter {
    public void obtenerIntegrantesSinEquipo();
    public void aumentarIntegrante(int id, String codigo, AgregarIntegranteRequest agregarIntegranteRequest);
}
