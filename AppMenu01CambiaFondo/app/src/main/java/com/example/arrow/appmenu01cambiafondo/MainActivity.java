package com.example.arrow.appmenu01cambiafondo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_rojo:
                ((LinearLayout) findViewById(R.id.activity_main)).setBackgroundColor(Color.parseColor("#CC0000"));
                return true;
            case R.id.item_azul:
                ((LinearLayout) findViewById(R.id.activity_main)).setBackgroundColor(Color.parseColor("#0000CC"));
                return true;
            case R.id.item_verde:
                ((LinearLayout) findViewById(R.id.activity_main)).setBackgroundColor(Color.parseColor("#00CC00"));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
