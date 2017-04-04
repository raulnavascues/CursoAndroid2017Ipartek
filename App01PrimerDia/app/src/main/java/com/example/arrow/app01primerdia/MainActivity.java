package com.example.arrow.app01primerdia;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSaludar = (Button) findViewById(R.id.button_saludar);
        buttonSaludar.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_saludar) {
            TextView text_view_saludo = (TextView) findViewById(R.id.text_view_saludo);
            EditText edit_text_nombre = (EditText) findViewById(R.id.edit_text_nombre);
            String strSeparador = " ";
            String strHola = getResources().getString(R.string.hola_text);
            text_view_saludo.setText(strHola.concat(strSeparador.concat(edit_text_nombre.getText().toString())));
        }
    }

}
