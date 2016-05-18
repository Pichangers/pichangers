package pe.edu.ulima.pichangers.integrantesequipos;

import android.util.Log;

import java.util.List;

import pe.edu.ulima.pichangers.Remote.EquiposService;
import pe.edu.ulima.pichangers.beans.AgregarIntegranteRequest;
import pe.edu.ulima.pichangers.beans.AgregarIntegranteResponse;
import pe.edu.ulima.pichangers.beans.Alumno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by W3214 on 18/05/2016.
 */
public class ListadoIntegrantesPresenterRemote implements ListadoIntegrantesPresenter {
    private ListadoIntegrantesView mView;

    public ListadoIntegrantesPresenterRemote(ListadoIntegrantesView mView) {
        this.mView = mView;
    }

    @Override
    public void obtenerIntegrantesSinEquipo() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EquiposService service = retrofit.create(EquiposService.class);

        service.obtenerAlumnosSinEqupo().enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                List<Alumno> alumnos = response.body();
                mView.mostrarListadoAlumnos(alumnos);
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                Log.e("Pichangers Error: ", t.getMessage());
            }
        });
    }

    @Override
    public void aumentarIntegrante(int id, String codigo, AgregarIntegranteRequest agregarIntegranteRequest) {
        System.out.println(id + codigo + agregarIntegranteRequest.getId() + agregarIntegranteRequest.getCodigo());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EquiposService service = retrofit.create(EquiposService.class);

        service.agregarIntegrante(id, codigo, agregarIntegranteRequest).enqueue(new Callback<AgregarIntegranteResponse>() {
            @Override
            public void onResponse(Call<AgregarIntegranteResponse> call, Response<AgregarIntegranteResponse> response) {
                if (response.body().getMsg().equals("OK")) {
                    mView.agregarIntegrante();
                    System.out.println("Agregar integrante");
                } else {
                    mView.errorAgregarIntegrante();
                    System.out.println("Error agregar integrante");
                }
            }

            @Override
            public void onFailure(Call<AgregarIntegranteResponse> call, Throwable t) {
                Log.e("Pichangers Error: ", t.getMessage());
            }
        });
    }
}
