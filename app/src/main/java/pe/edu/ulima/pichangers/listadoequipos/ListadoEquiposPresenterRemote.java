package pe.edu.ulima.pichangers.listadoequipos;

import android.util.Log;

import java.util.List;

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
public class ListadoEquiposPresenterRemote implements ListadoEquiposPresenter {

    private ListadoEquiposView mView;

    public ListadoEquiposPresenterRemote(ListadoEquiposView mView) {
        this.mView = mView;
    }

    @Override
    public void obtenerEquipos() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EquiposService service = retrofit.create(EquiposService.class);
        service.obtenerEquipos().enqueue(new Callback<List<Equipo>>() {
            @Override
            public void onResponse(Call<List<Equipo>> call, Response<List<Equipo>> response) {
                mView.mostrarListadoEquipos(response.body());
            }

            @Override
            public void onFailure(Call<List<Equipo>> call, Throwable t) {
                Log.e("Pichangers Error: ", t.getMessage());
            }
        });

    }
}
