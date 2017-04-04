package com.example.arrow.apppersistencia01sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static final String NOMBRE_ARCHIVO_PREFERNECIAS = "AppPersistencia01PrefsFies";
    public static final String NOMBRE_PREFERENCIA = "COLOR";
    public static final String VALOR_PREFERNCIA_COLOR_ROJO = "ROJO";
    public static final String VALOR_PREFERNCIA_COLOR_VERDE = "VERDE";
    public static final String VALOR_PREFERNCIA_COLOR_AZUL = "AZUL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(NOMBRE_ARCHIVO_PREFERNECIAS, Context.MODE_PRIVATE);
        String color = settings.getString(NOMBRE_PREFERENCIA, VALOR_PREFERNCIA_COLOR_ROJO);

        if (color.compareToIgnoreCase(VALOR_PREFERNCIA_COLOR_ROJO)==0){
            ((RadioButton) findViewById(R.id.radio_button_color_rojo)).setChecked(true);
            findViewById(R.id.activity_main).setBackgroundResource(R.color.rojo);
        }else if(color.compareToIgnoreCase(VALOR_PREFERNCIA_COLOR_VERDE)==0){
            ((RadioButton) findViewById(R.id.radio_button_color_verde)).setChecked(true);
            findViewById(R.id.activity_main).setBackgroundResource(R.color.verde);
        }else  if(color.compareToIgnoreCase(VALOR_PREFERNCIA_COLOR_AZUL)==0) {
            ((RadioButton) findViewById(R.id.radio_button_color_azul)).setChecked(true);
            findViewById(R.id.activity_main).setBackgroundResource(R.color.azul);
        }


        ((Button) findViewById(R.id.button_guardar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences settings = getSharedPreferences(NOMBRE_ARCHIVO_PREFERNECIAS, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();

                if (((RadioButton) findViewById(R.id.radio_button_color_rojo)).isChecked()) {
                    editor.putString(NOMBRE_PREFERENCIA, VALOR_PREFERNCIA_COLOR_ROJO);
                } else if (((RadioButton) findViewById(R.id.radio_button_color_verde)).isChecked()) {
                    editor.putString(NOMBRE_PREFERENCIA, VALOR_PREFERNCIA_COLOR_VERDE);
                } else if (((RadioButton) findViewById(R.id.radio_button_color_azul)).isChecked()) {
                    editor.putString(NOMBRE_PREFERENCIA, VALOR_PREFERNCIA_COLOR_AZUL);
                }

                editor.commit();
            }
        });
    }
}
