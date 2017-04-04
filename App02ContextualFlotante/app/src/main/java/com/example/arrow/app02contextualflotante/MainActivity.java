package com.example.arrow.app02contextualflotante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewHelloWorld = (TextView) findViewById(R.id.textView);
        registerForContextMenu(textViewHelloWorld);
        ImageView imageViewCabeza = (ImageView) findViewById(R.id.imageView);
        registerForContextMenu(imageViewCabeza);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        if (v.getId() == R.id.textView) {
            inflater.inflate(R.menu.activity_main_menu_text_view, menu);
        } else if (v.getId() == R.id.imageView) {
            inflater.inflate(R.menu.activity_main_menu_image_view, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ContextMenu.ContextMenuInfo menuInfo = item.getMenuInfo();
        Toast t = null;

        switch (item.getItemId()) {
            case R.id.item_1:
                t = Toast.makeText(this,"Item 1 pulsado en el TextView",Toast.LENGTH_SHORT);
                t.show();
                return true;
            case R.id.item_2:
                t = Toast.makeText(this,"Item 2 pulsado en el TextView",Toast.LENGTH_SHORT);
                t.show();
                return true;
            case R.id.item_3:
                t = Toast.makeText(this,"Item 3 pulsado en el TextView",Toast.LENGTH_SHORT);
                t.show();
                return true;
            case R.id.item_4:
                t = Toast.makeText(this,"Item 4 pulsado en el TextView",Toast.LENGTH_SHORT);
                t.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
