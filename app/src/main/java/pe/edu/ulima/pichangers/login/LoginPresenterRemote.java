package pe.edu.ulima.pichangers.login;

import android.util.Log;

import pe.edu.ulima.pichangers.Remote.PichangersService;
import pe.edu.ulima.pichangers.beans.AlumnoLoginRequest;
import pe.edu.ulima.pichangers.beans.GenericResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by W3214 on 18/05/2016.
 */
public class LoginPresenterRemote implements LoginPresenter {
    public LoginView mView;
    public LoginPresenterRemote (LoginView mView){this.mView = mView;}

    @Override
    public void loginAlumno(final AlumnoLoginRequest alumnoLoginRequest) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PichangersService pichangersService = retrofit.create(PichangersService.class);

        pichangersService.loginAlumno(alumnoLoginRequest).enqueue(new Callback<GenericResponse>() {
            @Override
            public void onResponse(Call<GenericResponse> call, Response<GenericResponse> response) {
                if (response.body().getMsg().equals("OK")) {
                    mView.onLoginCorrecto();
                    System.out.println("En el login correcto");
                }else{
                    mView.onLoginIncorrecto(response.body().getMsg());
                    System.out.println("En el login incorrecto");
                }
            }

            @Override
            public void onFailure(Call<GenericResponse> call, Throwable t) {
                Log.e("Pichangers Error: ", t.getMessage());
                System.out.println("On failure");
                System.out.println(t.getMessage());
            }
        });
    }
}