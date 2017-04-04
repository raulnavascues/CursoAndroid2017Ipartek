package com.example.arrow.appmenu01opciones;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean otroMenu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.button_cambiar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otroMenu = !otroMenu;
               if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
                   supportInvalidateOptionsMenu();  //Cuando se usa AppCompactActivity
                   invalidateOptionsMenu();     //Cuando se usa Activity
               }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast t = null;

        switch (item.getItemId()) {
            case R.id.item_1:
                t = Toast.makeText(this, "Item 1 Pulsado", Toast.LENGTH_SHORT);
                t.show();
                return true;
            case R.id.item_2:
                t = Toast.makeText(this, "Item 2 Pulsado", Toast.LENGTH_SHORT);
                t.show();
                return true;
            case R.id.item_3:
                t = Toast.makeText(this, "Item 3 Pulsado", Toast.LENGTH_SHORT);
                t.show();
                return true;
            case R.id.item_4:
                t = Toast.makeText(this, "Item 4 Pulsado", Toast.LENGTH_SHORT);
                t.show();
                return true;
            case R.id.item_otro:
                t = Toast.makeText(this, "Item Otro Pulsado", Toast.LENGTH_SHORT);
                t.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu,menu);
        ((MenuItem) menu.findItem(R.id.item_otro)).setVisible(otroMenu);
        return super.onPrepareOptionsMenu(menu);
    }
}
