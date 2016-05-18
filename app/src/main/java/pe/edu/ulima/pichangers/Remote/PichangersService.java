package pe.edu.ulima.pichangers.Remote;

import pe.edu.ulima.pichangers.beans.AlumnoLoginRequest;
import pe.edu.ulima.pichangers.beans.GenericResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by W3214 on 18/05/2016.
 */
public interface PichangersService {
    @POST("/rest/alumnos/login")
    Call<GenericResponse> loginAlumno(@Body AlumnoLoginRequest alumnoLoginRequest);
}