package com.example.arrow.app03menucontextuallistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ArrayList<String> arrayListAnimales = null;
    private ArrayAdapter<String> arrayAdapterAnimales = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListAnimales= new ArrayList<String>();
        arrayListAnimales.add("Perro");
        arrayListAnimales.add("Gato");
        arrayListAnimales.add("Pez");
        arrayListAnimales.add("Caballo");
        arrayListAnimales.add("Tortuga");
        arrayListAnimales.add("Delfin");
        arrayListAnimales.add("Vaca");
        arrayListAnimales.add("Cerdo");

        arrayAdapterAnimales = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayListAnimales);
        ListView listViewAnimales = (ListView) findViewById(R.id.list_view_animales);
        listViewAnimales.setAdapter(arrayAdapterAnimales);

        registerForContextMenu(listViewAnimales);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu_animales,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Toast.makeText(this, "Pulsado el menu " + item.getTitle() +"  en el animal llamado ".concat(arrayAdapterAnimales.getItem(info.position).toString()), Toast.LENGTH_SHORT).show();

        return super.onContextItemSelected(item);
    }
}
