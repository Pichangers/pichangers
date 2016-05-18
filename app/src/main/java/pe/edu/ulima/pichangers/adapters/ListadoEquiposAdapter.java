package pe.edu.ulima.pichangers.adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.ulima.pichangers.R;
import pe.edu.ulima.pichangers.beans.Equipo;
import pe.edu.ulima.pichangers.informacionequipos.InformacionActivity;
import pe.edu.ulima.pichangers.integrantesequipos.NuevoIntegranteActivity;

/**
 * Created by w3204 on 11/05/2016.
 */
public class ListadoEquiposAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Equipo> mEquipos;
    private Context mContext;

    public ListadoEquiposAdapter(Context mContext, List<Equipo> mEquipos) {
        this.mInflater = LayoutInflater.from(mContext);
        this.mEquipos = mEquipos;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mEquipos.size();
    }

    @Override
    public Object getItem(int position) {
        return mEquipos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mEquipos.get(position).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view==null) {
            view  = mInflater.inflate(R.layout.item_listado_equipos, null);
            viewHolder = new ViewHolder();
            viewHolder.iviFotoEquipo = (ImageView) view.findViewById(R.id.iviFotoEquipo);
            viewHolder.tviNombreEquipo = (TextView) view.findViewById(R.id.tviNombreEquipo);
            viewHolder.iviAdd = (ImageView) view.findViewById(R.id.iviAdd);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Equipo equipo = mEquipos.get(i);

        viewHolder.tviNombreEquipo.setText(equipo.getNombre());
        Picasso.with(mContext).load(equipo.getUrlImagen()).into(viewHolder.iviFotoEquipo);
        view.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 400));

        final int id = equipo.getId();

        viewHolder.iviFotoEquipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InformacionActivity.class);
                intent.putExtra("EquipoID", id);
                mContext.startActivity(intent);
            }
        });

        viewHolder.iviAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NuevoIntegranteActivity.class);
                intent.putExtra("equipoInfo", equipo);

                mContext.startActivity(intent);
            }
        });

        return view;
    }

    class ViewHolder {
        ImageView iviFotoEquipo;
        TextView tviNombreEquipo;
        ImageView iviAdd;
    }
}
