package pe.edu.ulima.pichangers.Remote;



import java.util.List;

import pe.edu.ulima.pichangers.beans.AgregarIntegranteRequest;
import pe.edu.ulima.pichangers.beans.AgregarIntegranteResponse;
import pe.edu.ulima.pichangers.beans.Alumno;
import pe.edu.ulima.pichangers.beans.Equipo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by kyos_ on 13/05/2016.
 */
public interface EquiposService {
    @GET("rest/equipos")
    Call<List<Equipo>> obtenerEquipos();

    @GET("rest/equipos/{id}")
    Call<Equipo> obtenerEquipoByID(@Path("id") int id);

    @GET("/rest/alumnos?sin_equipo=true")
    Call<List<Alumno>> obtenerAlumnosSinEqupo();

    @POST("/rest/equipos/{id}/{codigo_alumno}")
    Call<AgregarIntegranteResponse> agregarIntegrante(@Path("id") int id, @Path("codigo_alumno") String codigo, @Body AgregarIntegranteRequest agregarIntegranteRequest);
}
