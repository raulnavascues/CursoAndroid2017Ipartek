package com.example.arrow.applistview01palabras;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPalabras;
    private Spinner spinnerCategorias;
    private ArrayList<String> arrayListPalabras;
    //private ArrayAdapter<String> arrayAdapterPalabras;
    private Palabras_adapter arrayAdapterPalabras;
    private ArrayAdapter<String> arrayAdapterCategorias;

    //Constantes para definir las categorias
    private final static int CATEGORIAANIMALES = 0;
    private final static int CATEGORIAVEHICULOS = 1;
    private final static int CATEGORIACOSAS = 2;

    private String categorias[] = {"Animales", "Vehiculos", "Cosas"};

    private void cargarDatos(ArrayList<String> arrayListPalabras, int categoria) {
        switch (categoria) {
            case CATEGORIAANIMALES:
                arrayListPalabras.add("Perro");
                arrayListPalabras.add("Gato");
                arrayListPalabras.add("Delfin");
                arrayListPalabras.add("Ardilla");
                arrayListPalabras.add("Tiburon");
                arrayListPalabras.add("Raton");
                arrayListPalabras.add("Elefante");
                arrayListPalabras.add("Canario");
                arrayListPalabras.add("Ballena");
                arrayListPalabras.add("Vaca");
                arrayListPalabras.add("Burro");
                arrayListPalabras.add("Tigre");
                break;
            case CATEGORIAVEHICULOS:
                arrayListPalabras.add("Coche");
                arrayListPalabras.add("Moto");
                arrayListPalabras.add("Camion");
                arrayListPalabras.add("Furgoneta");
                arrayListPalabras.add("Barco");
                break;
            case CATEGORIACOSAS:
                arrayListPalabras.add("Espada");
                arrayListPalabras.add("Mesa");
                arrayListPalabras.add("Lapiz");
                arrayListPalabras.add("Goma");
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPalabras = (ListView) findViewById(R.id.list_view_palabras);

        arrayAdapterCategorias = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categorias);

        spinnerCategorias = (Spinner) findViewById(R.id.spinner_categorias);

        spinnerCategorias.setAdapter(arrayAdapterCategorias);

        spinnerCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                arrayListPalabras = new ArrayList<String>();
                cargarDatos(arrayListPalabras, position);
                //arrayAdapterPalabras = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, arrayListPalabras);
                arrayAdapterPalabras = new Palabras_adapter(view.getContext(),  arrayListPalabras);
                listViewPalabras.setAdapter(arrayAdapterPalabras);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
