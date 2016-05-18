package pe.edu.ulima.pichangers.informacionequipos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.Equipo;

public class InformacionActivity extends AppCompatActivity implements InformacionEquipoView{

    InformacionEquipoPresenter mPresenter;
    TextView tviNombreEquipoInfo, tviPartidosG, tviPartidosP;
    ImageView iviFotoEquipoInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        tviNombreEquipoInfo = (TextView) findViewById(R.id.tviNombreEquipoInfo);
        tviPartidosG = (TextView) findViewById(R.id.tviPartidosG);
        tviPartidosP = (TextView) findViewById(R.id.tviPartidosP);
        iviFotoEquipoInfo = (ImageView) findViewById(R.id.iviFotoEquipoInfo);

        setPresenter(new InformacionEquipoPresenterRemote(this));

        Intent intent = getIntent();
        int id = intent.getIntExtra("EquipoID", 0);

        mPresenter.obtenerEquipoByID(id);
    }

    @Override
    public void setPresenter(InformacionEquipoPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void mostrarInfoEquipo(Equipo equipo) {
        tviNombreEquipoInfo.setText(equipo.getNombre());
        tviPartidosG.setText("Partidos Ganados: " + equipo.getPartidosGanados());
        tviPartidosP.setText("Partidos Perdidos: " + equipo.getPartidosPerdidos());
        Picasso.with(this).load(equipo.getUrlImagen()).into(iviFotoEquipoInfo);
    }
}
