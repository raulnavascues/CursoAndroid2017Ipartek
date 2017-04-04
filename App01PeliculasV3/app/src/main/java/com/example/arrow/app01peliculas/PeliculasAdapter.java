package com.example.arrow.app01peliculas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PeliculasAdapter extends ArrayAdapter<Pelicula> {

    public PeliculasAdapter(Context context, List<Pelicula> peliculas) {
        super(context, 0, peliculas);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pelicula p = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_pelicula,parent,false);
        }

        TextView txTitulo =(TextView) convertView.findViewById(R.id.text_view_titulo_lista);
        TextView txDuraccion =(TextView) convertView.findViewById(R.id.text_view_duracion_lista);
        TextView txAnio =(TextView) convertView.findViewById(R.id.text_view_anyo_lista);
        TextView txPais =(TextView) convertView.findViewById(R.id.text_view_pais_lista);
        ImageView img = (ImageView) convertView.findViewById(R.id.image_view_caratula);

        txTitulo.setText(p.getTitulo());
        txDuraccion.setText(String.valueOf(p.getDuraccion() + " min."));
        txAnio.setText(p.getAnio());
        txPais.setText(p.getPais());
        img.setImageResource(p.getCaratulaMini());

        return convertView;
    }
}
