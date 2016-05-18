package pe.edu.ulima.pichangers.listadoequipos;

import java.util.ArrayList;
import java.util.List;

import pe.edu.ulima.pichangers.beans.Equipo;

/**
 * Created by w3204 on 11/05/2016.
 */
public class ListadoEquiposPresenterImpl implements ListadoEquiposPresenter {

    private ListadoEquiposView mView;

    public ListadoEquiposPresenterImpl(ListadoEquiposView mView) {
        this.mView = mView;
    }

    @Override
    public void obtenerEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo(1,"Real Madrid", "http://cde.3.depor.pe/ima/0/0/3/0/1/301918.jpg",0,0));
        equipos.add(new Equipo(1,"Barcelona", "http://www.socceronlinehub.com/wp-content/uploads/2015/09/FC-Barcelona-Schedule-2016-La-Liga.jpg?189db0",0,0));
        equipos.add(new Equipo(1,"Atletico Madrid", "http://bola70.com/wp-content/uploads/2016/04/Prediksi-Skor-Atletico-Madrid-vs-Granada.jpg",0,0));
        equipos.add(new Equipo(1,"Bayern", "http://www.spox.com/de/sport/fussball/bundesliga/saison2015-2016/winterpause/bilder/fc-bayern-muenchen-winterpause-600.jpg",0,0));
        equipos.add(new Equipo(1,"Benfica", "http://news.xinhuanet.com/english/photo/2016-02/17/135105489_14556739249821n.jpg",0,0));
        equipos.add(new Equipo(1,"Man. City", "http://static.goal.com/2504700/2504782_heroa.jpg",0,0));
        equipos.add(new Equipo(1,"Wolfsburg", "http://as01.epimg.net/en/imagenes/2016/04/06/football/1459950971_604030_1459975862_noticia_normal.jpg",0,0));
        equipos.add(new Equipo(1,"Paris St-Germain", "http://s.weltsport.net/bilder/teamfotos/640x360/563.jpg",0,0));

        mView.mostrarListadoEquipos(equipos);
    }
}
