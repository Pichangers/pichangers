package pe.edu.ulima.pichangers.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.AlumnoLoginRequest;
import pe.edu.ulima.pichangers.listadoequipos.EquiposActivity;

public class LoginActivity extends AppCompatActivity implements LoginView{

    EditText eteUsuario, etePassword;
    LoginPresenter mPresenter;
    AlumnoLoginRequest alumnoLoginRequest = new AlumnoLoginRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eteUsuario = (EditText) findViewById(R.id.eteUsuario);
        etePassword = (EditText) findViewById(R.id.etePassword);

        setPresenter(new LoginPresenterRemote(this));
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onLoginCorrecto() {
        Intent intent = new Intent(this, EquiposActivity.class);
        intent.putExtra("username", alumnoLoginRequest);
        startActivity(intent);
    }

    @Override
    public void onLoginIncorrecto(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        // Limpiar los edittext
        eteUsuario.setText("");
        etePassword.setText("");
    }

    public void onButLoginClick(View view) {
        String username = eteUsuario.getText().toString().trim();
        String password = etePassword.getText().toString().trim();

        alumnoLoginRequest.setUsuario(username);
        alumnoLoginRequest.setPassword(password);

        mPresenter.loginAlumno(alumnoLoginRequest);
    }
}
