package pe.edu.ulima.pichangers.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.AgregarIntegranteRequest;
import pe.edu.ulima.pichangers.beans.Alumno;
import pe.edu.ulima.pichangers.beans.Equipo;
import pe.edu.ulima.pichangers.integrantesequipos.ListadoIntegrantesPresenterRemote;
import pe.edu.ulima.pichangers.integrantesequipos.ListadoIntegrantesView;
import pe.edu.ulima.pichangers.listadoequipos.EquiposActivity;

/**
 * Created by W3214 on 18/05/2016.
 */
public class ListadoIntegrantesAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Alumno> mAlumnos;
    private Context mContext;

    public ListadoIntegrantesAdapter(Context mContext, List<Alumno> mAlumnos) {
        this.mInflater = LayoutInflater.from(mContext);
        this.mAlumnos = mAlumnos;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mAlumnos.size();
    }

    @Override
    public Object getItem(int position) {
        return mAlumnos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mAlumnos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_integrante, null);
            viewHolder = new ViewHolder();
            viewHolder.imgAdd = (ImageView) convertView.findViewById(R.id.imgAdd);
            viewHolder.tviAlumno = (TextView) convertView.findViewById(R.id.tviNombre);
            viewHolder.tviCodigo = (TextView) convertView.findViewById(R.id.tviCodigo);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Alumno alumno = mAlumnos.get(position);


        viewHolder.tviAlumno.setText(alumno.getNombre());
        viewHolder.tviCodigo.setText(alumno.getCodigo());


        viewHolder.tviAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ((Activity) mContext).getIntent();
                Equipo equipo = (Equipo) intent.getSerializableExtra("equipoInfo");
                AgregarIntegranteRequest agregarIntegranteRequest = new AgregarIntegranteRequest();
                agregarIntegranteRequest.setId(equipo.getId());
                agregarIntegranteRequest.setCodigo(alumno.getCodigo());
                System.out.println("Id" + equipo.getId());
                System.out.println("Codigo" + alumno.getCodigo());
                new ListadoIntegrantesPresenterRemote((ListadoIntegrantesView) mContext).aumentarIntegrante(equipo.getId(), alumno.getCodigo(),
                        agregarIntegranteRequest);
                Intent intent2 = new Intent(mContext, EquiposActivity.class);
                mContext.startActivity(intent2);


            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView imgAdd;
        TextView tviCodigo;
        TextView tviAlumno;
    }
}
