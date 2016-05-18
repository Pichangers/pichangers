package pe.edu.ulima.pichangers.integrantesequipos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.adapters.ListadoIntegrantesAdapter;
import pe.edu.ulima.pichangers.beans.Alumno;

public class NuevoIntegranteActivity extends AppCompatActivity implements ListadoIntegrantesView{

    ListadoIntegrantesPresenter mPresenter;
    ListView lviIntegrantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_integrante);
        setTitle("Agregar un nuevo integrante");

        lviIntegrantes = (ListView) findViewById(R.id.listView);

        setPresenter(new ListadoIntegrantesPresenterRemote(this));
        mPresenter.obtenerIntegrantesSinEquipo();
    }

    @Override
    public void setPresenter(ListadoIntegrantesPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void mostrarListadoAlumnos(List<Alumno> alumnos) {
        ListadoIntegrantesAdapter adapter = new ListadoIntegrantesAdapter(this, alumnos);
        lviIntegrantes.setAdapter(adapter);
    }

    @Override
    public void agregarIntegrante() {

    }

    @Override
    public void errorAgregarIntegrante() {

    }
}
