package com.example.arrow.appmenu05modoaccioncontextuallistview;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayAdapter<String> animalesArrayAdapter;
    private ArrayList<String> animalesArrayList;
    private ListView animalesListView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_borrar_lista:
                animalesArrayAdapter .clear();
                return true;
            case R.id.item_cargar_lista:
                cargarListadoOpciones(animalesListView);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void  cargarListadoOpciones(ListView animalesListView){
        animalesArrayList = new ArrayList<String>();
        animalesArrayList.add("Perro");
        animalesArrayList.add("Gato");
        animalesArrayList.add("Raton");
        animalesArrayAdapter = new ArrayAdapter<String>(this, R.layout.animales_list_item, R.id.animales_text_view, animalesArrayList);
        animalesListView.setAdapter(animalesArrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        setSupportActionBar(toolbar);

        animalesListView = (ListView) findViewById(R.id.animales_list_view);
        cargarListadoOpciones(animalesListView);

        animalesListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        animalesListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                mode.setTitle(animalesListView.getCheckedItemCount() + " seleccionados");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.animales_list_view_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.borrar_menu_item:
                        SparseBooleanArray checked = animalesListView.getCheckedItemPositions();
                        for (int i = (checked.size() - 1); i >= 0; i--) {
                            animalesArrayAdapter.remove(animalesArrayAdapter.getItem(checked.keyAt(i)));
                        }
                        mode.finish();
                        return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
