package pe.edu.ulima.pichangers.listadoequipos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import java.util.List;

import pe.edu.ulima.pichangers.informacionequipos.InformacionActivity;
import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.adapters.ListadoEquiposAdapter;
import pe.edu.ulima.pichangers.beans.Equipo;

public class EquiposActivity extends AppCompatActivity implements ListadoEquiposView{

    ListadoEquiposPresenter mPresenter;
    GridView gviEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);
        setTitle("Equipos");

        gviEquipos = (GridView) findViewById(R.id.gviEquipos);

        setPresenter(new ListadoEquiposPresenterRemote(this));

        mPresenter.obtenerEquipos();
    }

    @Override
    public void setPresenter(ListadoEquiposPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void mostrarListadoEquipos(List<Equipo> equipos) {
        ListadoEquiposAdapter adapter = new ListadoEquiposAdapter(this, equipos);

        gviEquipos.setAdapter(adapter);
    }
}
