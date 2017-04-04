package com.example.arrow.app02conversor;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final double FACTOR = 166.386;
    private double cambio;
    private EditText edit_text_moneda_a;
    private EditText edit_text_moneda_b;
    private RadioGroup radioGroupMonedadas;

    private void cambiarPantalla(int idRadioButtonMonedaActiva) {
        TextView monA;
        TextView monB;

        monA = (TextView) findViewById(R.id.text_view_moneda_a);
        monB = (TextView) findViewById(R.id.text_view_moneda_b);

        switch (idRadioButtonMonedaActiva) {
            case R.id.radio_button_euros_ptas:
                monA.setText(R.string.euros);
                monB.setText(R.string.ptas);
                cambio = FACTOR;
                break;
            case R.id.radio_button_ptas_euros:
                monA.setText(R.string.ptas);
                monB.setText(R.string.euros);
                cambio = 1 / FACTOR;
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupMonedadas = (RadioGroup) findViewById(R.id.radio_group_monedas);
        cambiarPantalla(radioGroupMonedadas.getCheckedRadioButtonId());

        radioGroupMonedadas.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.getId() == R.id.radio_group_monedas) {
                    cambiarPantalla(group.getCheckedRadioButtonId());
                }
            }
        });
        //Button button_convertir = (Button) ;
        findViewById(R.id.button_convertir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double valor;
                double resultado = 0.0;
                edit_text_moneda_a = (EditText) findViewById(R.id.edit_text_moneda_a);
                edit_text_moneda_b = (EditText) findViewById(R.id.edit_text_moneda_b);
                valor = Double.parseDouble(edit_text_moneda_a.getText().toString());
                resultado = valor * cambio;
                edit_text_moneda_b.setText(String.format("%.2f", resultado));
            }
        });
    }
}
