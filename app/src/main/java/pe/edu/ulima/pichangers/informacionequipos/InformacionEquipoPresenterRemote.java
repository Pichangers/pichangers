package pe.edu.ulima.pichangers.informacionequipos;

import android.util.Log;

import pe.edu.ulima.pichangers.Remote.EquiposService;
import pe.edu.ulima.pichangers.beans.Equipo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kyos_ on 13/05/2016.
 */
public class InformacionEquipoPresenterRemote implements InformacionEquipoPresenter {

    private InformacionEquipoView mView;

    public InformacionEquipoPresenterRemote(InformacionEquipoView mView) {
        this.mView = mView;
    }

    @Override
    public void obtenerEquipoByID(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EquiposService servicio = retrofit.create(EquiposService.class);
        servicio.obtenerEquipoByID(id).enqueue(new Callback<Equipo>() {
            @Override
            public void onResponse(Call<Equipo> call, Response<Equipo> response) {
                mView.mostrarInfoEquipo(response.body());
            }

            @Override
            public void onFailure(Call<Equipo> call, Throwable t) {
                Log.e("Pichangers Error: ", t.getMessage());
            }
        });
    }
}
