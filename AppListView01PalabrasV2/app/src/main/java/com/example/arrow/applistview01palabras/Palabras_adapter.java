package com.example.arrow.applistview01palabras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ARROW on 16/03/2017.
 */

public class Palabras_adapter extends ArrayAdapter<String> {

    /**
     * Constructor
     *
     * @param context The current context.
     * @param objects The objects to represent in the ListView.
     */
    public Palabras_adapter(Context context, List<String> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String palabra = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_palabra, parent, false);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.text_view_palabra);
        tv.setText(palabra);

        return convertView;
    }


}
